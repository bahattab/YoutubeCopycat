package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.AppController;

public class TopView extends JPanel{
	
	private JTextField searchField;
	private JLabel srchLabel;
	private JButton srchButton;
	private AppController app;
	
	public TopView(AppController app){
		super(new FlowLayout(FlowLayout.CENTER));
		this.setOpaque(false);
		this.app=app;
		this.setMaximumSize(new Dimension(1800,200));
		searchField=new JTextField(50);
		searchField.setToolTipText("Type keywords here");
		srchButton=new JButton();
		srchButton.setText("Search");
		srchButton.setFont(new Font("Corbel",Font.BOLD,15));
		srchButton.setBorderPainted(false);
		srchButton.setFocusPainted(false);
		srchButton.setContentAreaFilled(true);
		srchButton.setBackground(Color.LIGHT_GRAY);

	    
	    searchField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					try {
						getApp().search();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					JTextField tf=(JTextField)e.getSource();
					tf.setText("");
			    }
			}
		});
	    srchButton.addMouseListener(new MouseAdapter(){
	    	@Override
	    	public void mousePressed(MouseEvent e){
	    		try {
					getApp().search();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	    		searchField.setText("");
	    	}
	    });
		this.add(searchField);
		this.add(srchButton);
	}

	public AppController getApp(){
		return this.app;
	}
	public JTextField getSearchField() {
		return searchField;
	}

	public JLabel getSrchLabel() {
		return srchLabel;
	}

	public JButton getSrchButton() {
		return srchButton;
	}

}
