package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.net.URL;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Home extends JPanel{

	JPanel mainPanel;
	JPanel descriptPanel;
	Box featuresPanel;
	
	
	public Home(){
		super();
		mainPanel=new JPanel(new BorderLayout());
		descriptPanel=new JPanel(new GridLayout(5,1));
		featuresPanel=Box.createHorizontalBox();
		JLabel descript=new JLabel("Welcome to Youtube Copycat, a JAVA application capable of display Youtube videos and local videos! ");
		JLabel f=new JLabel("This application can:");
		JLabel l1=new JLabel("");
		
		descriptPanel.add(descript);
		descriptPanel.add(f);
		
		JPanel h=new JPanel();
		JPanel s=new JPanel();
		JPanel c=new JPanel();
		JPanel con=new JPanel();
		JPanel most=new JPanel();
		
		URL home=Home.class.getResource("/icons/home.png");
		URL search=LeftSideBarView.class.getResource("/icons/local_search.png");
		URL settings=LeftSideBarView.class.getResource("/icons/settings.png");
		URL connexes= LeftSideBarView.class.getResource("/icons/connexes.png");
		URL mostWatched=LeftSideBarView.class.getResource("/icons/popular_today.png");

		ImageIcon icon1 = new ImageIcon(home);
		ImageIcon icon2 = new ImageIcon(search);
		ImageIcon icon3 = new ImageIcon(settings);
		ImageIcon icon5 = new ImageIcon(connexes);
		ImageIcon icon6 = new ImageIcon(mostWatched);
		
		JLabel hLabel=new JLabel(icon1);
		JLabel sLabel=new JLabel(icon2);
		JLabel cLabel=new JLabel(icon3);
		JLabel conLabel=new JLabel(icon5);
		JLabel mostLabel=new JLabel(icon6);
	
		
		JLabel hLabel2=new JLabel("Go to this welcome page");
		JLabel sLabel2=new JLabel("Search and add a video from your computer at the current playlist");
		JLabel cLabel2=new JLabel("Change your API Key (see INSTALL in README to know how to get one)");
		JLabel conLabel2=new JLabel("Display videos suggestions related to videos in your playlist");
		JLabel mostLabel2=new JLabel("Display most popular Youtube videos today");
		
		h.add(hLabel);
		h.add(hLabel2);
		
		s.add(sLabel);
		s.add(sLabel2);
		
		
		con.add(conLabel);
		con.add(conLabel2);
		
		most.add(mostLabel);
		most.add(mostLabel2);
		c.add(cLabel);
		c.add(cLabel2);
		
		Box vbox= Box.createVerticalBox();
		
		vbox.add(h);
		vbox.add(s);
		vbox.add(con);
		vbox.add(most);
		vbox.add(c);
		
		featuresPanel.add(vbox);
		mainPanel.add(descriptPanel,BorderLayout.NORTH);
		mainPanel.add(featuresPanel,BorderLayout.SOUTH);
		
		JOptionPane.showMessageDialog(null, mainPanel, "Welcome to Youtube Copycat !",1);
	}
	
}
