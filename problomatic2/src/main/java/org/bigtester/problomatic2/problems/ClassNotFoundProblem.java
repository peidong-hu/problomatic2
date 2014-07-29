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
package org.bigtester.problomatic2.problems;

import java.util.StringTokenizer;

import org.bigtester.problomatic2.Problem;

/**
 * @author danstieglitz
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ClassNotFoundProblem extends RawProblem implements Problem {
	
	/**
	 * @param source
	 * @param throwable
	 */
	public ClassNotFoundProblem(Object source, ClassNotFoundException throwable) {
		super(source, throwable);
		// TODO Auto-generated constructor stub
	}
	
	public String getClassName() {
		ClassNotFoundException cnfe = (ClassNotFoundException)getUnderlyingExceptions().get(0);
		return cnfe.getMessage();
	}
	
	public String getRootPackage() {
		StringTokenizer st = new StringTokenizer(getClassName(),".");
		if (st.countTokens()==1) {
			return null;
		}
		else {
			return st.nextToken();
		}
	}

}
