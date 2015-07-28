package com.altova.bankview;
import BankAPI.*;
public class Bank{
	protected String bankname;
	protected String IPaddress;
	protected String username;
	protected String password;
	protected Account[] accounts;
	public Bank(String name, String IP, String user, String pw){
		// TODO add implementation
	}
	public boolean collectAccountInfos(IBankAPI api){
		// TODO add implementation and return statement
	}
	public int getBalanceOfAccounts(){
		// TODO add implementation and return statement
	}
	public String getBankName(){
		// TODO add implementation and return statement
	}
	public String getIPAddress(){
		// TODO add implementation and return statement
	}
	public String getUsername(){
		// TODO add implementation and return statement
	}
	public String getPassword(){
		// TODO add implementation and return statement
	}
}
