package elements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import app.AppController;

import views.PlaylistRightSideBarView;

public class ClosePlaylistButton extends JButton {

	public ClosePlaylistButton(final AppController app) {
		super("Close");
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			       app.setPlaylist(null);
				
			}
		});
		
	}

}
