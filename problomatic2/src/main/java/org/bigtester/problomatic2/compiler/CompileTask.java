/*
 * Created on Jul 26, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.bigtester.problomatic2.compiler;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import org.apache.bcel.classfile.ClassFormatException;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.FileSet;

/**
 * @author danstieglitz
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class CompileTask extends Task {

	private final Vector filesets = new Vector();
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.tools.ant.Task#execute()
	 */
	public void execute() throws BuildException {
		if (filesets.isEmpty()) {
			throw new BuildException("You must specify which class files to instrument using a nested filesets element");
		}
		ProblomaticCompiler compiler = new ProblomaticCompiler();
		try {
			for (int i=0; i<filesets.size(); i++) {
				FileSet fs = (FileSet)filesets.elementAt(i);
				DirectoryScanner ds = fs.getDirectoryScanner(project);
				File dir = fs.getDir(project);
				String[] srcs = ds.getIncludedFiles();
				for (int j=0; i<srcs.length; j++) {
					compiler.problomaticizeClass(srcs[j]);
				}
			}
		} catch (ClassFormatException e) {
			throw new BuildException(e);
		} catch (IOException e) {
			throw new BuildException(e);
		} catch (ClassNotFoundException e) {
			throw new BuildException(e);
		}
	}

}