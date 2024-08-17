package com.student.manage;


import java.util.Scanner;
public class Application {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int input =0; 
		
		System.out.println("----------Student Management Application----------");
		do
		{
			printMenu();			
			input=sc.nextInt();
			
			if(input==1)
				InsertStudent();
						
			else if(input==2)
				DisplayAll();
			
			else if(input==3)
				UpdateStudent();
			
			else if(input==4)
				DeleteStudent();
			
			else if(input==5)
				break;
			
			else {
				System.out.println("\nPlease enter correct option");
			}			
		}while(input!=5);
		
		System.out.println("\nThank you..!!!");
		
	}
	
	public static void printMenu()
	{
		System.out.println("-------------------------------------------------");
		System.out.println("1: Insert Student");
		//System.out.println("2: Display Student by Id");
		System.out.println("2: Display all Students");
		System.out.println("3: Update Student Information");
		System.out.println("4: Delete Student");
		System.out.println("5: Exit Application");
		System.out.println("-------------------------------------------------\n");
	}
	
	public static void InsertStudent()
	{
		Scanner sc = new Scanner(System.in);
		//Student sobj = new Student();
		
		System.out.println("-------------------------------------------------");
		System.out.println("Enter Student Id:");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Student Name:");
		String name = sc.nextLine();
		
		System.out.println("Enter student Phone Number:");
		String number = sc.nextLine();
		
		System.out.println("Enter Student City:");
		String city= sc.nextLine();
		System.out.println("-------------------------------------------------");
		Student sobj= new Student(id,name,number,city);
		Repository robj = new Repository();
		boolean flag = robj.InsertStudent(sobj);
		
		if(flag==true)
				System.out.println("Stdent Profile Created");
		else 
			System.out.println("Error Occured");
		System.out.println("-------------------------------------------------\n");
	}
	
		
	public static void DisplayAll()
	{
		Repository repo=new Repository();
		repo.DisplayAll();
	}
	
	public static void UpdateStudent()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("\n-------------------------------------------------");
		System.out.println("Enter the Id number of Student to Edit");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Student Name:");
		String name = sc.nextLine();
		
		System.out.println("Enter Student Phone Number:");
		String number = sc.nextLine();
		
		System.out.println("Enter Student City:");
		String city= sc.nextLine();
		System.out.println("-------------------------------------------------");
		Student obj=new Student(id, name, number, city);
		Repository repository = new Repository();
		boolean flag = repository.UpdateStudent(obj);
		
		if(flag==true)
			System.out.println("Student Profile Updated");
		else 
			System.out.println("Error Occured");
		System.out.println("-------------------------------------------------\n");
	}
	
	public static void DeleteStudent()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("\n-------------------------------------------------");
		System.out.println("Enter the Id number of Student");
		System.out.println("-------------------------------------------------\n");
		int id = sc.nextInt();
		sc.nextLine();
		Repository repository = new Repository();
		boolean flag = repository.DeleteStudent(id);
		System.out.println("-------------------------------------------------");
		if(flag==true)
			System.out.println("Student Profile Deleted");
		else 
			System.out.println("Error Occured");
		System.out.println("-------------------------------------------------\n");
	}
}
