package frontend;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import backend.*;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class MainPage extends ButtonIndexCalculator implements ActionListener 
{
	private static JFrame mainPageFrame; //ustte olmalý
	private static MainPage mainPage;
	private JPanel quickOrderPanel;//ustte olmalý
	
	private JButton basketButton;
	private JButton settingsButton;//ustte olmalý
	private ArrayList<JComponent> currentPanels;
	private int startY=5;
	private int diffBetweenButtons=105;
	public static MainPage getMainPage()
	{
		return mainPage;
	}
	public JPanel getQuickOrderPanel()
	{
		return quickOrderPanel;
	}
	public static void showMainPage(User currentUser)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					if(mainPage==null)
					{
						mainPage=new MainPage();
						mainPage.initialize(currentUser);
						mainPageFrame.setVisible(true);
					}
					else
					{
						mainPage.createAgain(currentUser);
					}
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public static Container getFrame()
	{
		return mainPageFrame.getContentPane();
	}
	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer c2=new Customer("Jonathan43","_JJJ43",UserType.CUSTOMER,1500,"London");
					showMainPage(c2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	private MainPage() 
	{
		if(currentPanels==null)
		{
			currentPanels=new ArrayList<JComponent>();
		}
	}
	

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	
	/**
	 * @wbp.parser.entryPoint
	 */
	private void createFrame()
	{
		mainPageFrame = new JFrame();
		mainPageFrame.setBackground(Color.BLACK);
		mainPageFrame.setResizable(false);
		mainPageFrame.setBounds(100,100,766,889);
		mainPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPageFrame.getContentPane().setLayout(null);
		mainPageFrame.getContentPane().setBackground(Color.black);
		mainPageFrame.setLocationRelativeTo(null);
	}
	private void createQuickOrderPanel()
	{
		quickOrderPanel = new JPanel();
		quickOrderPanel.setBounds(0,0,750,80);
		quickOrderPanel.setLayout(null);
		quickOrderPanel.setBackground(Color.decode("#CAD3C8"));
		mainPageFrame.getContentPane().add(quickOrderPanel);
		JLabel qOrderLabel = new JLabel("QUICK ORDER");
		qOrderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		qOrderLabel.setBackground(Color.decode("#2C3A47"));
		qOrderLabel.setBounds(80,0,590,80);
		qOrderLabel.setFont(new Font("Ink Free", Font.BOLD, 50));
		quickOrderPanel.add(qOrderLabel);
		settingsButton=new JButton();
		settingsButton.setBounds(670,0,80,80);
		settingsButton.setHorizontalAlignment(SwingConstants.CENTER);
		settingsButton.setVerticalAlignment(SwingConstants.CENTER);
		settingsButton.addActionListener(this);
		settingsButton.setBackground(Color.decode("#9AECDB"));
		settingsButton.setIcon(this.resizeImage("Settings Image.jpg",70,70));
		quickOrderPanel.add(settingsButton);
	}
	private void createUserInfoPanel(User currentUser)
	{
		JPanel userInfoPanel = new JPanel();
		userInfoPanel.setBounds(0,81,750,160);
		userInfoPanel.setLayout(null);
		userInfoPanel.setBackground(Color.decode("#F8EFBA"));
		JLabel userNameLabel=new JLabel("Name : "+currentUser.getUserName());
		userNameLabel.setBounds(10,0,320,80);
		userNameLabel.setFont(new Font("Ink Free", Font.PLAIN, 25));
		userInfoPanel.add(userNameLabel);
		JLabel userTypeLabel=new JLabel("User Type : "+currentUser.getUserTypeAsString());
		userTypeLabel.setBounds(10,80,320,80);
		userTypeLabel.setFont(new Font("Ink Free", Font.PLAIN, 25));
		userInfoPanel.add(userTypeLabel);
		//if(currentUser.getUsertype().equals(UserType.CUSTOMER))
		//{
			Customer currentCustomer=((Customer)currentUser);
			JLabel balanceLabel=new JLabel("Balance : "+currentCustomer.getBalance());
			balanceLabel.setBounds(330,0,250,80);
			balanceLabel.setFont(new Font("Ink Free", Font.PLAIN, 25));
			userInfoPanel.add(balanceLabel);
			JLabel locationLabel=new JLabel("Location : "+currentCustomer.getLocation());
			locationLabel.setBounds(330,80,250,80);
			locationLabel.setFont(new Font("Ink Free", Font.PLAIN, 25));
			userInfoPanel.add(locationLabel);
			basketButton=new JButton();
			basketButton.setBounds(630,45,70,70);
			basketButton.setHorizontalAlignment(SwingConstants.CENTER);
			basketButton.setVerticalAlignment(SwingConstants.CENTER);
			basketButton.addActionListener(this);
			basketButton.setIcon(this.resizeImage("Basket Image.png",70,70));
			userInfoPanel.add(basketButton);
		//}
		mainPageFrame.getContentPane().add(userInfoPanel);
	}
	private void createIntroForRestaurantPanel()
	{
		JPanel restaurantsTextSide=new JPanel();
		restaurantsTextSide.setBounds(0,242,750,100);
		restaurantsTextSide.setLayout(null);
		JLabel allRestaurantsLabel = new JLabel("All Restaurants");
		allRestaurantsLabel.setBounds(10, 0, 750, 50);
		allRestaurantsLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		allRestaurantsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		restaurantsTextSide.add(allRestaurantsLabel);
		JSeparator s1=new JSeparator();
		s1.setBounds(0, 50, 750, 1);
		s1.setBackground(Color.BLACK);
		restaurantsTextSide.add(s1);
		JLabel imageLabel=new JLabel("Image");
		imageLabel.setBounds(0,50,100,50);
		imageLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		restaurantsTextSide.add(imageLabel);
		JSeparator s2=new JSeparator();
		s2.setBounds(100,50,1,50);
		s2.setOrientation(SwingConstants.VERTICAL);
		restaurantsTextSide.add(s2);
		JLabel rNameLabel=new JLabel("Restaurant Name");
		rNameLabel.setBounds(100,50,375,50);
		rNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		restaurantsTextSide.add(rNameLabel);
		JSeparator s3=new JSeparator();
		s3.setBounds(475,50,1,50);
		s3.setOrientation(SwingConstants.VERTICAL);
		restaurantsTextSide.add(s3);
		JLabel rLocationLabel=new JLabel("Restaurant Location");
		rLocationLabel.setBounds(475,50,275,50);
		rLocationLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rLocationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		restaurantsTextSide.add(rLocationLabel);
		currentPanels.add(restaurantsTextSide);
		mainPageFrame.getContentPane().add(restaurantsTextSide);
	}
	private void createRestaurantsPanel()
	{
		JPanel restaurantsPanel=new JPanel();
		restaurantsPanel.setBounds(0,343,750,510);
		restaurantsPanel.setPreferredSize(new Dimension(750,510));
		restaurantsPanel.setLayout(null);
		restaurantsPanel.setBackground(Color.decode("#9AECDB"));
		JPanel outsideScrollBar=new JPanel();
		outsideScrollBar.setBounds(0,343,750,510);
		outsideScrollBar.setLayout(null);
		JScrollPane scrollPane = new JScrollPane(); 
		scrollPane.setBounds(0,0,750,510);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setAutoscrolls(true);
		scrollPane.setViewportView(restaurantsPanel);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		outsideScrollBar.add(scrollPane);
	    int buttonXPosition=0;
		int buttonYPosiiton=5;
		int buttonWidth=750;
		int buttonHeight=100;
		int preferredY=0;
		JButton restaurantButton;
		JLabel restaurantImageLabel;
		JLabel restaurantNameLabel;
		JLabel restaurantLocationLabel;
		JSeparator s1;
		JSeparator s2;
		for(int i=0;i<Restaurant.getAllRestaurants().size();i++)
		{
			if(i>=3)
			{
				preferredY=restaurantsPanel.getPreferredSize().height;
				if(i==3)
				{
					preferredY-=80;
				}
				else
				{
					preferredY+=buttonHeight;
				}
				restaurantsPanel.setPreferredSize(new Dimension(buttonWidth,preferredY));
			}
			//bu ustteki islemler yerine bir fonksiyon yazýlabilir nasýlsa bunun benzeri
			//products kýsmýnda da var
			restaurantButton = new JButton();
			restaurantButton.setBounds(buttonXPosition, buttonYPosiiton, buttonWidth, buttonHeight);
			restaurantButton.setHorizontalAlignment(SwingConstants.LEFT);
			restaurantButton.setBackground(Color.decode("#BDC581"));
			restaurantButton.addActionListener(this);
			restaurantButton.setLayout(null);
			restaurantsPanel.add(restaurantButton);
			restaurantImageLabel =new JLabel();
			restaurantImageLabel.setBounds(0,0,100,100);
			restaurantImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
			restaurantImageLabel.setIcon(this.resizeImage(Restaurant.getAllRestaurants().get(i).getImageLink(),90,90));
			restaurantButton.add(restaurantImageLabel);
			s1=new JSeparator();
			s1.setBounds(100,0,1,100);
			s1.setOrientation(SwingConstants.VERTICAL);
			restaurantButton.add(s1);
			restaurantNameLabel= new JLabel(Restaurant.getAllRestaurants().get(i).getRestaurantName());
			restaurantNameLabel.setBounds(100,0,375,100);
			restaurantNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
			restaurantNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			restaurantButton.add(restaurantNameLabel);
			s2=new JSeparator();
			s2.setBounds(475,0,1,100);
			s2.setOrientation(SwingConstants.VERTICAL);
			restaurantButton.add(s2);
			restaurantLocationLabel= new JLabel(Restaurant.getAllRestaurants().get(i).getRestaurantLocation());
			restaurantLocationLabel.setBounds(475,0,275,100);
			restaurantLocationLabel.setHorizontalAlignment(SwingConstants.CENTER);
			restaurantLocationLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			restaurantButton.add(restaurantLocationLabel);
			buttonYPosiiton+=buttonHeight+5;
		}
		mainPageFrame.getContentPane().add(outsideScrollBar);
		currentPanels.add(outsideScrollBar);
	}
	private void createAgain(User currentUser)
	{
		this.createIntroForRestaurantPanel();
		this.createRestaurantsPanel();
		mainPageFrame.revalidate();
		mainPageFrame.repaint();
	}
	private void initialize(User currentUser) 
	{
		this.createFrame();
		this.createQuickOrderPanel();
		this.createUserInfoPanel(currentUser);
		this.createIntroForRestaurantPanel();
		this.createRestaurantsPanel();
	}
	private void remove(ArrayList<JComponent> c)
	{
		for(JComponent b:c)
		{
			System.out.println("name:"+b.getName());
			mainPageFrame.getContentPane().remove(b);
		}
	}
	public static void addPanel(JPanel panel)
	{
		mainPageFrame.getContentPane().add(panel);
		mainPageFrame.getContentPane().revalidate();
		mainPageFrame.getContentPane().repaint();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==settingsButton)
		{
			System.out.println("Demek ayarlara gitmek istiyorsun?");
		}
		else if(e.getSource()==basketButton)
		{
			System.out.println("Sepete gitmek istriyorsun?");
		}
		else
		{
			this.remove(this.currentPanels);
			currentPanels.clear();
			ProductsPage.showProductsPage(Restaurant.getAllRestaurants().get(this.calculateButtonIndex(e.getSource().toString(), startY, diffBetweenButtons)));
		}
	}
}