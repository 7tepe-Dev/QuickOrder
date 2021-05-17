import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
public class GUI implements ActionListener {
	
	private static JLabel UserLabel;
	private static JTextField UserText;
	private static JLabel PasswordLabel;
	private static JPasswordField PasswordText;
	private static JButton LoginButton;
	private static JButton RegisterButton;
	private static JLabel Succes;
	private static JLabel Uns;
	private static JLabel Unsuccessfull;
	private static JFrame frame = new JFrame("YEMEK ZEPETÝ");
	
	public static void main(String args[]) {
		
		//LaunchPage launchPage = new LaunchPage ();
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 50, 204));
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
		LoginButton.setBounds(185,80,90,25);
		LoginButton.addActionListener(new GUI());
		panel.add(LoginButton);
		
		RegisterButton = new  JButton ("Register");
		RegisterButton.setForeground(new Color(255, 255, 255));
		RegisterButton.setBackground(new Color(0, 0, 0));
		RegisterButton.setBounds(185,110,90,25);
		RegisterButton.addActionListener(new GUI());
		panel.add(RegisterButton);
		frame.dispose();
		RegisterPage regPage = new RegisterPage();
		regPage.setVisible(false);
		
		Succes = new JLabel("");
		Succes.setBounds(10,110,148,25);
		panel.add(Succes);
		
		Uns = new JLabel ("");
		Uns.setBounds(10,110,300,25);
		panel.add(Uns);
		
		ownersFirstPage ownPage = new ownersFirstPage();
		ownPage.setVisible(false);
		
		Unsuccessfull unspage = new Unsuccessfull();
		unspage.setVisible(false);
		
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==LoginButton) {
			frame.dispose();
			String User = UserText.getText();
			String Password = PasswordText.getText();
			System.out.println(User + "  " + Password);
			System.out.println("clicked");
			/*boolean check=false;//=isLoginCorrect(User,Password);
			if(check) {
				
			}
			else {
				Unsuccessfull.setVisible(true);
			}
			*/LoginPage logPage = new LoginPage();
			logPage.setVisible(true);
		}
		
		else if(e.getSource()==RegisterButton) {
			frame.dispose();
			RegisterPage regPage = new RegisterPage();
			regPage.setVisible(true);
		}
		
		
		
	}

}
//Jlabel JTextField JPassword vb silinecek
//private static JLabel UserLabel;//
//private static JTextField UserText; vb kullanýlacak//
//if else yapýsý action void'e eklenilecek (baðlamak lazým)//
