package views;

import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class VideoTab extends JPanel{
	
	private VideoPlayer videoPlayer;
	private ImageIcon videoIcon;
	
	public ImageIcon getVideoIcon() {
		return videoIcon;
	}

	public void setVideoIcon(ImageIcon videoIcon) {
		this.videoIcon = videoIcon;
	}

	public VideoTab(){
		super();
		this.setLayout(new CardLayout());
		String vidIconPath="src/main/resources/icons/video.png";
		videoIcon = new ImageIcon(vidIconPath);
		videoPlayer=new VideoPlayer();
		this.add(videoPlayer);

		
	}
	
	public void playVideo(String url) throws InterruptedException{
		videoPlayer.play(url);

		// Waits until the player window be closed
		Thread.currentThread().join();
	}
}
