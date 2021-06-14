package frontend;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import backend.Restaurant;
import backend.User;
import backend.UserType;

public class ProductsPage extends CommonThings implements ActionListener {

	private static ProductsPage productsPage;
	private static Restaurant currentRestaurant;
	private JButton addRestaurantButton;
	private JButton backButton;
	private JButton addProductButton;
	private JPanel outsideScrollBar;
	JScrollPane scrollPane;
	JPanel productsPanel;
	ArrayList<Component> currentComponents;
	public static int startY=0;
	private int productButtonsHeight=100;
	private int addProductButtonHeight=80;
	private int diffBetweenButtons=1;
	private int diffBetweenAddAndPButtons=10;
	JLabel restaurantImageLabel;
	private Color productButtonColor=Color.decode("#efe0e3");
	private Color outsideScrollbarBackground=Color.decode("#ffd32a");
	private Color productTextColor=Color.decode("#ab0012");
	public static void showProductsPage(int startYPosition,Restaurant restaurant) throws MalformedURLException
	{
		productsPage=new ProductsPage();
		currentRestaurant=restaurant;
		startY=startYPosition;
		productsPage.initializeArray();
		productsPage.initialize();
	}
	public void changeRestaurantImage(String path) throws MalformedURLException
	{
		restaurantImageLabel.setIcon(this.resizeImage(path, 90, 90));
	}
	public Restaurant getCurrentRestaurant()
	{
		return currentRestaurant;
	}
	public void setCurrentRestaurant(Restaurant restaurant)
	{
		currentRestaurant=restaurant;
	}
	public static ProductsPage getProductsPage()
	{
		return productsPage;
	}
	public void createForOwner() throws MalformedURLException
	{
		if(currentRestaurant==null)
		{
			this.initializePanels();
			this.createRestaurantButtonForOwner(productsPanel);
		}
		else
		{
			createProductsIntro();
			createProducts();
		}
	}
	public void createForOthers() throws MalformedURLException
	{
		createBackButton();
		createProductsIntro();
		createProducts();
	}
	private void initializeArray()
	{
		if(currentComponents==null)
		{
			currentComponents=new ArrayList<Component>();
		}
	}
	public ProductsPage() {}
	private void initializePanels()
	{
		productsPanel=new JPanel();
		productsPanel.setBounds(0,0,750,850-startY);
		productsPanel.setLayout(null);
		productsPanel.setBackground(outsideScrollbarBackground);
		scrollPane = new JScrollPane(); 
		scrollPane.setBounds(0,0,750,850-startY);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(13, 0));
		scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 13));
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setAutoscrolls(true);
		scrollPane.setViewportView(productsPanel);
		outsideScrollBar=new JPanel();
		outsideScrollBar.setBounds(0,startY,750,850-startY);
		outsideScrollBar.setBackground(Color.black);
		outsideScrollBar.setLayout(null);
		currentComponents.add(outsideScrollBar);

		addToContainer(outsideScrollBar, scrollPane);
		addToContainer(MainPage.getMainPage().getMainPageFrame(), outsideScrollBar);
	}
	private void createBackButton() throws MalformedURLException
	{
		backButton=new JButton();
		backButton.setBounds(0,0,80,80);
		backButton.setHorizontalAlignment(SwingConstants.CENTER);
		backButton.setVerticalAlignment(SwingConstants.CENTER);
		backButton.setIcon(this.resizeImage(getClass().getResource("/generalResources/backButton.png").toString(),80,80));
		backButton.addActionListener(this);
		addToContainer(MainPage.getMainPage().getQuickOrderPanel(),backButton);
	}
	private void createProductsIntro() throws MalformedURLException
	{
		JPanel productsIntroPanel=new JPanel();
		productsIntroPanel.setBackground(Color.decode("#F2FEDC"));
		productsIntroPanel.setBounds(0,startY,750,200);
		productsIntroPanel.setLayout(null);
		currentComponents.add(productsIntroPanel);
		restaurantImageLabel=new JLabel();
		restaurantImageLabel.setBounds(0, 0, 100, 100);
		restaurantImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		restaurantImageLabel.setIcon(this.resizeImage(currentRestaurant.getImageLink(),90,90));
		addToContainer(productsIntroPanel, restaurantImageLabel);
		JSeparator s1=new JSeparator();
		s1.setForeground(Color.BLACK);
		s1.setBounds(100,0,1,100);
		s1.setOrientation(SwingConstants.VERTICAL);
		addToContainer(productsIntroPanel, s1);
		JLabel restaurantNameLabel=new JLabel(currentRestaurant.getRestaurantName());
		restaurantNameLabel.setBounds(101, 0, 649, 100);
		restaurantNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		restaurantNameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		restaurantNameLabel.setBackground(Color.BLUE);
		addToContainer(productsIntroPanel, restaurantNameLabel);
		JSeparator s2=new JSeparator();
		s2.setForeground(Color.BLACK);
		s2.setBounds(0,100,750,1);
		s2.setOrientation(SwingConstants.HORIZONTAL);
		addToContainer(productsIntroPanel, s2);
		JLabel allProductsLabel = new JLabel("All Products");
		allProductsLabel.setBounds(10, 100, 740, 50);
		allProductsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		allProductsLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		addToContainer(productsIntroPanel, allProductsLabel);
		JSeparator s3=new JSeparator();
		s3.setForeground(Color.BLACK);
		s3.setBounds(0,150,750,1);
		s3.setOrientation(SwingConstants.HORIZONTAL);
		addToContainer(productsIntroPanel, s3);
		JLabel imageLabel=new JLabel("Image");
		imageLabel.setBounds(0, 150, 100, 50);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		addToContainer(productsIntroPanel, imageLabel);
		JSeparator s4=new JSeparator();
		s4.setForeground(Color.BLACK);

		s4.setBounds(101,150,1,50);
		s4.setOrientation(SwingConstants.VERTICAL);
		addToContainer(productsIntroPanel, s4);
		JLabel productNameLabel=new JLabel("Product Name");
		productNameLabel.setBounds(101, 150,433, 50);
		productNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productNameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		addToContainer(productsIntroPanel, productNameLabel);
		JSeparator s5=new JSeparator();
		s5.setForeground(Color.BLACK);
		s5.setBounds(535,150,1,50);
		s5.setOrientation(SwingConstants.VERTICAL);
		addToContainer(productsIntroPanel, s5);
		JLabel productPriceLabel = new JLabel("Product Price");
		productPriceLabel.setBounds(535,150,215,50);
		productPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productPriceLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		addToContainer(productsIntroPanel, productPriceLabel);
		addToContainer(MainPage.getMainPage().getMainPageFrame(),productsIntroPanel);
		startY+=201;
	}
	private void createRestaurantButtonForOwner(JPanel addToMe) 
	{
		addRestaurantButton=new JButton("Please add your restaurant!");
		addRestaurantButton.setBounds(217, 100,300,addProductButtonHeight);
		addRestaurantButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		addRestaurantButton.setHorizontalAlignment(SwingConstants.CENTER);
		addRestaurantButton.setBackground(Color.decode("#ab0012"));
		addRestaurantButton.setForeground(Color.decode("#feb036"));
		addRestaurantButton.setLayout(null);
		addRestaurantButton.addActionListener(this);
		addToContainer(addToMe, addRestaurantButton);
		repaintANDrevalidate(addToMe);
	}
	public void removeCreateRestaurantButton()
	{
		this.removeFromContainer(productsPanel,addRestaurantButton);
		addRestaurantButton=null;
	}
	public void refreshProducts() throws MalformedURLException
	{
		startY=MainPage.getMainPage().getStartYPosition()+201;
		createProducts();
	}
	public void removeProducts()
	{
		removeFromContainer(MainPage.getMainPage().getMainPageFrame(),outsideScrollBar);
		outsideScrollBar=null;
	}
	
	private void createProducts() throws MalformedURLException
	{
		initializePanels();	
		this.resizeThePanel(productsPanel);
		JButton productButton;
		JLabel productImageLabel;		
		JLabel productNameLabel;
		JSeparator s1;
		JSeparator s2;
		JLabel productPriceLabel;
		int buttonYPosition=0;
		if(currentRestaurant.getAllProducts().size()==0 && !User.getCurentUser().getUsertype().equals(UserType.OWNER))
		{
			JLabel infoLabel=new JLabel("There are no products.");
			infoLabel.setBounds(0, buttonYPosition,735,productButtonsHeight);
			infoLabel.setBackground(Color.decode("#BDC581"));
			infoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
			addToContainer(productsPanel, infoLabel);
		}
		for(int i=0;i<currentRestaurant.getAllProducts().size();i++)
		{
			productButton = new JButton();
			productButton.setBounds(0, buttonYPosition,735,productButtonsHeight);
			productButton.setHorizontalAlignment(SwingConstants.LEFT);
			productButton.setBackground(productButtonColor);
			productButton.setLayout(null);
			productButton.addActionListener(this);
			productButton.setName("b"+i);
			addToContainer(productsPanel, productButton);
			productImageLabel =new JLabel();
			productImageLabel.setBounds(0,0,100,100);
			productImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
			productImageLabel.setIcon(this.resizeImage(currentRestaurant.getAllProducts().get(i).getProductImage(), 90, 90) );
			addToContainer(productButton, productImageLabel);
			s1=new JSeparator();
			s1.setForeground(Color.BLACK);
			s1.setBounds(100,0,1,100);
			s1.setOrientation(SwingConstants.VERTICAL);
			addToContainer(productButton, s1);
			productNameLabel= new JLabel(currentRestaurant.getAllProducts().get(i).getProductName());
			productNameLabel.setBounds(101,0,433,100);
			productNameLabel.setForeground(productTextColor);
			productNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
			productNameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			addToContainer(productButton, productNameLabel);
			s2 =new JSeparator();
			s2.setForeground(Color.BLACK);
			s2.setBounds(534,0,1,100);
			s2.setOrientation(SwingConstants.VERTICAL);
			addToContainer(productButton, s2);
			productPriceLabel= new JLabel(Double.toString(currentRestaurant.getAllProducts().get(i).getProductPrice()));
			productPriceLabel.setBounds(535,0,215,100);
			productPriceLabel.setForeground(productTextColor);
			productPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
			productPriceLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			addToContainer(productButton, productPriceLabel);
			buttonYPosition+=productButtonsHeight+diffBetweenButtons;
		}
		if(User.getCurentUser().getUsertype().equals(UserType.OWNER))
		{
			buttonYPosition+=diffBetweenAddAndPButtons;
			createAddProductButtonForOwner(productsPanel,buttonYPosition);
		}
		currentComponents.add(outsideScrollBar);
	}
	private void createAddProductButtonForOwner(JPanel addToMe,int buttonYPosition)
	{
		addProductButton=new JButton("Add new product!");
		addProductButton.setBounds(250, buttonYPosition,235,addProductButtonHeight);
		addProductButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		addProductButton.setHorizontalAlignment(SwingConstants.CENTER);
		addProductButton.setBackground(Color.decode("#BDC581"));
		addProductButton.setLayout(null);
		addProductButton.addActionListener(this);
		addToContainer(addToMe, addProductButton);
	}
	private void resizeThePanel(JPanel panel)
	{
		int dynamicChange=0;
		panel.setPreferredSize(new Dimension(0,0));
		dynamicChange=currentRestaurant.getAllProducts().size()*productButtonsHeight
				+(currentRestaurant.getAllProducts().size()+1)*diffBetweenButtons;
		if(User.getCurentUser().getUsertype().equals(UserType.OWNER))
		{
			dynamicChange+=this.addProductButtonHeight+(this.diffBetweenAddAndPButtons)*2;
		}
		panel.setPreferredSize(new Dimension(panel.getPreferredSize().width,dynamicChange));
	}
	private void initialize() throws MalformedURLException 
	{
		if(User.getCurentUser().getUsertype().equals(UserType.OWNER))
		{
			createForOwner();
		}
		else
		{
			createForOthers();
		}
	}
	public void removeThings()
	{
		for(Component c:currentComponents)
		{
			removeFromContainer(MainPage.getMainPage().getMainPageFrame(), c);
		}
	}
	private void removeBackButton()
	{
		removeFromContainer(MainPage.getMainPage().getQuickOrderPanel(),backButton);
	}
	public void doThisBeforeLoadDiffPage()
	{
		removeBackButton();
		removeThings();
		currentComponents.clear();
		productsPage=null;
	}
	public void refreshForAddition()
	{
		removeThings();
		currentComponents.clear();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==backButton)
		{
			doThisBeforeLoadDiffPage();
			MainPage.showMainPage();
		}
		else if(e.getSource()==addProductButton)
		{
			AdditionalFrameAndPopups.getAdditionalThings().createAddProductsButtonFrame();
		}
		else if(e.getSource()==addRestaurantButton)
		{
			AdditionalFrameAndPopups.getAdditionalThings().createAddRestaurantFrame();
		}
		else
		{
			String checker=((JButton)e.getSource()).getName();
			int index=Integer.parseInt(checker.substring(1));
			System.out.println(currentRestaurant.getAllProducts().get(index).getProductName());
		}
	}
}