package views;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class CentralView extends JTabbedPane {
	
	//private VideoPanel video;
		
	public CentralView() {
		super();
		String vidIconPath="src/main/resources/icons/video.png";
		ImageIcon videoIcon = new ImageIcon(vidIconPath);
		JPanel jplInnerPanel1 = createInnerPanel("Video : ");
		//jplInnerPanel1.add(video);
		this.addTab("Video Player", videoIcon, jplInnerPanel1);
		this.setSelectedIndex(0);
		String srchIconPath="src/main/resources/icons/search.png";
		ImageIcon searchIcon = new ImageIcon(srchIconPath);
		JPanel jplInnerPanel2 = createInnerPanel("Seach Results: ");
		this.addTab("Search Results", searchIcon, jplInnerPanel2);
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
