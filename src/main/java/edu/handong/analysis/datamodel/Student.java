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
				(bbb.getYearTaken()+
				bbb.getSemesterCourseTaken())) {
				semestersByYearAndSemester.put(bbb.getYearTaken()+bbb.getSemesterCourseTaken(),
												sequenSem);
						sequenSem++;
			}
		}
		
		
		
		return semestersByYearAndSemester;
		}
	
	public int getNumCourseInNthSemester(int semester) {
		
		int count=0;	
		HashMap<String, Integer> aaa = new HashMap <String, Integer>();
		aaa =this.getSemestersByYearAndSemester();
		for(int value:aaa.values()) {
			if(value ==semester) {
				String realValue = getKey(aaa,value);
				for (Course courseTaken : coursesTaken) {
					String whenStudy =courseTaken.getYearTaken()+
									   courseTaken.getSemesterCourseTaken();
					if(whenStudy.contentEquals(realValue))
						count++;
							}
						}
					}
		return count;
	}
		
	private String getKey(HashMap<String, Integer> aaa, int value) {
		for(String a :aaa.keySet()) {
			if(aaa.get(a).equals(value))
			{
				return a;
			}
		}
		// TODO Auto-generated method stub
		return null;
	}
	
		

	public void setCoursesTaken(ArrayList<Course> coursesTaken) {
		this.coursesTaken = coursesTaken;
	}
	public ArrayList<Course> getCoursesTaken(){
		
		return this.coursesTaken;
	}


	
	/* Add getter and setter for the field if needed*/


	
	
}
