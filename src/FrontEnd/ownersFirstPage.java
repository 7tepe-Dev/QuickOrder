import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class ownersFirstPage extends JFrame  {
 
	private JFrame frame;
	private JTextField restaurantText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ownersFirstPage window = new ownersFirstPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ownersFirstPage() {
		initialize();
		setSize(600,600);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel addPanel = new JPanel();
		addPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		addPanel.setBackground(Color.YELLOW);
		addPanel.setBounds(10, 54, 414, 196);
		frame.getContentPane().add(addPanel);
		addPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Restaurant Name: ");
		lblNewLabel.setBounds(10, 11, 91, 14);
		addPanel.add(lblNewLabel);
		
		restaurantText = new JTextField();
		restaurantText.setBounds(111, 8, 86, 20);
		addPanel.add(restaurantText);
		restaurantText.setColumns(10);
		
		JButton checkRestaurant = new JButton("OK");
		checkRestaurant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPanel.hide();
				String restaurantName = restaurantText.getText();
				System.out.println("Restaurant Name:" + restaurantName);
				
			}
		});
		checkRestaurant.setBounds(315, 162, 89, 23);
		addPanel.add(checkRestaurant);
		
		addPanel.hide();
		
		JButton addRestaurant = new JButton("Add a new restaurant");
		addRestaurant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPanel.show();
				
			}
		});
		addRestaurant.setBounds(10, 11, 188, 32);
		frame.getContentPane().add(addRestaurant);
	}
}
