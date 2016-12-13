package app;


public class YoutubeCopycat {

	public static void main(String[] args) {
		UserInterface ui=new UserInterface();
		try{
			ui.getCenter().getVideoTab().playVideo("https://www.youtube.com/watch?v=cggl4WN77Mw");
			
		}catch (InterruptedException interrupt){
			System.out.println("playing was interrupted");
		}


	}

}
