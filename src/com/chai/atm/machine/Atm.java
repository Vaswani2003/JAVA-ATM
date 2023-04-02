package com.chai.atm.machine;

import java.util.*;

import com.chai.atm.accounts.Account;
import com.chai.atm.accounts.Checking;
import com.chai.atm.accounts.Savings;

public class Atm {
	Admin ad = new Admin();
	Scanner sc = new Scanner(System.in);
	
	public void login() {
		do{
			String uname, pass;
			System.out.println("Enter account ID(q to quit):");
			uname = sc.nextLine();
			if(uname.equals("q"))
				return;
			System.out.println("Enter account pin: ");
			pass = sc.nextLine();
			
			if(ad.verify(uname,pass)) {
				this.menu(ad.accounts.get(ad.indexAcc(uname)));
				break;
			}
		}while(true);
	}
	
	public void menu(Account a){
		if(a instanceof Savings)
			savingsMenu(a);
		else if(a instanceof Checking)
			checkingMenu(a);
	}
	
	private void checkingMenu(Account a) {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("Checking account menu:\n1. view balance\n2. withdraw\n3. deposit\n4. exit");
			int num = sc.nextInt();
			sc.nextLine();
			switch(num) {
				case 1:
					System.out.println("Account Balance is "+a.getAccBal());
					break;
				case 2:
					System.out.println("Enter amount to withdraw: ");
					float sum = sc.nextFloat();
					a.withdraw(sum);
					ad.logTransaction(a.getAccID(), sum, "w");
					break;
				case 3:
					System.out.println("Enter amount to deposit: ");
					float sum1 = sc.nextFloat();
					a.deposit(sum1);
					ad.logTransaction(a.getAccID(), sum1, "d");
					break;
				case 4:
					login();
					return;
			}
		}
			
	}

	private void savingsMenu(Account a) {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("Savings account menu:\n1. view balance\n2. withdraw\n3. deposit\n4. exit");
			int num = sc.nextInt();
			sc.nextLine();
			switch(num) {
				case 1:
					System.out.println("Account Balance is "+a.getAccBal());
					break;
				case 2:
					System.out.println("Enter amount to withdraw: ");
					float sum = sc.nextFloat();
					if(a.withdraw(sum))
						ad.logTransaction(a.getAccID(), sum, "w");
					break;
				case 3:
					System.out.println("Enter amount to deposit: ");
					float sum1 = sc.nextFloat();
					a.deposit(sum1);
					ad.logTransaction(a.getAccID(), sum1, "d");
					break;
				case 4:
					login();
					return;
			}
		}
		
	}
	
	public void saveData() {
		ad.updateFile();
	}

	public static void main(String[] args) {
		Atm current = new Atm();
		System.out.println("Welcome to the ATM");
		current.login();
		current.saveData();
	}
}
