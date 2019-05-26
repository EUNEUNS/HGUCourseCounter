package edu.handong.analysis.datamodel;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {

	private String studentId;
	private ArrayList<Course> coursesTaken; // List of courses student has taken
	private HashMap<String,Integer> semestersByYearAndSemester; 
	                                                         // key: Year-Semester
	                                                         // e.g., 2003-1, 
	public Student(String studentId) {
		coursesTaken = new ArrayList<Course>();
		this.studentId=studentId;
		// constructor
	}
	public void setStudentId(String studentId) {
		this.studentId=studentId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void addCourse(Course newRecord) {
		//ArrayList<Course> test =new ArrayList<Course>();
		coursesTaken.add(newRecord);
	  //  setCoursesTaken(test);
}
	public HashMap<String,Integer> getSemestersByYearAndSemester(){
		this.semestersByYearAndSemester = new HashMap<String,Integer>();
	
		return semestersByYearAndSemester;
		}
	
	
	 	
	public int getNumCourseInNthSementer(int semester) {
		
		ArrayList<Course> aaa = new ArrayList <Course>();
		ArrayList<Integer> coursecount =new ArrayList<Integer>();
		aaa = getCoursesTaken();
		int sequenSem = 1;
		int count=1;
		for(Course bbb:aaa) {
			if(this.semestersByYearAndSemester.containsKey
				(Integer.toString(bbb.getYearTaken())+
						Integer.toString(bbb.getSemesterCourseTaken()))) {
				count++;
			}
			else{
				this.semestersByYearAndSemester.put(Integer.toString(bbb.getYearTaken())+
						Integer.toString(bbb.getSemesterCourseTaken()),sequenSem++);
						coursecount.add(count);
						count=1;
								} 
		}
		
		 return coursecount.get(semester-1);
	}
		
	
	
	public void setCoursesTaken(ArrayList<Course> coursesTaken) {
		this.coursesTaken = coursesTaken;
	}
	public ArrayList<Course> getCoursesTaken(){
		
		return this.coursesTaken;
	}


	
	/* Add getter and setter for the field if needed*/


	
	
}
