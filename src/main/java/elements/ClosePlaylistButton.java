package elements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import app.AppController;

public class ClosePlaylistButton extends JButton {
	private AppController app;

	public ClosePlaylistButton(final AppController appC) {
		super("Close");
		this.app=appC;
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			       app.setPlaylist(null);
				
			}
		});
		
	}

}
