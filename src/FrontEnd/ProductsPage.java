package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;



import backend.Restaurant;


public class ProductsPage extends ButtonIndexCalculator implements ActionListener  
{
	private static ProductsPage productsPage;
	ArrayList<JComponent> currentComponents;
	JButton backButton;
	int buttonXPosition=0;
	int buttonYPosition=5;
	int startYPosition=5;
	int buttonWidth=600;
	int buttonHeight=100;
	int preferredY=0;
	
	public static void showProductsPage(Restaurant r)
	{
		productsPage=new ProductsPage();
		productsPage.initialize(r);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductsPage p=new ProductsPage();
					p.initialize(new Restaurant("asd"));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	private ProductsPage() 
	{
		if(currentComponents==null)
		{
			currentComponents=new ArrayList<JComponent>();
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void createBackButton()
	{
		backButton=new JButton();
		backButton.setBounds(0,0,100,100);
		backButton.setIcon(this.resizeImage("backButton.png",90,90));
		backButton.addActionListener(this);
		this.backButtonHandler(backButton,"add");
		//MainPage.addBackButton(backButton);
	}
	
	private void createProductsIntro(Restaurant restaurant)
	{
		JPanel productsIntroPanel=new JPanel();
		productsIntroPanel.setBounds(0,242,750,200);
		productsIntroPanel.setLayout(null);
		currentComponents.add(productsIntroPanel);
		JLabel restaurantNameLabel=new JLabel(restaurant.getRestaurantName());
		restaurantNameLabel.setBounds(0, 0, 750, 100);
		restaurantNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		restaurantNameLabel.setFont(new Font("Ink Free", Font.BOLD, 50));
		restaurantNameLabel.setBackground(Color.BLUE);
		productsIntroPanel.add(restaurantNameLabel);
		JLabel restaurantImageLabel=new JLabel();
		restaurantImageLabel.setBounds(0, 0, 100, 100);
		restaurantImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		restaurantImageLabel.setIcon(this.resizeImage(restaurant.getImageLink(),90,90));
		productsIntroPanel.add(restaurantImageLabel);
		JSeparator s1=new JSeparator();
		s1.setBounds(100,0,1,100);
		s1.setOrientation(SwingConstants.VERTICAL);
		productsIntroPanel.add(s1);
		JSeparator s2=new JSeparator();
		s2.setBounds(0,100,750,1);
		s2.setOrientation(SwingConstants.HORIZONTAL);
		productsIntroPanel.add(s2);
		JLabel allProductsLabel = new JLabel("All Products");
		allProductsLabel.setBounds(10, 100, 750, 50);
		allProductsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		allProductsLabel.setFont(new Font("Ink Free", Font.BOLD, 30));
		productsIntroPanel.add(allProductsLabel);
		JSeparator s3=new JSeparator();
		s3.setBounds(0,150,750,1);
		s3.setOrientation(SwingConstants.HORIZONTAL);
		productsIntroPanel.add(s3);
		JLabel imageLabel=new JLabel("Image");
		imageLabel.setBounds(0, 150, 100, 50);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel.setFont(new Font("Ink Free", Font.BOLD, 25));
		productsIntroPanel.add(imageLabel);
		JSeparator s4=new JSeparator();
		s4.setBounds(100,150,1,50);
		s4.setOrientation(SwingConstants.VERTICAL);
		productsIntroPanel.add(s4);
		JLabel productNameLabel=new JLabel("Product Name");
		productNameLabel.setBounds(100, 150,300, 50);
		productNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productNameLabel.setFont(new Font("Ink Free", Font.BOLD, 25));
		productsIntroPanel.add(productNameLabel);
		JSeparator s5=new JSeparator();
		s5.setBounds(400,150,1,50);
		s5.setOrientation(SwingConstants.VERTICAL);
		productsIntroPanel.add(s5);
		JLabel productPriceLabel = new JLabel("Product Price");
		productPriceLabel.setBounds(400,150,200,50);
		productPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productPriceLabel.setFont(new Font("Ink Free", Font.BOLD, 25));
		productsIntroPanel.add(productPriceLabel);
		JSeparator s6 = new JSeparator();
		s6.setBounds(600,150,1,50);
		s6.setOrientation(SwingConstants.VERTICAL);
		productsIntroPanel.add(s6);
		MainPage.addPanel(productsIntroPanel);
		//this.addPanelToFrame(productsIntroPanel);
	}
	private void createProducts(Restaurant restaurant)
	{
		JPanel productsPanel=new JPanel();
		productsPanel.setBounds(0,443,750,410);
	    productsPanel.setPreferredSize(new Dimension(750,410));
	    productsPanel.setLayout(null);
		productsPanel.setBackground(Color.decode("#9AECDB"));
		JScrollPane scrollPane = new JScrollPane(); 
		scrollPane.setBounds(0,0,750,410);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setAutoscrolls(true);
		scrollPane.setViewportView(productsPanel);
		JPanel outsideScrollBar=new JPanel();
		outsideScrollBar.setBounds(0,443,750,410);
		outsideScrollBar.setLayout(null);
		outsideScrollBar.add(scrollPane);
		JButton productButton;
		JLabel productImageLabel;		
		JLabel productNameLabel;
		JSeparator s1;
		JSeparator s2;
		JLabel productPriceLabel;
		for(int i=0;i<restaurant.getAllProducts().size();i++)
		{
			if(i>=3)
			{
				preferredY=productsPanel.getPreferredSize().height;
				if(i==3)
				{
					preferredY+=15;
				}
				else
				{
					preferredY+=buttonHeight;

				}
				productsPanel.setPreferredSize(new Dimension(buttonWidth,preferredY));
			}
			productButton = new JButton();
			productButton.setBounds(buttonXPosition, buttonYPosition, buttonWidth, buttonHeight);
			productButton.setHorizontalAlignment(SwingConstants.LEFT);
			productButton.setBackground(Color.decode("#BDC581"));
			productButton.setLayout(null);
			productButton.addActionListener(this);
			productsPanel.add(productButton);
			productImageLabel =new JLabel();
			productImageLabel.setBounds(0,0,100,100);
			productImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
			productImageLabel.setIcon(restaurant.getAllProducts().get(i).getDirectImage());
			productButton.add(productImageLabel);
			s1=new JSeparator();
			s1.setBounds(100,0,1,100);
			s1.setOrientation(SwingConstants.VERTICAL);
			productButton.add(s1);
			productNameLabel= new JLabel(restaurant.getAllProducts().get(i).getProductName());
			productNameLabel.setBounds(100,0,300,100);
			productNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
			productNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			productButton.add(productNameLabel);
			s2 =new JSeparator();
			s2.setBounds(400,0,1,100);
			s2.setOrientation(SwingConstants.VERTICAL);
			productButton.add(s2);
			productPriceLabel= new JLabel(Double.toString(restaurant.getAllProducts().get(i).getProductPrice()));
			productPriceLabel.setBounds(400,0,200,100);
			productPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
			productPriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			productButton.add(productPriceLabel);
			buttonYPosition+=buttonHeight+5;
		}
		currentComponents.add(outsideScrollBar);
		MainPage.addPanel(outsideScrollBar);
		//this.addPanelToFrame(outsideScrollBar);
	}
	private void initialize(Restaurant restaurant) 
	{
		this.createBackButton();
		this.createProductsIntro(restaurant);
		this.createProducts(restaurant);
	}
	public void remove(ArrayList<JComponent> component)
	{
		for(JComponent c:component)
		{
			MainPage.getFrame().remove(c);
		}
	}
	private void backButtonHandler(JButton button,String checker)
	{
		if(checker.equals("add"))
		{
			MainPage.getMainPage().getQuickOrderPanel().add(button);
		}
		else
		{
			MainPage.getMainPage().getQuickOrderPanel().remove(button);
		}
		MainPage.getMainPage().getQuickOrderPanel().revalidate();
		MainPage.getMainPage().getQuickOrderPanel().repaint();
	}
	private void addPanelToFrame(JPanel panel)
	{
		MainPage.getFrame().add(panel);
		MainPage.getFrame().revalidate();
		MainPage.getFrame().repaint();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		System.out.println(e.getSource());
		if(e.getSource()==backButton)
		{
			this.remove(currentComponents);
			this.backButtonHandler(backButton,"remove");
			//MainPage.removeBackButton(backButton);
			currentComponents.clear();
			productsPage=null;
			MainPage.showMainPage(backend.Main.currentUser);
		}
		else
		{
			System.out.println(this.calculateButtonIndex(e.getSource().toString(),startYPosition,this.buttonHeight+5));
		}
	}
}