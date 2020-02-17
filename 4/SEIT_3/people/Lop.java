package people;
import java.io.PrintStream;
import java.util.ArrayList;


//Lop does not utilise clone() to clone the Person objects passed to it. 
//This is because you would want Lop to refer to the original Person object by reference,
//thus tracking any changes to that Person object.
//If you were to clone the person you also do not have a variable name with which to refer to them when calling a method like add or remove. 

public class Lop {
	
	private ArrayList<Person> listOfPeople = new ArrayList<Person>();
	
	public Lop() {
		//empty constructor
	}
	public void add(Person person) {
		// adds person to list
		listOfPeople.add(person);
		
	}

	public void remove(Person person) {
		//removes person from the list
		listOfPeople.remove(person);
	}
	
	public Person find(String name) {
		//finds first person with that name, return them, or null 
		for (Person person : listOfPeople) {
			if(person.getName().contains(name)) {
				return person;
			}
		}
		return null; // only reached if person with name not found by search.
	}
	
	public void print(PrintStream ps) {
		for (Person person : listOfPeople) {
			person.print(ps);
		}
	}
	
	
}
