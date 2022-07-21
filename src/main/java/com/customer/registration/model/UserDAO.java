package com.customer.registration.model;


import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;



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
	public UserDTO getByUserIdAndPassword(String userLoginId,String password)throws DAOException
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hotwax?useSSL=false","root","123456");
		PreparedStatement preparedStatement=con.prepareStatement("select * from userLogin where userLoginId=? and password=?");
		preparedStatement.setString(1,userLoginId);
		preparedStatement.setString(2,password);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next()==false)
		{
			resultSet.close();
			preparedStatement.close();
			con.close();
			return null;
		}
		int partyId=resultSet.getInt("partyId");
		preparedStatement.close();
		resultSet.close();
		preparedStatement=con.prepareStatement("select * from party where partyid=?");
		preparedStatement.setInt(1,partyId);
		resultSet=preparedStatement.executeQuery();
		if(resultSet.next()==false)
		{
			resultSet.close();
			preparedStatement.close();
			con.close();
			throw new DAOException("Internal Server Error");
		}
		UserDTO user=new UserDTO();
		user.setFirstName(resultSet.getString("firstName").trim());
		user.setLastName(resultSet.getString("lastName").trim());
		user.setAddress(resultSet.getString("address").trim());
		user.setCity(resultSet.getString("city").trim());
		user.setZip(resultSet.getInt("zip"));
		user.setState(resultSet.getString("state").trim());
		user.setCountry(resultSet.getString("country").trim());
		user.setPhone(resultSet.getString("phone").trim());
		user.setEmail(userLoginId);
		resultSet.close();
		preparedStatement.close();
		con.close();
		return user;
		}catch(Exception exception)
		{
			throw new DAOException(exception.getMessage());
			
		}
	}
	
	public UserDTO getByName(String firstName,String lastName)throws DAOException
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hotwax?useSSL=false","root","123456");
		PreparedStatement preparedStatement=con.prepareStatement("select * from party where firstName=? and lastName=?");
		preparedStatement.setString(1,firstName);
		preparedStatement.setString(2,lastName);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next()==false)
		{
			resultSet.close();
			preparedStatement.close();
			con.close();
			return null;
		}
		
		int partyId=resultSet.getInt("partyid");
		UserDTO user=new UserDTO();
		user.setFirstName(resultSet.getString("firstName").trim());
		user.setLastName(resultSet.getString("lastName").trim());
		user.setAddress(resultSet.getString("address").trim());
		user.setCity(resultSet.getString("city").trim());
		user.setZip(resultSet.getInt("zip"));
		user.setState(resultSet.getString("state").trim());
		user.setCountry(resultSet.getString("country").trim());
		user.setPhone(resultSet.getString("phone").trim());
		
		preparedStatement.close();
		resultSet.close();
		preparedStatement=con.prepareStatement("select userLoginId from userLogin where partyid=?");
		preparedStatement.setInt(1,partyId);
		resultSet=preparedStatement.executeQuery();
		if(resultSet.next()==false)
		{
			resultSet.close();
			preparedStatement.close();
			con.close();
			throw new DAOException("Internal Server Error");
		}
		user.setEmail(resultSet.getString("userLoginId").trim());
		resultSet.close();
		preparedStatement.close();
		con.close();
		return user;
		}catch(Exception exception)
		{
			throw new DAOException(exception.getMessage());
			
		}
	}
	
	public UserDTO getByPartyId(int partyId)throws DAOException
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hotwax?useSSL=false","root","123456");
		PreparedStatement preparedStatement=con.prepareStatement("select * from party where partyid=?");
		preparedStatement.setInt(1,partyId);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next()==false)
		{
			resultSet.close();
			preparedStatement.close();
			con.close();
			return null;
		}
		
		UserDTO user=new UserDTO();
		user.setPartyid(partyId);
		user.setFirstName(resultSet.getString("firstName").trim());
		user.setLastName(resultSet.getString("lastName").trim());
		user.setAddress(resultSet.getString("address").trim());
		user.setCity(resultSet.getString("city").trim());
		user.setZip(resultSet.getInt("zip"));
		user.setState(resultSet.getString("state").trim());
		user.setCountry(resultSet.getString("country").trim());
		user.setPhone(resultSet.getString("phone").trim());
		
		preparedStatement.close();
		resultSet.close();
		preparedStatement=con.prepareStatement("select userLoginId from userLogin where partyid=?");
		preparedStatement.setInt(1,partyId);
		resultSet=preparedStatement.executeQuery();
		if(resultSet.next()==false)
		{
			resultSet.close();
			preparedStatement.close();
			con.close();
			throw new DAOException("Internal Server Error");
		}
		user.setEmail(resultSet.getString("userLoginId").trim());
		resultSet.close();
		preparedStatement.close();
		con.close();
		return user;
		}catch(Exception exception)
		{
			throw new DAOException(exception.getMessage());
			
		}
	}
	public void updateUser(UserDTO user)
	{
		int partyId=user.getPartyid();
		String firstName=user.getFirstName();
		String lastName=user.getLastName();
		String address=user.getAddress();
		String city=user.getCity();
		int zip=user.getZip();
		String state=user.getState();
		String country=user.getCountry();
		String phone=user.getPhone();
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hotwax?useSSL=false","root","123456");
		PreparedStatement preparedStatement=con.prepareStatement("update Party set firstName=?,lastName=?,address=?,city=?,zip=?,state=?,country=?,phone=? where partyid=?");
		preparedStatement.setString(1,firstName);
		preparedStatement.setString(2,lastName);
		preparedStatement.setString(3,address);
		preparedStatement.setString(4,city);
		preparedStatement.setInt(5,zip);
		preparedStatement.setString(6,state);
		preparedStatement.setString(7,country);
		preparedStatement.setString(8,phone);
		preparedStatement.setInt(9,partyId);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		con.close();
		}catch(Exception exception)
		{
			//throw new DAOException(exception.getMessage());
			
		}
		
		
	}
	public Set<UserDTO> getAllUsers()
	{
			Set<UserDTO> set= new HashSet<UserDTO>();
			try
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hotwax?useSSL=false","root","123456");
			Statement statement=con.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from Party");
			UserDTO user;
			
			while(resultSet.next())
			{
			user=new UserDTO();
			user.setPartyid(resultSet.getInt("partyid"));
			user.setFirstName(resultSet.getString("firstName").trim());
			user.setLastName(resultSet.getString("lastName").trim());
			user.setAddress(resultSet.getString("address").trim());
			user.setCity(resultSet.getString("city").trim());
			user.setZip(resultSet.getInt("zip"));
			user.setState(resultSet.getString("state").trim());
			user.setCountry(resultSet.getString("country").trim());
			user.setPhone(resultSet.getString("phone").trim());
			set.add(user);
			}
			statement.close();
			resultSet.close();
			con.close();
			return set;
			}catch(Exception exception)
			{
				return set;
			}
			
			
		}
		
		public void deleteUser(int partyId)
		{
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hotwax?useSSL=false","root","123456");
				PreparedStatement preparedStatement=con.prepareStatement("delete from userLogin where partyid=?");
				preparedStatement.setInt(1, partyId);
				preparedStatement.executeUpdate();
				preparedStatement.close();
				preparedStatement=con.prepareStatement("delete from party where partyid=?");
				preparedStatement.setInt(1, partyId);
				preparedStatement.executeUpdate();
				preparedStatement.close();
				
				con.close();
				
			}catch(Exception e)
			{
				
				
			}
			
		}
	
	
}
