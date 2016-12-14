package elements;

import java.util.ArrayList;

public class Playlist {
	
	ArrayList<OurVideo> playlist;
	
	public Playlist(){
		playlist = new ArrayList<OurVideo>();
	}
	
	public ArrayList<OurVideo> getPlaylist(){
		return playlist;
	}
	
	public void addVideo(OurVideo video){
		playlist.add(video);
	}
	
	public void removeVideo(OurVideo video){
		playlist.remove(video);
	}

}
