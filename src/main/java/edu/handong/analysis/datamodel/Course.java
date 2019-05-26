package edu.handong.analysis.datamodel;



public class Course {
	private String studentId;
	private String yearMonthGraduated;
	private String firstMajor;
	private String secondMajor;
	private String courseCode;
	private String courseName;
	private String courseCredit;
	private int yearTaken;
	private int semesterCourseTaken;

	
	
	public Course(String line) { // Split the line from constructor to initialize the field.
		String []aaa = line.split(",\\s");
		setStudentId(aaa[0]);
		setYearMonthGraduated(aaa[1]);
		setFirstMajor(aaa[2]);
		setSecondMajor(aaa[3]);
		setCourseCode(aaa[4]);
		setCourseName(aaa[5]);
		setCourseCredit(aaa[6]);
		setYearTaken(Integer.parseInt(aaa[7]));
		setSemesterCourseTaken(Integer.parseInt(aaa[8]));
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
	public int getYearTaken() {
		return yearTaken;
	}
	public void setYearTaken(int yearTaken) {
		this.yearTaken = yearTaken;
	}
	public String getCourseCredit() {
		return courseCredit;
	}
	public void setCourseCredit(String courseCredit) {
		this.courseCredit = courseCredit;
	}
	public int getSemesterCourseTaken() {
		return semesterCourseTaken;
	}
	public void setSemesterCourseTaken(int semesterCourseTaken) {
		this.semesterCourseTaken = semesterCourseTaken;
	}

	


	
	/* Self-define getter and setter if needed*/	
	
	
}
