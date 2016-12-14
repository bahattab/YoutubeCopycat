package app;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import views.*;

public class UserInterface extends JFrame {
	
	CentralView center;
	TopView top;
	BottomView bottom;
	LeftSideBarView left;
	PlaylistRightSideBarView right;
	JPanel mainPanel;
	AppController app;
	
	public UserInterface(AppController app){
		super("A Youtube Copycat");
		this.app=app;
		center=new CentralView(app);
		top=new TopView(app);
		bottom=new BottomView();
		left=new LeftSideBarView(app);
		right=new PlaylistRightSideBarView(app);
		
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

	public CentralView getCenter() {
		return center;
	}
	
	public AppController getApp(){
		return app;
	}

	public TopView getTop() {
		return top;
	}

	public BottomView getBottom() {
		return bottom;
	}

	public LeftSideBarView getLeft() {
		return left;
	}

	public PlaylistRightSideBarView getRight() {
		return right;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}
	
	

}
