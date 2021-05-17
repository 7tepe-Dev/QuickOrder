import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;

public class RegisterPage  extends JFrame {

	private JPanel contentPane;
	private JTextField usernameText;
	private JTextField passwordText;
	private JRadioButton ownerButton;
	private JRadioButton userButton;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage frame = new RegisterPage();
					frame.setLocationRelativeTo(null);
					frame.setVisible(false);
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
		setBounds(100, 100, 314, 162);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(10, 11, 70, 14);
		contentPane.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 36, 70, 14);
		contentPane.add(passwordLabel);
		
		usernameText = new JTextField();
		usernameText.setBounds(90, 8, 86, 20);
		contentPane.add(usernameText);
		usernameText.setColumns(10);
		
		passwordText = new JTextField();
		passwordText.setBounds(90, 33, 86, 20);
		contentPane.add(passwordText);
		passwordText.setColumns(10);
		
		
		
		ownerButton = new JRadioButton("Owner");
		ownerButton.setBounds(54, 82, 86, 14);
		ownerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ownerButton.isSelected()) {
					userButton.setSelected(false);
				}
			}
		});
		contentPane.add(ownerButton);
		
		
		userButton = new JRadioButton("User");
		userButton.setBounds(54, 99, 89, 17);
		userButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(userButton.isSelected()) {
					ownerButton.setSelected(false);
				}
			}
		});
		contentPane.add(userButton);
		
		JLabel lblNewLabel_4 = new JLabel("Choose your type:");
		lblNewLabel_4.setBounds(10, 61, 109, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton registerButton = new JButton("Register");
		registerButton.setBounds(199, 96, 89, 23);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selection=null;
				
					if(e.getSource()==registerButton) {
					contentPane.disable();
					String Username = usernameText.getText();
					String Password = passwordText.getText();
					System.out.println(Username + "  " + Password);
					/*LoginPage logPage = new LoginPage();
					logPage.setVisible(true);*/
					
					if (ownerButton.isSelected()) {
						selection="owner is selected";
						ownersFirstPage ownPage = new ownersFirstPage();
						ownPage.setVisible(true);
						
					}
					if(userButton.isSelected()) {
						selection="user is selected";
						LoginPage logPage = new LoginPage();
						logPage.setVisible(true);
					}
					System.out.println(selection);
				}	
			}
		});
		contentPane.add(registerButton);
	}
}
