package  htmldriver;		
import  java.sql.Connection;		
import  java.sql.Statement;
import java.sql.Timestamp;
import  java.sql.ResultSet;		
import  java.sql.DriverManager;		
import  java.sql.SQLException;		
public class  SQLConnectorfFromGuruNotWorking {				
    	public static void  main(String[] args) throws  ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {													
				//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
    		//jdbc:mysql://hostname:port/databasename
                String dbUrl = "jdbc:mysql://localhost:3036/sakila";					

				//Database Username		
				String username = "root";	
                
				//Database Password		
				String password = "root";				

				//Query to Execute		
				String query = "select *  from sakila.actor;";
				//For example select * from sakila.actor WHERE name LIKE + variable for the name that I created for a new user test or an order that should be recorded in the database!!!!
                
         	    //Load mysql jdbc driver
				//********************************
				//!!!!!!!!!!!**********BUG FROM GURU CODE MISSING .newInstance() call here
           	    Class.forName("com.mysql.jdbc.Driver").newInstance();			
           
           		//Create Connection to DB		
            	Connection con = DriverManager.getConnection(dbUrl,username,password);
          
          		//Create Statement Object		
        	   Statement stmt = con.createStatement();					
       
       			// Execute the SQL Query. Store results in ResultSet		
         		ResultSet rs= stmt.executeQuery(query);							
         
         		// While Loop to iterate through all data and print results		
				while (rs.next()){
			        		int actorId = rs.getInt("actor_id");								        
                            String firstName = rs.getString("first_name");
                            String lastName = rs.getString("last_name");
                            Timestamp lastUpdate = rs.getTimestamp("last_update");
                            System.out.println(actorId+" "+firstName+" "+lastName+" "+lastUpdate);		
                    }		
      			 // closing DB Connection	
				stmt.close();
      			con.close();			
		}
}