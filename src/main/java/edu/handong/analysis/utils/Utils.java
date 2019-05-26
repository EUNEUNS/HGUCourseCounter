package edu.handong.analysis.utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

	
	public static ArrayList<String> getLines(String file,boolean removeHeader){
			ArrayList<String> lines = new ArrayList<String>();
        Scanner inputStream = null;
        
        try {
            inputStream = new Scanner (new File (file));
        }  catch (FileNotFoundException e) {
            System.exit (0);
        }
        while (inputStream.hasNextLine ()) {
            String line = inputStream.nextLine ();
            lines.add(line);
            
        }
        if(removeHeader) {
        	 lines.remove(0);
        }
            return lines;
	}
	public static void writeAFile(ArrayList<String> lines, String targetFileName) {
		
		File theDir = new File(targetFileName);
		if (!theDir.exists()) theDir.mkdirs();
		
	}

}
