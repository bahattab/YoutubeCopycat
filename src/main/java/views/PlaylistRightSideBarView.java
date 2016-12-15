package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import app.AppController;
import elements.OurVideo;
import elements.Playlist;
import elements.PlaylistVideoComponent;
import elements.ClosePlaylistButton;
import elements.ImportPlaylistButton;
import elements.SavePlaylistButton;


public class PlaylistRightSideBarView extends JPanel{
	private Playlist playlist;
	private AppController app;
	private JPanel result;
	private JScrollPane jsc;
	ImportPlaylistButton importPlaylistButton;
	SavePlaylistButton savePlaylistButton;
	ClosePlaylistButton closePlaylistButton;
	//private Box bigvbox=Box.createVerticalBox();
	
	public PlaylistRightSideBarView(AppController app){
		super();
		this.setLayout(new BorderLayout());
		playlist = new Playlist();
		this.app=app;
		
		Box topPanel = Box.createVerticalBox();
		
		topPanel.add(new JLabel("Your Playlist"));
		Box hbox = Box.createHorizontalBox();
		importPlaylistButton = new ImportPlaylistButton(app);
		savePlaylistButton = new SavePlaylistButton(app);
		closePlaylistButton =  new ClosePlaylistButton(app);
		hbox.add(importPlaylistButton);
		hbox.add(savePlaylistButton);
		hbox.add(closePlaylistButton);
		topPanel.add(hbox);
		this.add(topPanel,BorderLayout.NORTH);
		
		
		this.result = new JPanel();
		result.setLayout(new FlowLayout(FlowLayout.CENTER));
		//result.setLayout(new BoxLayout(result,BoxLayout.Y_AXIS));
		result.setPreferredSize(new Dimension(335,100));
		jsc = new JScrollPane(result);
		this.add(jsc);
		
		JLabel label = new JLabel("You don't have any playlist yet");
		label.setHorizontalAlignment(WIDTH/2);
		result.add(label);
		jsc.setPreferredSize(new Dimension(355,100));
		//jsc.setMaximumSize(new Dimension(350,800));
		jsc.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//bigvbox.setSize(new Dimension(350,800));

		jsc.setPreferredSize(new Dimension(355,800));
		jsc.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		jsc.setVisible(true);
	}
	
	public Playlist getPlaylist(){
		return playlist;
	}
	
	public void updatePlaylist(OurVideo video) throws MalformedURLException, IOException{
		result.remove(label);
		if(!(playlist.existsIn(video))){
			playlist.addVideo(video);
			final PlaylistVideoComponent playlistComp = new PlaylistVideoComponent(playlist, video, app);
			playlistComp.addMouseListener(new MouseAdapter(){
		    	@Override
		    	public void mousePressed(MouseEvent e){
		    		app.readOurVideo(playlistComp.getVideo());
		    	}
		    });
			
			result.add(playlistComp);
			result.repaint();
			result.revalidate();
		}
		

	}
	public void remove(PlaylistVideoComponent pvc){
		playlist.removeVideo(pvc.getVideo());
		result.remove(pvc);
		result.repaint();
		result.revalidate();
	}

	public void setPlaylist(Playlist playlistChoice) {
		result.remove(label);
		playlist.removeAll();
		result.removeAll();
		if (playlistChoice!=null)
			for (OurVideo ov : playlistChoice.getVideos()){
				try {
					updatePlaylist(ov);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		result.repaint();
		result.revalidate();
		
		
	}
	
	public void toggleClose(){
		closePlaylistButton.doClick();
	}
	
	public void toggleSave(){
		savePlaylistButton.doClick();
	}

	
	

}

