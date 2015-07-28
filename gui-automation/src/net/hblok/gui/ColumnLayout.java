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
public class ColumnLayout extends AbstractLayoutManager {

    protected int yGap = 2;

    public void layoutContainer(Container c) {
        Insets insets = c.getInsets();
        int width = c.getWidth() - getXInset(insets);
        int x = xInset + insets.left;
        int y = yInset + insets.top;

        for (Component child : c.getComponents()) {
            Dimension prefSize = child.getPreferredSize();
            child.setSize(width, prefSize.height);
            child.setLocation(x, y);
            y += prefSize.height + yGap;
        }
    }

    public Dimension minimumLayoutSize(Container c) {
        Insets insets = c.getInsets();
        int height = yInset + insets.top;
        int width = insets.left + insets.right;

        for (Component child : c.getComponents()) {
            Dimension prefSize = child.getPreferredSize();
            height += prefSize.height + yGap;
            width = Math.max(width, prefSize.width + getXInset(insets));
        }
        height += insets.bottom;
        return new Dimension(width, height);
    }
    
    private int getXInset(Insets insets) {
        return insets.left + insets.right + xInset * 2;
    }

}
