package views;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SearchTab extends JPanel{
	
	private ImageIcon searchIcon;
	
	public ImageIcon getSearchIcon() {
		return searchIcon;
	}

	public void setSearchIcon(ImageIcon videoIcon) {
		this.searchIcon = videoIcon;
	}
	
	public SearchTab(){
		super();
		String srchIconPath="src/main/resources/icons/search.png";
		searchIcon = new ImageIcon(srchIconPath);
		
	}
	

}
