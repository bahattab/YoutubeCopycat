
//import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;


public class LeftSideBarView extends JPanel{
	
	public LeftSideBarView(){
		this.setSize(300,300);
		this.setLayout(new GridLayout(3,1));	
		ImageIcon icon = new ImageIcon("src/main/resources/icons/stats.png");
		this.add(new JButton("User"));
		this.add(new JButton(icon));
		this.add(new JButton("Other"));
	}
	/*
	public static void main(String[] args){
		JFrame truc = new JFrame();
		LeftSideBarView V = new LeftSideBarView();
		truc.add(V);
		truc.pack();
		truc.setVisible(true);
		System.out.println("truc");
		truc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	*/
	
}
