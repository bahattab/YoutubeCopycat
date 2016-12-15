package app;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import API.APIManager;
import elements.OurVideo;
import elements.Playlist;
import elements.PlaylistVideoComponent;
import views.Home;

public class AppController {
	private UserInterface ui;
	private APIManager api;
	
	public AppController(){
		try {
			api = new APIManager();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void search() throws IOException{
		
		
		String keyword=ui.getTop().getSearchField().getText();
		List<OurVideo> list = api.search(ui.getTop().getSearchField().getText(), 25);
		ui.getCenter().setSelectedIndex(1);
		ui.getCenter().getSearchTab().update(list,"Results for "+"\'"+keyword+"\'"+" search");
		
	}
	
	public void connexVideo() throws IOException{
		List<OurVideo> list = new ArrayList<>();
		List<OurVideo> bigList = new ArrayList<>();
		for(OurVideo v : ui.getRight().getPlaylist().getVideos()){
			list = api.ConnexVideo(v);
			for(int i = 0;i<list.size();i++){
				bigList.add(list.get(i));
			}
		}
		Collections.shuffle(bigList);
		list = new ArrayList<OurVideo>();
		for(int i=0;i<10;i++){
			list.add(bigList.get(i));
		}
		ui.getCenter().getSearchTab().update(list, "Videoes you might like");
		ui.getCenter().setSelectedIndex(1);
	}

	public void popularVideo() throws IOException{
		List<OurVideo> list = api.searchPopular();
		ui.getCenter().setSelectedIndex(1);;
		ui.getCenter().getSearchTab().update(list,"Most popular videos at this time");
	}
    
	public void setUi(UserInterface ui) {
		this.ui = ui;
	}
	
	public void home(){
		Home home = new Home();
	}

	public void readOurVideo(OurVideo ourVideo){
		System.out.println("AppController : reading video "+ourVideo.getName());
		ui.getCenter().getVideoTab().setDetails(ourVideo);
		ui.getCenter().setSelectedIndex(0);
		String url = "";
		if (ourVideo.isOnline())
			url = "https://www.youtube.com/watch?v=";
		url=url+ourVideo.getVideoID();
		try {
			ui.getCenter().getVideoTab().playVideo(url);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void removeVideoFromPlaylist(PlaylistVideoComponent pvc) {
		ui.getRight().remove(pvc);
	}

	public void addToPlaylist(OurVideo ourVideo) {
		try {
			ui.getRight().updatePlaylist(ourVideo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void setAPIKey(String key) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("/youtube.properties")));
		String nom = "youtube.apikey="+key;
		bw.write(nom);
		bw.close();
		api = new APIManager();
	}

	public void setPlaylist(Playlist playlistChoice) {
		ui.getRight().setPlaylist(null);		
		ui.getRight().setPlaylist(playlistChoice);		
	}

	public void savePlaylist() {
		Playlist playlist = ui.getRight().getPlaylist();
		if (playlist.getVideos().isEmpty()){
			JOptionPane.showMessageDialog(null, "Your playlist is empty !");
		}else{
		
		String name = JOptionPane.showInputDialog("Please choose a name for this playlist :");
		saveOnFile(name, playlist);
		}
		
	}
	public void saveOnFile(String fileName, Playlist playlist){
		URL path = getClass().getProtectionDomain().getCodeSource().getLocation();
		File dir = new File("playlists");
		dir.mkdir();
		File fichier =new  File(dir+ "/"+ fileName);
		
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
