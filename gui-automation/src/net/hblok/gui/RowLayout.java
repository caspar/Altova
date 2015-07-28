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

/**
 * @author Havard Rast Blok
 * 
 */
public class RowLayout extends AbstractLayoutManager {

    protected int xGap = 2;

    public void layoutContainer(Container c) {
        Insets insets = c.getInsets();
        int height = c.getHeight() - getYInset(insets);
        int x = xInset + insets.left;
        int y = yInset + insets.top;

        for (Component child : c.getComponents()) {
            Dimension prefSize = child.getPreferredSize();
            child.setSize(prefSize.width, height);
            child.setLocation(x, y);
            x += prefSize.width + xGap;
        }
    }

    public Dimension minimumLayoutSize(Container c) {
        Insets insets = c.getInsets();
        int height = insets.top + insets.bottom;
        int width = xInset + insets.left;

        for (Component child : c.getComponents()) {
            Dimension prefSize = child.getPreferredSize();
            width += prefSize.width + xGap;
            height = Math.max(height, prefSize.height + getYInset(insets));
        }
        width += insets.right;
        return new Dimension(width, height);
    }
    
    private int getYInset(Insets insets) {
        return (insets.top + insets.bottom + yInset * 2);
    }

}
