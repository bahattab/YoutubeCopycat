import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RightSideBarView extends JPanel{
	private Box sideBox;
	
	public RightSideBarView(){
		sideBox = Box.createVerticalBox();
		JButton b = createNewPreference("first button");
		sideBox.add(b);
		this.add(sideBox);
	}
	
	public Box getSideBox() {
		return sideBox;
	}

	JButton createNewPreference(String text){
		JButton newButton = new JButton();
		newButton.setText(text);
		newButton.setMaximumSize(new Dimension(500,30));
		return newButton;
	}
	
	public static void main(String[] args){
		JFrame truc = new JFrame();
		RightSideBarView V = new RightSideBarView();
		JButton encore=V.createNewPreference("encore un");
		JButton encore1=V.createNewPreference("fdufhzsduyfzogfyqerofqezyfpEZGQGUOZERQYEGFOU<GRYFOhhfqerfZHFIUZEIFLZefpZEUFIEFLZeu");
		V.getSideBox().add(encore);
		V.getSideBox().add(encore1);
		truc.add(V);
		truc.pack();
		truc.setVisible(true);
		System.out.println("truc");
		truc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
