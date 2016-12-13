package views;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import app.AppController;
import app.UserInterface;

public class CentralView extends JTabbedPane {
	
	private SearchTab searchTab;
	private AppController app;
	//private VideoPanel video;
		
	public CentralView(AppController app) {
		super();
		this.app=app;
		VideoTab  vidTab1=new VideoTab();
		JPanel jplInnerPanel1 = vidTab1;
		//jplInnerPanel1.add(video);
		this.addTab("Video Player", vidTab1.getVideoIcon(), jplInnerPanel1);
		this.setSelectedIndex(0);
		
		searchTab=new SearchTab();
		JPanel jplInnerPanel2 = searchTab;
		this.addTab("Search Results", searchTab.getSearchIcon(), jplInnerPanel2);
	}
	
	protected JPanel createInnerPanel(String text) {
		JPanel jplPanel = new JPanel();
		JLabel jlbDisplay = new JLabel(text);
		jlbDisplay.setHorizontalAlignment(JLabel.CENTER);
		jplPanel.setLayout(new GridLayout(1, 1));
		jplPanel.add(jlbDisplay);
		return jplPanel;
	}
	
	public SearchTab getSearchTab(){
		return searchTab;
	}

}
