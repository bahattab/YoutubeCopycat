package app;

import views.Home;
import views.PlaylistTab;

public class YoutubeCopycat {

	public static void main(String[] args) {
		AppController app = new AppController();
		app.home();
		UserInterface ui=new UserInterface(app);
		app.setUi(ui);
		try{
			ui.getCenter().getVideoTab().playVideo("https://www.youtube.com/watch?v=RtRb51L3hPQ");
			
		}catch (InterruptedException interrupt){
			System.out.println("playing was interrupted");
		}	


	}

}
