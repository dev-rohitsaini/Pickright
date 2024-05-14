package in.pickright.helpers;

import java.io.File;

public class Helpers {
	
	// Return path of current directory with "/" symbol 
	
	public static String getCurrentDir() {
		String currentDir = System.getProperty("user.dir") + File.separator; 
		return currentDir;
	}

}
