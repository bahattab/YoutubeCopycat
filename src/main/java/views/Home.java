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
		JLabel descript=new JLabel("Bienvenue sur Youtube Copycat, une application Java qui permet de visionner des videos depuis YouTube et depuis votre ordinateur ! ");
		JLabel f=new JLabel("Cette application a les fonctionnalités suivantes :");
		JLabel l1=new JLabel("");
		
		descriptPanel.add(descript);
		descriptPanel.add(f);
		
		JPanel h=new JPanel();
		JPanel s=new JPanel();
		JPanel c=new JPanel();
		JPanel st=new JPanel();
		JPanel con=new JPanel();
		JPanel most=new JPanel();
		
		System.out.println("1");
		URL home=Home.class.getResource("/home.png");
		System.out.println("2");
		URL search=LeftSideBarView.class.getResource("/icons/search.png");
		System.out.println("3");
		URL connect=LeftSideBarView.class.getResource("/icons/local.png");
		URL stats=LeftSideBarView.class.getResource("/icons/stats.png");
		URL connexes= LeftSideBarView.class.getResource("/icons/connexes.png");
		URL mostWatched=LeftSideBarView.class.getResource("/icons/popular_today.png");
		System.out.println("1");

		ImageIcon icon1 = new ImageIcon(home);
		System.out.println("2");

		ImageIcon icon2 = new ImageIcon(search);
		ImageIcon icon3 = new ImageIcon(connect);
		ImageIcon icon4 = new ImageIcon(stats);
		ImageIcon icon5 = new ImageIcon(connexes);
		ImageIcon icon6 = new ImageIcon(mostWatched);
		
		JLabel hLabel=new JLabel(icon1);
		JLabel sLabel=new JLabel(icon2);
		JLabel cLabel=new JLabel(icon3);
		JLabel stLabel=new JLabel(icon4);
		JLabel conLabel=new JLabel(icon5);
		JLabel mostLabel=new JLabel(icon6);
	
		
		JLabel hLabel2=new JLabel("Accéder à cette page d'accueil");
		JLabel sLabel2=new JLabel("Chercher et ajouter une video de votre ordinateur sur la playlist courante");
		JLabel cLabel2=new JLabel("Passer en mode connecté");
		JLabel stLabel2=new JLabel("Consulter les statistiques de YouTube");
		JLabel conLabel2=new JLabel("Afficher les suggestions de vidéos en rapport avec votre playlist");
		JLabel mostLabel2=new JLabel("Afficher les vidéos les plus visionnées sur YouTube aujourd'hui");
		
		h.add(hLabel);
		h.add(hLabel2);
		
		s.add(sLabel);
		s.add(sLabel2);
		
		c.add(cLabel);
		c.add(cLabel2);
		
		st.add(stLabel);
		st.add(stLabel2);
		
		con.add(conLabel);
		con.add(conLabel2);
		
		most.add(conLabel);
		most.add(conLabel2);
		
		Box vbox= Box.createVerticalBox();
		
		vbox.add(h);
		vbox.add(s);
		vbox.add(c);
		vbox.add(st);
		vbox.add(con);
		vbox.add(most);
		
		featuresPanel.add(vbox);
		mainPanel.add(descriptPanel,BorderLayout.NORTH);
		mainPanel.add(featuresPanel,BorderLayout.SOUTH);
		
		JOptionPane.showMessageDialog(null, mainPanel, "Welcome to Youtube Copycat !",1);
	}
	
}
