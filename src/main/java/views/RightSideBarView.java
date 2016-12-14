package views;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import elements.Playlist;


public class RightSideBarView extends JPanel{
	private Box sideBox;
	private Playlist playlist;
	
	public RightSideBarView(){
		super(new FlowLayout(FlowLayout.RIGHT));
		playlist = new Playlist();
		sideBox = Box.createVerticalBox();
		sideBox.setPreferredSize(new Dimension(320,800));
		JButton b = createNewPreference("first button");
		sideBox.add(b);
		this.add(sideBox);
	}
	
	public Box getSideBox() {
		return sideBox;
	}
	
	public Playlist getPlaylist(){
		return playlist;
	}

	public JButton createNewPreference(String text){
		JButton newButton = new JButton();
		newButton.setText(text);
		newButton.setMaximumSize(new Dimension(500,30));
		return newButton;
	}
	

}
