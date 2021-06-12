package frontend;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import backend.Customer;
import backend.Owner;
import backend.Restaurant;
import backend.User;
import backend.UserType;


public class MainPage extends CommonThings implements ActionListener,WindowListener
{
	
	private static JFrame mainPageFrame;
	private static MainPage mainPage=null;
	private ArrayList<Component> currentPanels;
	private JPanel quickOrderPanel;
	private JButton settingsButton;
	private JButton basketButton;
	private JLabel balanceLabel;
	private JLabel locationLabel;
	private int yPositionHolderForPanels=0;
	private int yPositionHolderForButtons=0;
	private int buttonXPosition=0;
	private int buttonWidth=735;
	private int startYPositionForProducts=0;
	private final int diffBetweenButtons=1;
	private final int quickOrderPanelHeight=80;
	private final int userInfoPanelHeight=160;
	private final int adminIntroPanelHeight=50;
	private final int usersTextSidePanelHeight=100;
	private final int restaurantsTextSidePanelHeight=100;
	private final int usersButtonHeight=100;
	private final int restaurantsButtonHeight=100;
	private final Color quickOrderBackgroundColor=Color.decode("#00745D");
	private final Color quickOrderTextColor=Color.decode("#ffd32a");
	private final Color userInfoBackgroundColor=Color.decode("#E55531");
	private final Color userInfoTextsColor=Color.decode("#3A001E");
	private final Color introTextColor=Color.decode("#00000");
	private final Color introSeparatorColor=Color.decode("#4D4637");
	private final Color separatorColor=Color.decode("#B3AA99"); 
	private final Color textColor=Color.decode("#ffd32a");
	private final Color buttonColor=Color.decode("#4D4637");
	private final Color backgroundColor=Color.decode("#ffd32a");
	
