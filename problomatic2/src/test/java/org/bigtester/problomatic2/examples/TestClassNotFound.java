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
package org.bigtester.problomatic2.examples;

import org.bigtester.problomatic2.Problomatic;
import org.bigtester.problomatic2.problems.ClassNotFoundProblem;
import org.junit.Test;

/**
 * @author danstieglitz
 * 
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TestClassNotFound {

	/**
	 *  
	 */
	public TestClassNotFound() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Test
	public void main1() {
		try {
		    // now Prob-lo-Matic automatically configures itself for this kind of problem
		    //	Problomatic.addProblemHandlerForProblem(ClassNotFoundProblem.class,
		    //			ClassNotFoundHandler.class);
			String className = "a.non.existant.Class";
			System.out.println("Searching for "+className);
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// for this to reallw work, so should have Maven downloaded somewhere on 
		// your system. If you don't, replace className with some class you do
		// have on the filesystem (make sure it's not already on the classpath).
		
		try {
			String className = "org.bigtester.problomatic2.examples.Configuration";
			System.out.println("Searching for "+className);
			Class.forName(className);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
