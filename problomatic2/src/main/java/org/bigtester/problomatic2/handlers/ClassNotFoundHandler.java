/*
 * Copyright 2004 Stieglitech, LLC.
 *
 * This file is part of Prob-lo-Matic
 *
 * Prob-lo-Matic is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * Prob-lo-Matic is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Prob-lo-Matic; if not, write to the Free Software
 * Foundation, Inc 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */
package org.bigtester.problomatic2.handlers;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.bigtester.problomatic2.InitException;
import org.bigtester.problomatic2.Problem;
import org.bigtester.problomatic2.ProblemHandler;
import org.bigtester.problomatic2.Recoverable;
import org.bigtester.problomatic2.problems.ClassNotFoundProblem;

/**
 * @author danstieglitz
 * 
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ClassNotFoundHandler extends AbstractProblemHandler
		implements
			ProblemHandler {

	private static final String SEARCH_ROOT = "classnotfoundhandler.searchRoot";
	private static boolean findAllPaths = false;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bigtester.problomatic2.ProblemHandler#init(java.util.Properties)
	 */
	public void init(Properties props) throws InitException {
		// TODO add properties for specific directories to search
		setRequiredProperty(props, SEARCH_ROOT);
	}

	/**
	 * Determines if the supplied .jar file (JarFile object) contains the
	 * specified java class.
	 * 
	 * @param file
	 * @param className
	 * @return true if the specified class is contained in the specified file,
	 *         otherwise false
	 */
	private boolean jarContainsClass(Problem aProblem, JarFile file, String className) {
		Enumeration entries = file.entries();
		//System.out.println("looking for "+constructPath(className));
		while (entries.hasMoreElements()) {
			JarEntry entry = (JarEntry)entries.nextElement();
			//System.out.println("Introspecting "+entry.getName());
			if (entry.getName().equals(constructPath(className))) {
				String msg = "Found "+className+" in "+file.getName();
				System.out.println(msg);
				aProblem.addMessage(msg);
				addMissingPath(aProblem,file.getName());
				return true;
			}
		}
		return false;
	}

	private void addMissingPath(Problem aProblem, String path) {
		List paths = (List)aProblem.getAttribute("missingPaths");
		if (paths==null) {
			paths = new ArrayList();
			aProblem.setAttribute("missingPaths",paths);
		}
		paths.add(path);
	}
	
	/**
	 * Returns the absolute path to the .class file, .jar file containing the
	 * specified class (first found), or null if the class cannot be found on
	 * the local filesystem alone or in an archive.
	 * 
	 * @param className
	 * @return @throws
	 *         IOException
	 */
	private void findPathToClass(Problem aProblem, List results, String rootPath, String className)
			throws IOException {
		// starting at root, traverse the tree and return files
		// having the name package/className, introspecting any
		// jar files found along the way.
		File root = new File(rootPath);
		File[] thisDir = root.listFiles();
		if (!findAllPaths && !results.isEmpty()) {
			return;
		}
		else if (thisDir != null) {
			for (int i = 0; i < thisDir.length; i++) {
				File nextFile = thisDir[i];
				if (nextFile.isDirectory()) {
					//System.out.println("Searching "+nextFile.getAbsolutePath());
					findPathToClass(aProblem,results, nextFile.getAbsolutePath(),
							className);
				}
				if (nextFile.getName().endsWith(".jar")) {
					if (jarContainsClass(aProblem, new JarFile(nextFile), className)) {
						results.add(nextFile.getAbsolutePath());
					}
				} else if (nextFile.getAbsolutePath().endsWith(
						constructPath(className))) {
					results.add(nextFile.getAbsolutePath());
					addMissingPath(aProblem,nextFile.getAbsolutePath());
				}
			}
		}
	}

	/**
	 * Constructs a file path from a fully-qualified Java class name
	 * 
	 * @param className
	 * @return
	 */
	private String constructPath(String className) {
		String str = new String(className);
		String str1 = str.replaceAll("\\.", "" + File.separatorChar);
		String str2 = str1 + ".class";
		return str2;
	}

	private Method findEmptyMethod(String name, Method[] methods) {
		for (int i=0; i<methods.length; i++) {
			Method m = methods[i];
			System.out.println("Found method "+m.getName()+" with "+m.getParameterTypes().length+" types");
			if (m.getName().equals(name) && m.getParameterTypes().length==0) {
				return m;
			}
		}
		return null;
	}
	
	private void appendClasspath(String pathElement) {
		String classpath = System.getProperty("java.class.path");
		classpath = classpath + File.pathSeparator + pathElement;
		System.setProperty("java.class.path",classpath);
	}
	
	private StackTraceElement getLastCallFromClass(StackTraceElement[] stackTrace, String name) {
		for (int i=0; i<stackTrace.length; i++) {
			StackTraceElement elem = stackTrace[i];
			if (elem.getClassName().equals(name)) {
				return elem;
			}
		}
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bigtester.problomatic2.ProblemHandler#handleProblem(org.bigtester.problomatic2.Problem)
	 */
	public void handleProblem(Problem aProblem) {
		if (aProblem instanceof ClassNotFoundProblem) {
			// search local filesystem for problem
			ClassNotFoundProblem problem = (ClassNotFoundProblem) aProblem;

			String className = problem.getClassName();
			ArrayList results = new ArrayList();
			try {
				findPathToClass(aProblem,results, getProperty("searchRoot"), className);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// recovery code
			try {
				Object source = aProblem.getSource();
				if (source instanceof Recoverable) {
					Recoverable recoverableSource = (Recoverable) source;
					Throwable lastException = (Throwable) aProblem.getUnderlyingExceptions().get(0);
					StackTraceElement[] stackTrace = lastException.getStackTrace();
					StackTraceElement elem = getLastCallFromClass(stackTrace,recoverableSource.getClass().getName());
					String methodName = elem.getMethodName();
					System.out.println("Problem occured in method "+methodName);
					Class clazz = source.getClass();
					Method failedMethod = findEmptyMethod(methodName,clazz.getMethods());
					System.out.println("Found method "+failedMethod);
					System.out.println("Attempting to fix "+aProblem.getClass().getName());
					
					// fix problem here
					List missingPaths = (List) problem.getAttribute("missingPaths");
					if (!missingPaths.isEmpty()) {
						try {
							// appendClasspath((String)missingPaths.get(0));
							String url = "file://"+missingPaths.get(0);
							System.out.println("Searching for class in "+url);
//						System.out.println("New java.class.path = "+System.getProperty("java.class.path"));
							URLClassLoader loader = new URLClassLoader(new URL[] { new URL(url) });
							loader.loadClass(lastException.getMessage());
						} catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					// end fix
					
					// TODO investigate and experiment with the various stack issues
					// that this code brings up
					// re-invoke method after having fixed problem
					if (failedMethod!=null) {
						if (!recoverableSource.canRecover()) {
							System.out.println("Can't recover!");
						}
						else if (recoverableSource.canRecover()) {
							recoverableSource.attemptedRecovery();
							System.out.println("Attempting recovery "+recoverableSource.getRecoveryAttemptsCount());
							System.out.println("Invoking "+failedMethod.getName());
							failedMethod.invoke(recoverableSource,null);
							// what happens when the stack returns to this point
							// when recovery is successful? Does it matter?
						} 
						else {
							int attempts = recoverableSource.getMaximumRecoveryAttempts();
							problem.addMessage("Attempted "+attempts+" recoveries to no avail");
						}
					}
				}
			} catch (ArrayIndexOutOfBoundsException ex) {
				// no exceptions, ignore
				return;
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			} 
			
//			System.out.println(results);
		}
	}
	
}