/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-2005, by Object Refinery Limited and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License as published by 
 * the Free Software Foundation; either version 2.1 of the License, or 
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public 
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License 
 * along with this library; if not, write to the Free Software Foundation, 
 * Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc. 
 * in the United States and other countries.]
 *
 * -------------
 * TickUnit.java
 * -------------
 * (C) Copyright 2001-2005, by Object Refinery Limited.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * $Id: TickUnit.java,v 1.5 2005/10/27 14:12:16 mungady Exp $
 *
 * Changes (from 19-Dec-2001)
 * --------------------------
 * 19-Dec-2001 : Added standard header (DG);
 * 01-May-2002 : Changed the unit size from Number to double (DG);
 * 26-Sep-2002 : Fixed errors reported by Checkstyle (DG);
 * 08-Nov-2002 : Moved to new package com.jrefinery.chart.axis (DG);
 * 26-Mar-2003 : Implemented Serializable (DG);
 * 05-Sep-2005 : Implemented hashCode(), thanks to Thomas Morgner (DG);
 *
 */

package org.jfree.chart.axis;

import java.io.Serializable;

/**
 * Base class representing a tick unit.  This determines the spacing of the
 * tick marks on an axis.
 * <P>
 * This class (and any subclasses) should be immutable, the reason being that
 * ORDERED collections of tick units are maintained and if one instance can be
 * changed, it may destroy the order of the collection that it belongs to.
 * In addition, if the implementations are immutable, they can belong to
 * multiple collections.
 *
 * @see ValueAxis
 */
public abstract class TickUnit implements Comparable, Serializable {

    /** For serialization. */
    private static final long serialVersionUID = 510179855057013974L;
    
    /** The size of the tick unit. */
    private double size;

    /**
     * Constructs a new tick unit.
     *
     * @param size  the tick unit size.
     */
    public TickUnit(double size) {
        this.size = size;
    }

    /**
     * Returns the size of the tick unit.
     *
     * @return The size of the tick unit.
     */
    public double getSize() {
        return this.size;
    }

    /**
     * Converts the supplied value to a string.
     * <P>
     * Subclasses may implement special formatting by overriding this method.
     *
     * @param value  the data value.
     *
     * @return Value as string.
     */
    public String valueToString(double value) {
        return String.valueOf(value);
    }

    /**
     * Compares this tick unit to an arbitrary object.
     *
     * @param object  the object to compare against.
     *
     * @return <code>1</code> if the size of the other object is less than this,
     *      <code>0</code> if both have the same size and <code>-1</code> this
     *      size is less than the others.
     */
    public int compareTo(Object object) {

        if (object instanceof TickUnit) {
            TickUnit other = (TickUnit) object;
            if (this.size > other.getSize()) {
                return 1;
            }
            else if (this.size < other.getSize()) {
                return -1;
            }
            else {
                return 0;
            }
        }
        else {
            return -1;
        }

    }

    /**
     * Tests this unit for equality with another object.
     *
     * @param obj  the object.
     *
     * @return <code>true</code> or <code>false</code>.
     */
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof TickUnit) {
            TickUnit tu = (TickUnit) obj;
            return this.size == tu.size;
        }
        return false;

    }

    /**
     * Returns a hash code for this instance.
     * 
     * @return A hash code.
     */
    public int hashCode() {
        final long temp = size != +0.0d ? Double.doubleToLongBits(size) : 0L;
        return (int) (temp ^ (temp >>> 32));
    }
}