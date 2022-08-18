package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.gradeManagement;
import database.studentManagement;
import database.subjectManagement;
import databaseModel.student;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

import validate.tool;
import validate.validate;
import databaseModel.grade;

public class addGrade extends JFrame {

	private JPanel contentPane;
	private JTextField studentIDInput;
	private JTextField studentFullNameInput;
	private JTextField labsInput;
	private JTextField progressTestInput;
	private JTextField finalExamInput;
	private JTextField averageInput;
	private JTextField gradeInput;
	private JLabel subject;
	private JLabel labs;
	private JLabel progressTest;
	private JLabel finalExam;
	private JLabel average;
	private JLabel grade;
	private JButton saveButton ;
	menu menu = new menu();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addGrade frame = new addGrade();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public addGrade() {
		setTitle("Add grade");
		studentManagement studentManage = new studentManagement();
		subjectManagement subjectManage = new subjectManagement();
		gradeManagement gradeManage = new gradeManagement();
		try {
			studentManage.uploadStudentList();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			subjectManage.uploadModel();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			gradeManage.uploadModel();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 964, 83);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(30, 11, 182, 31);
		panel.add(lblNewLabel);
		
		JLabel lblGradeing = new JLabel("GRADETING");
		lblGradeing.setForeground(Color.WHITE);
		lblGradeing.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblGradeing.setBounds(61, 41, 182, 31);
		panel.add(lblGradeing);
		
		studentIDInput = new JTextField();
		studentIDInput.setBounds(24, 126, 154, 20);
		contentPane.add(studentIDInput);
		studentIDInput.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("STUDENT ID");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_2.setBounds(24, 101, 80, 14);
		contentPane.add(lblNewLabel_2);
		
		int index = 0;
		ArrayList<String> subjectData = new ArrayList<String>();
		subjectData.addAll(subjectManage.getSubjectIDList());
		String[] subjectHeader = new String[subjectData.size()];
		for(String subjectElement: subjectData) {
			subjectHeader[index] = subjectElement;
			index++;
		}
		JComboBox subjectInput = new JComboBox();
		subjectInput.setModel(new DefaultComboBoxModel(subjectHeader));
		subjectInput.setBounds(24, 237, 52, 22);
		contentPane.add(subjectInput);
		
		JLabel lblNewLabel_2_1 = new JLabel("STUDENT FULLNAME");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(24, 157, 154, 14);
		contentPane.add(lblNewLabel_2_1);
		
		studentFullNameInput = new JTextField();
		studentFullNameInput.setColumns(10);
		studentFullNameInput.setBounds(24, 182, 154, 20);
		contentPane.add(studentFullNameInput);
		
		subject = new JLabel("SUBJECT");
		subject.setFont(new Font("Times New Roman", Font.BOLD, 13));
		subject.setBounds(24, 213, 154, 14);
		contentPane.add(subject);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(295, 80, 10, 361);
		contentPane.add(panel_1);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fullName;
				String studentID = studentIDInput.getText();
				ArrayList<student> studentData = new ArrayList<student>();
				studentData.addAll(studentManage.getreadModel(studentID));
				if(studentData.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Your student ID is not on database, please check again...");
				}
				else {
					fullName = studentData.get(0).getStudentFullName();
					studentFullNameInput.setText(fullName);
					grade.setVisible(true);
					gradeInput.setVisible(true);
					labs.setVisible(true);
					labsInput.setVisible(true);
					progressTest.setVisible(true);
					progressTestInput.setVisible(true);
					finalExam.setVisible(true);
					finalExamInput.setVisible(true);
					average.setVisible(true);
					averageInput.setVisible(true);
					grade.setVisible(true);
					gradeInput.setVisible(true);
					saveButton.setVisible(true);
					

				}
			}
		});
		searchButton.setBounds(196, 125, 89, 23);
		contentPane.add(searchButton);
		
		labs = new JLabel("LABS");
		labs.setFont(new Font("Times New Roman", Font.BOLD, 13));
		labs.setBounds(326, 101, 80, 14);
		contentPane.add(labs);
		labs.setVisible(false);
		
		labsInput = new JTextField();
		labsInput.setColumns(10);
		labsInput.setBounds(324, 126, 154, 20);
		contentPane.add(labsInput);
		labsInput.setVisible(false);
		
		progressTest = new JLabel("PROGRESS TEST");
		progressTest.setFont(new Font("Times New Roman", Font.BOLD, 13));
		progressTest.setBounds(326, 157, 109, 14);
		contentPane.add(progressTest);
		progressTest.setVisible(false);
		
		progressTestInput = new JTextField();
		progressTestInput.setColumns(10);
		progressTestInput.setBounds(324, 182, 154, 20);
		contentPane.add(progressTestInput);
		progressTestInput.setVisible(false);
	
		
		finalExam = new JLabel("FINAL EXAM");
		finalExam.setFont(new Font("Times New Roman", Font.BOLD, 13));
		finalExam.setBounds(326, 213, 80, 14);
		contentPane.add(finalExam);
		finalExam.setVisible(false);
	
		
		finalExamInput = new JTextField();
		finalExamInput.setColumns(10);
		finalExamInput.setBounds(324, 238, 154, 20);
		contentPane.add(finalExamInput);
		finalExamInput.setVisible(false);
		
		average = new JLabel("AVERAGE");
		average.setFont(new Font("Times New Roman", Font.BOLD, 13));
		average.setBounds(326, 269, 80, 14);
		contentPane.add(average);
		average.setVisible(false);
		
		averageInput = new JTextField();
		averageInput.setColumns(10);
		averageInput.setBounds(324, 294, 154, 20);
		contentPane.add(averageInput);
		averageInput.setVisible(false);
		
		grade = new JLabel("GRADE");
		grade.setFont(new Font("Times New Roman", Font.BOLD, 13));
		grade.setBounds(328, 325, 80, 14);
		contentPane.add(grade);
		grade.setVisible(false);
		
		gradeInput = new JTextField();
		gradeInput.setColumns(10);
		gradeInput.setBounds(326, 350, 154, 20);
		contentPane.add(gradeInput);
		gradeInput.setVisible(false);
		
		saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validate validate = new validate();
				String studentID = studentIDInput.getText();
				String subjectID = subjectInput.getSelectedItem().toString();
				String labs = labsInput.getText();
				String progressTest = progressTestInput.getText();
				String finalExam = finalExamInput.getText();
				if(labs.isEmpty() || progressTest.isEmpty() || finalExam.isEmpty()) {
					JOptionPane.showMessageDialog(null,"You may not have enter input, please try again...");
				}
				else {
					if(!validate.checkScore(finalExam) || !validate.checkScore(labs) || !validate.checkScore(progressTest)) {
						JOptionPane.showMessageDialog(null, "Your input isn't valid, please check again...");
					}
					else {
						tool tool = new tool();
						Double caculation = tool.caculateAverage(Double.parseDouble(labs), Double.parseDouble(progressTest), Double.parseDouble(finalExam));
						averageInput.setText(String.valueOf(caculation));
						if(tool.checkGrade(caculation)) {
							gradeInput.setText("Pass");
						}
						else {
							gradeInput.setText("Fail");
						}
						String average = averageInput.getText();
						String grade = gradeInput.getText();
						grade gradeModel = new grade(studentID, subjectID,Double.parseDouble(labs),Double.parseDouble(progressTest),Double.parseDouble(finalExam),Double.parseDouble(average), grade);
						ArrayList<grade> gradeData = new ArrayList<grade>();
						gradeData.add(gradeModel);
						gradeManage.addNewGrade(gradeData);
						JOptionPane.showMessageDialog(null,"Saving success...");
					}
				}
			}
		});
		saveButton.setBounds(644, 207, 168, 83);
		contentPane.add(saveButton);
		saveButton.setVisible(false);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(true);
				dispose();
			}
		});
		backButton.setBounds(10, 394, 114, 36);
		contentPane.add(backButton);
		
		JButton caculateButton = new JButton("Caculate");
		caculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				double labs = Double.parseDouble(labsInput.getText());
//				double progressTest = Double.parseDouble(progressTestInput.getText());
//				double finalExam = Double.parseDouble(finalExamInput.getText());
				validate validate = new validate();
				String labs = labsInput.getText();
				String progressTest = progressTestInput.getText();
				String finalExam = finalExamInput.getText();
				if(labs.isEmpty() || progressTest.isEmpty() || finalExam.isEmpty()) {
					JOptionPane.showMessageDialog(null,"You may not have enter input, please try again...");
				}
				else {
					if(!validate.checkScore(finalExam) || !validate.checkScore(labs) || !validate.checkScore(progressTest)) {
						JOptionPane.showMessageDialog(null, "Your input isn't valid, please check again...");
					}
					else {
						tool tool = new tool();
						Double caculation = tool.caculateAverage(Double.parseDouble(labs), Double.parseDouble(progressTest), Double.parseDouble(finalExam));
						averageInput.setText(String.valueOf(caculation));
						if(tool.checkGrade(caculation)) {
							gradeInput.setText("Pass");
						}
						else {
							gradeInput.setText("Fail");
						}
					}
				}
			}
		});
		caculateButton.setBounds(319, 389, 89, 23);
		contentPane.add(caculateButton);
	}
}
