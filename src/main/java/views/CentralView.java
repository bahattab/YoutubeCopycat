package views;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class CentralView extends JTabbedPane {
	
	private VideoTab videoTab;
	public VideoTab getVideoTab() {
		return videoTab;
	}
	//private VideoPanel video;
		
	public CentralView() {
		super();
		
		videoTab=new VideoTab();
		JPanel jplInnerPanel1 = videoTab;
		//jplInnerPanel1.add(video);
		this.addTab("Video Player", videoTab.getVideoIcon(), jplInnerPanel1);
		this.setSelectedIndex(0);
		
		SearchTab searchTab1=new SearchTab();
		JPanel jplInnerPanel2 = searchTab1;
		this.addTab("Search Results", searchTab1.getSearchIcon(), jplInnerPanel2);
	}
	
	protected JPanel createInnerPanel(String text) {
		JPanel jplPanel = new JPanel();
		JLabel jlbDisplay = new JLabel(text);
		jlbDisplay.setHorizontalAlignment(JLabel.CENTER);
		jplPanel.setLayout(new GridLayout(1, 1));
		jplPanel.add(jlbDisplay);
		return jplPanel;
	}

}
