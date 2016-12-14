package elements;

import javax.swing.JButton;

import app.AppController;

public class PlaylistComponent{
	
	Playlist playlist;
	OurVideoComponent video;
	AppController app;
	JButton play = new JButton();
	JButton remove = new JButton();

	public PlaylistComponent(Playlist playlist, OurVideoComponent video, AppController app, JButton play, JButton remove) {
		this.video=video;
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

