package activity;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.event.*;
import attr.*;
/*-------------------------------------------------------------------------------------------
 *    Class to create and manage view customer activity  screen
 *-------------------------------------------------------------------------------------------
 */
public class ViewCustomerActivity extends JFrame implements ActionListener {
	/*
	 *--------------------------Objects for visual components and other classes 
	 */
	private JPanel panel;
	private JFrame activity;
	private Employee employee;
	private JScrollPane frame;
	JComboBox byWhatCB;
	JTable table;
	private JButton buttonLogout, buttonBack, buttonCheck;
	private JLabel title, header, keywordLabel;
	JTextField keywordTF;
	/*
	 *--------------------------Constructor for Customer
	 */

	public ViewCustomerActivity(JFrame prev, Employee employee) {
		super("View Customer");
		/*
		 *--------------------------Setting window 
		 */
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		/*
		 *--------------------------Setting panel 
		 */
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		/*
		 *--------------------------Setting title 
		 */
		title = new JLabel(" -> View Customer");
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
		 *--------------------------setting logout button 
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
		 *--------------------------Setting keyword text field 
		 */
		keywordTF = new JTextField();
		keywordTF.setBounds(160, 140, 240, 30);
		keywordTF.setFont(Theme.FONT_INPUT);
		panel.add(keywordTF);
		/*
		 *--------------------------Setting combo box for search by choice 
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
		model.setColumnIdentifiers(Customer.columnName);
		table.setModel(model);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
               jTable_ClickMouseClicked(evt);
            }
		});
		/*
		 *--------------------------Setting scroll able panel 
		 */
		frame = new JScrollPane(table);
		frame.setBounds(40,185,600,300);
		panel.add(frame);
		
		table.setModel(Customer.searchCustomer("", "By Name"));
		// setting header
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

		if (ae.getSource().equals(buttonLogout)) {// logout button event
			this.setVisible(false);
			new LoginActivity().setVisible(true);
		}
		else if (ae.getSource().equals(buttonBack)) {
			//back button event
			this.setVisible(false);
			activity.setVisible(true);
		}
		else if (ae.getSource().equals(buttonCheck)) {// button check event
			table.setModel(Customer.searchCustomer(keywordTF.getText().trim(), byWhatCB.getSelectedItem().toString()));
		}
		else {}
	}
	//clicking on table events
	private void jTable_ClickMouseClicked(MouseEvent evt) {                                          
       int index = table.getSelectedRow();
     //getting table model
       TableModel model = table.getModel();
     //row as string

       String value1 = model.getValueAt(index, 0).toString();
     //open manage customer window
	   new ManageCustomer(value1, this).setVisible(true);
    }
}