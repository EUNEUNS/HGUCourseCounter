package edu.handong.analysis;

import java.util.ArrayList;
import org.apache.commons.csv.CSVRecord;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

//import org.apache.commons.cli.CommandLineParser;
//import org.apache.commons.cli.DefaultParser;
//import org.apache.commons.cli.Option;
//import org.apache.commons.cli.Options;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;
//import edu.handong.analysis.utils.NotEnoughArgumentException;
import edu.handong.analysis.utils.Utils;

public class HGUCoursePatternAnalyzer {

	private HashMap<String,Student> students;
	private HashMap<String,ArrayList<Course>> duringCourses;
	private boolean help;
	private String inputPath ;
	private String outputPath; 
	private String analysis;
	private String coursecode;
	private String startyear;
	private String endyear;


	/**
	 * This method runs our analysis logic to save the number courses taken by each student per semester in a result file.
	 * Run method must not be changed!!
	 * @param args
	 */
	public void run(String[] args) {

		try {
			// when there are not enough arguments from CLI, it throws the NotEnoughArgmentException which must be defined by you.
			/*		if(args.length<1)
			throw new NotEnoughArgumentException();
		} catch (NotEnoughArgumentException e) {
		System.out.println(e.getMessage());
			System.exit(0);
		}*/
			Options options = createOptions();
			if(parseOption(options, args)) {

				if (help) {
					printHelp(options);
					System.exit(0);
				}

				ArrayList<CSVRecord> lines = Utils.getLines(inputPath);


				if(analysis.equals("1")) {
					students = loadStudentCourseRecords(lines);
					// To sort HashMap entries by key values so that we can save the results by student ids in ascending order.
					Map<String, Student> sortedStudents = new TreeMap<String,Student>(students); 

					// Generate result lines to be saved.
					ArrayList<String> linesToBeSaved = countNumberOfCoursesTakenInEachSemester(sortedStudents);

					// Write a file (named like the value of resultPath) with linesTobeSaved.

					Utils.writeAFile(linesToBeSaved, outputPath);
				}
				else if (analysis.equals("2")) {

					this.duringCourses=new HashMap<String,ArrayList<Course>>();

					duringCourses=countTotalCourses(lines);
					Map<String,ArrayList<Course>> duringCour = new TreeMap<String,ArrayList<Course>>(duringCourses); 


					ArrayList<String> resultresult = countCourseStudnet(duringCour);

					Utils.writeAFile(resultresult, outputPath);


				}

			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	private boolean parseOption(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cmd = parser.parse(options, args);
			inputPath = cmd.getOptionValue("i");
			outputPath= cmd.getOptionValue("o");
			analysis = cmd.getOptionValue("a");
			coursecode = cmd.getOptionValue("c");
			startyear = cmd.getOptionValue("s");			
			endyear = cmd.getOptionValue("e");
		}catch(Exception e) {
			printHelp(options);
			System.exit(1);
		}

		return true;
	}
	private void printHelp( Options options) {
		HelpFormatter formatter = new HelpFormatter();
		String header = "HGU Course Analyzer";
		String footer ="";
		formatter.printHelp("HGU CourseCounter", header, options, footer ,true);
	}

	private Options createOptions() {
		Options options = new Options();
		options.addOption(Option.builder("i").longOpt("input")
				.desc("Set an input file path")
				.hasArg()
				.argName("Input path")
				.required()
				.build());
		options.addOption(Option.builder("o").longOpt("output")
				.desc("Set an output file path")
				.hasArg()
				.argName("Output path")
				.required()
				.build());
		options.addOption(Option.builder("a").longOpt("analysis")
				.desc("1: Count courses per semester, 2: Count per course name and year")
				.hasArg()
				.argName("Analysis option")
				.required()
				.build());
		options.addOption(Option.builder("c").longOpt("coursecode")
				.desc("Course code for '-a 2' option")
				.hasArg()
				.argName("course code")
				.build());
		options.addOption(Option.builder("s").longOpt("startyear")
				.desc("Set the start year for analysis e.g., -s 2002")
				.hasArg()
				.argName("Start year for analysis")
				.required()
				.build());
		options.addOption(Option.builder("e").longOpt("endyear")
				.desc("Set the end year for analysis e.g., -e 2005")
				.hasArg()
				.argName("End year for analysis")
				.required()
				.build());
		options.addOption(Option.builder("h").longOpt("help")
				.desc("Show a Help page")
				.argName("Help")
				.build());


		return options;
	}


	/**
	 * This method create HashMap<String,Student> from the data csv file. 
	 * 
	 * Key is a student id and the corresponding object is an instance of Student.
	 * The Student instance have all the Course instances taken by the student.
	 * @param lines
	 * @return
	 */

	private HashMap<String,Student> loadStudentCourseRecords(ArrayList<CSVRecord> lines) {
		HashMap<String,Student> loadStuCourse = new HashMap<String,Student>();
		for(CSVRecord line: lines) {
			Course cour = new Course(line);
			Student stustu = new Student(cour.getStudentId());

			if(loadStuCourse.containsKey(cour.getStudentId())) {
				loadStuCourse.get(stustu.getStudentId()).addCourse(cour);

			}else {
				stustu.addCourse(cour);


				loadStuCourse.put(stustu.getStudentId(),stustu);


			}
		}
		return loadStuCourse;

		/*

		for(int i=0; i < lines.size();i++) {
			String line = lines.get(i);
			String[] names = line.split(("\\s,\\s"));
			String name = names[0];
			String course = names[5];
			Student stustu = new Student(name);
			if(!stu.contains(stustu)) {
				stu.add(stustu);
		if(loadStuCourse.containsKey(stu.contains(stustu))) {

		}else {


		}*/



		// TODO: Implement this method	

		// do not forget to return a proper variable.

	}

	/**
	 * This method generate the number of courses taken by a student in each semester. The result file look like this:
	 * StudentID, TotalNumberOfSemestersRegistered, Semester, NumCoursesTakenInTheSemester
	 * 0001,14,1,9
	 * 0001,14,2,8
	 * ....
	 * 0001,14,1,9 => this means, 0001 student registered 14 semeters in total.
	 * In the first semeter (1), the student took 9 courses.
	 * @param sortedStudents
	 * @return
	 */
	private ArrayList<String> countNumberOfCoursesTakenInEachSemester(Map<String, Student> sortedStudents) {
		ArrayList<String> countNumOfCour = new ArrayList<String>();
		int totalSem=0;
		for(Map.Entry<String,Student> entry : sortedStudents.entrySet()) {
			Student studentToCheck = entry.getValue();
			String studentId = studentToCheck.getStudentId();

			totalSem = studentToCheck.getSemestersByYearAndSemester().size();
			for(int j=1; j<=studentToCheck.getSemestersByYearAndSemester().size();j++) {
				int numOfCour = studentToCheck.getNumCourseInNthSemester(j);
				String result = studentId+","+totalSem+"," + j + "," + numOfCour;
				countNumOfCour.add(result);
			}
		}

		// TODO: Implement this method

		return countNumOfCour; // do not forget to return a proper variable.
	}


	private HashMap<String,ArrayList<Course>> countTotalCourses(ArrayList<CSVRecord> lines){
		HashMap<String,ArrayList<Course>> HashCount=new HashMap<String,ArrayList<Course>> ();
		for(CSVRecord line:lines) {

			Course cour = new Course(line);
			if(Integer.parseInt(startyear)<=Integer.parseInt(cour.getYearTaken())&&
					Integer.parseInt(endyear)>=Integer.parseInt(cour.getYearTaken())) {

				if(HashCount.containsKey(cour.getYearTaken()+" "+cour.getSemesterCourseTaken())) {
					HashCount.get((cour.getYearTaken()+" "+cour.getSemesterCourseTaken())).add(cour);

				}else {
					ArrayList<Course> courses = new ArrayList<Course>();
					HashCount.put(cour.getYearTaken()+" "+cour.getSemesterCourseTaken(),courses);
					courses.add(cour);
				}			
			}
		}
		return HashCount;
	}
	private ArrayList<String> countCourseStudnet( Map<String,ArrayList<Course>> duringCour){
		ArrayList<String> finalresult = new ArrayList<String>();
			String courseName = null;

			float rate =0;
			
			for(Map.Entry<String,ArrayList<Course>> entry : duringCour.entrySet()) {
			ArrayList<Course> cour = entry.getValue();
			ArrayList<String> totalStudents = new ArrayList<String>();
			int totalStu = 0;
			int semStu=0;
			String aaa[] = entry.getKey().split(" ");
			String year =aaa[0];
			String semester = aaa[1];
			
			for(Course course: cour) {
				
				if(!totalStudents.contains(course.getStudentId()))
					totalStudents.add(course.getStudentId());
					totalStu++;
				if(course.getCourseCode().equals(this.coursecode)) {
					semStu++;
					courseName = course.getCourseName();
				}

				rate=(semStu/(float)totalStu)*100;
				
			}
			String result = year+","+semester+","  + coursecode+ ","+ courseName +","+totalStu+","+semStu+","+String.format("%.1f", rate);
			finalresult.add(result);
		}


		return finalresult;
	}

}











































