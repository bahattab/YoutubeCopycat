package elements;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import views.PlaylistRightSideBarView;

public class importPlaylistButton extends JButton {

	public importPlaylistButton(final PlaylistRightSideBarView playlistRightSideBarView) {
		super("Import");
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser playlistChooser = new JFileChooser();
				playlistChooser.showOpenDialog(null);
			     try {
				       ObjectInputStream flotLecture = 
				             new ObjectInputStream(
				                new FileInputStream(playlistChooser.getSelectedFile()));
				       Object lu = flotLecture.readObject();
				       Playlist playlistChoice=(Playlist)lu;
				       playlistRightSideBarView.setPlaylist(playlistChoice);
				       flotLecture.close();
				     } catch (Exception e1) {
				       System.out.println(" erreur :" +e1.toString());
				     }  
				
			}
		});
	}

}
