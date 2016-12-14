package elements;

import javax.swing.Box;
import javax.swing.JButton;

import app.AppController;

public class PlaylistVideoComponent extends Box{
	
	Playlist playlist;
	OurVideoComponent video;
	AppController app;
	JButton play = new JButton();
	JButton remove = new JButton();

	public PlaylistVideoComponent(Playlist playlist, OurVideo video, AppController app, JButton play, JButton remove) {
		super(0);
		this.video = new OurVideoComponent(0,video,app);
		this.app=app;
		this.play=play;
		this.remove=remove;
		this.playlist=playlist;
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
		
	}
	
	public void remove(){
		playlist.removeVideo(video.getVideo());
	}
}

