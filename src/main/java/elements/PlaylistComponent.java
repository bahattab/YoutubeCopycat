package elements;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

import app.AppController;

public class PlaylistComponent extends Box {
	
	Playlist playlist;
	AppController app;
	JLabel jname;

	public PlaylistComponent(Playlist playlist,String name, AppController app){
		super(0);
		this.playlist=playlist;
		this.app=app;
		Box vbox=Box.createVerticalBox();
		jname = new JLabel("     Title = "+name);
		vbox.add(jname);
		this.setMaximumSize(new Dimension(1000,300));
		BevelBorder border = new BevelBorder(0);
		this.setBorder(border);
		//Box vbox=Box.createVerticalBox();
		this.add(vbox);
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
