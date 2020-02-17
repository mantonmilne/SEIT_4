package office;
import java.io.PrintStream;

import people.Lop;
import people.Person;

public class Worker {

	private Person self;
	private Boss supervisor;
	
	public Worker(Person worker, Boss boss, Lop allEmployees) {
		
		self = worker;
		supervisor = boss;
		supervisor.add_worker(this); //communicates to a protected method in Boss.
		allEmployees.add(self);
		
		
	}
	
	public Boss get_boss() {
		
		return supervisor;
		
	}
	
	//sets a new boss for this worker.
	public void new_boss(Boss newBoss) {
						
		get_boss().sub_worker(this); 	//communicates to a protected method in Boss.
		newBoss.add_worker(this); 		//communicates to a protected method in Boss.
		supervisor = newBoss;
			
	}
		
		public void print (PrintStream ps) { //communicates to a protected method in Boss.
			
			ps.println(self.getName() + " is a worker, whose supervisor is " + get_boss().getName());
			
		}
		
	public Person get_self() {
		return this.self;
	}
	
}
