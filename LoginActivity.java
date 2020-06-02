package activity;

import java.lang.*;
import javax.swing.Timer;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import attr.*;
/*-------------------------------------------------------------------------------------------
 *              Class to manage logins screen by users and employees
 *-------------------------------------------------------------------------------------------
 */
public class LoginActivity extends JFrame implements ActionListener {
	/*
	 *--------------------------Login activity attributes 
	 */
	private JPanel panel;
	private JButton buttonExit, buttonLogin, buttonSignup;
	private JLabel title, header,footer, usernameLabel, passwordLabel;
	private JTextField usernameTF;
	private JPasswordField passwordF;
	/*
	 *--------------------------Constructor 
	 */
	public LoginActivity() {
		super("Login");
		/*
		 *--------------------------Setting Window 
		 */
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		/*
		 *--------------------------Setting Panel 
		 */
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		/*
		 *--------------------------Setting Title in window 
		 */
		title = new JLabel(" -> VULCAN GENERAL");
		title.setBounds(0, 40, 465, 75);
		title.setBackground(Theme.BACKGROUND_PANEL);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		 Timer t = new Timer(200, this); // set a timer
	      t.start();
	      
		/*
		 *--------------------------Placing Exit BUtton 
		 */
		buttonExit = new JButton("Exit");
		buttonExit.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonExit.setFont(Theme.FONT_BUTTON);
		buttonExit.setBackground(Color.WHITE);
		buttonExit.setForeground(Theme.BACKGROUND_HEADER);
		buttonExit.addActionListener(this);
		panel.add(buttonExit);
		/*
		 *--------------------------Setting Signup button 
		 */
		buttonSignup = new JButton("Sign up");
		buttonSignup.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonSignup.setFont(Theme.FONT_BUTTON);
		buttonSignup.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonSignup.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonSignup.addActionListener(this);
		panel.add(buttonSignup);
		/*
		 *--------------------------Setting user name label 
		 */
		usernameLabel = new JLabel("User ID: ");
		usernameLabel.setBounds(210, 220, 120, 30);
		usernameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(usernameLabel);
		/*
		 *--------------------------Text field for userID 
		 */
		usernameTF = new JTextField();
		usernameTF.setBounds(330, 220, 220, 30);
		usernameTF.setFont(Theme.FONT_INPUT);
		panel.add(usernameTF);
		/*
		 *--------------------------Label for password 
		 */
		passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(210, 280, 120, 30);
		passwordLabel.setFont(Theme.FONT_REGULAR);
		panel.add(passwordLabel);
		/*
		 *--------------------------PasswordField for password 
		 */
		passwordF = new JPasswordField();
		passwordF.setBounds(330, 280, 220, 30);
		passwordF.setFont(Theme.FONT_INPUT);
		panel.add(passwordF);
		/*
		 *--------------------------Setting login Button 
		 */
		buttonLogin = new JButton("Login");
		buttonLogin.setBounds(230, 345, 300, 30);
		buttonLogin.setFont(Theme.FONT_BUTTON);
		buttonLogin.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonLogin.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonLogin.addActionListener(this);
		panel.add(buttonLogin);
		/*
		 *--------------------------Setting header in window  
		 */
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		
		/*
		 *----------------------------Setting footer in window  
		 */
		footer = new JLabel();
		footer.setBackground(Theme.BACKGROUND_HEADER);
		footer.setOpaque(true);
		footer.setBounds(0, 540, Theme.GUI_WIDTH, 25);
		panel.add(footer);
		
		/*
		 *--------------------------Adding Panel to Window 
		 */
		this.add(panel);
	}
	/*
	 *--------------------------Managing actions by user 
	 */
	public void actionPerformed(ActionEvent ae) {
			  String oldText = title.getText();
		      String newText= oldText.substring(1)+ oldText.substring(0,1);
		      title.setText(newText);
		     
		if (ae.getSource().equals(buttonExit))
			System.exit(0);//Exit button event
		else if (ae.getSource().equals(buttonSignup)) {
			this.setVisible(false);//Sign up button event
			new SignupActivity().setVisible(true);
		}
		else if (ae.getSource().equals(buttonLogin)) {
			//Checking login credentials
			int status = User.checkStatus(usernameTF.getText(), passwordF.getText());
			if (status == 0) {
				EmployeeActivity ea = new EmployeeActivity(usernameTF.getText());
				ea.setVisible(true);
				this.setVisible(false);
			}//Employee credentials detected
			else if (status == 1) {
				CustomerActivity ca = new CustomerActivity(usernameTF.getText());
				ca.setVisible(true);
				this.setVisible(false);
			}//customer credentials detected
			else {
				JOptionPane.showMessageDialog(this,"Invalid ID or Password"); 
			}//incase wrong credentials
		}
		else {}
	}
}