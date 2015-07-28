package com.altova.util;

import static com.altova.util.LoggerUtils.logger;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

/**
 * This class functions as a simple interface against the OS clipboard. 
 * 
 * @author Havard Rast Blok
 *
 */
public abstract class ClipboardUtils implements ClipboardOwner{
	
    // avoid construction
    private ClipboardUtils() {
    }

    /**
     * Returns the contents of the clipboard, or null if it was empty
     * or contained non-text data.
     * @return The system clipboard contents as a String,
     * 	or null if it was empty or could not be copied as a String.
     */
	public static String getClipboardContents() {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		try {
			Transferable contents = clipboard.getContents(null);

			// only get strings from the clipboard
			if (contents == null || !contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
				return null;
			}
			return (String) contents.getTransferData(DataFlavor.stringFlavor);
			
		} catch (Exception e) {
			logger.warning("getClipboardContents failed: \n\n" + IOUtils.getStackTrace(e));
		}

		return null;
	}
	
	/**
	 * Place a String on the clipboard, and make this class the
	 * owner of the Clipboard's contents.
	 */

	public static void setClipboardContents(String aString) {
		StringSelection stringSelection = new StringSelection(aString);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		ClipboardOwner n=null;
		clipboard.setContents(stringSelection, n);
	}
}
