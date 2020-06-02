package attr;

import java.lang.*;
import java.sql.*;
import attr.*;
import javax.swing.*;
import activity.*;
/*-------------------------------------------------------------------------------------------
 *              Class to manage logins check from Customer or Employee
 *-------------------------------------------------------------------------------------------
 */
public abstract class User {
	/*
	 *--------------------------User attributes 
	 */
	protected String userId;
	protected String password;
	protected int status;
	/*
	 *--------------------------Constructor with ID 
	 */
	public User(String userId) {
		if (!userId.isEmpty())
			this.userId = userId;
		else
			throw new IllegalArgumentException("Fill in the User ID");
	}
	/*
	 *--------------------------Abstract method 
	 */
	public abstract void fetch();
	/*
	 *--------------------------User ID Getter method
	 */
	public String getUserId() {
		return userId;
	}
	/*
	 *--------------------------Status setter method 
	 */
	public void setStatus(int stts) {
		this.status = stts;
	}
	/*
	 *--------------------------Password setter method  
	 */
	public void setPassword(String passwd) {
		if (!passwd.isEmpty())
			this.password = passwd;
		else
			throw new IllegalArgumentException("Fill in the password");
	}
	/*
	 *--------------------------Login Status check method 
	 */
	public static int checkStatus(String uid, String pass) {
		int result = -1;
		//JDBC connection essentials
		String query = "SELECT `userId`, `password`, `status` FROM `login`;";     
        Connection con = null;
        Statement st = null;
		ResultSet rs = null;
		System.out.println(query);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");//jdbc driver loaded
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			/*
			 *--------------------------Reading Result set 
			 */
			while(rs.next()) {
                String userId = rs.getString("userId");
                String password = rs.getString("password");
				int status = rs.getInt("status");
				//confirming login data
				if(userId.equals(uid) && password.equals(pass)) {
					result = status;
				}
			}
		}
        catch(Exception ex) {
			System.out.println("Exception : " +ex.getMessage());
			ex.printStackTrace();
        }
        /*
    	 *--------------------------closing resources
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
		return result;
	}
	/*
	 *--------------------------Password changing method 
	 */
	public void changePassword(ChangePasswordActivity a, String oldPass, String newPass) {
		//query and jdbc connection
		String query = "UPDATE `login` SET `password`='"+newPass+"' WHERE (`userId`='"+this.userId+"' AND `password`='"+oldPass+"');";
		Connection con = null;
        Statement st = null;
		System.out.println(query);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");//jdbc diver loaded
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			int res = st.executeUpdate(query);//insert query
			System.out.println("data inserted");
			if (res > 0) {
				JOptionPane.showMessageDialog(null,"Password Updated!");
			a.setVisible(false);
			}//task accomplished
			else {
				JOptionPane.showMessageDialog(null,"Password didn't match!");
			}//task aborted
		}
        catch(Exception ex) {
			System.out.println("Exception : " +ex.getMessage());
        }
        /*
    	 *--------------------------Closing resources 
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
}