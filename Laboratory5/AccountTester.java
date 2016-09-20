/*
created by cftahadlangit on 9/20/16
*/

/*
* This is a Test Driver for the Account class.
*/

public class AccountTester{
	public static void main(String[] args){
		
		Account acc = new Account();
		Account acc2 = new Account(123, 456.7);
		Account acc3 = new Account(123);

		System.out.println(acc);
		System.out.println(acc2);
		System.out.println(acc3);

		acc.setBalance(1000000);
		acc.credit(100);
		acc.debit(1500000);

		System.out.println(acc);
	}
}