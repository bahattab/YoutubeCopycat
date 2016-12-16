package elements;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;


import app.AppController;

public class PlaylistVideoComponent extends OurVideoComponent{

	private Playlist playlist;
	private AppController app;
	private JButton remove = new JButton();

	public PlaylistVideoComponent(Playlist playlist, OurVideo video, final AppController app) throws MalformedURLException, IOException {
		super(video,app);
		this.video=video;
		setMaximumSize(new Dimension(325,150));
		setPreferredSize(new Dimension(325, 100));
		if (video.getName().length()>23)
			jname.setText(video.getName().substring(0,20)+"[...]");
		else jname.setText(video.getName());


		if (video.getChannelTitle().length()>23)
			jchannel.setText(video.getChannelTitle().substring(0,20)+"[...]");
		else jchannel.setText(video.getChannelTitle());
		
		jname.setSize(new Dimension(jname.getHeight(),80));
		jchannel.setSize(new Dimension(jchannel.getHeight(),80));
		
		setJduration(video.getDuration());
		this.playlist=playlist;
		this.app=app;

		Box vbox = Box.createVerticalBox();
		remove = new JButton();
		ImageIcon cross = new ImageIcon(PlaylistVideoComponent.class.getResource("/icons/remove.png"));


		remove.setIcon(cross);
		remove.setToolTipText("Remove the video below from your playlist");
		remove.setBorder(null);
		remove.setOpaque(false);
		remove.setContentAreaFilled(false);
		remove.setFocusPainted(false);

		final PlaylistVideoComponent plvc = this;
		remove.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e){
				app.removeVideoFromPlaylist(plvc);
			}
		});

		vbox.add(remove);
		vbox.add(Box.createVerticalGlue());
		this.add(Box.createHorizontalGlue());
		this.add(vbox);
		this.setOpaque(true);

//		this.addMouseListener(new MouseAdapter(){
//			public void mousePressed(MouseEvent e){
//				app.readOurVideo(((PlaylistVideoComponent) e.getSource()).getVideo());
//			}
//		});
	}


	public AppController getApp() {
		return app;
	}



	public Playlist getPlaylist() {
		return playlist;
	}
}
