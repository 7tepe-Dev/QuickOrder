package frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import backend.Customer;
import backend.Owner;
import backend.User;
import backend.UserType;
import database.WriteData;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JMenuBar;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RegisterPage extends JFrame {

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
					RegisterPage frame = new RegisterPage();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(22, 84, 190, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(22, 62, 152, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(22, 115, 152, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(22, 140, 190, 20);
		contentPane.add(passwordField);
		
		JRadioButton rdbtnCustomer = new JRadioButton("Customer");
		rdbtnCustomer.setBounds(268, 83, 109, 23);
		contentPane.add(rdbtnCustomer);
		
		JRadioButton rdbtnOwner = new JRadioButton("Owner");
		rdbtnOwner.setBounds(268, 126, 109, 23);
		contentPane.add(rdbtnOwner);
		
		ButtonGroup G = new ButtonGroup();
		G.add(rdbtnCustomer);
		G.add(rdbtnOwner);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String username = textField.getText();
				String password = String.copyValueOf(passwordField.getPassword());
				UserType usertype = G.getSelection() == rdbtnCustomer.getModel() ? UserType.CUSTOMER : UserType.OWNER;
				
				if (usertype.equals(UserType.CUSTOMER)) 
				{
					User.addNewUserToList(new Customer(username,password,usertype));
				}
				else if(usertype.equals(UserType.OWNER))
				{
					User.addNewUserToList(new Owner(username,password,usertype));
				}
													
				LoginPage login = new LoginPage();
				login.setLocationRelativeTo(null);
				login.setResizable(false);
				login.setVisible(true);
			}
		});
		btnNewButton.setBounds(22, 188, 89, 23);
		contentPane.add(btnNewButton);
						

		

		
	}
}
