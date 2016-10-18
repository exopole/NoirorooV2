package utils;

import javax.swing.ImageIcon;

public class UtilsImage {
	
	
	/** Returns an ImageIcon, or null if the path was invalid. */
	static public ImageIcon createImageIcon(String path,
	                                           String description) {
	    if (path != null) {
	        return new ImageIcon(path, description);
	    } else {
	        System.err.println("Couldn't find file: " + path);
	        return null;
	    }
	}
}
