package edu.handong.analysis.datamodel;

import org.apache.commons.csv.CSVRecord;

public class Course {
	private String studentId;
	private String yearMonthGraduated;
	private String firstMajor;
	private String secondMajor;
	private String courseCode;
	private String courseName;
	private String courseCredit;
	private String yearTaken;
	private String semesterCourseTaken;

	
	
	public Course(CSVRecord line) { // Split the line from constructor to initialize the field.
		setStudentId(line.get(0));
		setYearMonthGraduated(line.get(1));
		setFirstMajor(line.get(2));
		setSecondMajor(line.get(3));
		setCourseCode(line.get(4));
		setCourseName(line.get(5));
		setCourseCredit(line.get(6));
		setYearTaken(line.get(7));
		setSemesterCourseTaken(line.get(8));
		}
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}



	public String getYearMonthGraduated() {
		return yearMonthGraduated;
	}



	public void setYearMonthGraduated(String yearMonthGraduated) {
		this.yearMonthGraduated = yearMonthGraduated;
	}
	public String getFirstMajor() {
		return firstMajor;
	}
	public void setFirstMajor(String firstMajor) {
		this.firstMajor = firstMajor;
	}
	public String getSecondMajor() {
		return secondMajor;
	}
	public void setSecondMajor(String secondMajor) {
		this.secondMajor = secondMajor;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getYearTaken() {
		return yearTaken;
	}
	public void setYearTaken(String yearTaken) {
		this.yearTaken = yearTaken;
	}
	public String getCourseCredit() {
		return courseCredit;
	}
	public void setCourseCredit(String courseCredit) {
		this.courseCredit = courseCredit;
	}
	public String getSemesterCourseTaken() {
		return semesterCourseTaken;
	}
	public void setSemesterCourseTaken(String semesterCourseTaken) {
		this.semesterCourseTaken = semesterCourseTaken;
	}

	


	
	/* Self-define getter and setter if needed*/	
	
	
}
