package databaseModel;

public class login {
	private String userName;
	private String passWord;
	private String teacherName;
	/**
	 * @param userName
	 * @param passWord
	 * @param teacherName
	 */
	public login(String userName, String passWord, String teacherName) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.teacherName = teacherName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
}
