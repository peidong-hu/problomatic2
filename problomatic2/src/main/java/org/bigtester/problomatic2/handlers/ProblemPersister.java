package org.bigtester.problomatic2.handlers;

import java.util.Properties;

import org.bigtester.problomatic2.InitException;
import org.bigtester.problomatic2.Persistable;
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
 * Persist a problem to the database for posterity. The problem must implement the Persistable
 * interface to be persisted. If the problem does not implement Persistable, it is not stored.
 * The following information is stored; an asterisk indicates a non-null field: Problem class name*,
 * Source class name*, Occurance timestamp*, Attributes, Stack trace* 
 * User: danstieglitz
 * Date: Feb 29, 2004
 * Time: 3:38:21 PM
 */
public class ProblemPersister extends AbstractProblemHandler {

    private static final String DATABASE_URL = "problempersister.database.url";
    private static final String DATABASE_USERNAME = "problempersister.database.username";
    private static final String DATABASE_PASSWORD = "problempersister.database.password";
    private static final String DATABASE_DRIVER = "problempersister.database.driver";

    private Properties properties;

    public void init(Properties props) throws InitException {
        setRequiredProperty(props,DATABASE_URL);
        setRequiredProperty(props,DATABASE_USERNAME);
        setRequiredProperty(props,DATABASE_PASSWORD);
        setRequiredProperty(props,DATABASE_DRIVER);
    }

    public void handleProblem(Problem aProblem) {
        if (aProblem instanceof Persistable) {
        //todo: Write problem to database according to schema specified in properties file
        //todo: essentially, each column of the database maps to a property key

        }
    }
}
