package main.java.app;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.java.views.*;

public class UserInterface extends JFrame {
	
	CentralView center;
	TopView top;
	BottomView bottom;
	
	JPanel mainPanel;
	
	public UserInterface(){
		super("A Youtube Copycat");
		center=new CentralView();
		top=new TopView();
		bottom=new BottomView();
		mainPanel=new JPanel();
		this.setPreferredSize(new Dimension(1500,1000));
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(center,BorderLayout.CENTER);
		mainPanel.add(top,BorderLayout.NORTH);
		mainPanel.add(bottom,BorderLayout.SOUTH);
		this.add(mainPanel);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	

}
