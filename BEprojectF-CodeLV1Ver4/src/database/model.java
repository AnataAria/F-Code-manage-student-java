package database;

import java.util.ArrayList;

import databaseModel.student;

public interface model {
	//read model from the database
	void readModel(String ID);
	//Delete 1 model from the database
	void deleteModel(String ID);
	//updateModel from the database
	void updateModel(String ID,ArrayList<student> listStudent);
	//Add new model to the database
	void addModel(ArrayList<student> studentList);
}
