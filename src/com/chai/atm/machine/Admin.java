package com.chai.atm.machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

import com.chai.atm.accounts.Account;
import com.chai.atm.accounts.AccountAdmin;

public class Admin {
	AccountAdmin admin;
	ArrayList<Account> accounts;
	HashMap<String, ArrayList<String>> transactions = new HashMap<String,ArrayList<String>>();
	//verify
	int indexAcc(String id) {
		for(int i=0;i<accounts.size();i++) {
			if(((accounts.get(i)).getAccID()).equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean verify(String id, String pin) {
		int index = this.indexAcc(id);
		if(index==-1) {
			System.out.println("Account does not exist. Enter a valid Account ID");
			return false;
		}
		else {
			if(accounts.get(index).getAccID().equals(id) && accounts.get(index).getAccPIN().equals(pin)) {
				return true;
			}
			else {
				System.out.println("Enter a valid pin!");
				return false;
			}
		}
	}
	
	public void logTransaction(String id,float sum,String mode) {
		if(!transactions.containsKey(id)) {
			ArrayList<String> s = new ArrayList<String>();
			s.add((mode.equals("w")?"Withdraw":"Deposit")+": "+sum);
			transactions.put(id,s);
		}else {
			ArrayList<String> s = transactions.get(id);
			s.add((mode.equals("w")?"Withdraw":"Deposit")+": "+sum);
			transactions.put(id,s);
		}
	}
	
	public void updateFile() {
		//Add the path of your choice to save the transactions
		try (FileWriter file = new FileWriter("C:\\Users\\Chaitanya Vengali\\eclipse-workspace\\ATM\\src\\com\\chai\\atm\\machine\\transactions.json")) {
			JSONObject json = new JSONObject(transactions);
            file.write(json.toJSONString()); 
            file.flush();
		}catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	Admin(){
		admin = new AccountAdmin();
		accounts = admin.getAccounts();
		System.out.println("Hi");
	}

}
