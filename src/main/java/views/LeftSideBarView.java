package views;

import java.awt.Color;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import app.AppController;
import elements.LocalSearchButton;
import elements.SettingsButton;

import javax.swing.Box;
import javax.swing.ImageIcon;


public class LeftSideBarView extends JPanel{
	private AppController app;
	public LeftSideBarView(final AppController appC){
		super();
		this.app=appC;
		Color color = new Color(0,0, 0, 0);
		this.setBackground(color);
		this.setSize(100,800);
		this.setLayout(new GridLayout(10,1));	
		
		URL home=LeftSideBarView.class.getResource("/icons/home.png");
		URL search=LeftSideBarView.class.getResource("/icons/local_search.png");
		URL local=LeftSideBarView.class.getResource("/icons/settings.png");
		URL connexes= LeftSideBarView.class.getResource("/icons/connexes.png");
		URL mostWatched=LeftSideBarView.class.getResource("/icons/popular_today.png");
		
		ImageIcon icon1 = new ImageIcon(home);
		ImageIcon icon2 = new ImageIcon(search);
		ImageIcon icon3 = new ImageIcon(local);
		ImageIcon icon5 = new ImageIcon(connexes);
		ImageIcon icon6 = new ImageIcon(mostWatched);
		
		JButton b1=new JButton(icon1);
		b1.setMaximumSize(new Dimension(80,30));
		b1.setBackground(new Color(115,21,21));
		b1.setBorderPainted(false);
		b1.setFocusPainted(false);
		
		LocalSearchButton b2=new LocalSearchButton(icon2,app);
		b2.setMaximumSize(new Dimension(80,30));
		b2.setBackground(new Color(115,21,21));
		b2.setBorderPainted(false);
		b2.setFocusPainted(false);
		
		SettingsButton b3=new SettingsButton(icon3,app);
		b3.setMaximumSize(new Dimension(80,30));
		b3.setBackground(new Color(115,21,21));
		b3.setBorderPainted(false);
		b3.setFocusPainted(false);
		
		JButton b5=new JButton(icon5);
		b5.setMaximumSize(new Dimension(80,30));
		b5.setBackground(new Color(115,21,21));
		b5.setBorderPainted(false);
		b5.setFocusPainted(false);
		
		JButton b6=new JButton(icon6);
		b6.setMaximumSize(new Dimension(80,30));
		b6.setBackground(new Color(115,21,21));
		b6.setBorderPainted(false);
		b6.setFocusPainted(false);
		
		b1.setToolTipText("Home");
		b2.setToolTipText("Do a local search with a file explorer");
		b3.setToolTipText("Settings");
		b5.setToolTipText("Suggestions");
		b6.setToolTipText("Most popular videos today");
		
		b1.addMouseListener(new MouseAdapter(){
	    	@Override
	    	public void mousePressed(MouseEvent e){
	    		app.home();
	    	}
		});
		

		b5.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				try {
					app.connexVideo();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});


b6.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				try {
					app.popularVideo();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		this.add(b1);
		this.add(b2);
		this.add(b5);
		this.add(b6);
		this.add(b3);
		//this.add(Box.createHorizontalGlue());
	}
	
	public void suggestionsHelp(){
		JPanel mainPanel=new JPanel(new BorderLayout());
		JPanel message=new JPanel(new GridLayout(5,1));
		JLabel descript=new JLabel("The suggestion of videos isn't available unless the \"Playlist\" panel at the right of the screen isn't empty. So make a playlist to get started !");
		JLabel l2=new JLabel("To add some videos to your playlist you can launch a search, click on a video to launch it and click on the 'Add' button at the bottom of the video player");
		URL add=LeftSideBarView.class.getResource("/icons/add.png");
		ImageIcon icon1 = new ImageIcon(add);
		JLabel f=new JLabel(icon1);
		JLabel l3=new JLabel("You can then click on this button to get some suggestions of videos that ressemble those of yout playlist !");
		
		message.add(descript);
		message.add(l2);
		message.add(f);
		message.add(l3);
		
		
		mainPanel.add(message);
		

		JOptionPane.showMessageDialog(null, mainPanel, "Suggestions de vidéos",1);

	}

	
}

