package frontend;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import backend.Customer;
import backend.Owner;
import backend.Product;
import backend.Restaurant;
import backend.User;
import backend.UserType;

public class AdditionalFrameAndPopups extends CommonThings implements ActionListener 
{
	private static AdditionalFrameAndPopups additionalThings;
	private JFrame frame;
	
	private JTextField productNameTextField;
	private JTextField productPriceTextField;
	
	private JTextField balanceText;
	private JTextField locationText;
	
	private JTextField restaurantNameTF;
	private JTextField restaurantBalanceTF;
	private JTextField restaurantLocationTF;
	
	private JButton imageChooserForProducts;
	private JButton imageChooserForRestaurant;
	private JButton chooseForRestaurant;
	//private JButton image
	
	private JButton addProductButton;
	private JButton updateSettingsButton;
	private JButton addRestaurantButton;
	
	
	private JLabel productImageLabel;
	private JLabel restaurantImageLabel;
	//private JLabel restaurantImageLabelFirst;

	private JPanel settingsPanel;
	private JPanel addRestaurantPanel;
	private JPanel addProductsPanel;

	private String imageDirectory;
	
	public void createAddProductsButtonFrame()
	{
		frame = new JFrame();
		frame.setBounds(800,400, 516, 539);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		addProductsPanel = new JPanel();
		addProductsPanel.setBounds(0, 0, 500, 500);
		addProductsPanel.setBackground(Color.decode("#ab0012"));
		frame.getContentPane().add(addProductsPanel);
		addProductsPanel.setLayout(null);
		JLabel productNameLabel = new JLabel("Product Name:");
		productNameLabel.setForeground(Color.decode("#feb036"));
		productNameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		productNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		productNameLabel.setBounds(55, 90, 195, 50);
		addProductsPanel.add(productNameLabel);
		productNameTextField = new JTextField();
		productNameTextField.setHorizontalAlignment(SwingConstants.LEFT);
		productNameTextField.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		productNameTextField.setBounds(250, 90, 220, 50);
		addProductsPanel.add(productNameTextField);
		productNameTextField.setColumns(10);
		JLabel productPriceLabel = new JLabel("Product Price:");
		productPriceLabel.setForeground(Color.decode("#feb036"));
		productPriceLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		productPriceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		productPriceLabel.setBounds(55, 180, 195, 50);
		addProductsPanel.add(productPriceLabel);
		productPriceTextField = new JTextField();
		productPriceTextField.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		productPriceTextField.setBounds(250, 180, 220, 50);
		addProductsPanel.add(productPriceTextField);
		productPriceTextField.setColumns(10);
		JLabel productImageLabelT = new JLabel("Product Image:");
		productImageLabelT.setForeground(Color.decode("#feb036"));
		productImageLabelT.setHorizontalAlignment(SwingConstants.LEFT);
		productImageLabelT.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		productImageLabelT.setBounds(55, 270, 195, 50);
		addProductsPanel.add(productImageLabelT);
		imageChooserForProducts = new JButton("Choose");
		imageChooserForProducts.setBackground(Color.decode("#feb036"));
		imageChooserForProducts.setForeground(Color.decode("#ab0012"));
		imageChooserForProducts.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		imageChooserForProducts.setBounds(357, 270, 113, 50);
		imageChooserForProducts.addActionListener(this);
		addProductsPanel.add(imageChooserForProducts);
		addProductButton = new JButton("Add Product");
		addProductButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		addProductButton.setBackground(Color.decode("#feb036"));
		addProductButton.setForeground(Color.decode("#ab0012"));
		addProductButton.setBounds(125, 400, 250, 60);
		addProductButton.addActionListener(this);
		addProductsPanel.add(addProductButton);
		productImageLabel = new JLabel();
		productImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productImageLabel.setBounds(250, 255, 80, 80);
		addProductsPanel.add(productImageLabel);
		frame.setVisible(true);
	}
	public void createSettingsFrame()
	{
		if(((Owner)User.getCurentUser()).getRestaurant()!=null)
		{
			frame = new JFrame();
			frame.getContentPane().setLayout(null);
			frame.setBounds(800,400, 516, 539);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			settingsPanel = new JPanel();
			settingsPanel.setBounds(0, 0, 500, 500);
			settingsPanel.setBackground(Color.decode("#ab0012"));
			frame.getContentPane().add(settingsPanel);
			settingsPanel.setLayout(null);
			JLabel balanceLabel = new JLabel("Balance:");
			balanceLabel.setForeground(Color.decode("#feb036"));
			balanceLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
			balanceLabel.setHorizontalAlignment(SwingConstants.LEFT);
			balanceLabel.setBounds(100, 90, 150, 50);
			settingsPanel.add(balanceLabel);
			balanceText = new JTextField();
			balanceText.setHorizontalAlignment(SwingConstants.LEFT);
			balanceText.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			balanceText.setBounds(250, 90, 220, 50);
			settingsPanel.add(balanceText);
			balanceText.setColumns(10);
			JLabel locationLabel = new JLabel("Location:");
			locationLabel.setForeground(Color.decode("#feb036"));
			locationLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
			locationLabel.setHorizontalAlignment(SwingConstants.LEFT);
			locationLabel.setBounds(100, 180, 150, 50);
			settingsPanel.add(locationLabel);
			locationText = new JTextField();
			locationText.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			locationText.setBounds(250, 180, 220, 50);
			settingsPanel.add(locationText);
			locationText.setColumns(10);
			if(User.getCurentUser().getUsertype().equals(UserType.OWNER))
			{
				restaurantImageLabel = new JLabel("Restaurant Image:");
				restaurantImageLabel.setForeground(Color.decode("#feb036"));
				restaurantImageLabel.setHorizontalAlignment(SwingConstants.LEFT);
				restaurantImageLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
				restaurantImageLabel.setBounds(10, 270, 240, 60);
				settingsPanel.add(restaurantImageLabel);
				imageChooserForRestaurant = new JButton("Choose");
				imageChooserForRestaurant.setBackground(Color.decode("#feb036"));
				imageChooserForRestaurant.setForeground(Color.decode("#ab0012"));
				imageChooserForRestaurant.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
				imageChooserForRestaurant.setBounds(357, 277, 113, 50);
				imageChooserForRestaurant.addActionListener(this);
				settingsPanel.add(imageChooserForRestaurant);
				restaurantImageLabel = new JLabel("");
				restaurantImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
				restaurantImageLabel.setBounds(250, 265, 80, 80);
				settingsPanel.add(restaurantImageLabel);
			}
			updateSettingsButton = new JButton("Update");
			updateSettingsButton.setBackground(Color.decode("#feb036"));
			updateSettingsButton.setForeground(Color.decode("#ab0012"));
			updateSettingsButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
			updateSettingsButton.setBounds(125, 400, 250, 60);
			updateSettingsButton.addActionListener(this);
			settingsPanel.add(updateSettingsButton);
			frame.setVisible(true);
		}
		
	}
	public void createAddRestaurantFrame()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 516, 539);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		addRestaurantPanel = new JPanel();
		addRestaurantPanel.setBackground(Color.decode("#ab0012"));
		addRestaurantPanel.setBounds(0, 0, 500, 500);
		frame.getContentPane().add(addRestaurantPanel);
		addRestaurantPanel.setLayout(null);
		addRestaurantButton = new JButton("Add Restaurant");
		addRestaurantButton.setBackground(Color.decode("#feb036"));
		addRestaurantButton.setForeground(Color.decode("#ab0012"));
		addRestaurantButton.addActionListener(this);
		addRestaurantButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		addRestaurantButton.setBounds(100, 400, 300, 80);
		addRestaurantPanel.add(addRestaurantButton);
		JLabel restaurantNameLabel = new JLabel("Restaurant Name:");
		restaurantNameLabel.setForeground(Color.decode("#feb036"));
		restaurantNameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		restaurantNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		restaurantNameLabel.setBounds(30, 30, 220, 60);
		addRestaurantPanel.add(restaurantNameLabel);
		restaurantNameTF = new JTextField();
		restaurantNameTF.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		restaurantNameTF.setBounds(250, 30, 220, 60);
		addRestaurantPanel.add(restaurantNameTF);
		restaurantNameTF.setColumns(10);
		restaurantBalanceTF = new JTextField();
		restaurantBalanceTF.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		restaurantBalanceTF.setBounds(250, 120, 220, 60);
		addRestaurantPanel.add(restaurantBalanceTF);
		restaurantBalanceTF.setColumns(10);
		restaurantLocationTF = new JTextField(MainPage.getMainPage().getLocationLabel().getText().substring(11));
		restaurantLocationTF.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		restaurantLocationTF.setBounds(250, 210, 220, 60);
		addRestaurantPanel.add(restaurantLocationTF);
		restaurantLocationTF.setColumns(10);
		restaurantImageLabel = new JLabel("");
		restaurantImageLabel.setForeground(Color.decode("#feb036"));
		restaurantImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		restaurantImageLabel.setBounds(260, 295, 80, 80);
		addRestaurantPanel.add(restaurantImageLabel);
		chooseForRestaurant = new JButton("Choose");
		chooseForRestaurant.setBackground(Color.decode("#feb036"));
		chooseForRestaurant.setForeground(Color.decode("#ab0012"));
		chooseForRestaurant.addActionListener(this);
		chooseForRestaurant.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		chooseForRestaurant.setBounds(350, 310, 120, 50);
		addRestaurantPanel.add(chooseForRestaurant);
		JLabel restaurantBalanceLabel = new JLabel("Restaurant Balance:");
		restaurantBalanceLabel.setForeground(Color.decode("#feb036"));
		restaurantBalanceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		restaurantBalanceLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		restaurantBalanceLabel.setBounds(30, 120, 220, 60);
		addRestaurantPanel.add(restaurantBalanceLabel);
		JLabel restaurantLocationLabel = new JLabel("Restaurant Location:");
		restaurantLocationLabel.setForeground(Color.decode("#feb036"));
		restaurantLocationLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		restaurantLocationLabel.setHorizontalAlignment(SwingConstants.LEFT);
		restaurantLocationLabel.setBounds(30, 210, 220, 60);
		addRestaurantPanel.add(restaurantLocationLabel);
		JLabel restaurantImageLabel = new JLabel("Restaurant Image:");
		restaurantImageLabel.setForeground(Color.decode("#feb036"));
		restaurantImageLabel.setHorizontalAlignment(SwingConstants.LEFT);
		restaurantImageLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		restaurantImageLabel.setBounds(30, 300, 220, 60);
		addRestaurantPanel.add(restaurantImageLabel);
		frame.setVisible(true);
	}
	public static AdditionalFrameAndPopups getAdditionalThings()
	{
		if(additionalThings==null)
		{
			additionalThings=new AdditionalFrameAndPopups();
		}
		return additionalThings;
	}
	private void resetForAddRestaurant()
	{
		this.restaurantNameTF.setText("");
		this.restaurantBalanceTF.setText("");
		this.restaurantLocationTF.setText("");
		this.restaurantImageLabel.setIcon(null);
		imageDirectory="";
	}
	private void resetForAddProductFrame()
	{
		productNameTextField.setText("");
		productPriceTextField.setText("");
		productImageLabel.setIcon(null);
		imageDirectory="";
	}
	private void resetForSettings()
	{
		balanceText.setText("");
		locationText.setText("");
		if(restaurantImageLabel!=null)
		{
			restaurantImageLabel.setIcon(null);
		}
		imageDirectory="";
	}
	private void pressedProductButtonHandler()
	{
		if(productNameTextField.getText().isEmpty() || productPriceTextField.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "You have to enter name and price!");
			resetForAddProductFrame();
		}
		else
		{
			try
			{
				Product product=new Product(productNameTextField.getText(),imageDirectory,Double.parseDouble(productPriceTextField.getText()));
				for(int i=0;i<((backend.Owner)User.getCurentUser()).getRestaurant().getAllProducts().size();i++)
				{
					if(product.getProductName().equals(((backend.Owner)User.getCurentUser()).getRestaurant().getAllProducts().get(i).getProductName()))
					{
						throw new Exception();
					}
				}
				ProductsPage.getProductsPage().getCurrentRestaurant().addNewProduct(product);
				ProductsPage.getProductsPage().removeProducts();
				ProductsPage.getProductsPage().refreshProducts();
				JOptionPane.showMessageDialog(null, "New product added successfully!");
				//product database e yazdýrma islemini burada yap
				resetForAddProductFrame();
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "An error occured.Please try again!");
				resetForAddProductFrame();
			}
		}
	}
	private void pressedSettingsButtonHandler()
	{
		try
		{
			User user=User.getCurentUser();
			if(user.getUsertype().equals(UserType.CUSTOMER))
			{
				((Customer)user).setBalance(Double.parseDouble(balanceText.getText()));
				((Customer)user).setLocation(locationText.getText());
			}
			else if(user.getUsertype().equals(UserType.OWNER))
			{
				((Owner)user).setBalance(Double.parseDouble(balanceText.getText()));
				((Owner)user).getRestaurant().setRestaurantLocation(locationText.getText());
				((Owner)user).getRestaurant().setImageLink(imageDirectory);
				ProductsPage.getProductsPage().changeRestaurantImage(imageDirectory);
			}
			MainPage.getMainPage().updateUserInfo(balanceText.getText(), locationText.getText());
			JOptionPane.showMessageDialog(null, "Update is successfull!");
			resetForSettings();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "An error occured.Please try again!");
			resetForSettings();
		}
	}
	private void addRestaurantButtonHandler()
	{
		try
		{	
			((Owner) User.getCurentUser()).setBalance(Double.parseDouble(this.restaurantBalanceTF.getText()));
			Restaurant restaurant=new Restaurant(this.restaurantNameTF.getText());
			restaurant.setRestaurantLocation(this.restaurantLocationTF.getText());
			restaurant.setImageLink(imageDirectory);
			((Owner) User.getCurentUser()).setRestaurant(restaurant);
			JOptionPane.showMessageDialog(null, "Restaurant added successfully!");
			resetForAddRestaurant();
			ProductsPage.getProductsPage().setCurrentRestaurant(restaurant);
			ProductsPage.getProductsPage().removeCreateRestaurantButton();
			ProductsPage.getProductsPage().removeThings();
			MainPage.getMainPage().updateUserInfo(String.valueOf(((Owner) backend.User.getCurentUser()).getBalance()),restaurant.getRestaurantLocation());
			ProductsPage.getProductsPage().createForOwner();
			frame.dispose();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "An error occured.Please try again!");
			resetForAddRestaurant();
		}
	}
	private void handleImageDirectory(JLabel label)
	{
		FileDialog f=new FileDialog((java.awt.Frame) null);
		f.setVisible(true);
		imageDirectory="file:///"+f.getDirectory()+f.getFile();
		try 
		{
			label.setIcon(resizeImage(imageDirectory, 80, 80));
		} 
		catch (MalformedURLException e1) 
		{
			e1.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==addProductButton)
		{
			pressedProductButtonHandler();
		}
		else if(e.getSource()==updateSettingsButton)
		{
			pressedSettingsButtonHandler();
		}
		else if(e.getSource()==addRestaurantButton)
		{
			addRestaurantButtonHandler();
		}
		else if(e.getSource()==imageChooserForRestaurant)
		{
			handleImageDirectory(restaurantImageLabel);
		}
		else if(e.getSource()==imageChooserForProducts)
		{
			handleImageDirectory(productImageLabel);
		}
		else if(e.getSource()==this.chooseForRestaurant)
		{
			handleImageDirectory(restaurantImageLabel);
		}
	}
}