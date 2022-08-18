package database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

import databaseModel.subject;

public class subjectManagement {
	private ArrayList<subject> subjectList = new ArrayList<subject>();
	
	public ArrayList<subject> getSearchSubject(String subject) {
		ArrayList<subject> searchSubject = new ArrayList<subject>();
		for(subject subjectElement : subjectList) {
			if(subjectElement.getSubjectID().equals(subject)) {
				String subjectID = subjectElement.getSubjectID();
				String subjectName = subjectElement.getSubjectName();
				String description = subjectElement.getDescription();
				String credits = subjectElement.getCredits();
				subject subjectSearch = new subject(subjectID, subjectName, description, credits);
				searchSubject.add(subjectSearch);
			}
		}
		return searchSubject;
	}
	
	public ArrayList<String> getSubjectIDList(){
		ArrayList<String> result = new ArrayList<String>();
		for(subject subjectElement : subjectList) {
			result.add(subjectElement.getSubjectID());
		}
		return result;
	}
	
	public boolean checkMatch(String ID) {
		boolean flag = true;
		for(subject subjectElement:subjectList) {
			if(subjectElement.getSubjectID() == ID) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	public void addModel(ArrayList<subject> subject) {
		this.subjectList.addAll(subject);
		try {
			pullToFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateModel(ArrayList<subject> subject,String ID) {
		for(subject subjectElement:subjectList) {
			if(subjectElement.getSubjectID().equals(ID)) {
				subjectElement.setSubjectName(subject.get(0).getSubjectName());
				subjectElement.setDescription(subject.get(0).getDescription());
				subjectElement.setCredits(subject.get(0).getCredits());
				break;
			}
		}
		try {
			pullToFile();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteModel(String ID) {
		int index;
		for(index = 0; index < subjectList.size(); index++) {
			if(subjectList.get(index).getSubjectID().equals(ID) ) {
				subjectList.remove(index);
				break;
			}
		}
		
		try {
			pullToFile();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void uploadModel() throws IOException {
		FileReader fileReader = new FileReader("E:\\JavaOOPTraining\\BEprojectF-CodeLV1Ver4\\BEprojectF-CodeLV1Ver4\\src\\data\\subject.csv");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String[] temp;
		String line = "";
		try {
			while((line = bufferedReader.readLine()) != null) {
				temp = line.split(",");
				String subjectID = temp[0];
				String subjectName = temp[1];
				String description = temp[2];
				String credits = temp[3];
				subject subject = new subject(subjectID,subjectName,description,credits);
				subjectList.add(subject);
			}
			bufferedReader.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	

	void pullToFile() throws IOException{
		FileWriter fileWriter = new FileWriter("E:\\JavaOOPTraining\\BEprojectF-CodeLV1Ver4\\BEprojectF-CodeLV1Ver4\\src\\data\\subject.csv");
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		PrintWriter printWriter = new PrintWriter(bufferedWriter);
		for(subject subjectElement : subjectList) {
			printWriter.println(subjectElement.toString());
		}
		printWriter.close();
	}
	
	
}
