package elements;
import java.io.*;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import app.AppController;

public class PlaylistVideoComponent extends Box{
	
	private Playlist playlist;
	private OurVideoComponent video;
	private AppController app;
	private JButton remove = new JButton();
	private Box bigvbox;

	public PlaylistVideoComponent(Playlist playlist, final OurVideo video, final AppController app) {
		super(0);
		bigvbox=Box.createVerticalBox();
		try {
			this.video = new OurVideoComponent(video,app);
			this.video.setMaximumSize(new Dimension(320,300));
			if(this.video.getJname().length()>40){
				this.video.setJname((this.video.getJname().substring(13,39))+"[...]");
			}else{
				this.video.setJname(this.video.getJname().substring(13));
			}
			if(this.video.getJchannel().length()>40){
				this.video.setJchannel("by "+(this.video.getJchannel().substring(15,39))+"[...]");
			}else{
				this.video.setJchannel("by "+this.video.getJchannel().substring(15));
			}
			this.video.setJduration(this.video.getJduration().substring(16));
			this.video.setAlignmentX(0);
			this.playlist=playlist;
			this.app=app;
			remove = new JButton();
			remove.setIcon(new ImageIcon("src/main/resources/icons/delete.png"));
			remove.setToolTipText("Remove the video below from your playlist");
			remove.setMaximumSize(new Dimension(30,10));
			final PlaylistVideoComponent plvc = this;
			remove.addMouseListener(new MouseAdapter(){
		    	@Override
		    	public void mousePressed(MouseEvent e){
		    		app.removeVideoFromPlaylist(video,plvc);
		    	}
		    });
			bigvbox.add(remove);

			bigvbox.add(this.video);
			this.add(bigvbox);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public OurVideo getVideo() {
		return video.getVideo();
	}

	public AppController getApp() {
		return app;
	}

	public void setVideo(OurVideo video) {
		this.video.setVideo(video);
	}

	public void setApp(AppController app) {
		this.app = app;
	}
	
	public void play(){
		app.readOurVideo(video.getVideo());
	}
	
	public void remove(OurVideo video){
		playlist.removeVideo(this.video.getVideo());
		bigvbox.remove(this.video);
		bigvbox.remove(remove);
			
	}
}
