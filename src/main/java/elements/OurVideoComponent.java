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
import javax.swing.border.Border;

import app.AppController;

public class OurVideoComponent extends Box{

	OurVideo video;
	AppController app;
	JLabel jname;
	JLabel jchannel;
	JLabel miniaturelabel;

	public OurVideoComponent(OurVideo video, AppController app) throws MalformedURLException, IOException {
		super(0);
		this.video=video;
		this.app=app;
		this.setMaximumSize(new Dimension(1000,300));
		BevelBorder border = new BevelBorder(0);
		this.setBorder(border);
		Box vbox=Box.createVerticalBox();
		BufferedImage miniature = ImageIO.read(new URL(video.getMiniature()));
		//ImageIcon miniature = new ImageIcon(ImageIO.read(getClass().getResource("https://i.ytimg.com/vi/5Nrv5teMc9Y/default.jpg")));
		miniaturelabel = new JLabel(new ImageIcon(miniature));
		this.add(miniaturelabel);
		
		jname = new JLabel("     Title = "+video.getName());
		vbox.add(jname);
		jchannel = new JLabel("     Channel = "+video.getChannelTitle());
		vbox.add(jchannel);
		this.add(vbox);
	}
	

	public void setJname(String jname) {
		this.jname.setText(jname);
	}

	public void setJchannel(String jchannel) {
		this.jchannel.setText(jchannel);
	}

	public void setMiniaturelabel(JLabel miniaturelabel) {
		this.miniaturelabel = miniaturelabel;
	}

	public String getJname() {
		return jname.getText();
	}

	public String getJchannel() {
		return jchannel.getText();
	}

	public JLabel getMiniaturelabel() {
		return miniaturelabel;
	}

	public OurVideo getVideo() {
		return video;
	}

	public AppController getApp() {
		return app;
	}

	public void setVideo(OurVideo video) {
		this.video = video;
	}

	public void setApp(AppController app) {
		this.app = app;
	}
}

