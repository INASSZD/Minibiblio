

package com.util;

public class book {

	int id;
	String name,category,author,des;
	
	
	
	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getDesc() {
		return des;
	}



	public void setDesc(String des) {
		this.des = des;
	}



	@Override
	public String toString() {
		return "book [id=" + id + ", name=" + name + ", category=" + category + ", des=" + des + "]";
	}
	
	
}

