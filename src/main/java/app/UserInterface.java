package app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		super("A YouTube Copycat");
		setLayout(new BorderLayout());
		JLabel background = new JLabel();
		background = new JLabel();
		java.net.URL u=UserInterface.class.getResource("/icons/Background.jpg");
		background.setIcon(new ImageIcon(u));
		
		this.app=app;
		center=new CentralView(app);
		top=new TopView(app);
		bottom=new BottomView();
		left=new LeftSideBarView(app);
		right=new PlaylistRightSideBarView(app);
		
		mainPanel=new JPanel();
		this.setPreferredSize(new Dimension(1800,900));
		background.setPreferredSize(new Dimension(1800,900));
		mainPanel.setPreferredSize(new Dimension(1550,825));

		mainPanel.setLayout(new BorderLayout());
		
		mainPanel.add(center,BorderLayout.CENTER);
		mainPanel.add(top,BorderLayout.NORTH);
		mainPanel.add(bottom,BorderLayout.SOUTH);
		mainPanel.add(left,BorderLayout.WEST);
		mainPanel.add(right,BorderLayout.EAST);
		mainPanel.setOpaque(false);
		
		background.setLayout(new BorderLayout());
		background.add(Box.createHorizontalStrut(50),BorderLayout.EAST);
		background.add(Box.createHorizontalStrut(50),BorderLayout.WEST);
		background.add(mainPanel,BorderLayout.CENTER);
		this.add(background);
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
