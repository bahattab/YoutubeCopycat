package elements;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Playlist implements Serializable{

	ArrayList<OurVideo> videos;
	
	public ArrayList<OurVideo> getVideos() {
		return videos;
	}

	public Playlist(){
		videos = new ArrayList<OurVideo>();
	}
	
	public void addVideo(OurVideo video){
		videos.add(video);
	}
	
	public void removeVideo(OurVideo video){
		videos.remove(video);
	}
	
	public boolean existsIn(OurVideo video){
		for(OurVideo myVideo : videos){
			if(myVideo.getVideoID().equals(video.getVideoID())){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Playlist [videos=" + videos + "]";
	}
	
	public int size(){
		return videos.size();
	}

	public void saveOnFile(){
		File fichier= new File("playlist");
		System.out.println(fichier);
	       try {
	         ObjectOutputStream flotEcriture = 
	             new ObjectOutputStream(
	                new FileOutputStream(fichier));
	         flotEcriture.writeObject(this);
	         flotEcriture.close();
	       } catch (IOException e) {
	         System.out.println(" erreur :" + e.toString());
	       }  
	}
	
	public static void main(String[] args) {
		     File fichier= new File("playlist");
		     try {
		       ObjectInputStream flotLecture = 
		             new ObjectInputStream(
		                new FileInputStream(fichier));
		       Object lu = flotLecture.readObject();
		       Playlist playlist=(Playlist)lu;
		       System.out.println(playlist);
		       flotLecture.close();
		     } catch (Exception e) {
		       System.out.println(" erreur :" +e.toString());
		     }    
		
	}
}