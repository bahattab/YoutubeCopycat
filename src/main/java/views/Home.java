package views;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Home extends JPanel{


	public Home(){
		String message = "A video is running by default. To use this application, you can : "
				+ "\n- Do a research with some key words by cliking on the search button\n "
				+ "    - Once this search shows some results in the tab 'Search', you can click on a result to load the video in the Video Tab.\n"
				+ "    - You can do as many search as you want, but the results will be replaced\n"
				+ "- See some statictics by clicking on the graph icon"
				+ "  \n- Add videos at your playlist by clicking on the add button\n"
				+ "- Remove videos from your playlist by clicking on the remove button";
		JOptionPane.showMessageDialog(null, message, "Use conditions",1);
	}
	
}
