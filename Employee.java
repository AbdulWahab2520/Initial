package attr;

import java.lang.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import attr.*;
import activity.*;


/*----------------------------------------------------------------------------------------------------------------------
 * Class to Add a Employee and define its different properties i.e ID , Name , PhoneNumber , Role , Salary 
 *----------------------------------------------------------------------------------------------------------------------
 */

public class Employee extends User //User is an abstract class
{
	/*
	 *--------------------------Data Fields of the Employee Class
	 */
	private String employeeName;
	private String phoneNumber;
	private String role;
	public static String[] columnNames = {"EmployeeID", "EmployeeName", "PhoneNumber", "Role", "Salary"};
	public static String[] roles = {"General", "Manager"};
	private double salary;	
	/*
	 *--------------------------Constructor
	 */
	public Employee(String userId) {
		super(userId);    //--------------------Calling the constructor of the Super Class(User Class)
		this.setStatus(0); //-------------------calling the setStatus method of the super class(User class)
	}
	/*
	 * Setter method for the data field Employee Name of this (Employee) Class
	 */
	public void setEmployeeName(String name) {
		if (!name.isEmpty())
			this.employeeName = name;
		else
			throw new IllegalArgumentException("Fill in the name"); //-------Throwing illegal exception in case the name Text filed is left empty...
	}
	/*
	 *--------------------------Phone Number Setter Method 
	 */
	public void setPhoneNumber(int num) {
		this.phoneNumber = "+92"+num;
	}
	/*
	 *--------------------------Role Setter Method
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/*
	 *--------------------------Salary setter method
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	/*
	 *--------------------------Phone number Getter method
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/*
	 *--------------------------Employee Name Getter Method
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	/*
	 *--------------------------Role Getter Method
	 */
	public String getRole() {
		return role;
	}
	/*
	 *--------------------------Salary Getter Method
	 */
	public double getSalary() {
		return salary;
	}
	/*
	 * --------------------------Method to add information to database for the new Employee
	 */
	public void createEmployee() {
		String query1 = "INSERT INTO `login` VALUES ('"+userId+"','"+password+"',"+status+");";
		String query2 = "INSERT INTO `employee` VALUES ('"+userId+"','"+employeeName+"','"+phoneNumber+"','"+role+"', '"+salary+"');";
		Connection con = null;
        Statement st = null;
		System.out.println(query1);
		System.out.println(query2);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");//JDBC driver Loader 
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			st.execute(query1);//insert
			st.execute(query2);
			System.out.println("data inserted");//Data inserted
			JOptionPane.showMessageDialog(null,"Account Created!");//Confirming Account Created
		}
        
        //Catching Exception
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Failed to create account!");
			System.out.println("Exception : " +ex.getMessage());
        }
        /*
         * --------------------------Closing Resources
         */   
        finally {
            try {
                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }
	}
	/*
	 * --------------------------@override 
	 */
	public void fetch() {//Overriding the Abstract Method
		String query = "SELECT `userId`, `employeeName`, `phoneNumber`, `role`, `salary` FROM `employee` WHERE userId='"+this.userId+"';";     
        Connection con = null;
        Statement st = null;
		ResultSet rs = null;
		System.out.println(query);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");//Driver Loading 
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			boolean flag = false;
			while(rs.next()) {
				this.employeeName = rs.getString("employeeName");//Getting EmployeeName
				this.phoneNumber = rs.getString("phoneNumber");//Getting Employee Phone Number 
				this.role = rs.getString("role");//Getting Role
				this.salary = rs.getDouble("salary");//Getting Salary
			}
		}
        /*
         * --------------------------Closing Resources
         */
        catch(Exception ex) {
			System.out.println("Exception : " +ex.getMessage());
        }
        finally {
            try {
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }
	}
	/*
	 * --------------------------Method to update employee information
	 */
	public void updateEmployee(String name, int phone, String role, double salary) {
		String query = "UPDATE `employee` SET `employeeName`='"+name+"', `phoneNumber`='+92"+phone+"', `role`='"+role+"', `salary`="+salary+" WHERE `userId`='"+this.userId+"';";
		Connection con = null;
        Statement st = null;
		System.out.println(query);//Printing the Query
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");//Driver Loader
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			st.executeUpdate(query);//insert
			System.out.println("data inserted");
			JOptionPane.showMessageDialog(null,"Information Updated!");
			this.employeeName = name;
			this.phoneNumber = "+880"+phone;
			this.role = role;
			this.salary = salary;
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Failed to update account!");
			System.out.println("Exception : " +ex.getMessage());
        }   
        /*
         * Close Resources
         */
        finally {
            try {
                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }
	}
	/*
	 * --------------------------Method to delete Employee
	 */
	public void deleteEmployee() {
		String query1 = "DELETE FROM `login` WHERE `userId`='"+this.userId+"';";
		String query2 = "DELETE FROM `employee` WHERE `userId`='"+this.userId+"';";
		Connection con = null;
        Statement st = null;
		System.out.println(query1);
		System.out.println(query2);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");//Driver Loader
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			st.execute(query1);
			st.execute(query2);//delete
			System.out.println("data deleted");
			JOptionPane.showMessageDialog(null,"Account Deleted!");
			this.userId = "";
			this.employeeName = "";
			this.phoneNumber = "";
			this.role = "";
			this.salary = 0;
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Failed to delete account!");
			System.out.println("Exception : " +ex.getMessage());
        }   
        /*
         * --------------------------Closing resources
         */
        finally {
            try {
                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }
	}
	/*
	 * --------------------------Method to search employee
	 */
	public static DefaultTableModel searchEmployee(String keyword, String byWhat) {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		String query = "SELECT * FROM `employee` WHERE `userId`='"+keyword+"';";
		if (byWhat.equals("By Name"))
			query = "SELECT * FROM `employee` WHERE `employeeName` LIKE '%"+keyword+"%';";
		else {}
        Connection con = null;
        Statement st = null;
		ResultSet rs = null;
		System.out.println(query); //------------------Printing Query
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			
			while(rs.next()) {
				model.addRow(new Object[]{rs.getString("userId"), rs.getString("employeeName"), rs.getString("phoneNumber"), rs.getString("role"), rs.getString("salary")});
			}
		}
        catch(Exception ex) {
			System.out.println("Exception : " +ex.getMessage());
        }   
        /*
         *--------------------------Closing resources
         */
        finally {
            try {
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }
		return model;
	}
}
	///////////////////////////////////////////////////////////////////////////////////////
