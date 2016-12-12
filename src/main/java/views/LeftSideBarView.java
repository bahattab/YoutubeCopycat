package main.java.views;
//import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.ImageIcon;


public class LeftSideBarView extends JPanel{
	
	public LeftSideBarView(){
		this.setSize(100,800);
		this.setLayout(new GridLayout(10,1));	
		ImageIcon icon = new ImageIcon("src/main/resources/icons/stats.png");
		JButton b1=new JButton("User");
		b1.setMaximumSize(new Dimension(80,30));
		JButton b2=new JButton(icon);
		b2.setMaximumSize(new Dimension(80,30));
		JButton b3=new JButton("Other");
		b3.setMaximumSize(new Dimension(80,30));
		this.add(b1);
		this.add(b2);
		this.add(b3);
		//this.add(Box.createHorizontalGlue());
	}

	
}
