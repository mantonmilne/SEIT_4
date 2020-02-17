//Exercise for SEIT Week 3. Classes adapted from those for week2.
import java.io.PrintStream;

import office.Boss;
import office.Worker;
import people.Date;
import people.Lop;
import people.Person;

public class Test {

	public static void main(String[] args) throws CloneNotSupportedException { //because of clone method (of date class) now utilised in Person constructor, this Exception arises.
		
		//Setup printstream
		PrintStream printstream = new PrintStream(System.out);
		
		//Setup new LoP
		
		Lop compEmployees = new Lop();
		
		// Setup new persons and dates to serve as their dob.
		Date date1 = new Date(6,7,1960);
		Date date2 = new Date(6,7,1960);
		Date date3 = new Date(7,7,1977);
		Date date4 = new Date(18,2,2005);
		Date date5 = new Date(22,2,1984);
		Date date6 = new Date(14,7,1999);
		
		Person antonia = new Person("Antonia",date1);
		Person felipe = new Person("Felipe",date2);
		Person gus = new Person("Gus",date3);
		Person clair = new Person("Clair",date4);
		Person francesca = new Person("Francesca",date5);
		Person bill = new Person("Bill",date6);
		
		//Assign persons as workers and bosses
		Boss boAntonia = new Boss(antonia, compEmployees);
		Boss boBill = new Boss(bill, compEmployees);
		Worker woFelipe = new Worker(felipe, boAntonia, compEmployees);
		Worker woGus = new Worker(gus, boBill, compEmployees);
		Worker woClair = new Worker(clair, boAntonia, compEmployees);
		Worker woFrancesca = new Worker(francesca, boAntonia, compEmployees);
		
		//test assignation
//		boAntonia.print(printstream);
//		boBill.print(printstream);
//		woFelipe.print(printstream);
//		woGus.print(printstream);
//		woClair.print(printstream);
//		woFrancesca.print(printstream);
		
		//test cloning of dob in person
		Date current = new Date (17,2,2020);
		
		System.out.println(antonia.getAge(current)); //prints 59
		date1.changeYear(1959); //Antonia has realised her birth certificate was wrong. She's one year older!
		System.out.println(antonia.getAge(current)); //still prints 59. dob has been cloned in Person, and the changed info of dob is thus not tracked
		
		//now make a new antonia showing non-cloning dob
		date1.changeYear(1960); //reverts year for ease of testing
		Person antonia2 = new Person("Antonia2", date1, "TEST ONLY");
		
		System.out.println(antonia.getAge(current)); //prints 59
		System.out.println(antonia2.getAge(current)); //prints 59
		
		date1.changeYear(1959);
		System.out.println(antonia.getAge(current)); //prints 59
		System.out.println(antonia2.getAge(current)); //print 60
		//While antonia and antonia2 were both give date1 as dob, antonia's constructor clones the supplied dob, so does not track as the year value of dob
		//is changed, unlike in the case of antonia2.
		
		
		
		
//		//test listing in Lop
//		
//		System.out.println("\nIntroduce me to the employees of this company");
//		compEmployees.print(printstream);

			
	}
		//test code in support of SE_Lab3 (see below method hasSupervisee)
		//	//test reassignation
		//	
		//System.out.println("\nLet's check who Bill supervises.");		
		//hasSupervisee(boBill, printstream);
		//System.out.println("\nLet's check who Antonia supervises.");
		//hasSupervisee(boAntonia, printstream);
		//
		//System.out.println("\nReassigning Gus to be supervised by Antonia, then let's check both their list of supervisees now.");
		//woGus.new_boss(boAntonia);
		//hasSupervisee(boBill, printstream);
		//hasSupervisee(boAntonia, printstream);
	
	
	//method used to test working for SE_Lab3. Can no longer access .getName() as that has been set as protected to office package
	//as per requirements of SE_Lab4.
//	public static void hasSupervisee(Boss testCase, PrintStream printstream){
//		
//		Worker supervisee = testCase.next();
//		
//		while (supervisee != null) 
//		{
//			supervisee.print(printstream);
//			supervisee = testCase.next();
//		}
//			System.out.println("Can't find any(more) supervisees for " + testCase.getName() + ".");
//	}
		
}
	


