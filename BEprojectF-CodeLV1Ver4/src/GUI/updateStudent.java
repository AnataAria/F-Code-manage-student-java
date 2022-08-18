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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import validate.validate;

public class updateStudent extends JFrame {

	private JPanel contentPane;
	private JTextField IDInput;
	private JTextField firstNameInput;
	private JTextField lastNameInput;
	private JTextField phoneNumberInput;
	private JTextField emailInput;
	private JTextField birthdayInput;
	private JComboBox genderInput;
	private JTextPane addressInput;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel phoneNumberLabel;
	private JLabel emailLabel ;
	private JLabel genderLabel;
	private JLabel birthdayLabel;
	private JComboBox majorInput;
	private JLabel majorLabel;
	private JLabel addressLabel;
	private int No;
	menu menu = new menu();
	private JButton clearButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateStudent frame = new updateStudent();
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
	public updateStudent() {
		studentManagement studentManage = new studentManagement();
		gradeManagement gradeManage = new gradeManagement();
		try {
			gradeManage.uploadModel();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			studentManage.uploadStudentList();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setTitle("Update student data");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 499);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 715, 53);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPDATE STUDENT DATA");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 184, 31);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 64, 76, 30);
		contentPane.add(lblNewLabel_1);
		
		IDInput = new JTextField();
		IDInput.setBounds(20, 94, 170, 20);
		contentPane.add(IDInput);
		IDInput.setColumns(10);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String ID = IDInput.getText();
				ArrayList<student> studentData = new ArrayList<student>();
				studentData.addAll(studentManage.getreadModel(ID));
				if(studentData.isEmpty()) {
					JOptionPane.showMessageDialog(null,"No one have this ID in the database");
				}
				else {
					firstNameLabel.setVisible(true);
					firstNameInput.setVisible(true);
					lastNameLabel.setVisible(true);
					lastNameInput.setVisible(true);
					phoneNumberLabel.setVisible(true);
					phoneNumberInput.setVisible(true);
					emailLabel.setVisible(true);
					emailInput.setVisible(true);
					genderLabel.setVisible(true);
					genderInput.setVisible(true);
					birthdayLabel.setVisible(true);
					birthdayInput.setVisible(true);
					majorInput.setVisible(true);
					majorLabel.setVisible(true);
					addressInput.setVisible(true);
					addressLabel.setVisible(true);
					No = studentData.get(0).getNo();
					firstNameInput.setText(studentData.get(0).getStudentFirstName());
					lastNameInput.setText(studentData.get(0).getStudentLastName());
					phoneNumberInput.setText(Integer.toString(studentData.get(0).getPhoneNumber()));
					emailInput.setText(studentData.get(0).getEmail());
					birthdayInput.setText(studentData.get(0).getBirthday());
					if(studentData.get(0).getGender().equals("Man")) {
						genderInput.setSelectedIndex(0);
					}
					else if(studentData.get(0).getGender().equals("Woman")) {
						genderInput.setSelectedIndex(1);
					}
					else {
						genderInput.setSelectedIndex(2);
					}
					addressInput.setText(studentData.get(0).getAddress());
					if(studentData.get(0).getMajor().equals("AI")) {
						genderInput.setSelectedIndex(0);
					}
					else if(studentData.get(0).getMajor().equals("SE")) {
						genderInput.setSelectedIndex(1);
					}
					else {
						genderInput.setSelectedIndex(2);
					}//"AI", "SE", "IA"
					
				}
				
			}
		});
		searchButton.setBounds(200, 93, 89, 23);
		contentPane.add(searchButton);
		
		firstNameLabel = new JLabel("First name");
		firstNameLabel.setForeground(Color.WHITE);
		firstNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		firstNameLabel.setBounds(10, 125, 76, 30);
		contentPane.add(firstNameLabel);
		firstNameLabel.setVisible(false);
		
		firstNameInput = new JTextField();
		firstNameInput.setColumns(10);
		firstNameInput.setBounds(20, 155, 170, 20);
		contentPane.add(firstNameInput);
		firstNameInput.setVisible(false);
		
		lastNameLabel = new JLabel("Last name");
		lastNameLabel.setForeground(Color.WHITE);
		lastNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lastNameLabel.setBounds(10, 186, 76, 30);
		contentPane.add(lastNameLabel);
		lastNameLabel.setVisible(false);
		
		lastNameInput = new JTextField();
		lastNameInput.setColumns(10);
		lastNameInput.setBounds(20, 216, 170, 20);
		contentPane.add(lastNameInput);
		lastNameInput.setVisible(false);
		
		phoneNumberLabel = new JLabel("Phone number");
		phoneNumberLabel.setForeground(Color.WHITE);
		phoneNumberLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		phoneNumberLabel.setBounds(10, 247, 104, 30);
		contentPane.add(phoneNumberLabel);
		phoneNumberLabel.setVisible(false);
		
		phoneNumberInput = new JTextField();
		phoneNumberInput.setColumns(10);
		phoneNumberInput.setBounds(20, 277, 170, 20);
		contentPane.add(phoneNumberInput);
		phoneNumberInput.setVisible(false);
		
		emailLabel = new JLabel("Email");
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		emailLabel.setBounds(10, 308, 76, 30);
		contentPane.add(emailLabel);
		emailLabel.setVisible(false);
		
		emailInput = new JTextField();
		emailInput.setColumns(10);
		emailInput.setBounds(20, 338, 170, 20);
		contentPane.add(emailInput);
		emailInput.setVisible(false);
		
		genderLabel = new JLabel("Gender");
		genderLabel.setForeground(Color.WHITE);
		genderLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		genderLabel.setBounds(234, 127, 76, 30);
		contentPane.add(genderLabel);
		genderLabel.setVisible(false);
		
		genderInput = new JComboBox();
		genderInput.setModel(new DefaultComboBoxModel(new String[] {"Man", "Woman", "Others"}));
		genderInput.setBounds(244, 154, 57, 22);
		contentPane.add(genderInput);
		genderInput.setVisible(false);
		
		birthdayLabel = new JLabel("Birthday");
		birthdayLabel.setForeground(Color.WHITE);
		birthdayLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		birthdayLabel.setBounds(234, 186, 76, 30);
		contentPane.add(birthdayLabel);
		birthdayLabel.setVisible(false);
		
		birthdayInput = new JTextField();
		birthdayInput.setColumns(10);
		birthdayInput.setBounds(244, 216, 170, 20);
		contentPane.add(birthdayInput);
		birthdayInput.setVisible(false);
		
		majorInput = new JComboBox();
		majorInput.setModel(new DefaultComboBoxModel(new String[] {"AI", "SE", "IA"}));
		majorInput.setBounds(244, 275, 57, 22);
		contentPane.add(majorInput);
		majorInput.setVisible(false);
		
		majorLabel = new JLabel("Major");
		majorLabel.setForeground(Color.WHITE);
		majorLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		majorLabel.setBounds(234, 248, 76, 30);
		contentPane.add(majorLabel);
		majorLabel.setVisible(false);
		
		addressInput = new JTextPane();
		addressInput.setBounds(244, 338, 197, 89);
		contentPane.add(addressInput);
		addressInput.setVisible(false);
		
		addressLabel = new JLabel("Address");
		addressLabel.setForeground(Color.WHITE);
		addressLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		addressLabel.setBounds(234, 308, 76, 30);
		contentPane.add(addressLabel);
		addressLabel.setVisible(false);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validate validate = new validate();
				String firstName = firstNameInput.getText();
				String lastName = lastNameInput.getText();
				String fullName = firstName + " " + lastName;
				String ID = IDInput.getText();
				String gender = genderInput.getSelectedItem().toString();
				String major = majorInput.getSelectedItem().toString();
				String birthday = birthdayInput.getText();
				String address = addressInput.getText();
				String email = emailInput.getText();
				String phoneNumber = phoneNumberInput.getText();
				if(firstName.isEmpty() || lastName.isEmpty() || fullName.isEmpty()|| ID.isEmpty() || gender.isEmpty() || major.isEmpty() || birthday.isEmpty() || address.isEmpty() || email.isEmpty() || address.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Some of your input had blank, please check again");
				}
				else {
					if(! validate.isEmailValid(email)) {
						JOptionPane.showMessageDialog(null,"your email is invalid, please check again...");
					}else {
						if(! validate.checkInt(phoneNumber)) {
							JOptionPane.showMessageDialog(null,"Your phone number type is not valid, please try again");
						}
						else {
							student student = new student(No,firstName,lastName,fullName,ID,major,gender,birthday,Integer.parseInt(phoneNumber),email,address);
							ArrayList<student> newStudent = new ArrayList<student>();
							newStudent.add(student);
							studentManage.updateModel(ID,newStudent);
							JOptionPane.showMessageDialog(null,"Saving success....");
							menu.setVisible(true);
							dispose();
						}
					}
				}
			}
		});
		saveButton.setBounds(550, 215, 89, 23);
		contentPane.add(saveButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(true);
				dispose();
			}
		});
		backButton.setBounds(550, 276, 89, 23);
		contentPane.add(backButton);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentID = IDInput.getText();
				if(!gradeManage.isStudentEmpty(studentID)) {
					JOptionPane.showMessageDialog(null,"This student is joining class, can't deleted...");
				}
				else {
					studentManage.deleteModel(studentID);
					JOptionPane.showMessageDialog(null,"Deleting...");
				}
			}
		});
		deleteButton.setBounds(550, 337, 89, 23);
		contentPane.add(deleteButton);
		
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNameInput.setText("");
				lastNameInput.setText("");
				phoneNumberInput.setText("");
				emailInput.setText("");
				genderInput.setSelectedIndex(0);
				birthdayInput.setText("");
				majorInput.setSelectedIndex(0);
				addressInput.setText("");
				
				firstNameLabel.setVisible(false);
				firstNameInput.setVisible(false);
				lastNameLabel.setVisible(false);
				lastNameInput.setVisible(false);
				phoneNumberLabel.setVisible(false);
				phoneNumberInput.setVisible(false);
				emailLabel.setVisible(false);
				emailInput.setVisible(false);
				genderLabel.setVisible(false);
				genderInput.setVisible(false);
				birthdayLabel.setVisible(false);
				birthdayInput.setVisible(false);
				majorInput.setVisible(false);
				majorLabel.setVisible(false);
				addressInput.setVisible(false);
				addressLabel.setVisible(false);
			}
		});
		clearButton.setBounds(550, 154, 89, 23);
		contentPane.add(clearButton);
	}
}