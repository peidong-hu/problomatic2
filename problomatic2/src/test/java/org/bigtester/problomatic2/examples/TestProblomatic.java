package org.bigtester.problomatic2.examples;

import org.bigtester.problomatic2.Problomatic;
import org.junit.Test;


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
 * User: danstieglitz
 * Date: Feb 25, 2004
 * Time: 7:56:10 PM
 */
public class TestProblomatic {
	
    public void test1() {
        TestProblomatic tester = new TestProblomatic();
        try {
            Problomatic.addProblemHandlerForProblem("org.bigtester.problomatic2.problems.RawProblem",
                    "org.bigtester.problomatic2.handlers.SystemPrintlnHandler");
            Problomatic.addProblemHandlerForProblem("org.bigtester.problomatic2.problems.RawProblem",
                    "org.bigtester.problomatic2.handlers.EmailNotificationHandler");            
            throw new Exception("This is a test exception");
        } catch (Exception e) {
            Problomatic.handleThrowable(tester, e);
        }
    }

}
