package activity;



import java.lang.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import attr.*;

/*-------------------------------------------------------------------------------------------
 *   Class for adding Employee screen that enables user to add Employee in database
 *-------------------------------------------------------------------------------------------
 */

public class AddEmployeeActivity extends JFrame implements ActionListener {
	 /*
	 *---------------------------- Creating the Required data Fields for the Panel
	 */
	private JPanel panel;  
	private ViewEmployeeActivity activity;  
	private JButton buttonLogout, buttonBack, buttonAdd, buttonEdit, buttonDelete, buttonRandom; 
	private JLabel title, header, employeeIdLabel, employeeNameLabel, roleLabel, employeePhoneLabel, salaryLabel;
	private JComboBox roleCB;																	
	private JTextField employeeIdTF, employeeNameTF, salaryTF, employeePhoneTF1, employeePhoneTF2, passwordTF;
	private Random r,a;
		/*
		 * ----------------------------Constructor 
		 */
		public AddEmployeeActivity(ViewEmployeeActivity prev, Employee employee) {
	
		super("Add Employee");
		/*
		 *----------------------------Setting Window
		 */
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		r = new Random();
		
		/*
		 *----------------------------Setting Panel
		 */
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		/*
		 *----------------------------Setting Title in Window.
		 */
		title = new JLabel(" -> Add Employee");
		title.setBounds(0, 40, 440,75);
		title.setOpaque(true);
		title.setBackground(Theme.BACKGROUND_PANEL);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		 Timer t = new Timer(180, this); // set a timer
	      t.start();
		/*
		 *----------------------------Setting  the Logout Button
		 */
		
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonLogout.setFont(Theme.FONT_BUTTON);
		buttonLogout.setBackground(Color.WHITE);
		buttonLogout.setForeground(Theme.COLOR_TITLE);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);  //-----Placing the Logout button on the Panel. 
		
		/*
		 *----------------------------Setting the Back Button 
		 */
		
