package app;

import java.io.IOException;
import java.util.List;

import API.APIManager;
import elements.OurVideo;

public class AppController {
	private UserInterface ui;
	
	public AppController(){
		
	}
	
	public void search() throws IOException{
		APIManager api = new APIManager();
		List<OurVideo> list = api.search(ui.getTop().getSearchField().getText(), 25);
		ui.getCenter().getSearchTab().update(list);
	}

	public void setUi(UserInterface ui) {
		this.ui = ui;
	}
}
