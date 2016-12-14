package elements;

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
	
	public void removeAll(){
		for (int i =0; i< videos.size(); i++)
			videos.remove(i);
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
}