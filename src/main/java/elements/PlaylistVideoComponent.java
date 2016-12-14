package elements;
import java.io.*;
import java.awt.Dimension;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.Box;
import javax.swing.JButton;

import app.AppController;

public class PlaylistVideoComponent extends Box{
	
	Playlist playlist;
	OurVideoComponent video;
	AppController app;
	JButton play = new JButton();
	JButton remove = new JButton();

	public PlaylistVideoComponent(Playlist playlist, OurVideo video, AppController app) {
		super(0);
		Box bigvbox=Box.createVerticalBox();
		try {
			this.video = new OurVideoComponent(video,app);
			this.video.setMaximumSize(new Dimension(320,300));
			System.out.println(this.video.getJname().length());
			if(this.video.getJname().length()>40){
				this.video.setJname((this.video.getJname().substring(13,39))+"[...]");
			}else{
				this.video.setJname(this.video.getJname().substring(13));
			}
			if(this.video.getJchannel().length()>40){
				this.video.setJchannel((this.video.getJchannel().substring(15,39))+"[...]");
			}else{
				this.video.setJchannel(this.video.getJchannel().substring(15));
			}
			this.video.setAlignmentX(0);
			this.playlist=playlist;
			this.app=app;
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
	
	public void remove(){
		playlist.removeVideo(video.getVideo());
	}
}
