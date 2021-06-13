package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import backend.User;
import backend.UserFactory;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class FirstPage implements ActionListener {

	private JFrame frame;
	private JTextField usernameTF;
	private JPasswordField passwordTF;
	private JButton loginButton;
	private JButton registerButton;
	private JRadioButton radioButtonForCustomer;
	private JRadioButton radioButtonForOwner;
	private String usertype=null;
	private int counter=0;
	
	public static void createLoginPage()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstPage window = new FirstPage();
					window.initialize();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void initialize() {
		frame = new JFrame();
		frame.setSize(516,539);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel quickOrderLabel = new JLabel("QUICK ORDER");
		quickOrderLabel.setForeground(Color.decode("#dff9fb"));
		quickOrderLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 60));
		quickOrderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		quickOrderLabel.setBounds(0, 0, 500, 100);
		frame.getContentPane().add(quickOrderLabel);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.decode("#130f40"));
		topPanel.setBounds(0, 0, 500, 100);
		frame.getContentPane().add(topPanel);
		topPanel.setLayout(null);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBounds(0, 100, 500, 400);
		bottomPanel.setBackground(Color.decode("#dff9fb"));
		frame.getContentPane().add(bottomPanel);
		bottomPanel.setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		usernameLabel.setForeground(Color.decode("#130f40"));
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(30, 70, 220, 50);
		bottomPanel.add(usernameLabel);
		
		usernameTF = new JTextField();
		usernameTF.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		usernameTF.setForeground(Color.decode("#130f40"));

		usernameTF.setBounds(250, 70, 220, 50);
		bottomPanel.add(usernameTF);
		usernameTF.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(30, 160, 220, 50);
		passwordLabel.setForeground(Color.decode("#130f40"));
		bottomPanel.add(passwordLabel);
		passwordTF = new JPasswordField();
		passwordTF.setForeground(Color.decode("#130f40"));
		passwordTF.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		passwordTF.setBounds(250, 160, 220, 50);
		passwordTF.setColumns(10);
		bottomPanel.add(passwordTF);
		loginButton = new JButton("Login");
		loginButton.setBackground(Color.decode("#130f40"));
		loginButton.setForeground(Color.decode("#dff9fb"));
		loginButton.setFocusable(false);
		loginButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		loginButton.setBounds(255, 280, 220, 60);
		loginButton.addActionListener(this);
		bottomPanel.add(loginButton);
		registerButton = new JButton("Register");
		registerButton.setBackground(Color.decode("#130f40"));
		registerButton.setForeground(Color.decode("#dff9fb"));
		registerButton.setFocusable(false);
		registerButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		registerButton.setBounds(25, 280, 220, 60);
		registerButton.addActionListener(this);
		bottomPanel.add(registerButton);
		
		ButtonGroup group=new ButtonGroup();
		radioButtonForCustomer = new JRadioButton("Customer");
		radioButtonForCustomer.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		radioButtonForCustomer.setFocusable(false);
		radioButtonForCustomer.setBounds(250, 227, 171, 20);
		radioButtonForCustomer.addActionListener(this);
		radioButtonForCustomer.setVisible(false);

		bottomPanel.add(radioButtonForCustomer);
		group.add(radioButtonForCustomer);
		radioButtonForOwner = new JRadioButton("Owner");
		radioButtonForOwner.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		radioButtonForOwner.addActionListener(this);
		radioButtonForOwner.setFocusable(false);
		radioButtonForOwner.setVisible(false);
		radioButtonForOwner.setBounds(250, 263, 171, 20);
		bottomPanel.add(radioButtonForOwner);
		group.add(radioButtonForOwner);

	}
	private void handleLogin() 
	{
		String username=usernameTF.getText();
		String password=String.valueOf(passwordTF.getPassword());
		boolean temp=true;
		for(User user:User.getAllUsers())
		{
			if(user.getUserName().equals(username) && user.getPassword().equals(password))
			{
				temp=false;
				frame.dispose();
				User.setCurentUser(user);
				MainPage.showMainPage();
			}
			
		}
		if(temp)
		{
			JOptionPane.showMessageDialog(null, "Username or password is wrong!");
			usernameTF.setText("");
			passwordTF.setText("");
		}
		username=null;
		password=null;
	}
	
	private void handleRegister() 
	{
		if(counter==0)
		{
			loginButton.setVisible(false);
			registerButton.setLocation(140,300);
			radioButtonForCustomer.setVisible(true);
			radioButtonForOwner.setVisible(true);
		}
		else
		{
			if(!UserFactory.createNewUser(usernameTF.getText(),String.valueOf(passwordTF.getPassword()),usertype))
			{
				usernameTF.setText("");
				passwordTF.setText("");
			}
			else
			{
				frame.dispose();
				MainPage.showMainPage();
			}
		}
		counter++;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==loginButton)
		{
			handleLogin();
		}
		else if(e.getSource()==registerButton)
		{
			handleRegister();
		}
		else if(e.getSource()==radioButtonForCustomer)
		{
			usertype=radioButtonForCustomer.getText();
		}
		else if(e.getSource()==radioButtonForOwner)
		{
			usertype=radioButtonForOwner.getText();
		}
	}
}