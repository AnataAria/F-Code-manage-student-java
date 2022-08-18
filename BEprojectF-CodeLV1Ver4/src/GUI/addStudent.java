package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.studentManagement;
import databaseModel.student;
import databaseModel.subject;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import validate.validate;
import database.subjectManagement;

public class addStudent extends JFrame {

	private JPanel contentPane;
	private JTextField NoInput;
	private JLabel lblStudentId;
	private JTextField IDInput;
	private JLabel lblStudentId_1;
	private JTextField firstNameInput;
	private JLabel lblStudentFirstName;
	private JTextField lastNameInput;
	private JLabel lblLastName;
	private JLabel lblGender;
	private JTextField emailInput;
	private JTextField phoneNumberInput;
	private JTable table;
	private JTextArea addressInput;
	private JTextField birthDayInput;
	
	menu menu = new menu();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addStudent frame = new addStudent();
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
	public addStudent() {
//		subjectManagement subjectManage = new subjectManagement();
//		try {
//			subjectManage.uploadModel();
//		} catch (IOException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
		
		setTitle("Add student terminal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel welcome = new JLabel("WELCOME");
		welcome.setForeground(Color.WHITE);
		welcome.setBackground(Color.WHITE);
		welcome.setFont(new Font("Times New Roman", Font.BOLD, 25));
		welcome.setBounds(1114, 11, 140, 37);
		contentPane.add(welcome);
		
		NoInput = new JTextField();
		NoInput.setBounds(52, 52, 220, 20);
		contentPane.add(NoInput);
		NoInput.setColumns(10);
		
		lblStudentId = new JLabel("Student No");
		lblStudentId.setForeground(Color.WHITE);
		lblStudentId.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblStudentId.setBackground(Color.WHITE);
		lblStudentId.setBounds(52, 13, 140, 35);
		contentPane.add(lblStudentId);
		
		IDInput = new JTextField();
		IDInput.setColumns(10);
		IDInput.setBounds(52, 122, 220, 20);
		contentPane.add(IDInput);
		
		lblStudentId_1 = new JLabel("Student ID");
		lblStudentId_1.setForeground(Color.WHITE);
		lblStudentId_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblStudentId_1.setBackground(Color.WHITE);
		lblStudentId_1.setBounds(52, 83, 140, 35);
		contentPane.add(lblStudentId_1);
		
		firstNameInput = new JTextField();
		firstNameInput.setColumns(10);
		firstNameInput.setBounds(52, 192, 220, 20);
		contentPane.add(firstNameInput);
		
		lblStudentFirstName = new JLabel("First name");
		lblStudentFirstName.setForeground(Color.WHITE);
		lblStudentFirstName.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblStudentFirstName.setBackground(Color.WHITE);
		lblStudentFirstName.setBounds(52, 153, 140, 35);
		contentPane.add(lblStudentFirstName);
		
		lastNameInput = new JTextField();
		lastNameInput.setColumns(10);
		lastNameInput.setBounds(52, 262, 220, 20);
		contentPane.add(lastNameInput);
		
		lblLastName = new JLabel("Last name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblLastName.setBackground(Color.WHITE);
		lblLastName.setBounds(52, 223, 140, 35);
		contentPane.add(lblLastName);
		
		lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblGender.setBackground(Color.WHITE);
		lblGender.setBounds(341, 83, 140, 35);
		contentPane.add(lblGender);
		
		JComboBox genderInput = new JComboBox();
		genderInput.setFont(new Font("Times New Roman", Font.BOLD, 11));
		genderInput.setModel(new DefaultComboBoxModel(new String[] {"Man", "Woman", "Others"}));
		genderInput.setBounds(341, 121, 116, 22);
		contentPane.add(genderInput);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblEmail.setBackground(Color.WHITE);
		lblEmail.setBounds(52, 293, 140, 35);
		contentPane.add(lblEmail);
		
		emailInput = new JTextField();
		emailInput.setColumns(10);
		emailInput.setBounds(52, 332, 220, 20);
		contentPane.add(emailInput);
		
		JLabel lblMajor = new JLabel("Major");
		lblMajor.setForeground(Color.WHITE);
		lblMajor.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblMajor.setBackground(Color.WHITE);
		lblMajor.setBounds(341, 153, 140, 35);
		contentPane.add(lblMajor);
		
//		int index = 0;
//		ArrayList<String> subjectData = new ArrayList<String>();
//		subjectData.addAll(subjectManage.getSubjectIDList());
//		String[] subjectHeader = new String[subjectData.size()];
//		for(String subjectElement: subjectData) {
//			subjectHeader[index] = subjectElement;
//			index++;
//		}
		JComboBox majorInput = new JComboBox();
		majorInput.setModel(new DefaultComboBoxModel(new String[] {"SE", "AI", "IA"}));
		majorInput.setFont(new Font("Times New Roman", Font.BOLD, 11));
		majorInput.setBounds(341, 191, 116, 22);
		contentPane.add(majorInput);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblPhoneNumber.setBackground(Color.WHITE);
		lblPhoneNumber.setBounds(52, 363, 140, 35);
		contentPane.add(lblPhoneNumber);
		
		phoneNumberInput = new JTextField();
		phoneNumberInput.setColumns(10);
		phoneNumberInput.setBounds(52, 402, 220, 20);
		contentPane.add(phoneNumberInput);
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBackground(Color.WHITE);
		table.setForeground(Color.WHITE);
		table.setBounds(830, 460, 71, -45);
		contentPane.add(table);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setForeground(Color.WHITE);
		lblBirthday.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblBirthday.setBackground(Color.WHITE);
		lblBirthday.setBounds(341, 223, 140, 35);
		contentPane.add(lblBirthday);
		
		addressInput = new JTextArea();
		addressInput.setBounds(52, 470, 225, 96);
		contentPane.add(addressInput);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblAddress.setBackground(Color.WHITE);
		lblAddress.setBounds(52, 433, 140, 35);
		contentPane.add(lblAddress);
		
		birthDayInput = new JTextField();
		birthDayInput.setColumns(10);
		birthDayInput.setBounds(341, 262, 220, 20);
		contentPane.add(birthDayInput);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String emty = "";
				NoInput.setText(emty);
				IDInput.setText(emty);
				firstNameInput.setText(emty);
				lastNameInput.setText(emty);
				birthDayInput.setText(emty);
				addressInput.setText(emty);
				emailInput.setText(emty);
				phoneNumberInput.setText(emty);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(751, 139, 191, 97);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnBack.setBounds(751, 261, 191, 97);
		contentPane.add(btnBack);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentManagement studentManage = new studentManagement();
				try {
					studentManage.uploadStudentList();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				validate validate = new validate();
				String No = NoInput.getText();
				String firstName = firstNameInput.getText();
				String lastName = lastNameInput.getText();
				String fullName = firstName + " " + lastName;
				String ID = IDInput.getText();
				String gender = genderInput.getSelectedItem().toString();
				String major = majorInput.getSelectedItem().toString();
				String birthday = birthDayInput.getText();
				String address = addressInput.getText();
				String email = emailInput.getText();
				String phoneNumber = phoneNumberInput.getText();
				if(! validate.isEmailValid(email)) {
					JOptionPane.showMessageDialog(null,"your email is invalid, please check again...");
				}else {
					if(! studentManage.checkMatch(ID)) {
						JOptionPane.showMessageDialog(null,"Your ID is match with someone in the database, please try again...");
					}
					else {
						if(! validate.checkInt(phoneNumber)) {
							JOptionPane.showMessageDialog(null,"Your phone number type is not valid, please try again");
						}
						else {
							student student = new student(Integer.parseInt(No),firstName,lastName,fullName,ID,major,gender,birthday,Integer.parseInt(phoneNumber),email,address);
							ArrayList<student> newStudent = new ArrayList<student>();
							newStudent.add(student);
							try {
								studentManage.addStudent(newStudent);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null,"Saving success....");
							menu.setVisible(true);
							dispose();
						}
					}
				}
				
			}
		});
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSave.setBounds(751, 386, 191, 97);
		contentPane.add(btnSave);
	}
}
