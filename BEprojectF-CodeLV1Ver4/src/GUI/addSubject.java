package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.subjectManagement;
import databaseModel.subject;
import validate.validate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class addSubject extends JFrame {

	private JPanel contentPane;
	private JTextField subjectIDInput;
	private JTextField subjectNameInput;
	
	menu menu = new menu();
	private JTextField descriptionInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addSubject frame = new addSubject();
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
	public addSubject() {
		subjectManagement subjectManage = new subjectManagement();
		validate validate = new validate();
		try {
			subjectManage.uploadModel();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setTitle("Add subject");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel welcome = new JLabel("Welcome");
		welcome.setForeground(Color.WHITE);
		welcome.setFont(new Font("Times New Roman", Font.BOLD, 20));
		welcome.setBounds(335, 11, 89, 14);
		contentPane.add(welcome);
		
		subjectIDInput = new JTextField();
		subjectIDInput.setBounds(33, 51, 191, 20);
		contentPane.add(subjectIDInput);
		subjectIDInput.setColumns(10);
		
		subjectNameInput = new JTextField();
		subjectNameInput.setColumns(10);
		subjectNameInput.setBounds(33, 92, 191, 20);
		contentPane.add(subjectNameInput);
		
		JComboBox creditsInput = new JComboBox();
		creditsInput.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		creditsInput.setBounds(33, 185, 56, 22);
		contentPane.add(creditsInput);
		
		JLabel lblNewLabel = new JLabel("Subject ID");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(33, 29, 76, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblSubjectName = new JLabel("Subject name");
		lblSubjectName.setForeground(Color.WHITE);
		lblSubjectName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSubjectName.setBounds(33, 70, 111, 22);
		contentPane.add(lblSubjectName);
		
		JLabel lblCredits = new JLabel("Credits");
		lblCredits.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCredits.setBackground(Color.WHITE);
		lblCredits.setForeground(Color.WHITE);
		lblCredits.setBounds(33, 164, 76, 22);
		contentPane.add(lblCredits);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(true);
				dispose();
			}
		});
		backButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		backButton.setBounds(293, 50, 89, 23);
		contentPane.add(backButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subjectIDInput.setText("");
				subjectNameInput.setText("");
			}
		});
		clearButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		clearButton.setBounds(293, 91, 89, 23);
		contentPane.add(clearButton);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String subjectID = subjectIDInput.getText();
				String subjectName = subjectNameInput.getText();
				String description = descriptionInput.getText();
				String credits = creditsInput.getSelectedItem().toString();
				if(subjectID.isEmpty() || subjectName.isEmpty() || description.isEmpty() || credits.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Some of your input are empty, please check again...");
				}
				else {
					if(! subjectManage.checkMatch(subjectID)) {
						JOptionPane.showMessageDialog(null,"This ID is on the database, please try again...");
					}
					else {
						if(! validate.credits(credits)) {
							JOptionPane.showMessageDialog(null,"credits is invalid, please try again...");
						}
						else {
							subject subject = new subject(subjectID,subjectName,description,credits);
							ArrayList<subject> newSubjectData = new ArrayList<subject>();
							newSubjectData.add(subject);
							subjectManage.addModel(newSubjectData);
							JOptionPane.showMessageDialog(null, "Saving success...");
							menu.setVisible(true);
							dispose();
						}
					}
				}	
			}
		});
		saveButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		saveButton.setBounds(293, 142, 89, 23);
		contentPane.add(saveButton);
		
		descriptionInput = new JTextField();
		descriptionInput.setColumns(10);
		descriptionInput.setBounds(33, 133, 191, 20);
		contentPane.add(descriptionInput);
		
		JLabel subjectDescription = new JLabel("Description");
		subjectDescription.setForeground(Color.WHITE);
		subjectDescription.setFont(new Font("Times New Roman", Font.BOLD, 15));
		subjectDescription.setBounds(33, 111, 111, 22);
		contentPane.add(subjectDescription);
	}
}
