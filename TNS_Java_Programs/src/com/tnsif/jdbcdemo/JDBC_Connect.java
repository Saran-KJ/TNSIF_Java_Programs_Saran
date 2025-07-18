package com.tnsif.jdbcdemo;


import java.sql.*; //1st step

public class JDBC_Connect {

	public static void main(String[] args) {
		
		
		String url = "jdbc:postgresql://localhost:5432/jdbcdemo";
		String username = "postgres";
		String password = "sk@65";
		
		
		try {
			
			//Load the driver - 2nd step
			Class.forName("org.postgresql.Driver");
			
			
			//Establishing the connection - 3rd step
			
			Connection con = DriverManager.getConnection(url, username, password);
			
			//Define SQL Query - 4th step
			
			Statement st = con.createStatement();
			
			//Executing the query - 5th step
			
			
			String query = "SELECT * FROM sk01";
			
			//Process the Result - 6th Step
			
			ResultSet rs = st.executeQuery(query);
			
			
			while(rs.next())
				
			{
				String table = rs.getString(1) + ":" + rs.getString(2) + ":" + rs.getInt(3);
				System.out.println(table);
			}

			
			//close the resources - 7th
			
			rs.close();
			st.close();
			con.close();
			
			
		}
		

		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
