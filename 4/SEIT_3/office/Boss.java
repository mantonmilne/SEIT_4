package office;


import java.io.PrintStream;
import java.util.ArrayList;

import people.Lop;
import people.Person;

public class Boss {

	private ArrayList<Worker> supervisees = new ArrayList<Worker>();
	private Person self;
	private int superviseeIndex = 0;
	
	
	public Boss(Person b, Lop allEmployees) {
		self = b;
		allEmployees.add(self);
	}

	protected void add_worker(Worker worker) { //set as protected to restrict access to classes in same package. 
		
		supervisees.add(worker);
				
	}
	
	
	protected void sub_worker(Worker worker) { //set as protected to restrict access to classes in same package.
		
		supervisees.remove(worker); 
		
	}
	
	public void print (PrintStream ps) {
		
		ps.println(getName() + " is a boss");
		
	}
	//method to get the next supervisee in the list.
	public Worker next() {
		
		if (superviseeIndex >= supervisees.size()) {
			this.reset();
			return null;
		}
		
		Worker workerToReturn = supervisees.get(superviseeIndex);
		superviseeIndex++;
		
		return workerToReturn;
		
	}
	//reset the index tracker to return to the beginning of the list of supervisees.
	public void reset() {
		superviseeIndex = 0;
	}
	
	protected String getName() { //set as protected to restrict access to classes in same package.
		
		return self.getName(); 
	}
	
}

