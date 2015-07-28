package com.altova.robots;

/**
 * Identifying class for an internal window/pane component, where the tab and
 * header names are the same. Examples in the Altova applications include: The
 * Message Window, UModel Model Tree, etc.
 * 
 * For tabs which don't share the header name, like Facets->Patterns,
 * Details->SimpleType, etc. in XMLSpy, use the {@link TabPane} instead.
 * 
 * @author Havard Rast Blok
 * 
 */
public class Pane extends SnapshotArea {

	/**
	 * TODO is this good...?
	 * 
	 * @author Havard Rast Blok
	 * 
	 */
	public static enum PaneSize {
		SMALL(100), NORMAL(200), LARGE(250) , WIDE(320), EXTRAWIDE(400);

		int width;

		PaneSize(int width) {
			this.width = width;
		}

		public int getWidth() {
			return width;
		}
	}

	private String viewMenu;

	private String menuItem;

	/**
	 * Constructs a Pane class with the specified name, and where the windows is
	 * identified with the same name on the View menu in the Altova application.
	 * 
	 * @param name
	 *            the name of the pane/window as it is shown on screen (and on
	 *            the View menu).
	 */
	public Pane(String name) {
		this(name, "View", name);
	}

	/**
	 * Constructs a Pane class with the specified name, where the view menu
	 * equivalent is different, on/or the menu item on this menu is not the same
	 * as the pane name. An example of this is <i>XPath</i> pane in XMLSpy,
	 * where the menu is called <i>Window</i> and the menu item is called
	 * <i>Output windows</i>.
	 * 
	 * @param name
	 *            the name of the pane/window as it is shown on screen.
	 * @param viewMenu
	 *            the menu which contains the menu item for the pane
	 * @param viewMenuItem
	 *            the menu item which will show or hide the pane
	 */
	public Pane(String name, String viewMenu, String viewMenuItem) {
		super(name);
		this.viewMenu = viewMenu;
		this.menuItem = viewMenuItem;
	}

	public String getViewMenu() {
		return viewMenu;
	}

	public String getMenuItem() {
		return menuItem;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = super.hashCode();
		result = PRIME * result + ((menuItem == null) ? 0 : menuItem.hashCode());
		result = PRIME * result + ((viewMenu == null) ? 0 : viewMenu.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Pane other = (Pane) obj;
		if (menuItem == null) {
			if (other.menuItem != null)
				return false;
		} else if (!menuItem.equals(other.menuItem))
			return false;
		if (viewMenu == null) {
			if (other.viewMenu != null)
				return false;
		} else if (!viewMenu.equals(other.viewMenu))
			return false;
		return true;
	}

	
}