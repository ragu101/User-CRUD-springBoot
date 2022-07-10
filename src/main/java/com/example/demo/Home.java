package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Home {
	
	public Home()
	{
		System.out.println("Home Home");
	}
	

	// POJO classes. Plain Old Java Object
	private String owner;
	private int doorNo;
	
	@Autowired
	@Qualifier("Airtel")
	private InternetConnection modem;
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}
	
	public void connect() 
	{
		modem.switchOn();
		System.out.println("Connecting To Internet");
	}
	
}
