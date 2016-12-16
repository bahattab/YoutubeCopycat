package elements;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

import app.AppController;

public class PlaylistComponent extends Box {
	
	private Playlist playlist;
	private AppController app;
	private JLabel jname;
	private JButton remove;

	public PlaylistComponent(Playlist playlist,final String name, final AppController app){
		super(0);
		this.playlist=playlist;
		this.app=app;
		Box vbox=Box.createVerticalBox();
		jname = new JLabel(name);
		vbox.add(jname);
		this.setMaximumSize(new Dimension(1100,100));
		BevelBorder border = new BevelBorder(0);
		this.setBorder(border);
		
		Box vbox2= Box.createVerticalBox();
		ImageIcon cross = new ImageIcon(PlaylistVideoComponent.class.getResource("/icons/remove.png"));
		remove = new JButton(cross);
		remove.setToolTipText("Delete this playlist");
		remove.setBorder(null);
		remove.setOpaque(false);

		final PlaylistComponent plc = this;
		remove.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e){
				app.deleteFromFile(name,plc);
			}
		});

		vbox2.add(remove);
		vbox2.add(Box.createVerticalGlue());
		this.add(Box.createHorizontalGlue());
		this.add(vbox);
		this.add(Box.createHorizontalGlue());
		this.add(vbox2);
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}

	public AppController getApp() {
		return app;
	}

	public void setApp(AppController app) {
		this.app = app;
	}

	public JLabel getJname() {
		return jname;
	}

	public void setJname(JLabel jname) {
		this.jname = jname;
	}
	

}
