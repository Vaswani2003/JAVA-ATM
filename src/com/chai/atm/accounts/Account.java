package com.chai.atm.accounts;
/*Account super class that contains the basic structure of an account*/
public class Account {
	String accID;
	private String accPIN;
	float accBAL;
	
	Account(String id, String pin){
		this.accID = id;
		this.accPIN = pin;
		this.accBAL = 0;
	}

	public String getAccPIN() {
		return accPIN;
	}
	
	public boolean withdraw(float sum) {
		if((this.accBAL-sum)<0) {
			System.out.println("Not enough funds to withdraw "+sum);
			return false;
		}
		else {
			this.accBAL-=sum;
			return true;
		}
			
	}
	
	public void deposit(float sum) {
		this.accBAL+=sum;
	}
	
	public String toString() {
		return "Account ID: "+this.accID+"\nAccount Balance:"+this.accBAL;
	}

	public String getAccID() {
		return accID;
	}
	
	public float getAccBal() {
		return this.accBAL;
	}
	
}
