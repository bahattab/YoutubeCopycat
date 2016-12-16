package views;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JPanel;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.runtime.x.LibXUtil;


import com.sun.jna.Native;

import app.AppController;

public class VideoPlayer extends JPanel {
	private Canvas videoSurface;
	private EmbeddedMediaPlayer mediaPlayer;
	private PlayerControlsPanel controlsPanel;
	private AppController app;
	
	public VideoPlayer(AppController appC) {
		registerLibrary();
		this.app=appC;
		this.setLayout(new BorderLayout());
		videoSurface = new Canvas();
		videoSurface.setBackground(Color.BLACK);
		
		final List<String> vlcArgs = new ArrayList<String>();
		configureParameters(vlcArgs);
		
		this.add(videoSurface,BorderLayout.CENTER);
		
		mediaPlayer = createPlayer(vlcArgs, videoSurface);
		mediaPlayer.setVolume(100);
		controlsPanel=new PlayerControlsPanel(mediaPlayer,app);
		this.add(controlsPanel,BorderLayout.SOUTH);
		}


	/**
	 *  Runs the audio/video file
	 */
	public void play(final String filename) {
		if (mediaPlayer.isPlaying())
			mediaPlayer.stop();
		mediaPlayer.playMedia(filename);
		
	}
	

	/**
	 *  Important: Notice where is the libvlc, which contains all native functions to manipulate the player
	 * 
	 *  Windows: libvlc.dll
	 *  Linux: libvlc.so
	 */
	private void registerLibrary() {
		/**NativeLibrary.addSearchPath(
				RuntimeUtil.getLibVlcLibraryName(), "C:\\Program Files (x86)\\VideoLAN\\VLC");
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		*/
		NativeDiscovery nd = new NativeDiscovery();
		if(!nd.discover()){
			System.out.println("VLC Not found");
			//System.exit(-1);
		}
		String vlcLibName = RuntimeUtil.getLibVlcLibraryName();
		String vlcLibCoreName = RuntimeUtil.getLibVlcCoreName();
		Native.loadLibrary(vlcLibName, LibVlc.class);
		LibXUtil.initialise();
	}

	




	/**
	 * Configure VLC parameters
	 */
	private void configureParameters(final List<String> vlcArgs) {
		vlcArgs.add("--no-plugins-cache");
		vlcArgs.add("--no-video-title-show");
		
		// Important, if this parameter is not set on Windows, the app won't work
		if (RuntimeUtil.isWindows()) {
			vlcArgs.add("--plugin-path=D:\\vlc-2.2.1\\plugins");
		}
	}


	/**
	 * Build the player
	 */
	private EmbeddedMediaPlayer createPlayer(final List<String> vlcArgs, final Canvas videoSurface) {



		MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory(vlcArgs.toArray(new String[vlcArgs.size()]));
		mediaPlayerFactory.setUserAgent("vlcj test player");

		EmbeddedMediaPlayer embeddedMediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();

		embeddedMediaPlayer.setVideoSurface(mediaPlayerFactory.newVideoSurface(videoSurface));
		embeddedMediaPlayer.setPlaySubItems(true);


		return embeddedMediaPlayer;
	}


	public void setControlPanelPlaylistMode(boolean b) {
		controlsPanel.setPlaylistMode(b);
		
	}
	
}
