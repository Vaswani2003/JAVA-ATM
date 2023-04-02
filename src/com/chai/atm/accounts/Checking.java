package com.chai.atm.accounts;

public class Checking extends Account{
	String type;
	Checking(String id, String pin) {
		super(id, pin);
		this.type = "Checking";
	}
	public String getType() {
		return type;
	}
}
