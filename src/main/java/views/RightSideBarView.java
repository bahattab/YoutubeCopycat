package main.java.views;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RightSideBarView extends JPanel{
	private Box sideBox;
	
	public RightSideBarView(){
		super(new FlowLayout(FlowLayout.RIGHT));
		sideBox = Box.createVerticalBox();
		sideBox.setPreferredSize(new Dimension(320,800));
		JButton b = createNewPreference("first button");
		sideBox.add(b);
		this.add(sideBox);
	}
	
	public Box getSideBox() {
		return sideBox;
	}

	public JButton createNewPreference(String text){
		JButton newButton = new JButton();
		newButton.setText(text);
		newButton.setMaximumSize(new Dimension(500,30));
		return newButton;
	}
	

}
