package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dialog.ModalExclusionType;

public class menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
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
	public menu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\JavaOOPTraining\\BEprojectF-CodeLV1Ver4\\BEprojectF-CodeLV1Ver4\\src\\icon\\menu.png"));
		lblNewLabel_1.setBounds(231, 60, 71, 76);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setForeground(Color.WHITE);
		lblMenu.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblMenu.setBounds(312, 60, 144, 66);
		contentPane.add(lblMenu);
		
		JButton addStudentButton = new JButton("ADD NEW STUDENT");
		addStudentButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		addStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudent addStudent = new addStudent();
				addStudent.setVisible(true);
				dispose();
			}
		});
		addStudentButton.setBounds(252, 151, 204, 23);
		contentPane.add(addStudentButton);
		
		JButton updateStudentButton = new JButton("UPDATE STUDENT");
		updateStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateStudent updateStu = new updateStudent();
				updateStu.setVisible(true);
				dispose();
			}
		});
		updateStudentButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		updateStudentButton.setBounds(252, 188, 204, 23);
		contentPane.add(updateStudentButton);
		
		JButton addSubjectButton = new JButton("ADD SUBJECT");
		addSubjectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSubject addSubject = new addSubject();
				addSubject.setVisible(true);
				dispose();
			}
		});
		addSubjectButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		addSubjectButton.setBounds(252, 222, 204, 23);
		contentPane.add(addSubjectButton);
		
		JButton updateSubjectButton = new JButton("UPDATE SUBJECT");
		updateSubjectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateSubject updateSub = new updateSubject();
				updateSub.setVisible(true);
				dispose();
			}
		});
		updateSubjectButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		updateSubjectButton.setBounds(252, 256, 204, 23);
		contentPane.add(updateSubjectButton);
		
		JLabel logOut = new JLabel("");
		logOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure to log out(Y/N)");
				if(confirm == 0) {
					loginWindows login = new loginWindows();
					login.setVisible(true);
					dispose();
				}
			}
		});
		logOut.setIcon(new ImageIcon("E:\\JavaOOPTraining\\BEprojectF-CodeLV1Ver4\\BEprojectF-CodeLV1Ver4\\src\\icon\\log-out.png"));
		logOut.setBounds(10, 387, 42, 43);
		contentPane.add(logOut);
		
		JButton addAccountButton = new JButton("ADD NEW ACCOUNT");
		addAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assignAcount asignAccount = new assignAcount();
				asignAccount.setVisible(true);
				dispose();
			}
		});
		addAccountButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		addAccountButton.setBounds(252, 290, 204, 23);
		contentPane.add(addAccountButton);
		
		JButton subjectReportButton = new JButton("SUBJECT GRADE REPORT");
		subjectReportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subjectReport subjectReport = new subjectReport();
				subjectReport.setVisible(true);
				dispose();
			}
		});
		subjectReportButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		subjectReportButton.setBounds(252, 324, 204, 23);
		contentPane.add(subjectReportButton);
		
		JButton gradeReportButton = new JButton("STUDENT GRADE REPORT");
		gradeReportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gradeReport gradeReport = new gradeReport();
				gradeReport.setVisible(true);
				dispose();
			}
		});
		gradeReportButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		gradeReportButton.setBounds(252, 358, 204, 23);
		contentPane.add(gradeReportButton);
		
		JButton addGradeButton = new JButton("ADD GRADE");
		addGradeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addGrade addGrade = new addGrade();
				addGrade.setVisible(true);
				dispose();
			}
		});
		addGradeButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		addGradeButton.setBounds(252, 392, 204, 23);
		contentPane.add(addGradeButton);
	}
}
