import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {
	
	public static void main(String[] args) {
		Connection conn = null;
		
		String url="jdbc:mysql://localhost:3306/sqlTest";
		String username ="root";
		String password = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connected!");
			// our SQL SELECT query. 
		      // if you only need a few columns, specify them by name instead of using "*"
		      String query = "SELECT * FROM sqlTest.names";

		      // create the java statement
		      Statement st = conn.createStatement();
		      
		   // execute the query, and get a java resultset
		      ResultSet rs = st.executeQuery(query);
		    
		      
		   // iterate through the java resultset
		      while (rs.next())
		      {
		        int id = rs.getInt("name_id");
		        String firstName = rs.getString("firstName");
		        String lastName = rs.getString("lastName");
//		     // print the results
		        System.out.println("**************************");
		        System.out.println("First Name: " +  firstName);
		        System.out.println("Last Name: " +  lastName);
		        System.out.println("**************************");
		      }
			
		} catch(SQLException | ClassNotFoundException e) {
			throw new Error("Error", e);
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
