package attr;

import java.lang.*;
import java.util.*;
import java.sql.*;
import javax.swing.table.*;
import java.awt.*;
import java.text.*;
import attr.*;
import activity.*;
import javax.swing.*;
/*-------------------------------------------------------------------------------------------
 * Class to create a product and define its diferent properties i.e name, id, price, quantity
 *-------------------------------------------------------------------------------------------
 */
public class Product {
	/*
	 *--------------------------Product attributes 
	 */
	private String productId;
	private String productName;
	private double price;
	private int quantity;
	public static String[] columnNames = {"PID", "Name", "Price", "AvailableQuantity"};
	/*
	 *--------------------------Constructors 
	 */
	public Product() {}
	public Product(String productId) {
		if (!productId.isEmpty())
			this.productId = productId;
		else
			throw new IllegalArgumentException("Fill in the ID");
	}
	/*
	 *--------------------------Product Name Setter 
	 */
	public void setProductName(String name) {
		if (!name.isEmpty())
			this.productName = name;
		else
			throw new IllegalArgumentException("Fill in the name");
	}
	/*
	 *--------------------------Product Price Setter 
	 */
	public void setPrice(double p) {
		this.price = p;
	}
	/*
	 *--------------------------Product Quantity Setter 
	 */
	public void setQuantity(int q) {
		this.quantity = q;
	}
	/*
	 *--------------------------Product ID Getter 
	 */
	public String getProductId() {
		return productId;
	}
	/*
	 *--------------------------Product Name Getter 
	 */
	public String getProductName() {
		return productName;
	}
	/*
	 *--------------------------Product Price Getter 
	 */
	public double getPrice() {
		return price;
	}
	/*
	 *--------------------------Product QUantity Getter 
	 */
	public int getQuantity() {
		return quantity;
	}
	/*
	 *--------------------------Methord to get Product details by ID 
	 */
	public void fetch() {
		/*
		 *--------------------------Connection with database 
		 */
		String query = "SELECT `productId`, `productName`, `price`, `quantity` FROM `product` WHERE productId='"+this.productId+"';";     
        Connection con = null;
        Statement st = null;
		ResultSet rs = null;
		System.out.println(query);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");//driver loaded
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			/*
			 *--------------------------Reading result set 
			 */	
			while(rs.next()) {
				this.productName = rs.getString("productName");
				this.price = rs.getDouble("price");
				this.quantity = rs.getInt("quantity");
			}
		}
        catch(Exception ex) {
			System.out.println("Exception : " +ex.getMessage());
        }
        /*
    	 *--------------------------Closing connection
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
	}
	/*
	 *--------------------------Method for managinging sale of Product 
	 */
	public void sellProduct(String uid, int amount) {
		String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());//geting date
		String query = "INSERT INTO `purchaseInfo` (`userId`, `productId`, `amount`, `date`, `cost`) VALUES ('"+uid+"','"+this.productId+"',"+amount+", '"+date+"', "+(amount*this.price)+");";
		/*
		 *--------------------------Setting connection to database 
		 */
		Connection con = null;
        Statement st = null;
		System.out.println(query);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");//driver loaded
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			st.execute(query);//insert sales detail im database
			System.out.println("data inserted");
			updateProduct(this.productName, this.price, this.quantity-amount);
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Customer doesn't exist!"); 
			System.out.println("Exception : " +ex.getMessage());
        }
        /*
    	 *--------------------------Closing Connection 
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
	 *--------------------------Method for updating product details 
	 */
	public void updateProduct(String name, double price, int quantity) {
		String query = "UPDATE `product` SET `productName`='"+name+"', `price`="+price+", `quantity`="+quantity+" WHERE `productId`='"+this.productId+"';";
		/*
		 *--------------------------Database connection 
		 */
		Connection con = null;
        Statement st = null;
		System.out.println(query);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");//driver loaded
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			st.executeUpdate(query);//insert update in database
			System.out.println("data inserted");
			JOptionPane.showMessageDialog(null,"Done!");
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Failed!");
			System.out.println("Exception : " +ex.getMessage());
        }
        /*
		 *--------------------------closing connection 
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
	 *--------------------------Method to store new product in database 
	 */
	public void createProduct() {
		String query = "INSERT INTO `product` (`productName`, `price`, `quantity`) VALUES ('"+productName+"','"+price+"','"+quantity+"');";
		/*
		 *--------------------------Database connection 
		 */
		Connection con = null;
        Statement st = null;
		System.out.println(query);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");//drivr loaded
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			st.execute(query);//insert data in databse
			System.out.println("data inserted");
			JOptionPane.showMessageDialog(null,"Product Created!");
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Failed to add Product!");
			System.out.println("Exception : " +ex.getMessage());
        }
        /*
		 *--------------------------closing connection 
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
	 *--------------------------Method for searching product in database
	 */
	public static DefaultTableModel searchProduct(String keyword, String byWhat) {
		DefaultTableModel model = new DefaultTableModel();//creating table to display search results
		model.setColumnIdentifiers(columnNames);//giving field names
		String query = "SELECT `productId`, `productName`, `price`, `quantity` FROM `product` WHERE `productId`='"+keyword+"';";
		if (byWhat.equals("By Name"))//search by name
			query = "SELECT `productId`, `productName`, `price`, `quantity` FROM `product` WHERE `productName` LIKE '%"+keyword+"%';";
		else {}
		/*
		 *--------------------------Database connection 
		 */
        Connection con = null;
        Statement st = null;
		ResultSet rs = null;
		System.out.println(query);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");//driver loaded
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result of search
			System.out.println("results received");
			/*
			 *--------------------------Reading resultset and adding row-wise in table 
			 */
			while(rs.next()) {
				model.addRow(new Object[]{rs.getString("productId"), rs.getString("productName"), rs.getDouble("price"), rs.getInt("quantity")});
			}
		}
        catch(Exception ex) {
			System.out.println("Exception : " +ex.getMessage());
        }
        /*
		 *--------------------------closing connection 
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
		return model;//returning table for display on interface
	}
	
	/*
	 *--------------------------Method for deleting product in database 
	 */
	public void deleteProduct() {
		String query1 = "DELETE FROM `product` WHERE `productId`='"+this.productId+"';";
		/*
		 *--------------------------Database connection 
		 */
		Connection con = null;
        Statement st = null;
		System.out.println(query1);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");//driver loaded
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			st.execute(query1);//delete required data
			System.out.println("data deleted");
			JOptionPane.showMessageDialog(null,"Product Deleted!");
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Failed to delete product!");
			System.out.println("Exception : " +ex.getMessage());
        }
        /*
		 *--------------------------close connection
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

/*
 *-------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *                                                                 AN AWAIS-WAHAB-ZEESHAN PRODUCTION
 *-------------------------------------------------------------------------------------------------------------------------------------------------------------------
 */