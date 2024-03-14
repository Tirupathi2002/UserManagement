package com.um.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.um.model.User;

public class ServiceDao {
	
	private static Connection con = null;
	private static Statement s = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	private static String url = "jdbc:mysql://localhost:3306/usermanagement";
	private static String user = "root";
	private static String password = "hello";
	
	private static String insert_query = "insert into user(name,email,city) values(?,?,?)";
	private static String select_query = "select * from user";
	private static String delete_query = "delete from user where id=?";
	private static String select_by_id = "select * from user where id=?";
	private static String update_query = "update user set name=?,email=?,city=? where id=?";
	
	public static void doInsert(User u) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
			
			ps = con.prepareStatement(insert_query);
			
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getCity());
			
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static ArrayList<User> doDisplay() {
		
		ArrayList<User> arl = new ArrayList<User> ();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
			
			s = con.createStatement();
			rs = s.executeQuery(select_query);
			
			while(rs.next()) {
				
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String city = rs.getString("city");
				
				User us = new User(id, name, email, city);
				
				arl.add(us);
				
			}	
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(s!=null) {
				try {
					s.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return arl;
		
	}
	
	public static void doDelete(int id1) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
			
			ps = con.prepareStatement(delete_query);
			
			ps.setInt(1, id1);
			
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	public static User doEdit(int id2) {
		
		User u = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
			
			ps = con.prepareStatement(select_by_id);
			
			ps.setInt(1, id2);
			
			rs = ps.executeQuery();
			
			rs.next();
				
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String city = rs.getString("city");
				
				u = new User(id, name, email, city);
				
			
				
			
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return u;
	}
	
	public static void doUpdate(User u) {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
			
			ps = con.prepareStatement(update_query);
			
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getCity());
			
			ps.setInt(4, u.getId());
			
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
		
		
}

	

	

