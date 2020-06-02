package activity;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import attr.*;
/*-------------------------------------------------------------------------------------------
 *  Class to Manage Employee screen i.e adding, updating & deleting Employee Information
 *-------------------------------------------------------------------------------------------
 */
public class ManageEmployee extends JFrame implements ActionListener {

	private JPanel panel;
	ViewEmployeeActivity prev;
	private Employee employee;//Employee Class Object 
	/* 
	 *------------------------ Setting JButton , JLabel , JTextField and JComboBox
	 */
	private JButton buttonBack, buttonSave, buttonDelete;
	private JLabel title, header, userIdLabel, employeeNameLabel, phoneNumberLabel, roleLabel, salaryLabel;
	private JTextField userIdTF, employeeNameTF, phoneNumberTF, phoneCodeTF, salaryTF;
	private JComboBox roleCB;
	/* 
	 * ------------------------Constructor 
	 */
	
	public ManageEmployee(String eid, ViewEmployeeActivity prev) {
		super("Manage Employee");
		/*
		 * ------------------------Setting Window for managing employee 
		 */
		
		this.setSize(500,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.prev = prev;
		/*
		 *------------------------Getting employee by ID
		 */
		employee = new Employee(eid);
		employee.fetch();
		/*
		 *------------------------Setting panel 
		 */
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		/*
		 * ------------------------Setting employee ID Label
		 */
		userIdLabel = new JLabel("Employee ID: "+employee.getUserId());
		userIdLabel.setBounds(60, 20, 140, 30);
		userIdLabel.setFont(Theme.FONT_INPUT);
		panel.add(userIdLabel);//add ID label
		/* 
		 * ------------------------Setting Employee Name label  
		 */
		employeeNameLabel = new JLabel("Name: ");
		employeeNameLabel.setBounds(60, 60, 140, 30);
		employeeNameLabel.setFont(Theme.FONT_INPUT);
		panel.add(employeeNameLabel);//Adding Name Label
		/*
		 * ------------------------Setting Phone number Label
		 */
		phoneNumberLabel = new JLabel("Phone: ");
		phoneNumberLabel.setBounds(60, 100, 140, 30);
		phoneNumberLabel.setFont(Theme.FONT_INPUT);
		panel.add(phoneNumberLabel); //Adding phone number label
		/*
		 * ------------------------Setting Role Label 
		 */
		roleLabel = new JLabel("Role: ");
		roleLabel.setBounds(60, 140, 140, 30);
		roleLabel.setFont(Theme.FONT_INPUT);
		panel.add(roleLabel);//Adding role Label
		/* 
		 * ------------------------Setting Salary Label  
		 */
		salaryLabel = new JLabel("Salary: ");
		salaryLabel.setBounds(60, 180, 140, 30);
		salaryLabel.setFont(Theme.FONT_INPUT);
		panel.add(salaryLabel);//Adding salary label 
		/*
		 * ------------------------Setting EmployeeName text field 
		 */
		employeeNameTF = new JTextField(employee.getEmployeeName());
		employeeNameTF.setBounds(160, 60, 220, 30);
		employeeNameTF.setFont(Theme.FONT_INPUT);
		panel.add(employeeNameTF);//Adding the text field
		/*
		 * ------------------------Setting Phone Number Text Field 1
		 */
		phoneCodeTF = new JTextField("+92");
		phoneCodeTF.setEnabled(false);
		phoneCodeTF.setBounds(160, 100, 40, 30);
		phoneCodeTF.setFont(Theme.FONT_INPUT);
		panel.add(phoneCodeTF);//Adding text field
		/*
		 * ------------------------Setting Phone number text field 2
		 */
		phoneNumberTF = new JTextField(employee.getPhoneNumber().substring(3)+"");
		phoneNumberTF.setBounds(200, 100, 180, 30);
		phoneNumberTF.setFont(Theme.FONT_INPUT);
		panel.add(phoneNumberTF);//Adding text Field
		/*
		 * ------------------------Setting Role ComboBox  
		 */
		roleCB = new JComboBox(Employee.roles);
		roleCB.setBounds(160, 140, 160, 30);
		roleCB.setSelectedIndex(employee.getRole().equals("Manager") ? 1 : 0);
		roleCB.setFont(Theme.FONT_INPUT);
		panel.add(roleCB);//Adding ComboBox
		/*
		 * ------------------------Setting salary Text Field
		 */
		salaryTF = new JTextField(employee.getSalary()+"");
		salaryTF.setBounds(160, 180, 220, 30);
		salaryTF.setFont(Theme.FONT_INPUT);
		panel.add(salaryTF);//adding text field
		/*
		 * ------------------------Setting Edit Button  
		 */
		buttonSave = new JButton("Save");
		buttonSave.setBounds(60, 220, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonSave.setFont(Theme.FONT_BUTTON);
		buttonSave.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonSave.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonSave.addActionListener(this);
		panel.add(buttonSave);//Adding edit button 
		/*
		 * ------------------------Setting Delete Button 
		 */
		buttonDelete = new JButton("Delete");
		buttonDelete.setBounds(180, 220, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonDelete.setFont(Theme.FONT_BUTTON);
		buttonDelete.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonDelete.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonDelete.addActionListener(this);
		panel.add(buttonDelete);//Adding delete button 
		/*
		 *----------------------------Setting footer in window  
		 */
		JLabel footer = new JLabel();
		footer.setBackground(Theme.BACKGROUND_HEADER);
		footer.setOpaque(true);
		footer.setBounds(0, 345, 500, 25);
		panel.add(footer);
		/*
		 * ------------------------Adding Panel to Window 
		 */
		this.add(panel);
	}
	/* 
	 * ------------------------Setting Action performed 
	 */
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonSave)) {
			try {//edit button event
			employee.updateEmployee(employeeNameTF.getText(),Integer.parseInt(phoneNumberTF.getText()),roleCB.getSelectedItem().toString(), Double.parseDouble(salaryTF.getText())); //Show updated  status 
				if (!prev.keywordTF.getText().trim().isEmpty())
			prev.table.setModel(Employee.searchEmployee(prev.keywordTF.getText().trim(), prev.byWhatCB.getSelectedItem().toString())); //Show edited information in the table 
				else//Default Search by name  
					prev.table.setModel(Employee.searchEmployee("", "By Name"));
				this.setVisible(false);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Invalid Input!"); 
			}
		}
		/*
		 * Delete Button Event 
		 */
		else if (ae.getSource().equals(buttonDelete)) {
			employee.deleteEmployee();
			if (!prev.keywordTF.getText().trim().isEmpty())
				prev.table.setModel(Employee.searchEmployee(prev.keywordTF.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));//Show edited information in the table 
		else//default search by name 
				prev.table.setModel(Employee.searchEmployee("", "By Name"));
			this.setVisible(false);
		}
		else {}
	}
	
	
}

////////////////////////////////////////////////////////////////////////////////////////