package activity;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import attr.*;
/*-------------------------------------------------------------------------------------------
 *  Class to create and handle Manage customer screen
 *-------------------------------------------------------------------------------------------
 */
public class ManageCustomer extends JFrame implements ActionListener {
	/*
	 *--------------------------objects for visual components and other classes
	 */
	private JPanel panel;
	ViewCustomerActivity prev;
	private Customer customer;
	private JButton buttonBack, buttonSave, buttonDelete;
	private JLabel title, header, userIdLabel, customerNameLabel, phoneNumberLabel, addressLabel;
	private JTextField userIdTF, customerNameTF, phoneNumberTF, phoneCodeTF, addressTF;
	/*
	 *--------------------------Constructor
	 */
	public ManageCustomer(String cid, ViewCustomerActivity prev) {
		super("Manage Customer");
		/*
		 *--------------------------Setting Window for managing customer 
		 */
		this.setSize(500,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.prev = prev;
		/*
		 *--------------------------getting product by ID 
		 */
		customer = new Customer(cid);
		customer.fetch();
		/*
		 *--------------------------setting panel 
		 */
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		/*
		 *--------------------------setting  ID label 
		 */
		
		userIdLabel = new JLabel("Customer ID: "+customer.getUserId());
		userIdLabel.setBounds(60, 20, 140, 30);
		userIdLabel.setFont(Theme.FONT_INPUT);
		panel.add(userIdLabel);
		/*
		 *--------------------------Setting name label 
		 */
		customerNameLabel = new JLabel("Name: ");
		customerNameLabel.setBounds(60, 60, 140, 30);
		customerNameLabel.setFont(Theme.FONT_INPUT);
		panel.add(customerNameLabel);
		/*
		 *--------------------------Setting phone label 
		 */
		phoneNumberLabel = new JLabel("Phone: ");
		phoneNumberLabel.setBounds(60, 100, 140, 30);
		phoneNumberLabel.setFont(Theme.FONT_INPUT);
		panel.add(phoneNumberLabel);
		/*
		 *--------------------------Setting adress label 
		 */
		addressLabel = new JLabel("Address: ");
		addressLabel.setBounds(60, 140, 140, 30);
		addressLabel.setFont(Theme.FONT_INPUT);
		panel.add(addressLabel);
		/*
		 *--------------------------Setting text field for customer name   
		 */
		customerNameTF = new JTextField(customer.getCustomerName());
		customerNameTF.setBounds(160, 60, 220, 30);
		customerNameTF.setFont(Theme.FONT_INPUT);
		panel.add(customerNameTF);
		/*
		 *--------------------------Setting text field for customer country code   
		 */
		phoneCodeTF = new JTextField("+92");
		phoneCodeTF.setEnabled(false);
		phoneCodeTF.setBounds(160, 100, 40, 30);
		phoneCodeTF.setFont(Theme.FONT_INPUT);
		panel.add(phoneCodeTF);
		
		/*
		 *--------------------------Setting text field for getting phone   
		 */
		phoneNumberTF = new JTextField(customer.getPhoneNumber().substring(3)+"");
		phoneNumberTF.setBounds(200, 100, 180, 30);
		phoneNumberTF.setFont(Theme.FONT_INPUT);
		panel.add(phoneNumberTF);
		/*
		 *--------------------------Setting text field for customer adress   
		 */
		addressTF = new JTextField(customer.getAddress()+"");
		addressTF.setBounds(160, 140, 220, 30);
		addressTF.setFont(Theme.FONT_INPUT);
		panel.add(addressTF);
		/*
		 *--------------------------setting edit button 
		 */
		buttonSave = new JButton("Save");
		buttonSave.setBounds(60, 180, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonSave.setFont(Theme.FONT_BUTTON);
		buttonSave.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonSave.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonSave.addActionListener(this);
		panel.add(buttonSave);
		/*
		 *--------------------------setting delete button 
		 */
		buttonDelete = new JButton("Delete");
		buttonDelete.setBounds(180, 180, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonDelete.setFont(Theme.FONT_BUTTON);
		buttonDelete.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonDelete.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonDelete.addActionListener(this);
		panel.add(buttonDelete);
		/*
		 *----------------------------Setting footer in window  
		 */
		JLabel footer = new JLabel();
		footer.setBackground(Theme.BACKGROUND_HEADER);
		footer.setOpaque(true);
		footer.setBounds(0, 345, 500, 25);
		panel.add(footer);
		/*
		 *--------------------------Adding panel to window 
		 */
		this.add(panel);
	}
	/*
	 *--------------------------sorting actions performed 
	 */

	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonSave)) {// edit button event
			try {
				customer.updateCustomer(customerNameTF.getText(),Integer.parseInt(phoneNumberTF.getText()),addressTF.getText().trim());
				if (!prev.keywordTF.getText().trim().isEmpty())
					prev.table.setModel(Customer.searchCustomer(prev.keywordTF.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
				else
					prev.table.setModel(Customer.searchCustomer("", "By Name")); // search by name
				this.setVisible(false);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Invalid Input!"); // showing invalid input
			}
		}
		else if (ae.getSource().equals(buttonDelete)) { //button delete event
			customer.deleteCustomer();
			if (!prev.keywordTF.getText().trim().isEmpty())
				prev.table.setModel(Customer.searchCustomer(prev.keywordTF.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
			else
				prev.table.setModel(Customer.searchCustomer("", "By Name"));
			this.setVisible(false);
		}
		else {}
	}
}