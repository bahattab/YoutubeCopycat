package views;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import app.AppController;
import elements.Playlist;
import elements.PlaylistComponent;
import elements.PlaylistVideoComponent;

public class PlaylistTab extends JPanel {
	
	private ImageIcon PlaylistIcon;
	private JPanel result;
	private JScrollPane jsc;
	private AppController app;
	private Box bigvbox;
	
	public ImageIcon getPlaylistIcon() {
		return PlaylistIcon;
	}

	public void setPlaylistIcon(ImageIcon playlistIcon) {
		this.PlaylistIcon = playlistIcon;
	}
	
	public PlaylistTab(final AppController app){
		super();
		addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				System.out.println("focusGained");
				app.fillPlaylistTab();
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		    });;
		
		this.app=app;
		this.setLayout(new BorderLayout());
		URL PlaylistIconPath=SearchTab.class.getResource("/icons/playlist.png");
		PlaylistIcon = new ImageIcon(PlaylistIconPath);
		result = new JPanel(new BorderLayout());
		JLabel label = new JLabel("Your playlists will be displayed here. You have no playlists yet !");
		label.setFont(new Font("Corbel",Font.BOLD,15));
		label.setHorizontalAlignment(WIDTH/2);
		result.add(label);
		result.setSize(new Dimension(1000, 700));
		jsc = new JScrollPane(result);
		this.add(jsc);
		jsc.setPreferredSize(new Dimension(1000,700));
		jsc.setVisible(true);
	}
	
	public void update(final HashMap<String, Playlist> hashMap, final AppController app) throws IOException{
		JLabel playlist=new JLabel("Your playlists");
		playlist.setFont(new Font("Courier",Font.BOLD + Font.ITALIC,21));
	    bigvbox=Box.createVerticalBox();
		for ( String k : hashMap.keySet()) {
			final PlaylistComponent plc = new PlaylistComponent(hashMap.get(k),k,app);
			plc.addMouseListener(new MouseAdapter(){
		    	@Override
		    	public void mousePressed(MouseEvent e){
		    		app.setPlaylist(plc.getPlaylist());
		    	}
		    });
			bigvbox.add(plc);
			}
			
		result.removeAll();
		result.add(playlist,BorderLayout.NORTH);
		result.add(bigvbox);
		result.repaint();
		result.revalidate();
		
	}
	
	public int removeHelp(){
		String attention="Are you sure that you want to delete this playlist from your files ?";

		return JOptionPane.showConfirmDialog(null, attention, "Attention !",JOptionPane.YES_NO_CANCEL_OPTION);
		
	}
	
	public void remove(PlaylistComponent plc){
		bigvbox.remove(plc);
		result.repaint();
		result.revalidate();
	}
	
}
