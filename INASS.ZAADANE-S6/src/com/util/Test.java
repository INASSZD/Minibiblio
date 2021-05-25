package com.util;

public class Test {

	public static void main(String[] args) {
		bookManager um=new bookManager();
		int nb= um.addBook("test","test2","test3","test4");
		System.out.println(nb+"ligne ajouté");

	}

}
