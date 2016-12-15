package elements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JOptionPane;

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


