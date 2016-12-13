package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VideoTab extends JPanel{
	
	private VideoPlayer videoPlayer;
	private ImageIcon videoIcon;
	private JPanel videoDetails;
	
	public ImageIcon getVideoIcon() {
		return videoIcon;
	}

	public void setVideoIcon(ImageIcon videoIcon) {
		this.videoIcon = videoIcon;
	}

	public VideoTab(){
		super();
		this.setLayout(new BorderLayout());
		String vidIconPath="src/main/resources/icons/video.png";
		videoIcon = new ImageIcon(vidIconPath);
		videoPlayer=new VideoPlayer();
		this.add(videoPlayer);
		videoDetails = new JPanel();
		videoDetails.setLayout(new BoxLayout(videoDetails, BoxLayout.Y_AXIS));
		this.add(videoDetails,BorderLayout.SOUTH);
	}
	
	
	
	public void playVideo(String url) throws InterruptedException{
		videoPlayer.play(url);

		// Waits until the player window be closed
		Thread.currentThread().join();
	}
}
