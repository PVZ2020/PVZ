package main;

import plants.*;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import action.*;

public class BgmRunnable implements Runnable{
	URL url ;
	@Override
	public void run() {
		// TODO Auto-generated method stub
			
		try
		{
			File musicPath = new File("pvz_audio\\mainmusic1.wav");
			
			if(musicPath.exists())
			{
				System.out.print(000);
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
			else
			{
				
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

			
		}
	

}
