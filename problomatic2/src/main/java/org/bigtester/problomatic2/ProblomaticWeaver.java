/*
 * Created on Jul 19, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.bigtester.problomatic2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.bcel.Constants;
import org.apache.bcel.classfile.ClassFormatException;
import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.Code;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.LocalVariable;
import org.apache.bcel.classfile.LocalVariableTable;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.ASTORE;
import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.CodeExceptionGen;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.InstructionConstants;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.LocalVariableGen;
import org.apache.bcel.generic.MethodGen;
import org.apache.bcel.generic.ObjectType;
import org.apache.bcel.generic.Type;

/**
 * @author danstieglitz
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class ProblomaticWeaver {

	private static final String GENERIC_PROBLEM_CLASS_NAME = "org.bigtester.problomatic2.problems.RawProblem";
	
	public void problomaticizeJar(String pathToJar) throws IOException {
		JarFile file = new JarFile(new File(pathToJar));
		Enumeration entries = file.entries();
		while (entries.hasMoreElements()) {
			JarEntry entry = (JarEntry)entries.nextElement();
		}
	}
	
	/**
	 * Searches all of the supplied class' methods for catch blocks and inserts
	 * a static call to the problomatic handleThrowable method, passing in the
	 * exception relevant to the catch block. This will generate
	 * GenericThrowableProblems which could be handled by user-defined chains.
	 * 
	 * @param clazz
	 * @throws ClassFormatException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void problomaticizeClass(String pathToClass)
			throws ClassFormatException, IOException, ClassNotFoundException {
		JavaClass jclas = new ClassParser(pathToClass).parse();
		ClassGen cgen = new ClassGen(jclas);
		Method[] methods = jclas.getMethods();
		for (int i = 0; i < methods.length; i++) {
			MethodGen mgen = problomaticizeMethod(cgen, methods[i]);
			cgen.setMethodAt(mgen.getMethod(), i);
		}
		saveToFile(cgen, pathToClass);
	}

	private InstructionHandle getInstructionAtOffset(InstructionList ilist,
			int offset) {
		int[] offsets = ilist.getInstructionPositions();
		for (int pos = 0; pos < offsets.length; pos++) {
			if (offsets[pos] == offset) {
				return ilist.getInstructionHandles()[pos];
			}
		}
		return null;
	}

	/**
	 * This method returns the bytecode instructions to invoke the Problomatic
	 * subsystem. These instructions must be executed immediately after the
	 * catch block begins, i.e., they assume that the top of the stack contains
	 * the reference to the exception. TODO: The bytecodes returned by this
	 * method are not quite correct.
	 * 
	 * @param pgen
	 * @param handlerStart
	 *            the start offset of the catch block
	 * @return @throws
	 *         ClassNotFoundException
	 */
	private InstructionList getProblomaticInstructions(ClassGen cgen,
			MethodGen mgen) {
		InstructionList pinst = new InstructionList();
		Throwable typeTest = new Throwable();
		LocalVariableTable lvt = mgen.getLocalVariableTable(mgen
				.getConstantPool());

		int throwableSlot = -1;
		int thisSlot = -1;
		// find exception in lvt
		for (int i = 0; i < lvt.getTableLength(); i++) {
			LocalVariable var = lvt.getLocalVariable(i);
			//			System.out.println(var);
			if (var != null) {
				if (var.getName().equals("this")) {
					thisSlot = var.getIndex();
				} else {
					Class clazz;
					try {
						clazz = loadClassFromTypeSignature(var.getSignature());
						if (Throwable.class.isAssignableFrom(clazz)) {
							throwableSlot = var.getIndex();
						}
					} catch (ClassNotFoundException e) {
						System.err.println("Warning! Unable to find class "
								+ e.getMessage());
					}

				}
			}
		}

		if (throwableSlot == -1) {
			System.out.println("Can't find slot for exception");
			return null;
		}

		if (thisSlot == -1) {
			System.out.println("Can't find slot for this");
			return null;
		}

		InstructionFactory ifact = new InstructionFactory(cgen);

		pinst
				.append(InstructionFactory.createStore(Type.OBJECT,
						throwableSlot));
		pinst.append(ifact.createNew(GENERIC_PROBLEM_CLASS_NAME));

		pinst.append(InstructionConstants.DUP);
		pinst.append(InstructionFactory.createLoad(Type.OBJECT, thisSlot));
		pinst.append(InstructionFactory.createLoad(Type.OBJECT, throwableSlot));
		pinst.append(ifact.createInvoke(GENERIC_PROBLEM_CLASS_NAME, "<init>",
				Type.VOID, new Type[] { new ObjectType("java.lang.Object"),
						new ObjectType("java.lang.Throwable") },
				Constants.INVOKESPECIAL));

		LocalVariableGen prob = mgen.addLocalVariable("prob", new ObjectType(
				GENERIC_PROBLEM_CLASS_NAME), pinst.getStart(), pinst.getEnd());

		int probSlot = prob.getIndex();
		prob.setStart(pinst.append(new ASTORE(probSlot)));

		//		pinst.append(InstructionFactory.createStore(Type.OBJECT,probSlot));
		pinst.append(InstructionFactory.createLoad(Type.OBJECT, probSlot));

		prob.setEnd(pinst.append(ifact.createInvoke(
				"org.bigtester.problomatic2.Problomatic", "handleProblem",
				Type.VOID, new Type[] { new ObjectType(
						"org.bigtester.problomatic2.Problem") },
				Constants.INVOKESTATIC)));

		// put the throwable back on the stack (as it was before we found it)
		pinst.append(InstructionFactory.createLoad(Type.OBJECT, throwableSlot));

		//		System.out.println(pinst);
		//		System.out.println(mgen.getLocalVariableTable(mgen.getConstantPool()));

		return pinst;
	}

	/**
	 * Convert a method into a problomatic-capable one.
	 * 
	 * @param cgen
	 * @param method
	 * @return @throws
	 *         IOException
	 * @throws ClassNotFoundException
	 */
	private MethodGen problomaticizeMethod(ClassGen cgen, Method method)
			throws IOException, ClassNotFoundException {
		// find catch blocks in this method
		Code code = method.getCode();
		//		CodeException[] table = code.getExceptionTable();
		ConstantPoolGen pgen = cgen.getConstantPool();
		MethodGen mgen = new MethodGen(method, cgen.getClassName(), pgen);
		CodeExceptionGen[] table = mgen.getExceptionHandlers();
		System.out.println("Scanning "+method.getName());
		for (int i = 0; i < table.length; i++) {
			System.out.println("Exception handler "+(i+1)+" found");
			CodeExceptionGen exception = table[i];
			InstructionList mlist = mgen.getInstructionList();
			int handlerStartPos = exception.getHandlerPC().getPosition();
			//			System.out.println("Found TCF block " + exception);
			//			System.out.println("Entire method bytecode:");
			//			System.out.println(mlist);
			//			InstructionList ilist = getProblomaticInstructions(cgen, mgen,
			//					handlerStartPos);
			InstructionHandle handlerStart = exception.getHandlerPC();
			if (handlerStart != null) {
				InstructionList ilist = getProblomaticInstructions(cgen, mgen);
				if (ilist==null) {
					System.out.println("Unable to create instrumented bytecode");
					return mgen;
				}
				System.out.println(">>> Processing catch block "+(i+1)+" found in "
						+ method.getName());
				InstructionHandle newHandlerStart = ilist.getStart();
				// TODO: take original handler code and make a separate
				// method out of it, or even better, create a new handler
				// class with the code and append it to the handler chain.
				mlist.insert(handlerStart, ilist);
				mlist.setPositions(true);
				mgen.addExceptionHandler(exception.getStartPC(), exception
						.getEndPC(), newHandlerStart, exception.getCatchType());
				mgen.removeExceptionHandler(exception);
				cgen.setConstantPool(mgen.getConstantPool());
				//				mgen.stripAttributes(true);
				mgen.setMaxLocals();
				mgen.setMaxStack();

				//				System.out.println("New method bytecode: ");
				//				System.out.println(mgen.getInstructionList());
				//				System.out.println("New constant pool:");
				//				System.out.println(mgen.getConstantPool());
			}
		}

		return mgen;
	}

	private void saveToFile(ClassGen cgen, String pathToFile)
			throws IOException {
		FileOutputStream fos = new FileOutputStream(pathToFile);
		cgen.getJavaClass().dump(fos);
		fos.close();
	}

	private Class loadClassFromTypeSignature(String signature)
			throws ClassNotFoundException {
		StringBuffer buf = new StringBuffer();
		for (int i = 1; i < signature.length(); i++) {
			char ch = signature.charAt(i);
			if (ch == '/') {
				buf.append(".");
			} else if (Character.isLetterOrDigit(ch)) {
				buf.append(ch);
			}
		}
		//		System.out.println("Attempting to load class " + buf);
		return Class.forName(buf.toString());
	}

}