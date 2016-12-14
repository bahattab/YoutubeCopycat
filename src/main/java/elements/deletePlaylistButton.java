package elements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import views.PlaylistRightSideBarView;

public class deletePlaylistButton extends JButton {

	public deletePlaylistButton(final PlaylistRightSideBarView playlistRightSideBarView) {
		super("Delete");
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			       playlistRightSideBarView.setPlaylist(null);
				
			}
		});
		
	}

}
