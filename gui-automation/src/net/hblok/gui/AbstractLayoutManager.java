/*
    Blok Utils - Various utility classes in the hblok.net domain.  
    Copyright (C) 2005  Havard Rast Blok
    http://hblok.sourceforge.net
    
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.
    
    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.
    
    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/

package net.hblok.gui;

import java.awt.*;
import java.awt.Component;
import java.awt.LayoutManager;

/**
 * @author Havard Rast Blok
 *
 */
public abstract class AbstractLayoutManager implements LayoutManager {
    protected int xInset = 4;

    protected int yInset = 4;

    protected int xGap = 2;

    public void addLayoutComponent(String s, Component c) {
    }

    public Dimension preferredLayoutSize(Container c) {
        return minimumLayoutSize(c);
    }

    public void removeLayoutComponent(Component c) {
    }

}
