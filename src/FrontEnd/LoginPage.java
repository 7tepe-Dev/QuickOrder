package frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import backend.Main;
import backend.User;
import database.DataHandler;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setTitle("QUICK ORDER");
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
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

	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("QUICK ORDER");
		lblNewLabel_2.setBounds(172, 11, 169, 14);
		lblNewLabel_2.setBackground(Color.WHITE);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(36, 56, 130, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(36, 76, 212, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(36, 102, 130, 14);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(36, 122, 212, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				String username = textField.getText();
				String password = String.valueOf(passwordField.getPassword());
				for (User user : User.getAllUsers()) 
				{
					System.out.println(user.getUserName());
					if (user.getUserName().equals(username) && user.getPassword().equals(password)) 
					{	
						Main.currentUser = user;
						MainPage.showMainPage();
					}
				}
				
				if (Main.currentUser == null) 
				{
					JFrame popup = new JFrame();
		            JOptionPane.showMessageDialog(popup,"Something Wrong. Try Again.");
				}


			}
		});
		
		
		btnNewButton.setBounds(36, 148, 130, 23);
		contentPane.add(btnNewButton);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				RegisterPage register = new RegisterPage();				
				register.setLocationRelativeTo(null);
				register.setResizable(false);
				register.setVisible(true);				
				
			}
		});
		btnRegister.setBounds(36, 202, 130, 23);
		contentPane.add(btnRegister);
	}

}
