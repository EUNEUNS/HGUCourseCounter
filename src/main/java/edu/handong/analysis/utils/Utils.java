package edu.handong.analysis.utils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
		
		try {
			BufferedWriter fw =
					new BufferedWriter(new FileWriter(targetFileName));
				
		for(String dom : lines) {
			fw.write(dom);
			fw.newLine();
			
		}
		fw.flush();
			fw.close();
		}
		catch(Exception e ) {
			System.out.println(e.getMessage());
			System.out.println("The file path does not exist. Please check your CLI argument!");
			
		}
		
	}

}
