package elements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import app.AppController;

public class SettingsButton extends JButton {

	public SettingsButton(ImageIcon icon3, final AppController app) {
		this.setIcon(icon3);
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String key = JOptionPane.showInputDialog("Please enter your YouTube API key :");
				try {
					app.setAPIKey(key);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
		});
	}

}
