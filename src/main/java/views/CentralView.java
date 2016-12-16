package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import app.AppController;

public class CentralView extends JTabbedPane {
	

	private SearchTab searchTab;
	private AppController app;
	private VideoTab videoTab;
	private PlaylistTab playlistTab;
	
	public VideoTab getVideoTab() {
		return videoTab;
	}
		
	public CentralView(AppController app) {
		super();
		this.setMaximumSize(new Dimension(1500,800));
		this.app=app;
		this.setBackground(new Color(150,150,150));
		videoTab=new VideoTab(app);
		JPanel jplInnerPanel1 = videoTab;
		this.addTab("Video Player", videoTab.getVideoIcon(), jplInnerPanel1);
		
		this.setSelectedIndex(0);
		
		searchTab=new SearchTab(app);
		JPanel jplInnerPanel2 = searchTab;
		this.addTab("Search Results", searchTab.getSearchIcon(), jplInnerPanel2);
	
		playlistTab = new PlaylistTab(app);
		JPanel jplInnerPannel3 = playlistTab;
		this.addTab("My Playlists", playlistTab.getPlaylistIcon(),jplInnerPannel3);
		
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
	


	public PlaylistTab getPlaylistTab() {
		return playlistTab;
	}

}
