package elements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class savePlaylistButton extends JButton {

	public savePlaylistButton(final Playlist playlist) {
		super("Save");
		this.addActionListener(new ActionListener() {
			
				
			@Override
			public void actionPerformed(ActionEvent e) {
				if (playlist.getVideos().isEmpty()){
					JOptionPane.showMessageDialog(null, "Your playlist is empty !");
				}else{
				String name = JOptionPane.showInputDialog("Please type a name to save the playlist :");
				saveOnFile(name, playlist);
				}
			}
		});
		
	}
	
	public void saveOnFile(String fileName, Playlist playlist){
		File fichier= new File(fileName);
		System.out.println(fichier);
	       try {
	         ObjectOutputStream flotEcriture = 
	             new ObjectOutputStream(
	                new FileOutputStream(fichier));
	         flotEcriture.writeObject(playlist);
	         flotEcriture.close();
	       } catch (IOException e) {
	         System.out.println(" erreur :" + e.toString());
	       }  
	}

}
