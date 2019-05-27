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
		this.coursesTaken = new ArrayList<Course>();
		this.studentId=studentId;
		this.semestersByYearAndSemester = new HashMap<String,Integer>();
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
		ArrayList<Course> aaa = new ArrayList <Course>();
		aaa = getCoursesTaken();
		int sequenSem = 1;
		for(Course bbb:aaa) {
			if(!semestersByYearAndSemester.containsKey
				(Integer.toString(bbb.getYearTaken())+
						Integer.toString(bbb.getSemesterCourseTaken()))) {
				semestersByYearAndSemester.put(Integer.toString(bbb.getYearTaken())+
						Integer.toString(bbb.getSemesterCourseTaken()),sequenSem);
						sequenSem++;
			}
		}
		
		
		
		return semestersByYearAndSemester;
		}
	public int getNumCourseInNthSemester(int semester) {
		
		int count=0;
		for(String ccc:semestersByYearAndSemester.keySet()) {
			count++;
	if(semester==(semestersByYearAndSemester.get(ccc))) {
		
	}
	
			
	}
		return count;
	}
		
	
		
	public void setCoursesTaken(ArrayList<Course> coursesTaken) {
		this.coursesTaken = coursesTaken;
	}
	public ArrayList<Course> getCoursesTaken(){
		
		return this.coursesTaken;
	}


	
	/* Add getter and setter for the field if needed*/


	
	
}
