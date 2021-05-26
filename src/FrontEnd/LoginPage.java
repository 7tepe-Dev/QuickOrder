import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import backend.User;

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
public class LoginPage implements ActionListener {
	
	private static JLabel UserLabel;
	private static JTextField UserText;
	private static JLabel PasswordLabel;
	private static JPasswordField PasswordText;
	private static JButton LoginButton;
	private static JButton RegisterButton;
	private static JLabel Unsuccessfull;
	private static JFrame frame = new JFrame("YEMEK ZEPETÝ");
	private static JRadioButton ownerButton;
	private static JRadioButton userButton;
	private static JPanel panel;
	private static int a=1;
	public static void main(String args[]) {
		
		//LaunchPage launchPage = new LaunchPage ();
		
		
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(Color.WHITE);
		frame.setBackground(new Color(248, 248, 255));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,200);
		frame.getContentPane().add(panel);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		panel.setLayout(null);
		
		UserLabel = new JLabel("Username");
		UserLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		UserLabel.setBounds(10,20,80,25);
		panel.add(UserLabel);
		
		UserText = new JTextField();
		UserText.setBounds(100,20,165,25);
		panel.add(UserText);
		
		PasswordLabel = new JLabel("Password");
		PasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		PasswordLabel.setBounds(10,50,80,25);
		panel.add(PasswordLabel);
		
		PasswordText = new JPasswordField();
		PasswordText.setBounds(100,50,165,25);
		panel.add(PasswordText);
		
		LoginButton = new JButton("Login");
		LoginButton.setForeground(new Color(255, 255, 255));
		LoginButton.setBackground(new Color(0, 0, 0));
		LoginButton.setBounds(175,86,90,25);
		LoginButton.addActionListener(new LoginPage());
		panel.add(LoginButton);
		
		RegisterButton = new  JButton ("Register");
		RegisterButton.setForeground(new Color(255, 255, 255));
		RegisterButton.setBackground(new Color(0, 0, 0));
		RegisterButton.setBounds(175,113,90,25);
		RegisterButton.addActionListener(new LoginPage());
		panel.add(RegisterButton);
		frame.dispose();
		
		
		
		MainPage mainpage = new MainPage();
		mainpage.setVisible(false);
		
		frame.setVisible(true);
		
	}
	public boolean checkLogin() {
		String username= UserText.getText();
		String password = PasswordText.getText();
		for(int i=0; i<User.getAllUsers().size(); i++) {
			if(username.equals(User.getAllUsers().get(i).getUserName()) && password.equals(User.getAllUsers().get(i).getPassword())) {
				return true;
				
			}
		}
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==LoginButton) {
			frame.dispose();
			
			boolean check = checkLogin();
			if(check) {
			MainPage mainpage = new MainPage();
			mainpage.setVisible(true);
				//anasayfaya yönlendir//
			}
			else {
				JOptionPane.showMessageDialog(null, "Username or password is wrong!");
				//KULLANICI ADI ÞÝFRE SIFIRLANACAK//
				//!!!!BURADA DÝREKT WÝNDOWU KAPATIYOR BUNU ÇÖZMEMÝZ LAZIM!!!!//
			}
					
		}
		
		else if(e.getSource()==RegisterButton) {
			if(a==1) {
				LoginButton.setVisible(false);
				ownerButton = new JRadioButton("Owner");
				ownerButton.setBounds(54, 82, 86, 14);
				ownerButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(ownerButton.isSelected()) {
							userButton.setSelected(false);
						}
					}
				});
				panel.add(ownerButton);
				
				
				userButton = new JRadioButton("User");
				userButton.setBounds(54, 99, 89, 17);
				userButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(userButton.isSelected()) {
							ownerButton.setSelected(false);
						}
					}
				});
				panel.add(userButton);
				a++;
			}
			else {
				String username= UserText.getText();
				String password = PasswordText.getText();
				for(int i=0; i<User.getAllUsers().size(); i++) {
					if(username.equals(User.getAllUsers().get(i).getUserName())) {
						JOptionPane.showMessageDialog(null, "username allready ALINMIÞ!");
						UserText.setText("");
						//USERTEXT SIFIRLANMASI LAZIM//
					}
				}
				if(userButton.isSelected()){
					System.out.println("USERBUTTON IS SELECTED");
				}
				else if(ownerButton.isSelected()) {
					System.out.println("Owner is selected");
				}
				else {
					JOptionPane.showMessageDialog(null, "choose your type!");
				}
			}
			
		}
		
		
		
	}

}
