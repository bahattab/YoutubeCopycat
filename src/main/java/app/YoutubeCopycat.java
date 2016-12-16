package app;

public class YoutubeCopycat {

	public static void main(String[] args) {
		AppController app = new AppController();
		app.home();
		UserInterface ui=new UserInterface(app);
		app.setUi(ui);
		try{
			ui.getCenter().getVideoTab().playVideo("https://www.youtube.com/watch?v=6HZ5pkJ7Sb0");
		}catch (InterruptedException interrupt){
			System.out.println("playing was interrupted");
		}	


	}

}
