package activity;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import attr.*;
/* -------------------------------------------------------------------------------------------
 *                      Class to handle current Employee screen
 *-------------------------------------------------------------------------------------------
 */
public class EmployeeActivity extends JFrame implements ActionListener {
	
	/*
	 * ------------------------------Creating Panel
	 */
	private JPanel panel;
	private Employee employee;//Object of employee Class
	
	
	/*
	 *------------------------------Creating Button and Label on the Panel 
	 */
	private JButton buttonLogout, buttonProfile, buttonViewProduct;
	private JButton buttonViewCustomer, buttonViewEmployee;
	private JLabel title, header;
	
	/*
	 * ------------------------------Constructor
	 */
	public EmployeeActivity(String userId) {
		
		super("Dashboard - Employee");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		employee = new Employee(userId);// Object of Employee Class....
		employee.fetch();//Calling Fetch Method of the User Class which is Overridden in the Employee Class
		
		/*
		 *------------------------------Setting the Panel
		 * 
		 */
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		/*
		 *------------------------------Setting the screen 
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
		 *------------------------------Setting Logout Button 
		 */
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonLogout.setFont(Theme.FONT_BUTTON);
		buttonLogout.setBackground(Color.WHITE);
		buttonLogout.setForeground(Theme.COLOR_TITLE);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);//Adding button to the panel
		
		/*
		 *------------------------------Setting the button for My profile
		 */
		buttonProfile = new JButton("My Profile");
		buttonProfile.setBounds(Theme.GUI_WIDTH-150, 80, 120,30);
		buttonProfile.setFont(Theme.FONT_BUTTON);
		buttonProfile.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonProfile.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonProfile.addActionListener(this);
		panel.add(buttonProfile);//Adding to the Panel 
		
		/*
		 *------------------------------Setting View Product Button 
		 */
		buttonViewProduct = new JButton("View Product");
		buttonViewProduct.setBounds(60, 190, 200, 30);
		buttonViewProduct.setFont(Theme.FONT_BUTTON);
		buttonViewProduct.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonViewProduct.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonViewProduct.addActionListener(this);
		panel.add(buttonViewProduct);//Adding to the Panel 
		
		/*
		 *------------------------------Setting view Customer Button 
		 */
		buttonViewCustomer = new JButton("View Customer");
		buttonViewCustomer.setBounds(60, 230, 200, 30);
		buttonViewCustomer.setFont(Theme.FONT_BUTTON);
		buttonViewCustomer.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonViewCustomer.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonViewCustomer.addActionListener(this);
		panel.add(buttonViewCustomer);//Adding to the panel 
		
		
		
	/*
	 * If the manager account is logged in it will show the Employee option on the
	 *  dash board otherwise it will skip the Employee button 
	 */	
		if (employee.getRole().equals("Manager")) {
			buttonViewEmployee = new JButton("View Employee");
			buttonViewEmployee.setBounds(60, 270, 200, 30);
			buttonViewEmployee.setFont(Theme.FONT_BUTTON);
			buttonViewEmployee.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
			buttonViewEmployee.setForeground(Theme.COLOR_BUTTON_PRIMARY);
			buttonViewEmployee.addActionListener(this);
			panel.add(buttonViewEmployee);//Adding employee button to the panel
		}
		/*
		 *------------------------------Setting Header in window
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
		
		this.add(panel);//Adding to the panel 
	}
	
	
	/*
	 *------------------------------Managing action by User
	 * 
	 *  -----------------Assigning action upon selecting the specific button 
	 */
	public void actionPerformed(ActionEvent ae) {
		 String oldText = title.getText();
	      String newText= oldText.substring(1)+ oldText.substring(0,1);
	      title.setText(newText);
		if (ae.getSource().equals(buttonProfile)) {
			this.setVisible(false);//Profile Button Event 
			new MyProfileActivity(this, employee).setVisible(true);
		}
		else if (ae.getSource().equals(buttonLogout)) {
			this.setVisible(false); //Logout Button Event 
			new LoginActivity().setVisible(true);
		}
		else if (ae.getSource().equals(buttonViewProduct)) {
			this.setVisible(false);//Product Button Event 
			new ViewProductActivity(this, employee).setVisible(true);
		}
		else if (ae.getSource().equals(buttonViewCustomer)) {
			this.setVisible(false);//Customer Button Event 
			new ViewCustomerActivity(this, employee).setVisible(true);
		}
		else if (ae.getSource().equals(buttonViewEmployee)) {
			this.setVisible(false);//Employee Button Event 
			new ViewEmployeeActivity(this, employee).setVisible(true);
		}
		else {}
	}
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////