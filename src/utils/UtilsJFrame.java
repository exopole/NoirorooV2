package utils;

import java.awt.DisplayMode;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class UtilsJFrame {
	static public void setMaximized(JFrame frame, boolean maximized){
	    if(maximized){
	        DisplayMode mode = frame.getGraphicsConfiguration().getDevice().getDisplayMode();
	        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration());
	        frame.setMaximizedBounds(new Rectangle(
	                mode.getWidth() - insets.right - insets.left, 
	                mode.getHeight() - insets.top - insets.bottom
	        ));
	        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
	    }else{
	    	frame.setExtendedState(JFrame.NORMAL);
	    }
	}
}
