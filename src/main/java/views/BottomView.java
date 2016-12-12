package main.java.views;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BottomView extends JPanel {

	private JLabel bLabel1;
	private JLabel bLabel2;
	
	public BottomView(){
		super();
		this.setMaximumSize(new Dimension(1500,150));
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		bLabel1=new JLabel("This project is licensed under the terms of the Apache License 2.0");
		bLabel2=new JLabel("Authors : Graziella Husson, Timothy Garwood, Quentin Thareau, Valentina Zelaya");
		bLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
		bLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(bLabel1);
		this.add(bLabel2);
	}
	
	
}
