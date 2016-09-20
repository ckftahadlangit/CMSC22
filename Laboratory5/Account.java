/*
created by: cftahadlangit on 9/20/16
*/
public class Account{
	private int accountNumber;
	private double balance;

	public Account(){
		int accountNumber = 0;
		double balance = 0.0;
	}
	
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

	public double getBalance(){
		return this.balance;
	}

	public double setBalance(double balance){
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
		return String.format("A/C no:%03d Balance=%.2f", this.accountNumber, this.balance);
	}
}
