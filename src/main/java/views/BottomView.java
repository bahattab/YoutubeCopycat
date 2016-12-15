package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BottomView extends JPanel {

	private JLabel bLabel1;
	private JLabel bLabel2;
	
	public BottomView(){
		super();
		//Color color = new Color(191, 24, 0);
		this.setOpaque(false);
		this.setMaximumSize(new Dimension(1500,150));
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		bLabel1=new JLabel("This project is licensed under the terms of the Apache License 2.0");
		bLabel1.setFont(new Font("Corbel",10,15));
		bLabel1.setForeground(Color.WHITE);
		bLabel2=new JLabel("Authors : Graziella Husson, Timothy Garwood, Quentin Thareau, Valentina Zelaya");
		bLabel2.setForeground(Color.WHITE);
		bLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
		bLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(bLabel1);
		this.add(bLabel2);
	}
	
	
}
