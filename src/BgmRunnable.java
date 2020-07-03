

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

public class BgmRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		File sound=new File("pvz_picture\\Brainiac Maniac.wav");
		AudioClip audio;
		try {
			audio = Applet.newAudioClip(sound.toURL());
			audio.loop();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}

}
