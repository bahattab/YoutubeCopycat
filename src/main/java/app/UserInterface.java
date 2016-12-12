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
	LeftSideBarView left;
	RightSideBarView right;
	
	
	JPanel mainPanel;
	
	public UserInterface(){
		super("A Youtube Copycat");
		center=new CentralView();
		top=new TopView();
		bottom=new BottomView();
		left=new LeftSideBarView();
		right=new RightSideBarView();
		
		mainPanel=new JPanel();
		this.setPreferredSize(new Dimension(1500,1000));
		
		mainPanel.setLayout(new BorderLayout());
		
		mainPanel.add(center,BorderLayout.CENTER);
		mainPanel.add(top,BorderLayout.NORTH);
		mainPanel.add(bottom,BorderLayout.SOUTH);
		mainPanel.add(left,BorderLayout.WEST);
		mainPanel.add(right,BorderLayout.EAST);
		this.add(mainPanel);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	

}
