package elements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import app.AppController;

public class addToPlaylistButton extends JButton {
	private AppController appController;
	private OurVideo ourVideo;

	public addToPlaylistButton(final OurVideo ourVideo, final AppController appController,ImageIcon i) {
		super(i);
		this.ourVideo=ourVideo;
		this.appController = appController;
		this.setToolTipText("Add this video at your current playlist");
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				appController.addToPlaylist(ourVideo);
			}
		});
		
	}

	
	
}
