package people;
import java.io.PrintStream;

public class Person {  
	
	private String name;
	private Date dob;

	//constructor now clones dob object passed to it (relies upon Date implementing Cloneable)
	public Person(String name, Date dob) throws CloneNotSupportedException {
		this.dob = dob.clone();
		this.name = name;
		
	}
	
	//additional constructor added for the purposes of testing SE_Lab4. String test does nothing, used to distinguish constructors.
	public Person(String name, Date dob, String test )
	{
		this.dob = dob;
		this.name = name;
	}

	//method to print out name and date of birth
public void print (PrintStream ps) {
		
		ps.printf("This person is called %s and their date of birth is %d-%d-%d\n", name, dob.getDay(), dob.getMonth(), dob.getYear());
		
	}

	public String getName() {
		return name;
	}

	public int getAge(Date currentDate) {
		
		int age = dob.diffInYears(currentDate);
		return age;
	}


}



