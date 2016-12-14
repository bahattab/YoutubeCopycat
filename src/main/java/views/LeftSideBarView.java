package views;
//import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.AppController;

import javax.swing.Box;
import javax.swing.ImageIcon;


public class LeftSideBarView extends JPanel{
	
	public LeftSideBarView(final AppController app){
		this.setSize(100,800);
		this.setLayout(new GridLayout(10,1));	
		ImageIcon icon1 = new ImageIcon("src/main/resources/icons/home.png");
		ImageIcon icon2 = new ImageIcon("src/main/resources/icons/search.png");
		ImageIcon icon3 = new ImageIcon("src/main/resources/icons/local.png");
		ImageIcon icon4 = new ImageIcon("src/main/resources/icons/stats.png");
		JButton b1=new JButton(icon1);
		b1.setMaximumSize(new Dimension(80,30));
		JButton b2=new JButton(icon2);
		b2.setMaximumSize(new Dimension(80,30));
		JButton b3=new JButton(icon3);
		b3.setMaximumSize(new Dimension(80,30));
		JButton b4=new JButton(icon4);
		b3.setMaximumSize(new Dimension(80,30));
		b1.addMouseListener(new MouseAdapter(){
	    	@Override
	    	public void mousePressed(MouseEvent e){
	    		app.home();
	    	}
		});
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		//this.add(Box.createHorizontalGlue());
	}

	
}
