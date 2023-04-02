package com.chai.atm.accounts;

import java.util.ArrayList;

public class AccountAdmin {
	
	private ArrayList<Account> accounts;
	
	void createAcc(String id, String pin) {
		Account a = new Account(id,pin);
		
		accounts.add(a);
	}
	
	void createAcc(String id, String pin, String type) {
		if(type.equals("Savings")) {
			Savings s = new Savings(id,pin);
			accounts.add(s);
		}else if (type.equals("Checking")){
			Checking c = new Checking(id,pin);
			accounts.add(c);
		}else {
			System.out.println("Enter a valid type of account!");
		}
	}
	
	int indexAcc(String id) {
		for(int i=0;i<accounts.size();i++) {
			if(((accounts.get(i)).accID).equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	void deleteAcc(String id) {
		if(accounts.isEmpty())
			System.out.println("No accounts registered");
		else {
			int index = indexAcc(id);
			if(index==-1)
				System.out.println("Account ID not found");
			else {
				accounts.remove(index);
			}
		}
	}
	
	public ArrayList<Account> getAccounts(){
		return accounts;
	}
	
	public AccountAdmin(){
		accounts = new ArrayList<Account>();
		createAcc("1234","abcd","Savings");
		createAcc("5678", "aaaa","Checking");
	}
}
