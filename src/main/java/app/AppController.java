package app;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
		List<OurVideo> fatList = new ArrayList<>();
		fatList = ui.getRight().getPlaylist().getVideos();
		if (fatList.isEmpty()){
			ui.getLeft().suggestionsHelp();
		}
		else{
		for(OurVideo v : fatList){
			if(v.isOnline()){
				list = api.ConnexVideo(v);
				for(int i = 0;i<list.size();i++){
					bigList.add(list.get(i));
				}
				Collections.shuffle(bigList);
				list = new ArrayList<OurVideo>();
				for(int i=0;i<10;i++){
					list.add(bigList.get(i));
				}
				ui.getCenter().getSearchTab().update(list, "Videos you might like");
				ui.getCenter().setSelectedIndex(1);
			}
		}
		Collections.shuffle(bigList);
		list = new ArrayList<OurVideo>();
		for(int i=0;i<10;i++){
			list.add(bigList.get(i));
		}
		for(int i=0;i<10;i++){
			for(int j=0;i<10;j++){
				//for(int k=0;k<fatList.size();k++)
				if((i != j) && (list.get(i) == list.get(j) /*|| (list.get(i) == fatList.get(k)))*/)){
					
					Collections.shuffle(bigList);
					list.set(i,bigList.get(0)); 
					i--;
					for(int k=0;k<fatList.size();k++){
						if((i != k) && (list.get(i) == fatList.get(k))){
							Collections.shuffle(bigList);
							list.set(i,bigList.get(0));
							i--;
						}
						}
					}
				}
			}
		
		ui.getCenter().getSearchTab().update(list, "Videos you might like");
		ui.getCenter().setSelectedIndex(1);
		}
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
	
	public void playNextVideoFromPlaylist(){
		if (ui.getRight().getPlaylist().getVideos().isEmpty()){
			
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
	
	public HashMap<String, Playlist> loadPlaylist(){
		System.out.println("loadPlaylist");
		ArrayList<Playlist> l = new ArrayList<Playlist>();
		File repertoire = new File("playlists");
		File[] files=repertoire.listFiles();
		String[] f = null;
		HashMap<String, Playlist> hm = new HashMap<>(0);
		//String[] dir = new java.io.File("playlist").list( );
        /*for (int i=0; i<files.length; i++)
        {
            f[i] = files[i].toString();
	    }*/
		for(int i=0;i<files.length;i++){
			try{	
				ObjectInputStream flotLecture = new ObjectInputStream( new FileInputStream(files[i]));
				Object lu= new Object();
				try {
					lu = flotLecture.readObject();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				//f[i] = files[i].toString();
				Playlist playlistChoice=(Playlist)lu;
				hm.put(files[i].toString(), playlistChoice);				
			}catch(IOException e){
				System.out.println(" erreur :" + e.toString());
		}
		}
		return hm;
	}

	public void fillPlaylistTab() {
		
		System.out.println("fillPlayListTab");
		try {
			ui.getCenter().getPlaylistTab().update(loadPlaylist(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
