package elements;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import app.AppController;

import views.PlaylistRightSideBarView;

public class ImportPlaylistButton extends JButton {

	public ImportPlaylistButton(final AppController appController) {
		super("Import");
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser playlistChooser = new JFileChooser();
				playlistChooser.showOpenDialog(null);
			    
				       ObjectInputStream flotLecture;
				       
						try {
							flotLecture = new ObjectInputStream(
							new FileInputStream(playlistChooser.getSelectedFile()));				       
							Object lu = flotLecture.readObject();
							Playlist playlistChoice=(Playlist)lu;
							appController.setPlaylist(null);
							appController.setPlaylist(playlistChoice);
							appController.savePlaylist();
							flotLecture.close();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

				    
				       
				     
				
			}
		});
	}

}
