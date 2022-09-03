package org.student.mangement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import student.mange.Student;
import student.mange.StudentDao;



public class App {
	public static void main(String[] args)throws IOException
	{
		System.out.println("Welcome to the Student Mangement App");
		boolean flag = true;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do {
			System.out.println("Press 1 for ADD student");
			System.out.println("Press 2 for delete student");
			System.out.println("Press 3 for display students info");
			System.out.println("Press 4 for exit the app");
			int choice = Integer.parseInt(br.readLine());
			switch(choice) {
			case 1:
				//add student.......
				System.out.println("Enter Student Name :");
				String name = br.readLine();
				System.out.println("Enter Student Phone No :");
				String phone = br.readLine();
				System.out.println("Enter Student City : ");
				String city = br.readLine();
				//create student object to store student
				Student st = new Student(name,phone,city);
				boolean answer = StudentDao.insertStudentToDB(st);
				if(answer)
					System.out.println("Student is added Successfully.....");
				else 
					System.out.println("Something went wrong, Try again..");
				break;
			case 2:
				
				break;
			case 3:
				break;
			case 4:
				flag = false;
			default:
				System.out.println("You have enter wrong input!!!!!!!!!");
				System.out.println("Try Again.....");
			}
			
		}while(flag);
	}
}
