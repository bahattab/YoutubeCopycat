package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import app.AppController;
import elements.OurVideo;
import elements.OurVideoComponent;

public class PlaylistTab extends JPanel {
	
	private ImageIcon PlaylistIcon;
	private JPanel result;
	private JScrollPane jsc;
	private AppController app;
	
	public ImageIcon getSearchIcon() {
		return PlaylistIcon;
	}

	public void setSearchIcon(ImageIcon videoIcon) {
		this.PlaylistIcon = videoIcon;
	}
	
	public PlaylistTab(AppController app){
		super();
		this.app=app;
		this.setLayout(new BorderLayout());
		URL PlaylistIconPath=SearchTab.class.getResource("/icons/playlist.png");
		PlaylistIcon = new ImageIcon(PlaylistIconPath);
		result = new JPanel(new BorderLayout());
		JLabel label = new JLabel("This is where search results are displayed. There's no result yet.");
		label.setHorizontalAlignment(WIDTH/2);
		result.add(label);
		result.setSize(new Dimension(1000, 700));
		jsc = new JScrollPane(result);
		this.add(jsc);
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
