import java.util.*;
import java.sql.*;

//Alex Aquino Homework 9
//hw9_main connects to mysql database hw9 
//to output the values in table pet
public class hw9_main {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/hw9",
				args[0], //username
				args[1]); //password
				
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM pet");
			
			System.out.println("Showing table pet from database hw9\n");
			System.out.println("name\towner\tspecies\tsex\tbirth\t\tdeath");
			
			while(rs.next()) {
				System.out.println(rs.getString("name")
					+ "\t" + rs.getString("owner")
					+ "\t" + rs.getString("species")
					+ "\t" + rs.getString("sex")
					+ "\t" + rs.getString("birth")
					+ "\t" + rs.getString("death"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}