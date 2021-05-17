import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.AbstractListModel;

public class LoginPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(10, 11, 60, 14);
		contentPane.add(usernameLabel);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"image/name/price", "image/name/price", "image/name/price"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(10, 97, 414, 153);
		contentPane.add(list);
		
		JLabel balanceLabel = new JLabel("Balance:");
		balanceLabel.setBounds(10, 36, 60, 14);
		contentPane.add(balanceLabel);
		
		JComboBox sepetim = new JComboBox();
		sepetim.setBounds(359, 7, 30, 22);
		contentPane.add(sepetim);
		
		JComboBox settingsBox = new JComboBox();
		settingsBox.setBounds(399, 7, 30, 22);
		contentPane.add(settingsBox);
	}
}
