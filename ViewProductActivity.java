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
 *    Class to create and manage view product screen i.e search product and adding product
 *-------------------------------------------------------------------------------------------
 */
public class ViewProductActivity extends JFrame implements ActionListener {
	/*
	 *--------------------------Objects for visual components and other classes 
	 */
	private JPanel panel;
	private Customer customer;
	private JFrame activity;
	private Employee employee;
	private JScrollPane frame;
	JComboBox byWhatCB;
	JTable table;
	private JButton buttonLogout, buttonBack, buttonCheck, buttonAddProduct;
	private JLabel title, header, keywordLabel;
	JTextField keywordTF;
	/*
	 *--------------------------Constructor for Customer
	 */
	public ViewProductActivity(JFrame prev, Customer customer) {
		super("View Product");
		/*
		 *--------------------------Setting window 
		 */
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//passing arguments to current obj
		this.activity = prev;
		this.customer = customer;
		/*
		 *--------------------------setting panel 
		 */
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		/*
		 *--------------------------Setting title of window 
		 */
		title = new JLabel(" -> View Product");
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
		 *--------------------------Setting keyword label 
		 */
		keywordLabel = new JLabel("Keyword: ");
		keywordLabel.setBounds(60, 140, 140, 30);
		keywordLabel.setFont(Theme.FONT_REGULAR);
		panel.add(keywordLabel);
		/*
		 *--------------------------Setting keyword textfield 
		 */
		keywordTF = new JTextField();
		keywordTF.setBounds(160, 140, 240, 30);
		keywordTF.setFont(Theme.FONT_INPUT);
		panel.add(keywordTF);
		/*
		 *--------------------------Setting combobox for search by choice 
		 */
		byWhatCB = new JComboBox(new Object[]{"By ID", "By Name"});
		byWhatCB.setBounds(400, 140, 100,30);
		byWhatCB.setFont(Theme.FONT_INPUT);
		panel.add(byWhatCB);
		/*
		 *--------------------------Setting search button 
		 */
		buttonCheck = new JButton("Search");
		buttonCheck.setBounds(500, 140, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonCheck.setFont(Theme.FONT_BUTTON);
		buttonCheck.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonCheck.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonCheck.addActionListener(this);
		panel.add(buttonCheck);
		/*
		 *--------------------------Setting table layout 
		 */
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(Product.columnNames);
		table.setModel(model);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
               jTable_ClickMouseClicked(evt);
            }
		});
		/*
		 *--------------------------Setting scrollable panel 
		 */
		frame = new JScrollPane(table);
		frame.setBounds(40,185,600,300);
		panel.add(frame);
		/*
		 *--------------------------Adding search results to table model 
		 */
		table.setModel(Product.searchProduct("", "By Name"));
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
		 *--------------------------Adding panel to window 
		 */
		this.add(panel);
	}
	/*
	 *--------------------------Constructor for Employee 
	 */
	public ViewProductActivity(JFrame prev, Employee employee) {
		super("View Product");
		/*
		 *--------------------------Setting window to View Product Act 
		 */
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		this.employee = employee;
		/*
		 *--------------------------Setting panel 
		 */
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		/*
		 *--------------------------Setting title 
		 */
		title = new JLabel(" -> View Product");
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
		 *--------------------------Setting back button 
		 */
		buttonBack = new JButton("Back");
		buttonBack.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonBack.setFont(Theme.FONT_BUTTON);
		buttonBack.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonBack.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		/*
		 *--------------------------Setting Add button 
		 */
		buttonAddProduct = new JButton("Add");
		buttonAddProduct.setBounds(Theme.GUI_WIDTH-140, 115, Theme.BUTTON_PRIMARY_WIDTH, 30);
		buttonAddProduct.setFont(Theme.FONT_BUTTON);
		buttonAddProduct.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonAddProduct.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonAddProduct.addActionListener(this);
		panel.add(buttonAddProduct);
		/*
		 *--------------------------Setting Keyword label 
		 */
		keywordLabel = new JLabel("Keyword: ");
		keywordLabel.setBounds(60, 140, 140, 30);
		keywordLabel.setFont(Theme.FONT_REGULAR);
		panel.add(keywordLabel);
		/*
		 *--------------------------Setting Keyword textfield 
		 */
		keywordTF = new JTextField();
		keywordTF.setBounds(160, 140, 240, 30);
		keywordTF.setFont(Theme.FONT_INPUT);
		panel.add(keywordTF);
		/*
		 *--------------------------Setting combobox for search choice 
		 */
		byWhatCB = new JComboBox(new Object[]{"By ID", "By Name"});
		byWhatCB.setBounds(400, 140, 100,30);
		byWhatCB.setFont(Theme.FONT_INPUT);
		panel.add(byWhatCB);
		/*
		 *--------------------------Setting search button
		 */
		buttonCheck = new JButton("Search");
		buttonCheck.setBounds(500, 140, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonCheck.setFont(Theme.FONT_BUTTON);
		buttonCheck.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonCheck.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonCheck.addActionListener(this);
		panel.add(buttonCheck);
		/*
		 *--------------------------creating table model for viewing products 
		 */
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(Product.columnNames);
		table.setModel(model);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
               jTable_ClickMouseClicked(evt);
            }
		});
		/*
		 *--------------------------setting scrollable panel 
		 */
		frame = new JScrollPane(table);
		frame.setBounds(40,185,600,300);
		panel.add(frame);
		/*
		 *--------------------------Adding search data in table 
		 */
		table.setModel(Product.searchProduct("", "By Name"));
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
	 *--------------------------Sorting action performed 
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
		else if (ae.getSource().equals(buttonCheck)) {
			table.setModel(Product.searchProduct(keywordTF.getText().trim(), byWhatCB.getSelectedItem().toString()));
		}//search button event
		else if (ae.getSource().equals(buttonAddProduct)) {
			this.setVisible(false);
			new AddProductActivity(this, employee).setVisible(true);
		}//add button event
		else {}
	}
	//clicking on table events
	private void jTable_ClickMouseClicked(MouseEvent evt) {                                          
       int index = table.getSelectedRow();
       //geting table model
       TableModel model = table.getModel();
       //row as string
       String value1 = model.getValueAt(index, 0).toString();
       //open manage product window
		if (customer!=null) {}
		else if (employee!=null)
			new ManageProduct(value1, this).setVisible(true);
		else {}
    }
}