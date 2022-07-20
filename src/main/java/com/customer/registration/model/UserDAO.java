package com.customer.registration.model;


import java.sql.*;



public class UserDAO {
	
	public void addUser(UserDTO user) throws DAOException 
	{
		String firstName=user.getFirstName();
		String lastName=user.getLastName();
		String email=user.getEmail();
		String password=user.getPassword();
		String address=user.getAddress();
		String city=user.getCity();
		int zip=user.getZip();
		String state=user.getState();
		String country=user.getCountry();
		String phone=user.getPhone();
		
		try
		{
		ResultSet resultSet;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hotwax?useSSL=false","root","123456");
		PreparedStatement preparedStatement=con.prepareStatement("insert into Party (firstName,lastName,address,city,zip,state,country,phone) values(?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1,firstName);
		preparedStatement.setString(2,lastName);
		preparedStatement.setString(3,address);
		preparedStatement.setString(4,city);
		preparedStatement.setInt(5,zip);
		preparedStatement.setString(6,state);
		preparedStatement.setString(7,country);
		preparedStatement.setString(8,phone);
		preparedStatement.executeUpdate();
		resultSet=preparedStatement.getGeneratedKeys();
		resultSet.next();
		int generatedUserId=resultSet.getInt(1);
		resultSet.close();
		preparedStatement.close();
		preparedStatement=con.prepareStatement("insert into userlogin (userLoginId,password,partyid) values(?,?,?)");
		preparedStatement.setString(1,email);
		preparedStatement.setString(2,password);
		preparedStatement.setInt(3,generatedUserId);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		con.close();
		}catch(Exception exception)
		{
			throw new DAOException(exception.getMessage());
			
		}
		
	}
	
}
