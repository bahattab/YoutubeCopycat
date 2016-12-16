package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

	//JLabel label;
	//private Box bigvbox=Box.createVerticalBox();

	private Box bigvbox;
	Color backgroundColor;
	
	public PlaylistRightSideBarView(AppController app){
		super();
		this.setLayout(new BorderLayout());
		playlist = new Playlist();
		this.app=app;

		this.setOpaque(false);
		backgroundColor = new Color(255,255,255,100);
		//this.setBackground(backgroundColor);
		bigvbox = Box.createVerticalBox();
		//bigvbox.setBackground(backgroundColor);
		bigvbox.setOpaque(false);
		Box topPanel = Box.createVerticalBox();
		
		Box hboxtitle = Box.createHorizontalBox();
		JLabel topPanelLabel = new JLabel("Your Playlist");
		hboxtitle.add(Box.createHorizontalGlue());
		hboxtitle.add(topPanelLabel);
		hboxtitle.add(Box.createHorizontalGlue());
		topPanel.add(hboxtitle);
		topPanelLabel.setForeground(Color.WHITE);
		Box hbox = Box.createHorizontalBox();
		importPlaylistButton = new ImportPlaylistButton(app);
		importPlaylistButton.setFont(new Font("Corbel",Font.BOLD,15));
		importPlaylistButton.setFocusPainted(false);
		importPlaylistButton.setContentAreaFilled(true);
		importPlaylistButton.setBackground(Color.LIGHT_GRAY);
		savePlaylistButton = new SavePlaylistButton(app);
		savePlaylistButton.setFont(new Font("Corbel",Font.BOLD,15));
		savePlaylistButton.setFocusPainted(false);
		savePlaylistButton.setContentAreaFilled(true);
		savePlaylistButton.setBackground(Color.LIGHT_GRAY);
		closePlaylistButton =  new ClosePlaylistButton(app);
		closePlaylistButton.setFont(new Font("Corbel",Font.BOLD,15));
		closePlaylistButton.setFocusPainted(false);
		closePlaylistButton.setContentAreaFilled(true);
		closePlaylistButton.setBackground(Color.LIGHT_GRAY);
		hbox.add(importPlaylistButton);
		hbox.add(savePlaylistButton);
		hbox.add(closePlaylistButton);
		int border = hbox.getWidth()+2;
		
		topPanel.add(hbox);
		topPanel.add(Box.createHorizontalStrut(border));

		this.add(topPanel,BorderLayout.NORTH);
		
		
		this.result = new JPanel(new BorderLayout());
		result.setBackground(backgroundColor);
		result.add(bigvbox);
		result.setSize(new Dimension(338,100));
		
		jsc = new JScrollPane(result);
		this.add(jsc);
		
		jsc.setPreferredSize(new Dimension(355,100));
		
		jsc.setPreferredSize(new Dimension(355,800));
		
		jsc.setVisible(true);
		jsc.setOpaque(false);
	}
	
	public Playlist getPlaylist(){
		return playlist;
	}
	
	public void updatePlaylist(OurVideo video) throws MalformedURLException, IOException{
		//result.remove(label);
		if(!(playlist.existsIn(video))){
			playlist.addVideo(video);
			final PlaylistVideoComponent playlistComp = new PlaylistVideoComponent(playlist, video, app);
			playlistComp.setBackground(backgroundColor);
			playlistComp.addMouseListener(new MouseAdapter(){
		    	@Override
		    	public void mousePressed(MouseEvent e){
		    		app.activatePlaylistMode(playlistComp.getVideo());
		    		app.readOurVideo(playlistComp.getVideo());
		    	}
		    });
			this.remove(jsc);
			this.repaint();
			bigvbox.add(playlistComp);
			this.add(jsc);
			bigvbox.repaint();
			bigvbox.revalidate();
		}
	}
		public void fastUpdatePlaylist(OurVideo video) throws MalformedURLException, IOException{
			//if(!(playlist.existsIn(video))){
				System.out.println("adding video");
				final PlaylistVideoComponent playlistComp = new PlaylistVideoComponent(playlist, video, app);
				playlistComp.setBackground(backgroundColor);
				playlistComp.addMouseListener(new MouseAdapter(){
			    	@Override
			    	public void mousePressed(MouseEvent e){
			    		app.activatePlaylistMode(playlistComp.getVideo());
			    		app.readOurVideo(playlistComp.getVideo());
			    	}
			    });
				
				bigvbox.add(playlistComp);
			//}

	}
		
	public void remove(PlaylistVideoComponent pvc){
		this.remove(jsc);
		this.repaint();
		playlist.removeVideo(pvc.getVideo());
		bigvbox.remove(pvc);
		this.add(jsc);
		bigvbox.repaint();
		bigvbox.revalidate();
	}

	public void setPlaylist(Playlist playlistChoice) {
		this.remove(jsc);
		this.repaint();
		playlist = playlistChoice;
		bigvbox.removeAll();
		if (playlistChoice!=null)
			for (OurVideo ov : playlistChoice.getVideos()){
				try {
					fastUpdatePlaylist(ov);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		this.add(jsc);
		this.repaint();
		bigvbox.repaint();
		System.out.println("repainting");
		
		
	}
	
	public void toggleClose(){
		closePlaylistButton.doClick();
	}
	
	public void toggleSave(){
		savePlaylistButton.doClick();
	}

	public Playlist newPlaylist() {
		playlist=new Playlist();
		return playlist;
	}

	
	

}

