package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;

public class BasketFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BasketFrame window = new BasketFrame();
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
	public BasketFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 516, 539);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 500, 80);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel countLabel = new JLabel("Count");
		countLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		countLabel.setHorizontalAlignment(SwingConstants.CENTER);
		countLabel.setBounds(0, 0, 80, 80);
		panel.add(countLabel);
		
		JLabel productImageLabel = new JLabel("Image");
		productImageLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		productImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productImageLabel.setBounds(81, 0, 80, 80);
		panel.add(productImageLabel);
		
		JLabel productNameLabel = new JLabel("Product Name");
		productNameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		productNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productNameLabel.setBounds(162, 0, 260, 80);
		panel.add(productNameLabel);
		
		JLabel productPriceLabel = new JLabel("Price");
		productPriceLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		productPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productPriceLabel.setBounds(422, 0, 78, 80);
		panel.add(productPriceLabel);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(80, 0, 1, 80);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(161, 0, 1, 80);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(422, 0, 1, 80);
		panel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 80, 500, 1);
		frame.getContentPane().add(separator_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 420, 500, 80);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Total Price:");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 420, 80);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(420, 0, 79, 80);
		panel_1.add(lblNewLabel_1);
		
		
	}
}
