package activity;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import attr.*;
/*-------------------------------------------------------------------------------------------
 *                      Class to handle current customer screen
 *-------------------------------------------------------------------------------------------
 */

public class CustomerActivity extends JFrame implements ActionListener {
	/*
	 *--------------------------Objects for Visual components and other classes
	 */
	private JPanel panel;
	private Customer customer;
	private JButton buttonLogout, buttonProfile, buttonViewProduct, buttonMyProduct;
	private JLabel title, header;
	/*
	 *--------------------------Constructor 
	 */
	public CustomerActivity(String userId) {
		super("Dashboard - Customer");
		/*
		 *--------------------------Setting up window for customer activity 
		 */
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		/*
		 *--------------------------setting panel 
		 */
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		customer = new Customer(userId);
		customer.fetch();
		/*
		 *--------------------------Setting title to panel 
		 */
		title = new JLabel(" -> Welcome "+userId);
		title.setBounds(0, 40, userId.length()*30+340,75);
		title.setOpaque(true);
		title.setBackground(Theme.BACKGROUND_PANEL);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		 Timer t = new Timer(200, this); // set a timer
	      t.start();
		
		/*
		 *--------------------------setting logout button 
		 */
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonLogout.setFont(Theme.FONT_BUTTON);
		buttonLogout.setBackground(Color.WHITE);
		buttonLogout.setForeground(Theme.COLOR_TITLE);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);
		/*
		 *--------------------------setting profile button 
		 */
		buttonProfile = new JButton("My Profile");
		buttonProfile.setBounds(Theme.GUI_WIDTH-150, 80, 120,30);
		buttonProfile.setFont(Theme.FONT_BUTTON);
		buttonProfile.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonProfile.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonProfile.addActionListener(this);
		panel.add(buttonProfile);
		/*
		 *--------------------------setting view product  button 
		 */
		buttonViewProduct = new JButton("View Product");
		buttonViewProduct.setBounds(60, 190, 200, 30);
		buttonViewProduct.setFont(Theme.FONT_BUTTON);
		buttonViewProduct.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonViewProduct.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonViewProduct.addActionListener(this);
		panel.add(buttonViewProduct);
		/*
		 *--------------------------setting purchase history button 
		 */
		buttonMyProduct = new JButton("Purchase History");
		buttonMyProduct.setBounds(60, 230, 200, 30);
		buttonMyProduct.setFont(Theme.FONT_BUTTON);
		buttonMyProduct.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonMyProduct.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonMyProduct.addActionListener(this);
		panel.add(buttonMyProduct);
		/*
		 *--------------------------setting header to panel
		 */
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		/*
		 *----------------------------Setting footer in window  
		 */
		JLabel footer = new JLabel();
		footer.setBackground(Theme.BACKGROUND_HEADER);
		footer.setOpaque(true);
		footer.setBounds(0, 540, Theme.GUI_WIDTH, 25);
		panel.add(footer);
		/*
		 * ---------------------------Adding panel to window
		 */
		this.add(panel);
	}
	/*
	 *--------------------------Sorting actions performed  
	 */
	public void actionPerformed(ActionEvent ae) {
		 String oldText = title.getText();
	      String newText= oldText.substring(1)+ oldText.substring(0,1);
	      title.setText(newText);
		if (ae.getSource().equals(buttonProfile)) {
			this.setVisible(false);
			new MyProfileActivity(this, customer).setVisible(true); //  profile button event
		}
		else if (ae.getSource().equals(buttonLogout)) {
			this.setVisible(false);
			new LoginActivity().setVisible(true); // login button event
		}
		else if (ae.getSource().equals(buttonViewProduct)) {
			this.setVisible(false);   // view product button event
			new ViewProductActivity(this, customer).setVisible(true);
		}
		else if (ae.getSource().equals(buttonMyProduct)) {
			this.setVisible(false); // my product button event
			new MyProductActivity(this, customer).setVisible(true);
		}
		else {}
	}
}