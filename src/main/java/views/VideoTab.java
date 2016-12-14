package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import elements.OurVideo;

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

	public void setDetails(OurVideo ourVideo){
		System.out.println("VideoTab : setting details for "+ ourVideo.getName());
		videoDetails.removeAll();
		JLabel Title = new JLabel(ourVideo.getName());
		Title.setFont(new Font("Arial",0,22));
		videoDetails.add(Title);
		Box vbox1= Box.createVerticalBox();
		vbox1.add(new JLabel("Published on : "+ourVideo.getPublishedAt().toString()));
		vbox1.add(new JLabel("Published by : "+ourVideo.getChannelTitle()));
		Box vbox2= Box.createVerticalBox();
		vbox2.add(new JLabel(ourVideo.getViewCount()+" views"));
		vbox2.add(new JLabel(ourVideo.getLikeCount()+" likes / "+ourVideo.getDislikeCount() + " dislikes"));
		Box hbox = Box.createHorizontalBox();

		hbox.add(vbox1);
		hbox.add(Box.createHorizontalGlue());
		hbox.add(vbox2);
		videoDetails.add(hbox);
	}
	
	
	
	public void playVideo(String url) throws InterruptedException{
		videoPlayer.play(url);

		// Waits until the player window be closed
		//Thread.currentThread().join();
	}
}
