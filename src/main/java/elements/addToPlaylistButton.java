package elements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import app.AppController;

public class addToPlaylistButton extends JButton {
	private AppController appController;
	private OurVideo ourVideo;

	public addToPlaylistButton(final OurVideo ourVideo, final AppController appController) {
		super("+");
		this.ourVideo=ourVideo;
		this.appController = appController;
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("button to add");
				appController.addToPlaylist(ourVideo);
			}
		});
		
	}

	
	
}
