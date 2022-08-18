package databaseModel;

public class grade {
	private String studentID;
	private String subjectID;
	private double labs;
	private double progressTest;
	private double finalExam;
	private double average;
	private String grade;
	/**
	 * @param studentID
	 * @param subjectID
	 * @param labs
	 * @param progressTest
	 * @param finalExam
	 * @param average
	 * @param grade
	 */
	public grade(String studentID, String subjectID, double labs, double progressTest, double finalExam, double average, String grade) {
		super();
		this.studentID = studentID;
		this.subjectID = subjectID;
		this.labs = labs;
		this.progressTest = progressTest;
		this.finalExam = finalExam;
		this.average = average;
		this.grade = grade;
	}
	
	public double getLabs() {
		return labs;
	}
	public void setLabs(double labs) {
		this.labs = labs;
	}
	public double getProgressTest() {
		return progressTest;
	}
	public void setProgressTest(double progressTest) {
		this.progressTest = progressTest;
	}
	public double getFinalExam() {
		return finalExam;
	}
	public void setFinalExam(double finalExam) {
		this.finalExam = finalExam;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
	@Override
	public String toString() {
		return studentID + "," + subjectID + "," + labs + "," + progressTest + "," + finalExam + "," + average + "," + grade;
	}

	
}
