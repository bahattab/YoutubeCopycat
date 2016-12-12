package views;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TopView extends JPanel{
	
	private JTextField searchField;
	private JLabel srchLabel;
	private JButton srchButton;
	
	public TopView(){
		super(new FlowLayout(FlowLayout.CENTER));
		this.setMaximumSize(new Dimension(1800,200));
		searchField=new JTextField(50);
		srchLabel=new JLabel("Type keywords here");
		srchButton=new JButton();
		srchButton.setText("Search");
		srchLabel.setCursor(Cursor.getDefaultCursor());
	    searchField.add(srchLabel, BorderLayout.LINE_END);
	    srchLabel.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            searchField.setText("");
	        }
	    });
		this.add(searchField);
		this.add(srchButton);
	}
}
