import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import java.util.LinkedList;

public class SubjectWindow extends JFrame {
	private static final long serialVersionUID = 43L;
	private JTextField interpreter;
	private LinkedList<JTextField> listOfLinks;
	private LinkedList<JButton> listOfButtons;
	private int number_of_elements;
	Catcher c;
	
	/**
	 * Constructor used to generate basic window of the program
	 * Problems: 
	 * -something wrong with refreshing
	 * *try with changing size and search for refresh method
	 * -problem with Layout class (generating new widgets next to another)
	 * *probably FlowLayout object is not compatible with another objects from Swing and JFrame - need something less universal, but specific for inter-system operation
	 * -
	 */
	public SubjectWindow(){
	
		
		super("Subject Window");
		setLayout(new FlowLayout());
		setSize(300,300);
		
		setAutoRequestFocus(true);
		number_of_elements = 0;

		
		interpreter = new JTextField(20);
		interpreter.setEnabled(true);
		add(interpreter);
		c = new Catcher();
		
		interpreter.addActionListener(c);
		setVisible(true);
		listOfLinks = new LinkedList<JTextField>();
		listOfButtons = new LinkedList<JButton>();
		setVisible(true);
	}
	
	
	public void doCommand(String command){
		JOptionPane.showMessageDialog(null, command);
		
		JTextField temp = new JTextField(10);
		temp.setText(command);
		listOfLinks.add(temp);
		
		
		JButton temp_button = new JButton("DELETE");
		temp_button.addMouseListener(new MouseCatcher(number_of_elements));
		listOfButtons.add(temp_button);
		number_of_elements++;
		
		add(listOfLinks.getLast());
		add(listOfButtons.getLast());
		setVisible(true);
		
	}
	
	private class MouseCatcher implements MouseListener{

		private int num;
		
		public MouseCatcher(int n){
			num = n;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			setVisible(true);
			JOptionPane.showMessageDialog(null,"Deleted! "+ listOfLinks.get(num).getText());
			remove(listOfLinks.get(num));
			remove(listOfButtons.get(num));
			setSize(300,300);
			setVisible(true);
			
			
	   
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		} 
	}
	
	private class Catcher implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource()==interpreter)
			{
				doCommand(interpreter.getText());
				
			}
		}
	}
	

}
