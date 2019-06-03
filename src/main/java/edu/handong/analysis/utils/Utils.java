package edu.handong.analysis.utils;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Utils {

	public static ArrayList<CSVRecord> getLines(String file) {

		ArrayList<CSVRecord> lines = new ArrayList<CSVRecord>();
		CSVParser csvParser;
		try {
			Reader reader = Files.newBufferedReader(Paths.get(file));
			csvParser = new CSVParser(reader, CSVFormat.EXCEL.withIgnoreSurroundingSpaces().withFirstRecordAsHeader()
					.withIgnoreHeaderCase().withTrim());
			Iterator<CSVRecord> iter = csvParser.iterator();

			while (iter.hasNext()) {

				lines.add(iter.next());
				// System.out.println(iter.next());
			}
		} catch (IOException e) {
			System.exit(0);
		}

		/*
		 * Iterator<CSVRecord> iter = csvParser.iterator(); while(iter.hasNext()) {
		 * 
		 * lines.add(iter.next());
		 * 
		 * }
		 */
		return lines;
	}

	public static void writeAFile(ArrayList<String> lines, String targetFileName) {

		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(targetFileName));

			for (String dom : lines) {
				fw.write(dom);
				fw.newLine();

			}
			fw.flush();
			fw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("The file path does not exist. Please check your CLI argument!");

		}

	}

}
