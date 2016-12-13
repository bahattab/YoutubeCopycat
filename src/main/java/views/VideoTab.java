package views;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class VideoTab extends JPanel{
	
	//private Video video;
	private ImageIcon videoIcon;
	
	public ImageIcon getVideoIcon() {
		return videoIcon;
	}

	public void setVideoIcon(ImageIcon videoIcon) {
		this.videoIcon = videoIcon;
	}

	public VideoTab(){
		super();
		String vidIconPath="src/main/resources/icons/video.png";
		videoIcon = new ImageIcon(vidIconPath);
	}
}
