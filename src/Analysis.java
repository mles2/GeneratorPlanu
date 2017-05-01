/**
 * 
 * @author lesyeux
 *	File including definition of class Analysis used to find information in strings
 */
import java.util.LinkedList;
public class Analysis {
	private String original;//original string gained from the user
	private String preprocessed; //firstly parsed information
	private LinkedList<String> list; //information in separate strings
	private LinkedList<Subject> subjects;//information in separate subjects
	
	/**
	 * Contructor ran to do execute basic methods in this module
	 * @param s String with html content 
	 */
	public Analysis(String s){
		original = s;
		preprocessed = preprocess(s);
		extractStrings();
	}
	
	/**
	 * Method preprocessing html site to gain block with useful informations
	 * @param s String containing html site
	 * @return String containing block with information
	 */
	public String preprocess(String s){
		int ind1 = s.indexOf("</script></td>");
		int ind2 = s.indexOf("</a></b></td></tr></table></div>");
		//System.out.println(s.substring(ind1,ind2));
		System.out.printf("%d to %d \n",ind1,ind2);
		return s.substring(ind1, ind2);
		
	}
	
	/**
	 * Method used to get preprocessed string to check what's going on
	 * @return processed value
	 */
	public String getUsefulString()
	{
		return preprocessed;
	}
	
	/**
	 * Method used to get original value (probably don't needed, and  should be deleted)
	 * @return String containing original html site
	 */
	public String getOriginalString()
	{
		return original;
	}
	
	/**
	 * Method extracting subjects information into separate strings
	 */
	public void extractStrings()
	{
		list = new LinkedList<String>();
		subjects = new LinkedList<Subject>();
		//temporary list used to gather information about indexes
		LinkedList<Integer> temp1 = new LinkedList<Integer>();
		LinkedList<Integer> temp2 = new LinkedList<Integer>();
		
		LinkedList<Integer> kolumny = new LinkedList<Integer>();//numer znaczników <td> w html

		kolumny.add(0);
		while(kolumny.getLast()!=-1){
			kolumny.add(preprocessed.indexOf("<td",kolumny.getLast()+1));
		}
		
		LinkedList<Integer> wiersze = new LinkedList<Integer>();//numer znaczników <td> w html

		wiersze.add(0);
		while(wiersze.getLast()!=-1){
			wiersze.add(preprocessed.indexOf("<tr",wiersze.getLast()+1));
		}
		for (int i=0; i<kolumny.size();i++)
			System.out.printf("%4d ",i);
	
		System.out.println(" ");
		System.out.println(kolumny.toString());
		System.out.println(wiersze.toString());
		
		temp1.add(0);
		temp2.add(0);
		while(temp1.getLast()!=-1){
			temp1.add(preprocessed.indexOf("</span><div style='text-align:center;margin:10px 0'>",temp1.getLast()+1));
			temp2.add(preprocessed.indexOf("</div>",temp1.getLast()+1));
		}
		//deleting wastes
		temp1.removeLast(); temp2.removeLast();
		temp1.removeFirst(); temp2.removeFirst();
		
		System.out.println(temp1.toString());
	/*
		LinkedList<Integer> diff = new LinkedList<Integer>();
		for (int i=0;i<temp1.size();i++)
			for (int j=0; j<hours.size(); j++)
				diff.add(temp1.get(i)-hours.get(j));
		
		for (int i=0; i<temp1.size(); i++){
			
			for (int j=0; j<hours.size(); j++){
				System.out.print(diff.get(i*j+j));
				System.out.print(" #");
				System.out.print(i*j+j);
				System.out.print("# ");
			}
			System.out.println("");
		}
		*/
		for (int i=0; i<temp1.size();i++){
			list.add(preprocessed.substring(temp1.get(i)-17,temp2.get(i)));
		}
		//System.out.println(list.toString());
		
		for (int i=0; i<list.size(); i++)
			subjects.add(new Subject((list.get(i)),temp1.get(i),temp2.get(i)));
		
		for (int i=0; i<subjects.size(); i++)
			subjects.get(i).displayInformation();
		
	}
}
