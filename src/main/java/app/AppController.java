package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import API.APIManager;
import elements.OurVideo;
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
}
