package views;
import java.awt.Color;
//import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.AppController;
import elements.LocalSearchButton;
import elements.SettingsButton;

import javax.swing.Box;
import javax.swing.ImageIcon;


public class LeftSideBarView extends JPanel{
	
	public LeftSideBarView(final AppController app){
		Color color = new Color(0,0, 0, 0);
		this.setBackground(color);
		this.setSize(100,800);
		this.setLayout(new GridLayout(10,1));	
		
		URL home=LeftSideBarView.class.getResource("/icons/home.png");
		URL search=LeftSideBarView.class.getResource("/icons/local_search.png");
		URL local=LeftSideBarView.class.getResource("/icons/settings.png");
		URL stats=LeftSideBarView.class.getResource("/icons/stats.png");
		URL connexes= LeftSideBarView.class.getResource("/icons/connexes.png");
		URL mostWatched=LeftSideBarView.class.getResource("/icons/popular_today.png");
		
		ImageIcon icon1 = new ImageIcon(home);
		ImageIcon icon2 = new ImageIcon(search);
		ImageIcon icon3 = new ImageIcon(local);
		ImageIcon icon4 = new ImageIcon(stats);
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
		
		JButton b4=new JButton(icon4);
		b4.setMaximumSize(new Dimension(80,30));
		b4.setBackground(new Color(115,21,21));
		b4.setBorderPainted(false);
		b4.setFocusPainted(false);
		
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
		
		b1.setToolTipText("Accueil");
		b2.setToolTipText("Faire une recherche locale");
		b3.setToolTipText("Settings");
		b4.setToolTipText("Afficher des statistiques de videos");
		b5.setToolTipText("Suggestions de vidéo");
		b6.setToolTipText("Vidéos les plus visionnées aujourd'hui");
		
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
		
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(b5);
		this.add(b6);
		//this.add(Box.createHorizontalGlue());
	}

	
}

