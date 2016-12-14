package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import app.AppController;
import elements.OurVideo;
import elements.OurVideoComponent;
import elements.Playlist;
import elements.PlaylistVideoComponent;


public class PlaylistRightSideBarView extends JPanel{
	private Playlist playlist;
	private AppController app;
	private JPanel result;
	private JScrollPane jsc;
	private Box bigvbox=Box.createVerticalBox();
	
	public PlaylistRightSideBarView(AppController app){
		super(new FlowLayout(FlowLayout.RIGHT));
		playlist = new Playlist();
		this.app=app;
		result = new JPanel();
		result.setSize(new Dimension(350, 800));
		jsc = new JScrollPane(result);
		this.add(jsc);

		jsc.setPreferredSize(new Dimension(350,800));
		jsc.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		bigvbox.setSize(new Dimension(350,800));
		jsc.setVisible(true);
	}
	
	public Playlist getPlaylist(){
		return playlist;
	}
	
	public void updatePlaylist(OurVideo video) throws MalformedURLException, IOException{
		if(!(playlist.existsIn(video))){
			playlist.addVideo(video);
			final PlaylistVideoComponent playlistComp = new PlaylistVideoComponent(playlist, video, app);
			playlistComp.addMouseListener(new MouseAdapter(){
		    	@Override
		    	public void mousePressed(MouseEvent e){
		    		app.readOurVideo(playlistComp.getVideo());
		    	}
		    });
			playlistComp.setAlignmentX(0);
			bigvbox.add(playlistComp);
			result.add(bigvbox);
			result.repaint();
			result.revalidate();
		}
	}

	public JButton createNewPreference(String text){
		JButton newButton = new JButton();
		newButton.setText(text);
		newButton.setMaximumSize(new Dimension(500,30));
		return newButton;
	}
	

}

