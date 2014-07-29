package org.bigtester.problomatic2.problems;

import java.util.ArrayList;
import java.util.List;

import org.bigtester.problomatic2.AbstractAttributeObject;
import org.bigtester.problomatic2.Problem;

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

/**
 * User: danstieglitz Date: Feb 25, 2004 Time: 6:42:28 PM
 */
public abstract class AbstractProblem extends AbstractAttributeObject implements
		Problem {

	public AbstractProblem() {
		super.setAttribute("problomatic.messages",new ArrayList());
		super.setAttribute("problomatic.underlyingExceptions",new ArrayList());
		super.setAttribute("problomatic.occuredOn",new java.util.Date().getTime()+"");
	}
	
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("Problem " + getClass().getName() + " occured\n");
		buf.append(this.getAttributes());
		return buf.toString();
	}

	public void addMessage(String message) {
		getMessages().add(message);
	}

	public List getMessages() {
		return (List) super.getAttribute("problomatic.messages");
	}

	public List getUnderlyingExceptions() {
		return (List) super.getAttribute("problomatic.underlyingExceptions");
	}
	
	public void addUnderlyingException(Throwable exception) {
		getUnderlyingExceptions().add(exception);
	}

}