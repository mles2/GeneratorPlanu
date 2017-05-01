/**
 * File containing class used to define basic time option for project.
 * @author lesyeux
 */
import java.util.Scanner;

public class STime {
	
	private int hours; //hours variable, should be between 1-24
	private int minutes; //hours variable, should be between 0-59 
	
	/**
	 * Constructor setting up default time to 00:00.
	 */
	public STime(){
		hours = 0;
		minutes = 0;
	}
	
	/**
	 * Constructor setting up formatted time from string.
	 * @param String text containing time formatted as hh:mm.
	 */
	public STime(String string){
		setTime(string);
	}
	
	/**
	 * Method used to extract time from string.
	 * @param s Text containing time formatted as hh:mm.
	 */
	public void setTime(String s){
		s=s.replace('>', '0');
		Scanner scan = new Scanner(s);
		scan.useDelimiter(":");
		hours = scan.nextInt();
		minutes = scan.nextInt();
		scan.close();
	}
	
	/**
	 * Method used to have a String with time.
	 * @return String containing time in format hh:mm.
	 */
	public String toString(){
		return String.format("%02d:%02d", hours,minutes);
	}
}
