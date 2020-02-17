package people;
import java.io.PrintStream;

public class Date implements Cloneable { // implements Cloneable to allow Person to make clone of a date (dob). 
	
	private int day;
	private int month;
	private int year;
	
	public Date (int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
		}
	
	
	public void print (PrintStream ps) {
		
		ps.println();
		
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public int diffInYears(Date date) {
		int diff;
		diff = date.year - this.year;
		
		if (diff<0) {
			diff = diff * -1; //flips a negative to a positive.
		}
		
		if (date.month>this.month) {
			return diff;
		} else if (date.month==this.month && this.day>date.day) {
					diff--;
				}else if (date.month<this.month) {
					diff--;
				}
			return diff;
	}
	
	public Date clone() throws CloneNotSupportedException {
		return (Date)super.clone();
	}
	
	
	//new method for testing cloning of dob by Person class for SE_Lab 4.
	public void changeYear(int newYear)
	{
		this.year = newYear;
	}
	
}
