package com.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class bookManager {

	public int addBook(String name, String author, String category,String des) 
	{
		
				
		DBinteraction.connect();
		String sql="insert into books(name,author,category,des) values ('"+name+"','"+author+"','"+category+"','"+des+"')";
		int nb=DBinteraction.Maj(sql);
		DBinteraction.disconnect();
			return nb;	 
				
	}
	
	public int addBook(book u) 
	{
		
				
		DBinteraction.connect();
		String sql="insert into books(name,author,category,desc) values ('"+u.getName()+"','"+u.getAuthor()+"','"+u.getCategory()+"','"+u.getDesc()+"')";
		int nb=DBinteraction.Maj(sql);
		DBinteraction.disconnect();
				
			return nb;	 
				
	}
	public int deleteBook(int id) 
	{
				DBinteraction.connect();
				int nb=DBinteraction.Maj("delete from books where id="+id);
				DBinteraction.disconnect();
				
				return nb;
	}
	
	public book findBookById(int id)
	{
		book u=null;
		DBinteraction.connect();
		ResultSet rs = DBinteraction.select("select * from books where id="+id);
		try {
			if(rs.next())
			{
				u=new book();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setAuthor(rs.getString(3));
				u.setCategory(rs.getString(4));
				u.setDesc(rs.getString(5));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return u;
	}
	
	public int updateUser(int id,book ut)
	{
		DBinteraction.connect();
		String sql="update books set name='"+ut.getName()+"', author='"+ut.getAuthor()+"' , category='"+ut.getCategory()+"', desc='"+ut.getDesc()+"' where id="+id;
		int nb=DBinteraction.Maj(sql);
		DBinteraction.disconnect();
		return nb;
		
	}
	
	
	public List<book> allBooks()
	{
		List<book> us=new ArrayList<book>();
		DBinteraction.connect();
		ResultSet rs = DBinteraction.select("select * from books");
		try {
			while(rs.next())
			{
				book u=new book();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setAuthor(rs.getString(3));
				u.setCategory(rs.getString(4));
				u.setDesc(rs.getString(5));
				//ajouter u dans la liste
				us.add(u);		
			}
			}	
	
	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return us;
		
	}
	
	
	public List<book> catBooks(String cat)
	{
		List<book> us=new ArrayList<book>();
		DBinteraction.connect();
		ResultSet rs = DBinteraction.select("select * from books  where category="+cat);
		try {
			while(rs.next())
			{
				book u=new book();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setAuthor(rs.getString(3));
				u.setCategory(rs.getString(4));
				u.setDesc(rs.getString(5));
				//ajouter u dans la liste
				us.add(u);
				
			}
			}
		
	
	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return us;
		
	}
	
	public List<String> listCategory()
	{
		List<String> us=new ArrayList<String>();
		book b=new book();
		DBinteraction.connect();
		ResultSet rs = DBinteraction.select("select distinct category  * from books");
		
			 us.add(b.getCategory());
			 
			 return us;
				
			
	}}