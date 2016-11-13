package htmldriver;
//MYSQL CONNECTOR JAR 
//USE TO DO A TEST CASE FOR EXAMPLE TO VALIDATE A USER REGISTERED FROM THE UI OR THROUGH THE API IF THE RECORD IS IN THE DATABASE OR A PURCHASE ORDER AND ALWAYS DELETE IT THE SAME VARIABLE AS THE ORDER OR USERNAME
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class InitConnection {

	public static void main(String[] args) {
		MysqlConnect mysqlConnect = new MysqlConnect();
		String sql = "SELECT * FROM `actor`";
		try {
		    PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
		    //I ADDED THIS BY MYSELF
		    ResultSet result = statement.executeQuery();
		    System.out.println(result.toString());
		    //It always starts from the first row - the column names so go to the second row before working on it
		    result.next();
		    while(!result.isLast()){
		    	System.out.println(result.getRow());
		    	//I need to know the datatype of the columns that I need easiest way to see the im MySQLWorkbench or phpMyAdmin and from there generate my queries just in case or test them 
		    	System.out.println(result.getInt("actor_id") + "|" + result.getString("first_name") + "|" + result.getString("last_name") + "|" + result.getTimestamp("last_update"));
		    	result.next();
		    }
		    
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    mysqlConnect.disconnect();
		}

	}

}
