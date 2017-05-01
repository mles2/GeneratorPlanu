//to set up EXIT_zON_CLOSE
import javax.swing.JFrame;
import java.net.*;
import java.io.*;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JTextField;

public class Application {
	/**
	 * \brief Method with main function
	 * \param[in] args arguments from outside to use in program
	 */
	public static void main(String[] args) throws IOException, MalformedURLException{
		

		//DEFINITION OF WINDOW 1 (w1)
		//object generating new window including interface
		Window w1 = new Window();
		SubjectWindow w2 = new SubjectWindow();
		//needed for proper termination
		w1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//visibility
		w1.setVisible(true);
		w2.setVisible(true);
		//geometry of window
		w1.setSize(350, 50);	

		
//		SubjectWindow window1 = new SubjectWindow();
//		window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window1.setVisible(true);
	}
}
