import java.util.Scanner;

public class Subject {
	STime start_time;
	STime end_time;
	String day;
	
	String name;
	String staff;
	String group;
	String type;
	String place;
	
	public Subject(String s){
	/*
	 * 10:30-12:00, gr.1</span><div style='text-align:center;margin:10px 0'>
	 * Biochemia - Wykład (1.14), Anna Lityńska
	 */
	Scanner scan = new Scanner(s);
	//scan.useDelimiter(">? .*-.* , .*<.*>.* - .* .*, .*");
	//scan.useDelimiter("\\s*-\\s*|\\s,\\s|\\s</span>\\s*>\\s");
	scan.useDelimiter("\\s*-\\s*|</span><(.*)>|\\s*,\\s*");
	start_time = new STime(scan.next());//rozpoczecie
	end_time = new STime(scan.next());//zakonczenie
	group = scan.next();
	//scan.next();//pusty
	name = scan.next();//nazwa przedmiotu
	scan.useDelimiter(" ");
	type = scan.next();//typ
	place = scan.next();//miejsce
	
	//scan.useDelimiter(", ");
	scan.reset();
	//System.out.println(scan.next());
	staff = scan.nextLine();//prowadzacy
	
	
	scan.close();
	}
	/**
	 * constructor used to temporary define the location of Subject string in the 
	 * program to gain knowledge about day of week 
	 * (doesn't work - probably should be deleted)
	 * @param s
	 * @param num1
	 * @param num2
	 */
	public Subject(String s, int num1, int num2)
	{
		Scanner scan = new Scanner(s);
		//special regular expression used to seperate informations
		scan.useDelimiter("\\s*-\\s*|</span><(.*)>|\\s*,\\s*");
		start_time = new STime(scan.next());//start time
		end_time = new STime(scan.next());//end time
		group = scan.next(); //number of group 
	
		name = scan.next();//subject name
		scan.useDelimiter(" "); //adding delimiter to gain type and place
		type = scan.next();//type of subject
		place = scan.next();//place of subject
		
		scan.reset(); //reset of delimiters
		staff = scan.nextLine();//all course masters
		
		
		scan.close();
		if(num1<1500)
			day = "Poniedziałek";
		else if (num1<3000)
			day = "Wtorek";
		else if (num1<4500)
			day = "Środa";
		else if (num1<6000)
			day = "Czwartek";
		else if (num1<7500)
			day = "Piątek";
		else 
			day = "NIEWIADOMO";
		
	}
	/**
	 * Constructor used for initialization of object outside
	 * @param astart
	 * @param aend
	 * @param aday
	 * @param aname
	 * @param astaff
	 * @param agroup
	 * @param atype
	 * @param aplace
	 */
	public Subject(STime astart, STime aend, String aday, String aname,
	String astaff,String agroup,String atype,String aplace){
		start_time = astart;
		end_time=aend;
		day=aday;
		
		name = aname;
		staff = astaff;
		group = agroup;
		type = atype;
		place = aplace;
	}
	
	/**
	 * Method displaying information about subject in System.out
	 */
	public void displayInformation(){
		System.out.println(day + " "+start_time.toString()+" "+end_time.toString()+
				" "+ group + " "+ name + " " + type + " " + place + " "+staff+ "\n" );
		}
	
}