package views;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Home extends JPanel{


	public Home(){
		String message = "To use this application, you can \n do something \n do something";
		JOptionPane.showMessageDialog(null, message, "Use conditions",1);
	}
	
	public static void main(String[] args) {
		Home home = new Home();
	}
}