	public static void showMainPage()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(backend.Main.currentUser.getUsertype().equals(UserType.OWNER))
					{
						mainPage=new MainPage();
						mainPage.createCommons();
						mainPage.setStartPositionForProducts(mainPage.quickOrderPanelHeight+mainPage.userInfoPanelHeight+2);
						ProductsPage.showProductsPage(mainPage.startYPositionForProducts,((Owner)backend.Main.currentUser).getRestaurant());
						mainPageFrame.setVisible(true);
					}
					else
					{
						if(mainPage==null)
						{
							mainPage=new MainPage();
							mainPage.initialize();
							mainPageFrame.setVisible(true);
						}
						else
						{
							mainPage.createAgain();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void updateUserInfo(String balanceText,String locationText)
	{
		updateBalance(balanceText);
		updateLocation(locationText);
	}
	public JLabel getBalanceLabel()
	{
		return balanceLabel;
	}
	public JLabel getLocationLabel()
	{
		return locationLabel;
	}
	private void updateBalance(String text)
	{
		System.out.println("text:"+text);
		if(text.isEmpty() || text!=null)
		{
			balanceLabel.setText("Balance:"+text);
		}
	}
	private void updateLocation(String text)
	{
		if(text.isEmpty() || text!=null)
		{
			locationLabel.setText("Location:"+text);
		}
	}
	public MainPage() {}
	public int getStartYPosition()
	{
		return startYPositionForProducts;
	}
	private void setStartPositionForProducts(int addition)
	{
		startYPositionForProducts+=addition;
	}
	protected void createAgain() 
	{
		for(Component c:currentPanels)
		{
			c.setVisible(true);
		}
		repaintANDrevalidate(getMainPageFrame());
	}
	public void createCommons() throws MalformedURLException
	{
		this.createFrame();
		this.createQuickOrderPanel();
		this.createUserInfoPanel(backend.Main.currentUser);
	}
	
	public static MainPage getMainPage()
	{
		if(mainPage==null)
		{
			mainPage=new MainPage();
		}
		return mainPage;
	}
	public Container getMainPageFrame()
	{
		return mainPageFrame.getContentPane();
	}
	public JPanel getQuickOrderPanel()
	{
		return quickOrderPanel;
	}
	private void initialize() throws MalformedURLException 
	{
		if(currentPanels==null)
		{
			currentPanels=new ArrayList<Component>();
		}
		this.createFrame();
		this.createQuickOrderPanel();
		this.createUserInfoPanel(backend.Main.currentUser);
		this.createContentsPanel();
	}
	public void createFrame()
	{
		mainPageFrame = new JFrame();
		mainPageFrame.addWindowListener(this);;
		mainPageFrame.setBackground(Color.BLACK);
		mainPageFrame.setResizable(false);
		mainPageFrame.setBounds(100,100,766,889);
		mainPageFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		mainPageFrame.getContentPane().setLayout(null);
		mainPageFrame.getContentPane().setBackground(Color.black);
		mainPageFrame.setLocationRelativeTo(null);
	}
	public void createQuickOrderPanel() throws MalformedURLException
	{
		quickOrderPanel = new JPanel();
		quickOrderPanel.setBounds(0,0,750,quickOrderPanelHeight);
		quickOrderPanel.setLayout(null);
		quickOrderPanel.setBackground(quickOrderBackgroundColor);
		addToContainer(mainPageFrame.getContentPane(), quickOrderPanel);
		JLabel qOrderLabel = new JLabel("QUICK ORDER");
		qOrderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		qOrderLabel.setForeground(this.quickOrderTextColor);
		qOrderLabel.setBounds(80,0,590,80);
		qOrderLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		addToContainer(quickOrderPanel, qOrderLabel);
		settingsButton=new JButton();
		settingsButton.setBounds(670,0,80,80);
		settingsButton.setHorizontalAlignment(SwingConstants.CENTER);
		settingsButton.setVerticalAlignment(SwingConstants.CENTER);
		settingsButton.addActionListener(this);
		settingsButton.setIcon(this.resizeImage(getClass().getResource("/generalResources/Settings Image.jpg").toString(), 80, 80));
		settingsButton.setBackground(Color.decode("#9AECDB"));
		addToContainer(quickOrderPanel, settingsButton);
		yPositionHolderForPanels+=quickOrderPanelHeight+1;
	}
	public void createUserInfoPanel(User currentUser) throws MalformedURLException
	{
		JPanel userInfoPanel = new JPanel();
		userInfoPanel.setBounds(0,yPositionHolderForPanels,750,userInfoPanelHeight);
		userInfoPanel.setLayout(null);
		userInfoPanel.setBackground(userInfoBackgroundColor);
		JLabel userNameLabel=new JLabel("Name : "+currentUser.getUserName());
		userNameLabel.setBounds(10,0,320,80);
		userNameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		userNameLabel.setForeground(userInfoTextsColor);
		addToContainer(userInfoPanel, userNameLabel);
		JLabel userTypeLabel=new JLabel("User Type : "+currentUser.getUserTypeAsString());
		userTypeLabel.setBounds(10,80,320,80);
		userTypeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		userTypeLabel.setForeground(userInfoTextsColor);
		addToContainer(userInfoPanel, userTypeLabel);
		
		if(currentUser.getUsertype().equals(UserType.CUSTOMER))
		{
			Customer currentCustomer=((Customer)currentUser);
			balanceLabel=new JLabel("Balance : "+currentCustomer.getBalance());
			balanceLabel.setBounds(330,0,250,80);
			balanceLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
			balanceLabel.setForeground(userInfoTextsColor);
			addToContainer(userInfoPanel, balanceLabel);
			locationLabel=new JLabel("Location : "+currentCustomer.getLocation());
			locationLabel.setBounds(330,80,250,80);
			locationLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
			locationLabel.setForeground(userInfoTextsColor);
			addToContainer(userInfoPanel,locationLabel);
			basketButton=new JButton();
			basketButton.setBounds(630,45,70,70);
			basketButton.setHorizontalAlignment(SwingConstants.CENTER);
			basketButton.setVerticalAlignment(SwingConstants.CENTER);
			basketButton.addActionListener(this);
			basketButton.setIcon(this.resizeImage(getClass().getResource("/generalResources/Basket Image.png").toString(),70,70));
			addToContainer(userInfoPanel,basketButton);
		}
		else if(currentUser.getUsertype().equals(UserType.OWNER))
		{
			Owner currentOwner=((Owner)currentUser);
			balanceLabel=new JLabel("Balance : "+currentOwner.getBalance());
			balanceLabel.setBounds(330,0,250,80);
			balanceLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
			balanceLabel.setForeground(userInfoTextsColor);
			addToContainer(userInfoPanel, balanceLabel);
			if(currentOwner.getRestaurant()==null)
			{
				locationLabel=new JLabel("Location : "+"Not added");
			}
			else
			{
				locationLabel=new JLabel("Location : "+currentOwner.getRestaurant().getRestaurantLocation());
			}
			locationLabel.setBounds(330,80,250,80);
			locationLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
			locationLabel.setForeground(userInfoTextsColor);
			addToContainer(userInfoPanel, locationLabel);
		}
		else if(currentUser.getUsertype().equals(UserType.ADMIN))
		{
			balanceLabel=new JLabel("Balance : "+"I don't need money");
			balanceLabel.setBounds(330,0,250,80);
			balanceLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
			balanceLabel.setForeground(userInfoTextsColor);
			addToContainer(userInfoPanel, balanceLabel);
			locationLabel=new JLabel("Location : "+"Something else you can imagine");
			locationLabel.setBounds(330,80,250,80);
			locationLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
			locationLabel.setForeground(userInfoTextsColor);
			addToContainer(userInfoPanel, locationLabel);
		}
		addToContainer(mainPageFrame.getContentPane(), userInfoPanel);
		yPositionHolderForPanels+=userInfoPanelHeight+1;
	}
	private void createIntroForAdmin(int x,Container container)
	{
		JPanel adminIntroPanel=new JPanel();
		adminIntroPanel.setBounds(x,yPositionHolderForPanels,750,adminIntroPanelHeight);
		adminIntroPanel.setLayout(null);
		JLabel adminIntroText=new JLabel("All users and all restaurants are listed below");
		adminIntroText.setBounds(10,0,740,adminIntroPanelHeight);
		adminIntroText.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		adminIntroText.setHorizontalAlignment(SwingConstants.LEFT);
		addToContainer(adminIntroPanel,adminIntroText);
		addToContainer(container,adminIntroPanel);
		currentPanels.add(adminIntroPanel);
		yPositionHolderForPanels+=adminIntroPanelHeight+1;
	}
	private void createIntroForUsers(int x,Container container)
	{
		JPanel usersTextSidePanel=new JPanel();
		usersTextSidePanel.setBounds(x,0,750,usersTextSidePanelHeight);
		usersTextSidePanel.setLayout(null);
		JLabel allUsersLabel = new JLabel("All Users");
		allUsersLabel.setBounds(10,0,750,50);
		allUsersLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		allUsersLabel.setLayout(null);
		allUsersLabel.setHorizontalAlignment(SwingConstants.LEFT);
		addToContainer(usersTextSidePanel,allUsersLabel);
		JSeparator s1=new JSeparator();
		s1.setBounds(0, 50, 750, 1);
		s1.setBackground(Color.BLACK);
		s1.setBackground(introSeparatorColor);
		s1.setForeground(introSeparatorColor);
		addToContainer(usersTextSidePanel,s1);
		JLabel userNameLabel=new JLabel("User Name");
		userNameLabel.setBounds(0,50,225,50);
		userNameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		userNameLabel.setForeground(introTextColor);
		userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addToContainer(usersTextSidePanel,userNameLabel);
		JSeparator s2=new JSeparator();
		s2.setBounds(225,50,1,50);
		s2.setOrientation(SwingConstants.VERTICAL);
		//s2.setBackground(introSeparatorColor);
		//s2.setForeground(introSeparatorColor);
		addToContainer(usersTextSidePanel,s2);
		JLabel userPasswordLabel=new JLabel("User Password");
		userPasswordLabel.setBounds(226,50,225,50);
		userPasswordLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		userPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userPasswordLabel.setForeground(introTextColor);
		addToContainer(usersTextSidePanel,userPasswordLabel);
		JSeparator s3=new JSeparator();
		s3.setBounds(451,50,1,50);
		s3.setOrientation(SwingConstants.VERTICAL);
		s3.setBackground(introSeparatorColor);
		s3.setForeground(introSeparatorColor);
		addToContainer(usersTextSidePanel,s3);
		JLabel usertypeLabel=new JLabel("User Type");
		usertypeLabel.setBounds(452,50,110,50);
		usertypeLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		usertypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usertypeLabel.setForeground(introTextColor);
		addToContainer(usersTextSidePanel,usertypeLabel);
		JSeparator s4=new JSeparator();
		s4.setBounds(562,50,1,50);
		s4.setOrientation(SwingConstants.VERTICAL);
		s4.setBackground(introSeparatorColor);
		s4.setForeground(introSeparatorColor);
		addToContainer(usersTextSidePanel,s4);
		JLabel userLocationLabel=new JLabel("User Location");
		userLocationLabel.setBounds(563,50,172,50);
		userLocationLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		userLocationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userLocationLabel.setForeground(introTextColor);
		addToContainer(usersTextSidePanel,userLocationLabel);
		currentPanels.add(usersTextSidePanel);
		addToContainer(container,usersTextSidePanel);
		this.yPositionHolderForButtons+=this.usersTextSidePanelHeight+diffBetweenButtons;
	}
	private void createIntroForRestaurants(int x,int y,Container container)
	{
		JPanel restaurantsTextSidePanel=new JPanel();
		if(backend.Main.currentUser.getUsertype().equals(UserType.ADMIN))
		{
			restaurantsTextSidePanel.setBounds(x,y,735,restaurantsTextSidePanelHeight);
			this.yPositionHolderForButtons+=restaurantsTextSidePanelHeight+diffBetweenButtons/*+2*/;
		}
		else
		{
			restaurantsTextSidePanel.setBounds(x,y,750,restaurantsTextSidePanelHeight);
			yPositionHolderForPanels+=restaurantsTextSidePanelHeight+1;
		}
		restaurantsTextSidePanel.setLayout(null);
		restaurantsTextSidePanel.setBackground(Color.decode("#F2FEDC"));
		JLabel allRestaurantsLabel = new JLabel("All Restaurants");
		allRestaurantsLabel.setBounds(10, 0, 725, 50);
		allRestaurantsLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		allRestaurantsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		allRestaurantsLabel.setForeground(Color.decode("#00000"));
		addToContainer(restaurantsTextSidePanel,allRestaurantsLabel);
		JSeparator s1=new JSeparator();
		s1.setBounds(0, 50, 750, 1);
		s1.setBackground(introSeparatorColor);
		s1.setForeground(introSeparatorColor);
		addToContainer(restaurantsTextSidePanel,s1);
		JLabel imageLabel=new JLabel("Image");
		imageLabel.setBounds(0,50,100,50);
		imageLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel.setForeground(introTextColor);
		addToContainer(restaurantsTextSidePanel,imageLabel);
		JSeparator s2=new JSeparator();
		s2.setBounds(100,50,1,50);
		s2.setBackground(introSeparatorColor);
		s2.setForeground(introSeparatorColor);
		s2.setOrientation(SwingConstants.VERTICAL);
		addToContainer(restaurantsTextSidePanel,s2);
		JLabel restaurantNameLabel=new JLabel("Restaurant Name");
		restaurantNameLabel.setBounds(101,50,370,50);
		restaurantNameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		restaurantNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		restaurantNameLabel.setForeground(introTextColor);
		addToContainer(restaurantsTextSidePanel,restaurantNameLabel);
		JSeparator s3=new JSeparator();
		s3.setBounds(471,50,1,50);
		s3.setOrientation(SwingConstants.VERTICAL);
		s3.setBackground(introSeparatorColor);
		s3.setForeground(introSeparatorColor);
		addToContainer(restaurantsTextSidePanel,s3);
		JLabel restaurantLocationLabel=new JLabel("Restaurant Location");
		restaurantLocationLabel.setBounds(472,50,278,50);//normalde 263
		restaurantLocationLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		restaurantLocationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		restaurantLocationLabel.setForeground(introTextColor);
		addToContainer(restaurantsTextSidePanel,restaurantLocationLabel);
		currentPanels.add(restaurantsTextSidePanel);
		addToContainer(container,restaurantsTextSidePanel);
		
	}
	private void createAllRestaurants(JPanel contentsPanel) throws MalformedURLException
	{
		JButton restaurantButton;
		JLabel restaurantImageLabel;
		JLabel restaurantNameLabel;
		JLabel restaurantLocationLabel;
		JSeparator s1;
		JSeparator s2;
		for(int i=0;i<Restaurant.getAllRestaurants().size();i++)
		{
			restaurantButton = new JButton();
			restaurantButton.setBounds(buttonXPosition, yPositionHolderForButtons, buttonWidth, restaurantsButtonHeight);
			restaurantButton.setHorizontalAlignment(SwingConstants.LEFT);
			restaurantButton.setBackground(Color.decode("#A3CB38"));
			restaurantButton.addActionListener(this);
			restaurantButton.setLayout(null);
			restaurantButton.setBackground(buttonColor);
			restaurantButton.setName("r"+i);
			addToContainer(contentsPanel,restaurantButton);
			restaurantImageLabel =new JLabel();
			restaurantImageLabel.setBounds(0,0,100,100);
			restaurantImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
			restaurantImageLabel.setVerticalAlignment(SwingConstants.CENTER);
			restaurantImageLabel.setIcon(this.resizeImage(Restaurant.getAllRestaurants().get(i).getImageLink(),90,90));
			addToContainer(restaurantButton,restaurantImageLabel);
			s1=new JSeparator();
			s1.setBounds(100,0,1,100);
			s1.setOrientation(SwingConstants.VERTICAL);
			s1.setBackground(separatorColor);
			s1.setForeground(separatorColor);
			addToContainer(restaurantButton,s1);
			restaurantNameLabel= new JLabel(Restaurant.getAllRestaurants().get(i).getRestaurantName());
			restaurantNameLabel.setBounds(101,0,370,100);
			restaurantNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
			restaurantNameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			restaurantNameLabel.setForeground(textColor);
			addToContainer(restaurantButton,restaurantNameLabel);
			s2=new JSeparator();
			s2.setBounds(471,0,1,100);
			s2.setOrientation(SwingConstants.VERTICAL);
			s2.setBackground(separatorColor);
			s2.setForeground(separatorColor);
			addToContainer(restaurantButton,s2);
			restaurantLocationLabel= new JLabel(Restaurant.getAllRestaurants().get(i).getRestaurantLocation());
			restaurantLocationLabel.setBounds(472,0,263,100);
			restaurantLocationLabel.setHorizontalAlignment(SwingConstants.CENTER);
			restaurantLocationLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			restaurantLocationLabel.setForeground(textColor);
			addToContainer(restaurantButton,restaurantLocationLabel);
			yPositionHolderForButtons+=restaurantsButtonHeight+diffBetweenButtons;
		}
		repaintANDrevalidate(contentsPanel);
	}
	private void createAllUsers(JPanel contentsPanel)
	{
		String locationText="";
		JButton usersButton;
		JLabel userNameLabel;
		JLabel userPasswordLabel;
		JLabel usertypeLabel;
		JLabel userLocationLabel;
		JSeparator s1;
		JSeparator s2;
		JSeparator s3;
		for(int i=0;i<User.getAllUsers().size();i++)
		{
			if(User.getAllUsers().get(i).getUsertype().equals(UserType.ADMIN))
			{
				locationText="Who knows?";
			}
			else if(User.getAllUsers().get(i).getUsertype().equals(UserType.CUSTOMER))
			{
				locationText=((Customer)User.getAllUsers().get(i)).getLocation();
			}
			else if(User.getAllUsers().get(i).getUsertype().equals(UserType.OWNER))
			{
				if(((Owner)User.getAllUsers().get(i)).getRestaurant()!=null)
				{
					locationText=((Owner)User.getAllUsers().get(i)).getRestaurant().getRestaurantLocation();
				}
			}
			usersButton = new JButton();
			usersButton.setBounds(buttonXPosition,yPositionHolderForButtons, buttonWidth, usersButtonHeight);
			usersButton.setHorizontalAlignment(SwingConstants.LEFT);
			usersButton.setBackground(this.buttonColor);
			usersButton.addActionListener(this);
			usersButton.setLayout(null);
			usersButton.setName("u"+i);
			addToContainer(contentsPanel, usersButton);
			userNameLabel =new JLabel(User.getAllUsers().get(i).getUserName());
			userNameLabel.setBounds(0,0,225,100);
			userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
			userNameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN,20));
			userNameLabel.setForeground(this.textColor);
			addToContainer(usersButton, userNameLabel);
			s1=new JSeparator();
			s1.setBounds(225,0,1,100);
			s1.setOrientation(SwingConstants.VERTICAL);
			s1.setBackground(this.separatorColor);
			s1.setForeground(this.separatorColor);
			addToContainer(usersButton, s1);
			userPasswordLabel= new JLabel(User.getAllUsers().get(i).getPassword());
			userPasswordLabel.setBounds(226,0,225,100);
			userPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
			userPasswordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			userPasswordLabel.setForeground(this.textColor);
			addToContainer(usersButton, userPasswordLabel);
			s2=new JSeparator();
			s2.setBounds(451,0,1,100);
			s2.setOrientation(SwingConstants.VERTICAL);
			s2.setBackground(this.separatorColor);
			s2.setForeground(this.separatorColor);
			addToContainer(usersButton, s2);
			usertypeLabel= new JLabel(User.getAllUsers().get(i).getUserTypeAsString());
			usertypeLabel.setBounds(452,0,110,100);
			usertypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
			usertypeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			usertypeLabel.setForeground(this.textColor);
			addToContainer(usersButton, usertypeLabel);
			s3=new JSeparator();
			s3.setBounds(562,0,1,100);
			s3.setOrientation(SwingConstants.VERTICAL);
			s3.setBackground(this.separatorColor);
			s3.setForeground(this.separatorColor);
			addToContainer(usersButton, s3);
			userLocationLabel= new JLabel(locationText);
			userLocationLabel.setBounds(563,0,172,100);
			userLocationLabel.setHorizontalAlignment(SwingConstants.CENTER);
			userLocationLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			userLocationLabel.setForeground(this.textColor);
			addToContainer(usersButton, userLocationLabel);
			yPositionHolderForButtons+=usersButtonHeight+diffBetweenButtons;
		}
		repaintANDrevalidate(contentsPanel);
	}
	private void createContentsPanel() throws MalformedURLException
	{
		JPanel contentsPanel=new JPanel();
		JPanel outsideScrollBar=new JPanel();
		JScrollPane scrollPane = new JScrollPane();
		
		contentsPanel.setLayout(null);
		contentsPanel.setBackground(this.backgroundColor);
		outsideScrollBar.setLayout(null);
		currentPanels.add(outsideScrollBar);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setAutoscrolls(true);
		scrollPane.setViewportView(contentsPanel);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(13, 0));
		scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 13));
		addToContainer(outsideScrollBar, scrollPane);
		addToContainer(mainPageFrame.getContentPane(), outsideScrollBar);
		resizeThePanel(contentsPanel);
		if(backend.Main.currentUser.getUsertype().equals(UserType.ADMIN))
		{
			createIntroForAdmin(0,mainPageFrame.getContentPane());
			createIntroForUsers(0,contentsPanel);
			createAllUsers(contentsPanel);
			createIntroForRestaurants(0,this.yPositionHolderForButtons,contentsPanel);
			createAllRestaurants(contentsPanel);
		}
		else if(backend.Main.currentUser.getUsertype().equals(UserType.CUSTOMER))
		{
			createIntroForRestaurants(0,this.yPositionHolderForPanels,mainPageFrame.getContentPane());
			createAllRestaurants(contentsPanel);
		}
		outsideScrollBar.setBounds(0,yPositionHolderForPanels,750,850-yPositionHolderForPanels);
		contentsPanel.setBounds(0,0,735,850-yPositionHolderForPanels);
		scrollPane.setBounds(0,0,750,850-yPositionHolderForPanels);
	}
	private void resizeThePanel(JPanel panel)
	{
		int dynamicChange=0;
		panel.setPreferredSize(new Dimension(0,0));
		if(backend.Main.currentUser.getUsertype().equals(UserType.ADMIN))
		{
			dynamicChange=(User.getAllUsers().size()*usersButtonHeight)+(Restaurant.getAllRestaurants().size()*restaurantsButtonHeight)
					+((User.getAllUsers().size()+Restaurant.getAllRestaurants().size()+2)*diffBetweenButtons)
					+usersTextSidePanelHeight+restaurantsTextSidePanelHeight;
		}
		else if(backend.Main.currentUser.getUsertype().equals(UserType.CUSTOMER))
		{
			dynamicChange=(Restaurant.getAllRestaurants().size()*restaurantsButtonHeight)
					+((Restaurant.getAllRestaurants().size())*diffBetweenButtons);
		}
		panel.setPreferredSize(new Dimension(panel.getPreferredSize().width,dynamicChange));
	}
	
	private void removeCurrentPanels()
	{
		for(Component component:this.currentPanels)
		{
			//mainPageFrame.getContentPane().remove(component);
			component.setVisible(false);
		}
		repaintANDrevalidate(mainPageFrame.getContentPane());
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==settingsButton)
		{
			//System.out.println("Demek ayarlara gitmek istiyorsun.");
			
			AdditionalFrameAndPopups.getAdditionalThings().createSettingsFrame();
		}
		else if(e.getSource()==basketButton)
		{
			System.out.println("Demek sepete gitmek istiyorsun.");
		}
		else
		{
			String checker=((JButton)e.getSource()).getName();
			int index=Integer.parseInt(checker.substring(1));
			if(checker.charAt(0)=='r')
			{
				System.out.println(Restaurant.getAllRestaurants().get(index).getRestaurantName());
				removeCurrentPanels();
				//currentPanels.clear();
				startYPositionForProducts=this.quickOrderPanelHeight+this.userInfoPanelHeight+2;
				try {
					ProductsPage.showProductsPage(startYPositionForProducts,Restaurant.getAllRestaurants().get(index));
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(checker.charAt(0)=='u')
			{
				System.out.println(User.getAllUsers().get(index).getUserName());
			}
		}
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) 
	{
		System.out.println("Window is about to close!");
		System.out.println("Gidiyorum bak he");
		mainPageFrame.dispose();
	}
	@Override
	public void windowClosed(WindowEvent e) {
		//System.out.println("Window is about to close!");
		mainPageFrame.dispose();
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}