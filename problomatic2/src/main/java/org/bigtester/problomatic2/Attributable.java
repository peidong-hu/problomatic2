package org.bigtester.problomatic2;

import java.util.Map;
import java.util.Set;

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
 * Date: Feb 29, 2004
 * Time: 9:20:00 PM
 */
public interface Attributable {

    public void setAttribute(String name, Object obj);

    public Object getAttribute(String name);

    public boolean hasAttribute(String name);

    public Map getAttributes();

    public Set getAttributeNames();
    
    public Object removeAttribute(String name);

}
