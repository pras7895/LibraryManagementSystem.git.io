package com.pack;

import java.sql.Date;

public class BookBean {
	private String Callno,Name,Publisher,Author;
	int Quantity,Issued;
	Date date;
	public BookBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookBean(String callno, String name, String publisher, String author, int quantity) {
		super();
		Callno = callno;
		Name = name;
		Publisher = publisher;
		Author = author;
		Quantity = quantity;
	}
	public String getCallno() {
		return Callno;
	}
	public void setCallno(String callno) {
		Callno = callno;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getIssued() {
		return Issued;
	}
	public void setIssued(int issued) {
		Issued = issued;
	}

	
	}
