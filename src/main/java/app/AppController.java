package app;

import java.io.IOException;
import java.util.List;

import API.APIManager;
import elements.OurVideo;
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
		
		List<OurVideo> list = api.search(ui.getTop().getSearchField().getText(), 25);
		ui.getCenter().getSearchTab().update(list);
	}

	public void setUi(UserInterface ui) {
		this.ui = ui;
	}
	
	public void home(){
		Home home = new Home();
	}
}
