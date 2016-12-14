package elements;

import java.util.ArrayList;

public class Playlist {
	
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
	
	

}
