package org.bigtester.problomatic2;


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
 * A Solution encapsulates all the information needed to attempt to solve a Problem. Solutions
 * can be chained to attempt multiple solutions for a particular problem. A Solution requires
 * information about the context in which the problem occured to do its job. For example, if
 * the solution involves retrying a database call, the original database connection is required
 * to attempt the solution. Additional information may be required, such as the URL, username and password
 * of a secondary database. This information should be put to a Solution's attributes.
 * User: danstieglitz
 * Date: Feb 29, 2004
 * Time: 9:08:32 PM
 */
public interface Solution extends Attributable {

    /**
     * Attempt to solve a particular problem that occured. The context in which the problem occured
     * can by obtained by calling aProblem.getContext();
     * @param aProblem
     */
    public void attemptSolution(Problem aProblem);


    /**
     * Indicate if the solution that was applied was successful or not.
     * @return
     */
    public boolean wasSuccessful();
}
