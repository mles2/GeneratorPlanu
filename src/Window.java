
/**
 * @author lesyeux
 */
import java.awt.FlowLayout; //Basic Layout of System
import java.awt.event.ActionListener; //Listener of handlers
import java.awt.event.ActionEvent; // Listener of events
import javax.swing.JFrame; //Basic GUI
import javax.swing.JTextField; //Basic Text Fields
//import javax.swing.JPasswordField; // Basic Password Fields
import javax.swing.JOptionPane;// Basic Dialog Box
import javax.swing.JLabel; // Basic Label class
import java.io.*;
import java.net.*;
//import java.util.LinkedList;
import javax.swing.JComponent;
/*
 * window - class generating basic window with basic fields
 */
public class Window extends JFrame{
	private JLabel s1; //first information (about empty field)
	private JTextField item1; //empty editable text box
	private Link l1; //link included ;) 
	private static final long serialVersionUID = 42L; //serialization item
	private Analysis a; //object containing analysis of downloaded site
	
	/**
	 * Contructor used to generate basic Window prompting for link
	 */
	public Window ()
	{
		super("Generator Planu - Interfejs"); //name of generated window
		setLayout(new FlowLayout()); //setting up the layout

		//setting up first information
		s1 =new JLabel ("Wklej link w poniższe pole");
		add(s1);
		
		//setting up empty text field
		item1 = new JTextField(10);
		add(item1);
		
		
		//generating new handler (defined later)
		thehandler handler = new thehandler();
		item1.addActionListener(handler); //handler for first one

		
		//setting tool tip texts
		item1.setToolTipText("Pole do wpisania linku ");
		
		
	}
	
	/**
	 * method used to get the original link String
	 * @return String with text
	 */
	private String getLinkString(){
		return item1.getText();
	}
	
	/**
	 * method used to return link object
	 * @return member of Link class
	 */
	public Link getLink(){
		return l1;
	}
	
	/**
	 * Method used to add JFrame Object into current window
	 * (useful when you have to communicate with other non-corelated objects)
	 * @param t
	 */
	public void addJObject (JComponent t)
	{
		add(t);
	}
	
	/**
	 * 
	 * @author lesyeux
	 * thehandler - class used to implement ActionListener interface
	 */
	private class thehandler implements ActionListener{
		
		/**
		 * implementation of actionPerformed 
		 * @param event - event responsible for triggering dialog
		 */
		public void actionPerformed(ActionEvent event){
			String string = "";
			
			if(event.getSource()==item1)
			{
				string = String.format("Zapisano link 1: \n %s ", event.getActionCommand());
				l1 = new Link(getLinkString());
			}			
			
			JOptionPane.showMessageDialog(null,string+"\nKod grupy: "+l1.getSubject()+ 
					"\n Kod html:" +l1.getHTMLLink());
			//you need to try to get the HttpFile here
			HttpFile hf;
			try {
				hf = new HttpFile(new URL(l1.getHTMLLink()));
				try {
					String content = new String(hf.getData(), hf.getEncoding());
					a = new Analysis(content);
					a.getClass();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
}

