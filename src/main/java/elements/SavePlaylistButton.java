package elements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import app.AppController;

public class SavePlaylistButton extends JButton {

	public SavePlaylistButton(final AppController app) {
		super("Save");
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				app.savePlaylist();
			}
		});
		
	}
	 
}


