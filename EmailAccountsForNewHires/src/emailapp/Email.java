package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity=500;;
	private int defaultPasswordLength=8;
	private String alternateEmail;
	private String companySuffix="hackroom.com";
	
	//Constructor to receive the first name and last name
	public Email()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter your Details");
		System.out.println("FirstName: ");
		this.firstName=in.nextLine();
		System.out.println("LastName: ");
		this.lastName=in.nextLine();
		
		//this.firstName=firstName;
		//this.lastName=lastName;
		//System.out.println("Email CREATED: "+this.firstName+" "+this.lastName);;
		
		//call a method asking for the department -return the department
		this.department=setDepartment();
		System.out.println("Department: "+this.department);
		
		// call a method that returns a random password
		this.password=randomPassword(defaultPasswordLength);
		System.out.println("Your passsword is: "+this.password);
		
		//Combine elements to generate email
		 email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department.substring(0,3)+"."+companySuffix;
		
		 // System.out.println("Your email is: "+email);
	}
	
	//Ask for the department
	private String setDepartment()
	{
		System.out.println("New worker: "+firstName.toUpperCase()+" "+lastName.toUpperCase());
		System.out.println("Enter Your Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\nEnter the Department: ");
		Scanner in=new Scanner(System.in);
		int depChoice=in.nextInt();
		if(depChoice==1) {return "Sales";}
		else if (depChoice==2) {return "Development";}
		else if (depChoice==3) {return "Accounting";}
		else {
			System.out.println("Please enter a valid key");
			return setDepartment(); 
			}
	}
	
	//Generate a random password 
	private String randomPassword(int length) {
		String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz!@#$%_";
		char[] password=new char[length];
		for (int i=0; i<length; i++)
		{ 
			int rand=(int)(Math.random()* passwordSet.length());
			password[i]=passwordSet.charAt(rand);
			
		}
		return new String(password);
	}
	
	
	
	//Set a mail box capacity
	public void setMailBoxCapacity(int capacity) {
		this.mailboxCapacity=capacity;
	}
	
	//Set alternative email
	public void setAlternateEmail(String altEmail)
	{
		this.alternateEmail=altEmail;
	}
	
	//Change the password
	public void changePassword(String password)
	{
		this.password=password;
	}
	
	public int getMailboxCapacity(){
		return mailboxCapacity;
	}
	
	public String getAlternativeEmail()
	
	{ 
		return alternateEmail;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String showInfo()
	{
		return "DISPLAY NAME: " +firstName.toUpperCase()+" "+lastName.toUpperCase()+"\n"+
				"COMPANY EMAIL: "+email+"\n"+
				"MAILBOX CAPACITY: "+mailboxCapacity+"mb";
	}

}
