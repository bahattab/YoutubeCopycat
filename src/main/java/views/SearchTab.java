package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
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
		this.setLayout(new BorderLayout());
		URL searchIconPath=SearchTab.class.getResource("/icons/search.png");
		searchIcon = new ImageIcon(searchIconPath);
		result = new JPanel(new BorderLayout());
		JLabel label = new JLabel("This is where search results are displayed. There's no result yet.");
		label.setHorizontalAlignment(WIDTH/2);
		result.add(label);
		result.setSize(new Dimension(1000, 700));
		jsc = new JScrollPane(result);
		this.add(jsc);
		jsc.setBackground(Color.BLUE);
		jsc.setPreferredSize(new Dimension(1000,700));
		jsc.setVisible(true);
	}
	
	public void update(List<OurVideo> list, String tabTitle) throws IOException{
		JLabel resultsTitle=new JLabel(tabTitle);
		resultsTitle.setFont(new Font("Courier",Font.BOLD + Font.ITALIC,21));
		
		//result.setLayout(new GridLayout(25,1));	
		Box bigvbox=Box.createVerticalBox();
		for (int i = 0; i < list.size(); i++) {
			final OurVideoComponent hbox = new OurVideoComponent(list.get(i),app);
			hbox.addMouseListener(new MouseAdapter(){
		    	@Override
		    	public void mousePressed(MouseEvent e){
		    		app.readOurVideo(hbox.getVideo());
		    	}
		    });
			bigvbox.add(hbox);
			
		}	
		result.removeAll();
		result.add(resultsTitle,BorderLayout.NORTH);
		result.add(bigvbox);
		result.repaint();
		result.revalidate();
		
	}

}
