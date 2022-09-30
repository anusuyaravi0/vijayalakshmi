package ui;
import java.util.Scanner;

import entity.Account;
public class bankwebsite2 {
private static final int Amount = 0;
	
	Account allAccounts[] = new Account[50000];
	int nooOfAccountEntry = 0;
	
	Scanner sc = new Scanner(System.in);
	Scanner scStr = new Scanner(System.in);

	public static void main(String[] args) {
		
		bankwebsite2 bankApp = new bankwebsite2();
		
		while(true)
		{
		
		System.out.println("\n\n\n\n ===== WebSite links (actions what user can do) ==== ");
		System.out.println("1. create Account. ");
		System.out.println("2. Display All Account ");
		System.out.println("3. Display Account based on ID ");
		System.out.println("4. Check Balance by Account Number ");
		System.out.println("5. Fund Transfer ");
		System.out.println("6. Deposit Amount ");
		System.out.println("7. Withdrawl Amount ");
		System.out.println("0. EXIT");

		System.out.println(" Enter option [0-7] :- ");

		switch (new Scanner(System.in).nextInt()) {

		case 0:
			System.exit(0);
			break;

		case 1:
			bankApp.createAccount();
			break;

		case 2:
			bankApp.displayAllAccounts();
			break;

		case 3:
			//bankApp.displayAccountBasedOnId();
			break;

		case 4:
			bankApp.checkBalance();
			break;

		case 5:
			bankApp.fundTransfer();
			break;
		case 6:
			bankApp.depositAmount();
			break;
		case 7:
			bankApp.withdrawlAmount();
			break;
	
	
            default:
			System.out.println("Invalid Option ...");
		} //end switch

	}//end of while

}//
	
	
		
	

	public void printAccountDetails(Account a)
{
	System.out.print("\n"+a.getAccountNumber()+"\t");
	System.out.print(a.getAccountHolderName()+"\t");
	System.out.print(a.getBalance()+"\t");
	System.out.println(a.getlocation()+"\t");
	System.out.println("\n---------------------------------------------\n");

}


     public void displayAllAccounts() {

	for(int i = 0;i< nooOfAccountEntry ;i++)
	{
		Account a = allAccounts[i];
		printAccountDetails(a);
	}
}

     public void createAccount()
{
	// take user input and set in the array 

	System.out.println(" Enter Account Number ");
	int accNumber = sc.nextInt();

	System.out.println(" Enter Account Holder Name :- ");
	String accHolderName = scStr.nextLine();

	System.out.println(" Enter Account Initial Balance:- ");
	int balance = sc.nextInt();

	allAccounts[nooOfAccountEntry++] = new Account(accNumber, accHolderName, balance);


     }

    public void checkBalance()
    {
	// take user input as account number and render account balance;
	System.out.println(" Enter Account Number to check Balance ");
	int searchAccountNumber = sc.nextInt(); // 103

	boolean accountFound = false;

	for(int i = 0;i< nooOfAccountEntry ;i++)
	{
		Account a = allAccounts[i];

		if(a.getAccountNumber() == searchAccountNumber)
		{
			System.out.println(" Current Balance :- "+a.getBalance()+" \n ");
			accountFound = true;
			break;
		}

	}

	if(accountFound == false)
	{
		System.out.println(searchAccountNumber+" is Inavlid account number ");
	}


}

     public void fundTransfer()
    {
	// take user input such as account id , payeeId & amount 
	System.out.println("\n ======== Fund Transfer Use Case ==============\n");

	System.out.println(" Enter Account Owner Number ");
	int accNumber = sc.nextInt();

	System.out.println(" Enter Payee Account Number ");
	int payeeAccNumber = sc.nextInt();

	System.out.println(" Enter Amount to be Transfered :-  ");
	int amount  = sc.nextInt();


	Account ownerAccount = null;
	boolean foundOwnerAccount = false;
	Account payeeAccount = null;
	boolean foundPayeeAccount = false;

	for(int i = 0;i< nooOfAccountEntry ;i++)
	{
		Account a = allAccounts[i];
		if(a.getAccountNumber() == accNumber)
		{
			ownerAccount = a;
			foundOwnerAccount = true;
		}
		if(a.getAccountNumber() == payeeAccNumber)
		{
			payeeAccount = a;
			foundPayeeAccount = true;
		}

		if(foundOwnerAccount && foundPayeeAccount)
		{
			break; // no need to iterate loop further as we got both accounts
			// otherwise , it slow down the application
		}

	}

	if(foundOwnerAccount && foundPayeeAccount)
	{
		ownerAccount.setBalance(ownerAccount.getBalance()-amount);
		payeeAccount.setBalance(payeeAccount.getBalance()+amount);

		System.out.println(" Fund Transfer Done ");
		System.out.println(" Cheack Balance ");
		System.out.println(ownerAccount.getAccountNumber()+" - "+ownerAccount.getBalance());
		System.out.println(payeeAccount.getAccountNumber()+" - "+payeeAccount.getBalance());

	}
    }
	
	 public void depositAmount() 
	 
	
	{
		 System.out.println("\n ======== Deposit Amount Use Case ==============\n");
		System.out.println(" Enter Account Number in which should deposit: ");
		int accNumber = sc.nextInt();

		System.out.println(" Enter Amount to be deposited ");
		int amount= sc.nextInt();

		Account Account = null;
		boolean OwnerAccount = false;
		
		for(int i = 0;i< nooOfAccountEntry ;i++)
		{
			Account a = allAccounts[i];
			if(a.getAccountNumber() == accNumber)
			{
				Account = a;
				OwnerAccount = true;
			}
			
			if(OwnerAccount)
			{
				Account.setBalance(Account.getBalance()+Amount);
				
			}
			if(OwnerAccount)
			{
				break;
			}

		}
		if(OwnerAccount)
			{
			System.out.println(" Successfully Amount is deposited ");
			System.out.println(" Cheack Balance ");
			System.out.println(Account.getAccountNumber()+" - "+Account.getBalance());
			
			}
		
	
	}
	 


	 public void withdrawlAmount() 
	 
		
		{
			 System.out.println("\n ======== Withdraw Amount Use Case ==============\n");
			System.out.println(" Enter Account Number to Withdraw Amount: ");
			int accNumber = sc.nextInt();

			System.out.println(" Enter Amount to be Withdraw: ");
			int amount= sc.nextInt();

			Account Account = null;
			boolean OwnerAccount = false;
			
			for(int i = 0;i< nooOfAccountEntry ;i++)
			{
				Account a = allAccounts[i];
				if(a.getAccountNumber() == accNumber)
				{
					Account = a;
					OwnerAccount = true;
				}
				
				if(OwnerAccount)
				{
					Account.setBalance(Account.getBalance()+Amount);
					
				}

			}
			if(OwnerAccount)
				{
				System.out.println(" Successfully Amount is withdrawed: ");
				System.out.println(" Cheack Balance ");
				System.out.println(Account.getAccountNumber()+" - "+Account.getBalance());
				
				}
			
		
		}
}