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
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 708, 84);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel unameLabel = new JLabel("Username:");
		unameLabel.setBounds(118, 11, 67, 20);
		panel.add(unameLabel);
		
		JLabel usernameLabel = new JLabel("Mert34");
		usernameLabel.setBounds(248, 14, 46, 14);
		panel.add(usernameLabel);
		
		JLabel utypeLabel = new JLabel("Usertype:");
		utypeLabel.setBounds(118, 42, 67, 20);
		panel.add(utypeLabel);
		
		JLabel usertypeLabel = new JLabel("Customer");
		usertypeLabel.setBounds(248, 45, 57, 14);
		panel.add(usertypeLabel);
		
		JLabel baLabel = new JLabel("Balance:");
		baLabel.setBounds(534, 11, 67, 20);
		panel.add(baLabel);
		
		JLabel balanceLabel = new JLabel("12.000");
		balanceLabel.setBounds(636, 14, 46, 14);
		panel.add(balanceLabel);
		
		JLabel locLabel = new JLabel("Location:");
		locLabel.setBounds(534, 42, 67, 20);
		panel.add(locLabel);
		
		JLabel locationLabel = new JLabel("Null");
		locationLabel.setBounds(636, 48, 46, 14);
		panel.add(locationLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(20, 106, 698, 385);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("All Restaurants");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 11, 109, 40);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Name");
		lblNewLabel_6.setBounds(313, 56, 57, 27);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Location");
		lblNewLabel_7.setBounds(478, 62, 46, 14);
		panel_1.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Mc Donald's                                    \u0130stanbul");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(199, 87, 438, 38);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Burger King");
		btnNewButton_1.setBounds(199, 162, 438, 38);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Fatma Ev Yemekleri");
		btnNewButton_2.setBounds(199, 238, 438, 38);
		panel_1.add(btnNewButton_2);
		
		/*JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLUE);
		panel_2.setBounds(10, 160, 718, 331);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.setBounds(629, 11, 52, 30);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("X");
		btnNewButton_1.setBounds(629, 68, 52, 30);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("X");
		btnNewButton_2.setBounds(629, 127, 52, 30);
		panel_2.add(btnNewButton_2);
		
		JScrollBar scrollBar = new JScrollBar();
		
		scrollBar.setBounds(691, 11, 17, 309);
		panel_2.add(scrollBar);
		
		JButton btnNewButton_3 = new JButton("F\u0130YAT DE\u011E\u0130\u015ET\u0130RME BUTONU");
		btnNewButton_3.setBounds(547, 15, 72, 23);
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("60.50");
		btnNewButton_4.setBounds(547, 72, 72, 23);
		panel_2.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(547, 131, 72, 23);
		panel_2.add(btnNewButton_5);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(227, 11, 166, 30);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setBounds(227, 65, 166, 30);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("New label");
		lblNewLabel_2_2.setBounds(227, 127, 166, 30);
		panel_2.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("New label");
		lblNewLabel_2_3.setBounds(227, 179, 166, 30);
		panel_2.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("New label");
		lblNewLabel_2_4.setBounds(227, 236, 166, 30);
		panel_2.add(lblNewLabel_2_4);
		
		JButton btnNewButton_5_1 = new JButton("New button");
		btnNewButton_5_1.setBounds(547, 183, 72, 23);
		panel_2.add(btnNewButton_5_1);
		
		JButton btnNewButton_5_2 = new JButton("New button");
		btnNewButton_5_2.setBounds(547, 240, 72, 23);
		panel_2.add(btnNewButton_5_2);
		
		JButton btnNewButton_2_1 = new JButton("X");
		btnNewButton_2_1.setBounds(629, 183, 52, 30);
		panel_2.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("X");
		btnNewButton_2_2.setBounds(629, 240, 52, 30);
		panel_2.add(btnNewButton_2_2);
		
		JButton btnNewButton_6 = new JButton("ADD PRODUCT");
		btnNewButton_6.setBounds(227, 290, 123, 30);
		panel_2.add(btnNewButton_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 106, 708, 45);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Burger King");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(299, 11, 90, 23);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("IMAGE");
		lblNewLabel_1.setBounds(22, 11, 78, 20);
		panel_1.add(lblNewLabel_1);
		panel_2.setVisible(true);
		
		scrollBar.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
			}
		});*/
	}
}
