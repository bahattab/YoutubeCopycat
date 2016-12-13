package app;


public class YoutubeCopycat {

	public static void main(String[] args) {
		AppController app = new AppController();
		UserInterface ui=new UserInterface(app);
		app.setUi(ui);
	}

}
