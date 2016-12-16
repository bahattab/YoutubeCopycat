package elements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import app.AppController;

public class makeChangesButton extends JButton {
	private AppController appController;
	private OurVideo ourVideo;

	public makeChangesButton(final OurVideo ourVideo, final AppController appController,ImageIcon i) {
		super(i);
		this.ourVideo=ourVideo;
		this.appController = appController;
		this.setToolTipText("Change the video's title");
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				appController.changeVideoTitle(ourVideo);
			}
		});
		
	}

}
