package validate;

import java.time.format.DateTimeFormatter;

public class validate {
	public String userName;
	private String passWord;
	private String studentName;
	private String ID;

	public validate(java.lang.String userName, java.lang.String passWord, java.lang.String studentName, java.lang.String ID) {
		this.userName = userName;
		this.passWord = passWord;
		this.studentName = studentName;
		this.ID = ID;
	}
	public validate() {
		
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
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public boolean checkUserNameInput() {
		boolean flag = true;
		if(userName.length() > 8) {
			int checkUppercase = 0;
			int checkNumber = 0;
			for(int i = 0; i < userName.length(); i++) {
				if(Character.isUpperCase(userName.charAt(i))) {
					checkUppercase++;
				}
				if(Character.isDigit(userName.charAt(i))) {
					checkNumber++;
				}
			}
			if(checkUppercase == 0 || checkNumber == 0) {
				flag = false;
			}
		}
		else {
			flag = false;
		}
		return flag;
	}
	public boolean checkPasswordInput() {
		boolean flag = true;
		if(passWord.length() > 8) {
			int checkUppercase = 0;
			int checkNumber = 0;
			for(int i = 0; i < passWord.length(); i++) {
				if(Character.isUpperCase(passWord.charAt(i))) {
					checkUppercase++;
				}
				if(Character.isDigit(passWord.charAt(i))) {
					checkNumber++;
				}
			}
			if(checkUppercase == 0 || checkNumber == 0) {
				flag = false;
			}
		}
		else {
			flag = false;
		}
		return flag;
	}
	
	public boolean isEmailValid(String email) {
	      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      return email.matches(regex);
	}
	public boolean checkInt(String Input) {
		if (Input == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(Input);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	public boolean credits(String credits) {
		boolean flag = false;
		if(Integer.parseInt(credits) >= 0 && Integer.parseInt(credits)<=10 ) {
			flag = true;
		}
		return flag;
	}
	public boolean checkScore(String Input) {
		if (Input == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(Input);
	        if (d > 0 && d < 10) return true;
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
//	public static boolean daytimeValidate(String dayTime) {
//		DateTimeFormatter formatter = new DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		try {
//			formatter.parse(dayTime);
//		}catch(Exception e) {
//			return false;
//		}
//		
//	}
}
