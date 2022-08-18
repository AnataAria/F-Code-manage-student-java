package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.gradeManagement;
import database.subjectManagement;
import databaseModel.subject;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

import validate.validate;

public class updateSubject extends JFrame {

	private JPanel contentPane;
	private JTextField subjectNameInput;
	private JTextField descriptionInput;
	private JComboBox subJectIDInput;
	private JButton searchButton;
	private JLabel credits;
	private JComboBox creditsInput;
	
	menu menu = new menu();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateSubject frame = new updateSubject();
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
	public updateSubject() {
		subjectManagement subjectManage = new subjectManagement();
		gradeManagement gradeManage = new gradeManagement();
		try {
			subjectManage.uploadModel();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			gradeManage.uploadModel();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setTitle("Update subject");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 355);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 0, 556, 59);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPDATE SUBJECT");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 184, 37);
		panel.add(lblNewLabel);
		
		int index = 0;
		ArrayList<String> subjectData = new ArrayList<String>();
		subjectData.addAll(subjectManage.getSubjectIDList());
		String[] subjectHeader = new String[subjectData.size()];
		for(String subjectElement: subjectData) {
			subjectHeader[index] = subjectElement;
			index++;
		}
		subJectIDInput = new JComboBox();
		subJectIDInput.setModel(new DefaultComboBoxModel(subjectHeader));
		subJectIDInput.setBounds(31, 100, 76, 22);
		contentPane.add(subJectIDInput);
		
		JLabel lblNewLabel_1 = new JLabel("Subject ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(31, 70, 82, 32);
		contentPane.add(lblNewLabel_1);
		
		searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String subjectID = subJectIDInput.getSelectedItem().toString();
				ArrayList<subject> subjectData = new ArrayList<subject>();
				subjectData = subjectManage.getSearchSubject(subjectID);
				subjectNameInput.setText(subjectData.get(0).getSubjectName());
				descriptionInput.setText(subjectData.get(0).getDescription());
				creditsInput.setSelectedIndex(Integer.parseInt(subjectData.get(0).getCredits()));
			}
		});
		searchButton.setBounds(133, 100, 89, 23);
		contentPane.add(searchButton);
		
		JLabel subjectName = new JLabel("Subject  name");
		subjectName.setForeground(Color.WHITE);
		subjectName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		subjectName.setBounds(31, 127, 112, 29);
		contentPane.add(subjectName);
		
		subjectNameInput = new JTextField();
		subjectNameInput.setBounds(31, 161, 184, 20);
		contentPane.add(subjectNameInput);
		subjectNameInput.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Description");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(31, 192, 112, 29);
		contentPane.add(lblNewLabel_1_1_1);
		
		descriptionInput = new JTextField();
		descriptionInput.setColumns(10);
		descriptionInput.setBounds(31, 226, 184, 20);
		contentPane.add(descriptionInput);
		
		credits = new JLabel("Credits");
		credits.setForeground(Color.WHITE);
		credits.setFont(new Font("Times New Roman", Font.BOLD, 15));
		credits.setBounds(31, 257, 82, 32);
		contentPane.add(credits);
		
		creditsInput = new JComboBox();
		creditsInput.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		creditsInput.setBounds(31, 287, 76, 22);
		contentPane.add(creditsInput);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String subjectID = subJectIDInput.getSelectedItem().toString();
				if(!gradeManage.isSubjectEmpty(subjectID)) {
					JOptionPane.showMessageDialog(null, "This subject have student, can't deleted...");
				}
				else {
					subjectManage.deleteModel(subjectID);//will add condition when have done codeing grade input later...
					JOptionPane.showMessageDialog(null, "Deleting sucess...");
				}
			}
		});
		deleteButton.setBounds(367, 131, 89, 23);
		contentPane.add(deleteButton);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validate validate = new validate();
				String subjectID = subJectIDInput.getSelectedItem().toString();
				String subjectName = subjectNameInput.getText();
				String description = descriptionInput.getText();
				String credits = creditsInput.getSelectedItem().toString();
				if(subjectID.isEmpty() || subjectName.isEmpty() || description.isEmpty() || credits.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Some of your input aren't enter, please try again...");
				}
				else {
					if(! validate.credits(credits)) {
						JOptionPane.showMessageDialog(null,"credits is invalid, please try again...");
					}
					else {
						subject subject = new subject(subjectID,subjectName,description,credits);
						ArrayList<subject> newSubjectData = new ArrayList<subject>();
						newSubjectData.add(subject);
						subjectManage.updateModel(newSubjectData,subjectID);
						JOptionPane.showMessageDialog(null, "Saving success...");
						menu.setVisible(true);
						dispose();
					}
				}
			}
		});
		saveButton.setBounds(367, 177, 89, 23);
		contentPane.add(saveButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(true);
				dispose();
			}
		});
		backButton.setBounds(367, 225, 89, 23);
		contentPane.add(backButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subJectIDInput.setSelectedIndex(0);
				subjectNameInput.setText("");
				descriptionInput.setText("");
				creditsInput.setSelectedIndex(0);
			}
		});
		clearButton.setBounds(367, 88, 89, 23);
		contentPane.add(clearButton);
	}
}
