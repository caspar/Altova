package com.altova.robots;

/**
 * A Pane window which does not have the same name in the header of the window
 * and tab. Examples in XMLSpy include Facets->Patterns, Details->SimpleType,
 * etc.
 * 
 * For other Panes which have the same name, like Project, XPath, etc., the
 * {@link Pane} class should be used instead.
 * 
 * @author Havard Rast Blok
 * 
 */
public class TabPane extends Pane {

	String tab;

	public TabPane(Pane mainPane, String tab) {
		super(mainPane.getName(), mainPane.getViewMenu(), mainPane
				.getMenuItem());
		this.tab = tab;
	}

	public String getTab() {
		return tab;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = super.hashCode();
		result = PRIME * result + ((tab == null) ? 0 : tab.hashCode());
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
		final TabPane other = (TabPane) obj;
		if (tab == null) {
			if (other.tab != null)
				return false;
		} else if (!tab.equals(other.tab))
			return false;
		return true;
	}

	
}
