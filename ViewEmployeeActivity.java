package activity;

import java.lang.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import attr.*;

/*-------------------------------------------------------------------------------------------
 *    Class to create and manage view Employee screen i.e search Employee and adding Employee
 *-------------------------------------------------------------------------------------------
 */
public class ViewEmployeeActivity extends JFrame implements ActionListener {
	/*
	 * ----------------------ViewEmployeeActivity Attributes
	 */
	
	private JPanel panel;
	private JFrame activity;
	private Employee employee;   //Object of Employee Class
	private JScrollPane frame;  //Creating jScrollpane
	JComboBox byWhatCB;        //Creating jComboBx
	JTable table;
	/*
	 * ----------------------------------Setting Buttons,Labels and text fields
	 */
	private JButton buttonLogout, buttonBack, buttonCheck, buttonAddEmployee;
	private JLabel title, header, keywordLabel;
	JTextField keywordTF;
	/*
	 * ----------------------------------Constructor for Employee
	 */
	public ViewEmployeeActivity(JFrame prev, Employee employee) {
		
		super("View Employee");
		/*
		 * ----------------------------------Setting Window
		 */
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		/*
		 * ----------------------------------Setting Panel
		 */
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		/*
		 * ----------------------------------Setting Window title
		 */
		title = new JLabel(" -> View Employee");
		title.setBounds(0, 40, 450,75);
		title.setOpaque(true);
		title.setBackground(Theme.BACKGROUND_PANEL);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		 Timer t = new Timer(180, this); // set a timer
	      t.start();
		/*
		 * ----------------------------------Setting Logout Button 
		 */
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonLogout.setFont(Theme.FONT_BUTTON);
		buttonLogout.setBackground(Color.WHITE);
		buttonLogout.setForeground(Theme.COLOR_TITLE);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);//Adding Button 
		
		/*
		 * ----------------------------------Setting Back button 
		 */
		buttonBack = new JButton("Back");
		buttonBack.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonBack.setFont(Theme.FONT_BUTTON);
		buttonBack.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonBack.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);//Adding back button 
		/*
		 * ----------------------------------Setting Add Button  
		 */
		buttonAddEmployee = new JButton("Add");
		buttonAddEmployee.setBounds(Theme.GUI_WIDTH-140, 115, Theme.BUTTON_PRIMARY_WIDTH, 30);
		buttonAddEmployee.setFont(Theme.FONT_BUTTON);
		buttonAddEmployee.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonAddEmployee.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonAddEmployee.addActionListener(this);
		panel.add(buttonAddEmployee); //Adding add button 
		/*
		 * ----------------------------------Setting Keyword Label
		 */
		keywordLabel = new JLabel("Keyword: ");
		keywordLabel.setBounds(60, 140, 140, 30);
		keywordLabel.setFont(Theme.FONT_REGULAR);
		panel.add(keywordLabel);//Adding keyword
		/*
		 * ----------------------------Setting Keyword Text Field
		 */
		keywordTF = new JTextField();
		keywordTF.setBounds(160, 140, 240, 30);
		keywordTF.setFont(Theme.FONT_INPUT);
		panel.add(keywordTF);//Adding keyword
		/*
		 * ----------------------------------Setting Combo Box for search by choice
		 */
		byWhatCB = new JComboBox(new Object[]{"By ID", "By Name"});
		byWhatCB.setBounds(400, 140, 100,30);
		byWhatCB.setFont(Theme.FONT_INPUT);
		panel.add(byWhatCB);//Adding combo Box
		/*
		 * ----------------------------------Setting Search Button 
		 */
		buttonCheck = new JButton("Search");
		buttonCheck.setBounds(500, 140, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonCheck.setFont(Theme.FONT_BUTTON);
		buttonCheck.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonCheck.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonCheck.addActionListener(this);
		panel.add(buttonCheck);
		/*
		 * ----------------------------------Setting Table layout
		 */
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(Employee.columnNames);
		table.setModel(model);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
               jTable_ClickMouseClicked(evt);
            }
		});
		/*
		 * ----------------------------------Setting Scroll Label Pane
		 */
		frame = new JScrollPane(table);
		frame.setBounds(40,185,600,300);
		panel.add(frame);
		/*
		 * ----------------------------------Adding search result to table mode 
		 */
		table.setModel(Employee.searchEmployee("", "By Name"));
		/*
		 * ----------------------------------Setting header to Pane 
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
		 * ----------------------------------Adding pane to window
		 */
		this.add(panel);
	}
	/*
	 * ----------------------------------Setting Action Event upon selecting the specific button 
	 */
	public void actionPerformed(ActionEvent ae) {
		  String oldText = title.getText();
	      String newText= oldText.substring(1)+ oldText.substring(0,1);
	      title.setText(newText);
		if (ae.getSource().equals(buttonLogout)) {
			this.setVisible(false);//Set logout Button Event 
			new LoginActivity().setVisible(true);
		}
		else if (ae.getSource().equals(buttonBack)) {
			this.setVisible(false);//set back button Event 
			activity.setVisible(true);
		}
		else if (ae.getSource().equals(buttonAddEmployee)) {
			this.setVisible(false);//Set add Employee Button Event 
			new AddEmployeeActivity(this, employee).setVisible(true);
		}
		else if (ae.getSource().equals(buttonCheck)) {
			table.setModel(Employee.searchEmployee(keywordTF.getText().trim(), byWhatCB.getSelectedItem().toString()));
		//Setting table	
		
		}
		else {}
	}
	
	/*
	 *  ----------------------------------Setting Mouse Event 
	 */
	private void jTable_ClickMouseClicked(MouseEvent evt) {                                          
       int index = table.getSelectedRow();//it will give the row selected from the table 

      TableModel model = table.getModel();

       String value1 = model.getValueAt(index, 0).toString();
	   new ManageEmployee(value1, this).setVisible(true);
    }
}
////////////////////////////////////////////////////////////////////////////////