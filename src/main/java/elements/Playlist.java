package elements;

import java.io.Serializable;
import java.util.ArrayList;

public class Playlist implements Serializable{

	ArrayList<OurVideo> videos;
	int currentVideo;
	
	public ArrayList<OurVideo> getVideos() {
		return videos;
	}

	public Playlist(){
		videos = new ArrayList<OurVideo>();
		currentVideo=-1;
	}
	
	public Playlist(Playlist playlist) {
		videos = new ArrayList<OurVideo>(playlist.getVideos().size());
		for (OurVideo ov : playlist.getVideos())
			videos.add(ov.copy());
		currentVideo=playlist.currentVideo;
	}

	public void addVideo(OurVideo video){
		videos.add(video);
		//currentVideo++;
	}
	
	public void removeVideo(OurVideo video){
		int j = videos.indexOf(video);
		videos.remove(video);
		if (j<currentVideo)
			currentVideo--;
	}
	
	public void removeAll(){
		for (int i =0; i< videos.size(); i++)
			videos.remove(i);
		currentVideo=-1;
	}
	
	public boolean existsIn(OurVideo video){
		for(OurVideo myVideo : videos){
			if(myVideo.getVideoID().equals(video.getVideoID())){
				System.out.println(myVideo.getName() + " same as "+ video.getName());
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

	public OurVideo getNext() throws Exception {
		currentVideo++;
		if (currentVideo<videos.size())
			return videos.get(currentVideo);
		else throw new Exception("End of playlist exception");
		
	}
	
	public OurVideo getPrevious() throws Exception {
		currentVideo--;
		if (currentVideo>-1)
			return videos.get(currentVideo);
		else throw new Exception("Start of playlist exception");
	}
	
	public void setCurrent(OurVideo ourVideo) {
		currentVideo=videos.indexOf(ourVideo);
	}


}