package database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import databaseModel.student;

public class studentManagement  {
	private ArrayList<student>studentList = new ArrayList<student>();
	
	
	public void updateModel(String ID,ArrayList<student> listStudent) {
		// TODO Auto-generated method stub
		for(student studentElement: studentList) {
			if(studentElement.getStudentID().equals(ID)) {
				studentElement.setStudentFirstName(listStudent.get(0).getStudentFirstName());
				studentElement.setStudentLastName(listStudent.get(0).getStudentLastName());
				studentElement.setStudentFullName(listStudent.get(0).getStudentFullName());
				studentElement.setMajor(listStudent.get(0).getMajor());
				studentElement.setGender(listStudent.get(0).getGender());
				studentElement.setBirthday(listStudent.get(0).getBirthday());
				studentElement.setPhoneNumber(listStudent.get(0).getPhoneNumber());
				studentElement.setEmail(listStudent.get(0).getEmail());
				studentElement.setAddress(listStudent.get(0).getAddress());
			}
		}
		try {
			pullToFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addModel(ArrayList<student> studentList) {
		// TODO Auto-generated method stub
		this.studentList.addAll(studentList);
	}
	public ArrayList<student> getreadModel(String ID) {
		// TODO Auto-generated method stub
		ArrayList<student> researchModel = new ArrayList<student>();
		for(student studentElement:studentList) {
			if(studentElement.getStudentID().equals(ID)) {
				student student = new student(studentElement.getNo(),studentElement.getStudentFirstName(),studentElement.getStudentLastName(),studentElement.getStudentFullName(),studentElement.getStudentID(),studentElement.getMajor(),studentElement.getGender(),studentElement.getBirthday(),studentElement.getPhoneNumber(),studentElement.getEmail(),studentElement.getAddress());
				researchModel.add(student);
				break;
			}
		}
		return researchModel;	
	}
	public void deleteModel(String ID) {
		// TODO Auto-generated method 
		int index;
		for(index = 0; index < studentList.size(); index++) {
			if(studentList.get(index).getStudentID().equals(ID) ) {
				studentList.remove(index);
				break;
			}
		}
		try {
			pullToFile();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void uploadStudentList() throws IOException {
		FileReader reader = new FileReader("E:\\JavaOOPTraining\\BEprojectF-CodeLV1Ver4\\BEprojectF-CodeLV1Ver4\\src\\data\\student.csv");
		BufferedReader br = new BufferedReader(reader);
		String[] temp;
		String line = "";
		try {
			while((line = br.readLine()) != null) {
				temp = line.split(",");
				int no = Integer.parseInt(temp[0]);
				String firstName = temp[1];
				String lastName = temp[2];
				String fullName = temp[3];
				String ID = temp[4];
				String major = temp[5];
				String gender = temp[6];
				String birthday = temp[7];
				int phoneNumber = Integer.parseInt(temp[8]);;
				String email = temp[9];
				String address = temp[10];
				student student = new student(no,firstName,lastName,fullName,ID,major,gender,birthday,phoneNumber,email,address);
				studentList.add(student);
			}
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	void pullToFile() throws IOException {
		FileWriter fileWriter = new FileWriter("E:\\JavaOOPTraining\\BEprojectF-CodeLV1Ver4\\BEprojectF-CodeLV1Ver4\\src\\data\\student.csv");
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		PrintWriter printWriter = new PrintWriter(bufferedWriter);
		for(student studentElement : studentList) {
			printWriter.println(studentElement.toString());
		}
		printWriter.close();
	}
	
	void deleteModel(int index) {
		studentList.remove(index);
	}
	public boolean checkMatch(String ID) {
		for(student studentElement:studentList) {
			if(studentElement.getStudentID().equals(ID)) {
				return false;
			}
		}
		return true;
	}
	public void addStudent(ArrayList<student> studentData) throws IOException {
		this.studentList.addAll(studentData);
		pullToFile();
	}

	
}
