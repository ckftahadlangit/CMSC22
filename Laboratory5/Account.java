/*
created by: cftahadlangit on 9/20/16
*/


public class Account{
	private int accountNumber;
	private double balance;

	public Account{
	private int accountNumber;
	private double balance = 0.0;

	public Account(int accountNumber, double balance){
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public Account(int accountNumber){
		this.accountNumber = accountNumber;
		this.balance = 0.0;
	}

	public int getAccountNumber(){
		return this.accountNumber;
	}

	public int getBalance(){
		return this.balance;
	}

	public void credit(double amount){
		this.balance += amount;
	}

	public void debit(double amount){
		if(balance >= amount){
			balance -= amount;
		}else{
			throw new IllegalArgumentException("Amount withdrawn exceeds the current balance!");
		}
	}

	public String toString(){
		String info = ("A/C no:%03d, Balance=%.3f", accountNumber, balance);
			return info;
	}
}