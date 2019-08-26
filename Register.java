package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField tfUser;
	private JTextField tfPassword;
	private Connection conn;
	private Statement st;
	private ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//connect SQL DB
	public void ConnectDB() {
		try {
			//nap driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-1I94MIJ;database=StudentDB;integratedSecurity=true;");
			System.out.println("Connected..");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("UserName");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUser.setBounds(42, 50, 126, 34);
		contentPane.add(lblUser);
		
		tfUser = new JTextField();
		tfUser.setBounds(178, 50, 229, 34);
		contentPane.add(tfUser);
		tfUser.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(42, 131, 114, 25);
		contentPane.add(lblPassword);
		
		tfPassword = new JTextField();
		tfPassword.setBounds(178, 131, 229, 34);
		contentPane.add(tfPassword);
		tfPassword.setColumns(10);
		
		JButton btnRegis = new JButton("Register");
		btnRegis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ConnectDB();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
			}
		});
		btnRegis.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegis.setBounds(82, 189, 126, 34);
		contentPane.add(btnRegis);
	}
}
