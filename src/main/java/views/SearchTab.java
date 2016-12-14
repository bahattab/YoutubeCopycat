package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;

import app.AppController;
import elements.OurVideo;
import elements.OurVideoComponent;

public class SearchTab extends JPanel{
	
	private ImageIcon searchIcon;
	private JPanel result;
	private JScrollPane jsc;
	private AppController app;
	
	public ImageIcon getSearchIcon() {
		return searchIcon;
	}

	public void setSearchIcon(ImageIcon videoIcon) {
		this.searchIcon = videoIcon;
	}
	
	public SearchTab(AppController app){
		super();
		this.app=app;
		String srchIconPath="src/main/resources/icons/search.png";
		searchIcon = new ImageIcon(srchIconPath);
		result = new JPanel();
		result.setSize(new Dimension(1000, 700));
		jsc = new JScrollPane(result);
		this.add(jsc);
		jsc.setBackground(Color.BLUE);

		jsc.setPreferredSize(new Dimension(1000,700));
		jsc.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsc.setVisible(true);
	}
	
	public void update(List<OurVideo> list) throws IOException{
		
		//result.setLayout(new GridLayout(25,1));	
		Box bigvbox=Box.createVerticalBox();
		for (int i = 0; i < list.size(); i++) {
			final OurVideoComponent hbox = new OurVideoComponent(0,list.get(i),app);
			hbox.setMaximumSize(new Dimension(1000,300));
			BevelBorder border = new BevelBorder(0);
			hbox.setBorder(border);
			Box vbox=Box.createVerticalBox();
			BufferedImage miniature = ImageIO.read(new URL(list.get(i).getMiniature()));
			//ImageIcon miniature = new ImageIcon(ImageIO.read(getClass().getResource("https://i.ytimg.com/vi/5Nrv5teMc9Y/default.jpg")));
			JLabel miniaturelabel = new JLabel(new ImageIcon(miniature));
			hbox.add(miniaturelabel);
			
			JLabel jname = new JLabel("     Title = "+list.get(i).getName());
			vbox.add(jname);
			JLabel jchannel = new JLabel("     Channel = "+list.get(i).getChannelTitle());
			vbox.add(jchannel);
			hbox.add(vbox);
			hbox.addMouseListener(new MouseAdapter(){
		    	@Override
		    	public void mousePressed(MouseEvent e){
		    		app.readOurVideo(hbox.getVideo());
		    	}
		    });
			bigvbox.add(hbox);
			
		}	
		result.removeAll();
		result.add(bigvbox);
		result.repaint();
		result.revalidate();
		
	}

}
