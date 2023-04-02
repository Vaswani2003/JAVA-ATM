package com.chai.atm.accounts;

public class Savings extends Account{
	String type;
	Savings(String id, String pin) {
		super(id, pin);
		this.type = "Savings";
	}
	public String getType() {
		return type;
	}
}
