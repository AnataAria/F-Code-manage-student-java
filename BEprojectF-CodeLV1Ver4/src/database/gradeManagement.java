package database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import databaseModel.grade;

public class gradeManagement {
	private ArrayList<grade> gradeList = new ArrayList<grade>();
	
	public gradeManagement() {
		
	}
	
	public boolean isStudentEmpty(String studentID) {
		boolean flag = true;
		for(grade gradeElement : gradeList) {
			if(gradeElement.getStudentID().equals(studentID)) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	public boolean isSubjectEmpty(String subjectID) {
		boolean flag = true;
		for(grade gradeElement : gradeList) {
			if(gradeElement.getSubjectID().equals(subjectID)) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	public void addNewGrade(ArrayList<grade> newGrade) {
		this.gradeList.addAll(newGrade);
		try {
			pullToFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void uploadModel() throws IOException {
		FileReader fileReader = new FileReader("E:\\JavaOOPTraining\\BEprojectF-CodeLV1Ver4\\BEprojectF-CodeLV1Ver4\\src\\data\\grade.csv");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = "";
		String[] temp;
		try {
			while((line = bufferedReader.readLine()) != null) {
				temp = line.split(",");
				String studentID = temp[0];
				String subjectID = temp[1];
				String labs = temp[2];
				String progressTest = temp[3];
				String finalExam = temp[4];
				String average = temp[5];
				String grade = temp[6];
				grade gradeForm = new grade(studentID, subjectID, Double.parseDouble(labs), Double.parseDouble(progressTest), Double.parseDouble(finalExam), Double.parseDouble(average),grade);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	void pullToFile() throws IOException {
		FileWriter writer = new FileWriter("E:\\JavaOOPTraining\\BEprojectF-CodeLV1Ver4\\BEprojectF-CodeLV1Ver4\\src\\data\\grade.csv");
		BufferedWriter reader = new BufferedWriter(writer);
		PrintWriter filePointer = new PrintWriter(reader);
		for(grade gradeElement : gradeList) {
			filePointer.println(gradeElement.toString());
		}
		filePointer.close();
	}
	
	
	
	
}