		buttonBack = new JButton("Back");
		buttonBack.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonBack.setFont(Theme.FONT_BUTTON);
		buttonBack.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonBack.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);//-----------Placing the Back Button 
		/*
		 * ----------------------------Setting employeeIdlabel for ID
		 */
		
		employeeIdLabel = new JLabel("Employee ID: ");
		employeeIdLabel.setBounds(60, 140, 140, 30);
		employeeIdLabel.setFont(Theme.FONT_REGULAR);
		panel.add(employeeIdLabel); //--------Placing employeeIdLabel
		
		/*
		 *----------------------------Setting employeeIdLabel for the Employee Password
		 */
		employeeIdLabel = new JLabel("Password: ");
		employeeIdLabel.setBounds(60, 190, 140, 30);
		employeeIdLabel.setFont(Theme.FONT_REGULAR);
		panel.add(employeeIdLabel);//--------Adding to the Panel

		/*
		 *----------------------------Setting employeeIdLabel for the Employee Name
		 */
		employeeNameLabel = new JLabel("Name: ");
		employeeNameLabel.setBounds(60, 240, 140, 30);
		employeeNameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(employeeNameLabel); //---------Adding to the Panel
		
		/*
		 * ----------------------------Setting EmployeeePhoneLabel for Employee Phone Number 
		 */
		employeePhoneLabel = new JLabel("Phone No: ");
		employeePhoneLabel.setBounds(60, 290, 140, 30);
		employeePhoneLabel.setFont(Theme.FONT_REGULAR);
		panel.add(employeePhoneLabel);
		
		
		/*
		 *----------------------------Setting the label for the Role of the Employee
		 */
		roleLabel = new JLabel("Role: ");
		roleLabel.setBounds(60, 340, 340, 30);
		roleLabel.setFont(Theme.FONT_REGULAR);
		panel.add(roleLabel);//---------------Adding to the Panel
		
		/*
		 *----------------------------Setting the Label for Employee Salary
		 */		
		salaryLabel = new JLabel("Salary: ");
		salaryLabel.setBounds(60, 390, 140, 30);
		salaryLabel.setFont(Theme.FONT_REGULAR);
		panel.add(salaryLabel);//Adding to the Panel
		
		
		
						//////////////Setting Text Fields for the  Labels///////
		
		
		/*
		 *----------------------------Setting the Text field for employee ID
		 */
		employeeIdTF = new JTextField();
		employeeIdTF.setBounds(180, 140, 220, 30);
		employeeIdTF.setFont(Theme.FONT_INPUT);
		panel.add(employeeIdTF);//--------------Adding to the Panel
		
		
		/*
		 *----------------------------Setting a Random password for the Employee
		 */
		passwordTF = new JTextField(""+(r.nextInt(8999)+1000));
		passwordTF.setBounds(180, 190, 220, 30);
		passwordTF.setFont(Theme.FONT_INPUT);
		passwordTF.setEnabled(true);
		passwordTF.setDisabledTextColor(Color.BLACK);
		panel.add(passwordTF);//---------------------Adding to the Panel...
		
		
		/*
		 *----------------------------Setting the Button to generate the random password again and again for the ease to remember 
		 */
		buttonRandom = new JButton("Generate");
		buttonRandom.setBounds(400, 190, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonRandom.setFont(Theme.FONT_BUTTON);
		buttonRandom.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonRandom.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonRandom.addActionListener(this);
		panel.add(buttonRandom); //-----------------Adding the Generate Button to the Panel
		
		
		/*
		 *----------------------------Setting the text field for the employee Name
		 */
		employeeNameTF = new JTextField();
		employeeNameTF.setBounds(180, 240, 220, 30); 
		employeeNameTF.setFont(Theme.FONT_INPUT);
		panel.add(employeeNameTF);//----------------------------Adding it to the Panel
		
		
		/*
		 *---------------------------- Setting text field for the employee phone number(Text field for Country code for International User)
		 */
		employeePhoneTF1 = new JTextField("+92");
		employeePhoneTF1.setBounds(180, 290, 40, 30);
		employeePhoneTF1.setEnabled(false);
		employeePhoneTF1.setFont(Theme.FONT_INPUT);
		panel.add(employeePhoneTF1);//---------------Adding to the Panel
	
		/*
		 *----------------------------Setting the Remaining text field for the Phone number of the employee
		 */
		employeePhoneTF2 = new JTextField();
		employeePhoneTF2.setBounds(220, 290, 180, 30);
		employeePhoneTF2.setFont(Theme.FONT_INPUT);
		panel.add(employeePhoneTF2);//----------Adding to the Panel
		
		/*
		 *----------------------------Setting ComboBox for role of the Employee
		 */
		roleCB = new JComboBox(Employee.roles);
		roleCB.setBounds(180, 340, 160, 30);
		roleCB.setFont(Theme.FONT_INPUT);
		panel.add(roleCB);//-----------Adding to the Panel
		
		/*
		 *----------------------------Setting TextFiled for the Salary of the Employee
		 */
		salaryTF = new JTextField();
		salaryTF.setBounds(180, 390, 220, 30);
		salaryTF.setFont(Theme.FONT_INPUT);
		panel.add(salaryTF);//------------Adding to the Panel
		/*
		 *----------------------------Setting the Add button to Add the Employee 
		 */
		buttonAdd = new JButton("Add");
		buttonAdd.setBounds(60, 440, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonAdd.setFont(Theme.FONT_BUTTON);
		buttonAdd.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonAdd.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonAdd.addActionListener(this);
		panel.add(buttonAdd);
		
		/*
		 *----------------------------Setting header in window  
		 */
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header); //----------------------------Adding Header to the panel
		/*
		 *----------------------------Setting footer in window  
		 */
		JLabel footer = new JLabel();
		footer.setBackground(Theme.BACKGROUND_HEADER);
		footer.setOpaque(true);
		footer.setBounds(0, 540, Theme.GUI_WIDTH, 25);
		panel.add(footer);
		/*
		 *----------------------------Setting footer in window  
		 */
		this.add(panel);
	}
	/*
	 *----------------------------Setting the Action Performed by the Buttons i.e.,logout button ,back button and add button
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
		/*
		 *----------------------------Setting information of the employee upon selecting add button 
		 */
		else if (ae.getSource().equals(buttonAdd)) {
			try {
				Employee e = new Employee(employeeIdTF.getText().trim());// Setting employee ID
				
				e.setPassword(passwordTF.getText().trim());// Setting employee Password
				
				e.setEmployeeName(employeeNameTF.getText().trim());// Setting employee Phone Number
				
				e.setPhoneNumber(Integer.parseInt(employeePhoneTF2.getText()));// Setting employee Phone Number
				
				e.setSalary(Double.parseDouble(salaryTF.getText()));// Setting employee Salary
				
				e.setRole(roleCB.getSelectedItem().toString());// Setting employee Role
				
				
				//----------------------------Set all the information by calling the setter method for all data fields
				
				e.createEmployee();
				employeeIdTF.setText("");
				employeeNameTF.setText("");
				employeePhoneTF2.setText("");
				salaryTF.setText("");
				roleCB.setSelectedIndex(0);
				
				if (!activity.keywordTF.getText().trim().isEmpty())
					activity.table.setModel(Employee.searchEmployee(activity.keywordTF.getText().trim(), activity.byWhatCB.getSelectedItem().toString()));
				else
					activity.table.setModel(Employee.searchEmployee("", "By Name"));
				
				}
			catch (NumberFormatException e) {
				//Exceptional handling when employee add wrong information (Phone Number)
				JOptionPane.showMessageDialog(this,"Enter phone no correctly!"); 
			}
			catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(this,e.getMessage()); 
			}
		}
		else if (ae.getSource().equals(buttonRandom)) {
			passwordTF.setText(""+(r.nextInt(8999)+1000));
		}
		else {}
	}
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////