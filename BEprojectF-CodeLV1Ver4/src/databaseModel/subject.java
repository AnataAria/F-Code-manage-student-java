package databaseModel;

public class subject {
	private String subjectID;
	private String subjectName;
	private String description;
	private String credits;
	public subject(String subjectID, String subjectName, String description, String credits) {
		super();
		this.subjectID = subjectID;
		this.subjectName = subjectName;
		this.description = description;
		this.credits = credits;
	}
	public String getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCredits() {
		return credits;
	}
	public void setCredits(String credits) {
		this.credits = credits;
	}
	@Override
	public String toString() {
		return subjectID + "," + subjectName + "," + description + "," + credits;
	}
}
