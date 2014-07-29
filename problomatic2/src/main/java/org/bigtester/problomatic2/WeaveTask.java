/*
 * Created on Jul 26, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.bigtester.problomatic2;

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
public class WeaveTask extends Task {

	private final Vector filesets = new Vector();
	
	private boolean verbose;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.tools.ant.Task#execute()
	 */
	public void execute() throws BuildException {
		if (verbose) {
			System.out.println("Executing WeaveTask");
		}
		if (filesets.isEmpty()) {
			throw new BuildException("You must specify which class files to instrument using a nested filesets element");
		}
		ProblomaticWeaver weaver = new ProblomaticWeaver();
		try {
			for (int i=0; i<filesets.size(); i++) {
				FileSet fs = (FileSet)filesets.elementAt(i);
				if (verbose) {
					System.out.println(fs.getSelectors(project));
				}
				DirectoryScanner ds = fs.getDirectoryScanner(project);
//				File dir = fs.getDir(project);
				String[] srcs = ds.getIncludedFiles();
				if (verbose) {
					System.out.println("Found "+srcs.length+" files to process");
				}
				for (int j=0; j<srcs.length; j++) {
					String fullpath = ds.getBasedir().toString()+File.separatorChar+srcs[j];
					if (verbose) {
						System.out.println("Processing "+fullpath);
					}
					weaver.problomaticizeClass(fullpath);
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
	
	public void addFileset(FileSet fileset) {
		filesets.add(fileset);
	}

	public boolean isVerbose() {
		return verbose;
	}
	
	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}
}