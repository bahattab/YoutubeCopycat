package elements;

import javax.swing.Box;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import app.AppController;

public class OurVideoComponent extends Box{

	OurVideo video;
	AppController app;

	public OurVideoComponent(int arg0, OurVideo video, AppController app) {
		super(arg0);
		this.video=video;
		this.app=app;
	}
	
	public OurVideo getVideo() {
		return video;
	}

	public AppController getApp() {
		return app;
	}

	public void setVideo(OurVideo video) {
		this.video = video;
	}

	public void setApp(AppController app) {
		this.app = app;
	}
}
