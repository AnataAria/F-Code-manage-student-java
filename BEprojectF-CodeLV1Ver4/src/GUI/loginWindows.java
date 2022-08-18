package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import database.loginManagement;
public class loginWindows extends JFrame {

	private JPanel contentPane;
	private JTextField userNameIn;
	private JPasswordField passwordIn;
	
	loginManagement loginManage = new loginManagement();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginWindows frame = new loginWindows();
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
	public loginWindows() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\JavaOOPTraining\\BEprojectF-CodeLV1Ver4\\BEprojectF-CodeLV1Ver4\\src\\icon\\login terminal.png"));
		setTitle("Login terminal");
		setFont(new Font("Segoe UI", Font.BOLD, 12));
		setAlwaysOnTop(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 360);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel loginIcon = new JLabel("");
		loginIcon.setIcon(new ImageIcon("E:\\JavaOOPTraining\\BEprojectF-CodeLV1Ver4\\BEprojectF-CodeLV1Ver4\\src\\icon\\login.png"));
		loginIcon.setBounds(10, 0, 64, 82);
		contentPane.add(loginIcon);
		
		JLabel welcome = new JLabel("WELCOME TO F-CODE WJBU STUDENT MANAGER");
		welcome.setForeground(Color.WHITE);
		welcome.setFont(new Font("Times New Roman", Font.BOLD, 14));
		welcome.setBounds(84, 11, 344, 28);
		contentPane.add(welcome);
		
		JLabel lblLoginTerminal = new JLabel("- Login terminal -");
		lblLoginTerminal.setForeground(Color.WHITE);
		lblLoginTerminal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblLoginTerminal.setBounds(84, 38, 113, 28);
		contentPane.add(lblLoginTerminal);
		
		userNameIn = new JTextField();
		userNameIn.setBounds(84, 127, 307, 20);
		contentPane.add(userNameIn);
		userNameIn.setColumns(10);
		
		passwordIn = new JPasswordField();
		passwordIn.setBounds(84, 173, 307, 20);
		contentPane.add(passwordIn);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(84, 98, 102, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblPassword.setBounds(84, 147, 102, 28);
		contentPane.add(lblPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userNameInput = userNameIn.getText();
				String passWordInput = passwordIn.getText();
				try {
					if(loginManage.checkUserPass(userNameInput, passWordInput)) {
						JOptionPane.showInternalMessageDialog((null), "Welcome" + userNameInput);
						menu menu = new menu();
						menu.setVisible(true);
						dispose();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(360, 224, 89, 23);
		contentPane.add(btnNewButton);
	}
}
