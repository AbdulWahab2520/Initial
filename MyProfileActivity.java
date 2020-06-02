package activity;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import attr.*;
/*-------------------------------------------------------------------------------------------
 *                 Class for managing user profile activity screen
 *-------------------------------------------------------------------------------------------
 */
public class MyProfileActivity extends JFrame implements ActionListener {
	/*
	 *--------------------------Class Attributes 
	 */
	private JPanel panel;
	private JButton buttonEdit, buttonBack, buttonLogout, buttonSubmit, buttonPass, buttonDelete;
	private JFrame backActivity;
	private User usr;
	private Employee employee;
	private Customer customer;
	private JLabel title, header, usernameLabel, nameLabel, phoneLabel, addressLabel;
	private JTextField nameTF, phoneTF1, phoneTF2, addressTF;
	private JLabel roleLabel, salaryLabel;
	/*
	 *--------------------------Constructor for Customer Profile
	 */
	public MyProfileActivity(JFrame activity, Customer customer) {
		super("My Profile");
		/*
		 *--------------------------Setting a window 
		 */
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		/*
		 *--------------------------Setting panel for window 
		 */
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		/*
		 *--------------------------Passing arguments to current class 
		 */
		backActivity = activity;
		this.customer = customer;
		this.usr = (User) customer;
		/*
		 *--------------------------Setting title in panel 
		 */
		title = new JLabel(" -> My Profile");
		title.setBounds(0, 40, 440,75);
		title.setOpaque(true);
		title.setBackground(Theme.BACKGROUND_PANEL);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		Timer t = new Timer(200, this); // set a timer
	      t.start();
		/*
		 *--------------------------Setting Edit button 
		 */
		buttonEdit = new JButton("Edit Profile");
		buttonEdit.setBounds(60, 330, 120, 30);
		buttonEdit.setFont(Theme.FONT_BUTTON);
		buttonEdit.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonEdit.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonEdit.addActionListener(this);
		panel.add(buttonEdit);
		/*
		 *--------------------------Setting submit button 
		 */
		buttonSubmit = new JButton("Submit");
		buttonSubmit.setBounds(60, 330, 120, 30);
		buttonSubmit.setFont(Theme.FONT_BUTTON);
		buttonSubmit.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonSubmit.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonSubmit.setVisible(false);
		buttonSubmit.addActionListener(this);
		panel.add(buttonSubmit);
		/*
		 *--------------------------Setting Change Password button
		 */
		buttonPass = new JButton("Change Password");
		buttonPass.setBounds(Theme.GUI_WIDTH-180, 115, 160, 30);
		buttonPass.setFont(Theme.FONT_BUTTON);
		buttonPass.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonPass.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonPass.addActionListener(this);
		panel.add(buttonPass);
		/*
		 *--------------------------Setting Delete button
		 */
		buttonDelete = new JButton("Delete Account");
		buttonDelete.setBounds(Theme.GUI_WIDTH-180, 150, 160, 30);
		buttonDelete.setFont(Theme.FONT_BUTTON);
		buttonDelete.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonDelete.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonDelete.addActionListener(this);
		panel.add(buttonDelete);
		/*
		 *--------------------------Setting logout button
		 */
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH, 30);
		buttonLogout.setFont(Theme.FONT_BUTTON);
		buttonLogout.setBackground(Color.WHITE);
		buttonLogout.setForeground(Theme.COLOR_TITLE);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);
		/*
		 *--------------------------Setting Back Button 
		 */
		buttonBack = new JButton("Back");
		buttonBack.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH, 30);
		buttonBack.setFont(Theme.FONT_BUTTON);
		buttonBack.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonBack.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		/*
		 *--------------------------Setting label for user ID 
		 */
		usernameLabel = new JLabel("User ID:       "+customer.getUserId());
		usernameLabel.setBounds(60, 140, 440, 30);
		usernameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(usernameLabel);
		/*
		 *--------------------------Setting label for name 
		 */
		nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(60, 190, 440, 30);
		nameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(nameLabel);
		/*
		 *--------------------------Setting label for PH no.
		 */
		phoneLabel = new JLabel("Phone No: ");
		phoneLabel.setBounds(60, 240, 440, 30);
		phoneLabel.setFont(Theme.FONT_REGULAR);
		panel.add(phoneLabel);
		/*
		 *--------------------------Setting Address label
		 */
		addressLabel = new JLabel("Address: ");
		addressLabel.setBounds(60, 290, 440, 30);
		addressLabel.setFont(Theme.FONT_REGULAR);
		panel.add(addressLabel);
		/*
		 *--------------------------Setting Textfield for Username 
		 */
		nameTF = new JTextField(customer.getCustomerName());
		nameTF.setBounds(180, 190, 220, 30);
		nameTF.setFont(Theme.FONT_INPUT);
		nameTF.setEnabled(false);
		nameTF.setDisabledTextColor(Color.BLACK);
		panel.add(nameTF);
		/*
		 *--------------------------Setting Textfield 1 for PH no. 
		 */
		phoneTF1 = new JTextField("+92");
		phoneTF1.setBounds(180, 240, 40, 30);
		phoneTF1.setFont(Theme.FONT_INPUT);
		phoneTF1.setEnabled(false);
		phoneTF1.setDisabledTextColor(Color.BLACK);
		panel.add(phoneTF1);
		/*
		 *--------------------------Setting Textfield 2 for PH no. 
		 */
		phoneTF2 = new JTextField(customer.getPhoneNumber().substring(3));
		phoneTF2.setBounds(220, 240, 180, 30);
		phoneTF2.setFont(Theme.FONT_INPUT);
		phoneTF2.setEnabled(false);
		phoneTF2.setDisabledTextColor(Color.BLACK);
		panel.add(phoneTF2);
		/*
		 *--------------------------Setting Textfield for Address 
		 */
		addressTF = new JTextField(customer.getAddress());
		addressTF.setBounds(180, 290, 220, 30);
		addressTF.setEnabled(false);
		addressTF.setFont(Theme.FONT_INPUT);
		addressTF.setDisabledTextColor(Color.BLACK);
		panel.add(addressTF);
		
		/*
		 *--------------------------Setting panel Header
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
		this.add(panel);
		/*
		 *--------------------------Adding panel to window 
		 */
		this.add(panel);
	}
	/*
	 *--------------------------Constructor for Employee Profile
	 */
	public MyProfileActivity(JFrame activity, Employee employee) {
		super("My Profile");
		/*
		 *--------------------------Setting Window
		 */
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		/*
		 *--------------------------Setting panel for window
		 */
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		/*
		 *--------------------------Passing arguments to current class
		 */
		backActivity = activity;
		this.employee = employee;
		this.usr = (User) employee;
		/*
		 *--------------------------Setting Title for panel
		 */
		title = new JLabel(" -> My Profile");
		title.setBounds(0, 40, 450,75);
		title.setOpaque(true);
		title.setBackground(Theme.BACKGROUND_PANEL);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		Timer t = new Timer(200, this); // set a timer
	      t.start();
		/*
		 *--------------------------Setting Edit button
		 */
		buttonEdit = new JButton("Edit Profile");
		buttonEdit.setBounds(60, 380, 120, 30);
		buttonEdit.setFont(Theme.FONT_BUTTON);
		buttonEdit.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonEdit.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonEdit.addActionListener(this);
		panel.add(buttonEdit);
		/*
		 *--------------------------Setting Submit button
		 */
		buttonSubmit = new JButton("Submit");
		buttonSubmit.setBounds(60, 380, 120, 30);
		buttonSubmit.setFont(Theme.FONT_BUTTON);
		buttonSubmit.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonSubmit.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonSubmit.setVisible(false);
		buttonSubmit.addActionListener(this);
		panel.add(buttonSubmit);
		/*
		 *--------------------------Setting Change password button
		 */
		buttonPass = new JButton("Change Password");
		buttonPass.setBounds(Theme.GUI_WIDTH-180, 115, 160, 30);
		buttonPass.setFont(Theme.FONT_BUTTON);
		buttonPass.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonPass.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonPass.addActionListener(this);
		panel.add(buttonPass);
		/*
		 *--------------------------Setting logout button
		 */
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH, 30);
		buttonLogout.setFont(Theme.FONT_BUTTON);
		buttonLogout.setBackground(Color.WHITE);
		buttonLogout.setForeground(Theme.COLOR_TITLE);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);
		/*
		 *--------------------------Setting back button
		 */
		buttonBack = new JButton("Back");
		buttonBack.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH, 30);
		buttonBack.setFont(Theme.FONT_BUTTON);
		buttonBack.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonBack.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		/*
		 *--------------------------Setting label for user ID
		 */
		usernameLabel = new JLabel("User ID:        "+employee.getUserId());
		usernameLabel.setBounds(60, 140, 440, 30);
		usernameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(usernameLabel);
		/*
		 *--------------------------Setting label for name
		 */
		nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(60, 190, 440, 30);
		nameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(nameLabel);
		/*
		 *--------------------------Setting label for PH no.
		 */
		phoneLabel = new JLabel("Phone No: ");
		phoneLabel.setBounds(60, 240, 440, 30);
		phoneLabel.setFont(Theme.FONT_REGULAR);
		panel.add(phoneLabel);
		/*
		 *--------------------------Setting label for employee position
		 */
		roleLabel = new JLabel("Role:             "+employee.getRole());
		roleLabel.setBounds(60, 290, 440, 30);
		roleLabel.setFont(Theme.FONT_REGULAR);
		panel.add(roleLabel);
		/*
		 *--------------------------Setting label for salary
		 */
		salaryLabel = new JLabel("Salary:          "+employee.getSalary());
		salaryLabel.setBounds(60, 340, 440, 30);
		salaryLabel.setFont(Theme.FONT_REGULAR);
		panel.add(salaryLabel);
		/*
		 *--------------------------Setting lanel for Employee name
		 */
		nameTF = new JTextField(employee.getEmployeeName());
		nameTF.setBounds(180, 190, 220, 30);
		nameTF.setFont(Theme.FONT_INPUT);
		nameTF.setEnabled(false);
		nameTF.setDisabledTextColor(Color.BLACK);
		panel.add(nameTF);
		/*
		 *--------------------------Setting Textfield 1 for PH no.
		 */
		phoneTF1 = new JTextField("+92");
		phoneTF1.setBounds(180, 240, 40, 30);
		phoneTF1.setFont(Theme.FONT_INPUT);
		phoneTF1.setEnabled(false);
		phoneTF1.setDisabledTextColor(Color.BLACK);
		panel.add(phoneTF1);
		/*
		 *--------------------------Setting Textfield 2 for PH no.
		 */
		phoneTF2 = new JTextField(employee.getPhoneNumber().substring(3));
		phoneTF2.setBounds(220, 240, 180, 30);
		phoneTF2.setFont(Theme.FONT_INPUT);
		phoneTF2.setEnabled(false);
		phoneTF2.setDisabledTextColor(Color.BLACK);
		panel.add(phoneTF2);
		/*
		 *--------------------------Setting panel header
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
		 *--------------------------Adding panel to window
		 */
		this.add(panel);
	}
	/*
	 *--------------------------Method to manage actions performed by user
	 */
	public void actionPerformed(ActionEvent ae) {
		String oldText = title.getText();
	      String newText= oldText.substring(1)+ oldText.substring(0,1);
	      title.setText(newText);
		if (ae.getSource().equals(buttonBack)) {
			this.setVisible(false);
			backActivity.setVisible(true);
		}//back button event
		else if (ae.getSource().equals(buttonLogout)) {
			this.setVisible(false);
			new LoginActivity().setVisible(true);
		}//logout button event
		else if (ae.getSource().equals(buttonEdit)) {
			buttonEdit.setVisible(false);
			buttonSubmit.setVisible(true);
			nameTF.setEnabled(true);
			phoneTF2.setEnabled(true);
			if (customer!=null)
				addressTF.setEnabled(true);
		}//edit button event
		else if (ae.getSource().equals(buttonSubmit)) {
			/*
			 *--------------------------customer profile update
			 */
			if (customer!=null) {
				addressTF.setEnabled(false);
				try {
					customer.updateCustomer(nameTF.getText().trim(), Integer.parseInt(phoneTF2.getText()), addressTF.getText().trim());
					buttonEdit.setVisible(true);
					buttonSubmit.setVisible(false);
					nameTF.setEnabled(false);
					phoneTF2.setEnabled(false);
				}
				catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,"Invalid Number!");
				}
			}
			/*
			 *--------------------------Employee profile update
			 */
			else if (employee!=null) {
				try {
					employee.updateEmployee(nameTF.getText().trim(), Integer.parseInt(phoneTF2.getText()), employee.getRole(), employee.getSalary());
					buttonEdit.setVisible(true);
					buttonSubmit.setVisible(false);
					nameTF.setEnabled(false);
					phoneTF2.setEnabled(false);
				}
				catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,"Invalid number!");
				}
			}
		}
		/*
		 *--------------------------Change password button event
		 */
		else if (ae.getSource().equals(buttonPass)) {
			new ChangePasswordActivity(this.usr).setVisible(true);
		}
		/*
		 *--------------------------Delete button event
		 */
		else if (ae.getSource().equals(buttonDelete)) {
			int input = JOptionPane.showConfirmDialog(null, "Sure to Delete?", "Delete "+customer.getUserId()+"?", JOptionPane.YES_NO_OPTION);
			if (input == 0) {
				customer.deleteCustomer();
				this.setVisible(false);
				new LoginActivity().setVisible(true);
			}
			else {}
		}
		else {}
	}
}