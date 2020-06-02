package activity;

import java.lang.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.table.*;
import attr.*;
/*-------------------------------------------------------------------------------------------
 *                      Class to handle current product screen
 *-------------------------------------------------------------------------------------------
 */
public class MyProductActivity extends JFrame implements ActionListener {
	/*
	 *--------------------------Objects for Visual components and other classes
	 */
	private JPanel panel;
	private Customer customer;
	private JFrame activity;
	private JScrollPane frame;
	private JTable table;
	private JButton buttonLogout, buttonBack, buttonCheck;
	private JLabel title, header, keywordLabel, productNameLabel, productQtLabel, productPriceLabel;
	private JTextField keywordTF, productNameTF, productQtTF, productPriceTF;
	/*
	 *--------------------------Constructor 
	 */
	public MyProductActivity(JFrame prev, Customer customer) {
		super("Purchase History");
		/*
		 *--------------------------Setting up window for product 
		 */
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		this.customer = customer;
		/*
		 *--------------------------setting panel 
		 */
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		/*
		 *--------------------------Setting title to panel 
		 */
		title = new JLabel(" -> Purchase History");
		title.setBounds(0, 40, 580,75);
		title.setOpaque(true);
		title.setBackground(Theme.BACKGROUND_PANEL);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		 Timer t = new Timer(200, this); // set a timer
	      t.start();
		/*
		 *--------------------------Setting logout button 
		 */
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonLogout.setFont(Theme.FONT_BUTTON);
		buttonLogout.setBackground(Color.WHITE);
		buttonLogout.setForeground(Theme.COLOR_TITLE);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);
		/*
		 *--------------------------setting back button 
		 */
		buttonBack = new JButton("Back");
		buttonBack.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonBack.setFont(Theme.FONT_BUTTON);
		buttonBack.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonBack.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		/*
		 *--------------------------Creating table model 
		 */
		table = new JTable();
		table.setModel(customer.myProduct());
		/*
		 *--------------------------Setting scrollable frame 
		 */
		frame = new JScrollPane(table);
		frame.setBounds(40,140,600,300);
		panel.add(frame);
		/*
		 *--------------------------Setting header to panel 
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
		 *--------------------------Add panel to window 
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
		if (ae.getSource().equals(buttonLogout)) {
			this.setVisible(false);
			new LoginActivity().setVisible(true);
		}//logout button event
		else if (ae.getSource().equals(buttonBack)) {
			this.setVisible(false);
			activity.setVisible(true);
		}//back button event
		else {}
	}
	/*
	 *--------------------------Click on table event handle 
	 */
	private void jTable_ClickMouseClicked(MouseEvent evt) {                                          
       
    }
}