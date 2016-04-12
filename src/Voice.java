import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javax.sound.sampled.FloatControl;

import javazoom.jl.player.Player;
public class Voice {
	 private String filename="ses.mp3";
	 private static Player player; 
	 
	 public void close() { if (player != null) player.close(); }
	 public void play() {
	        try {
	            FileInputStream fis     = new FileInputStream(filename);
	            BufferedInputStream bis = new BufferedInputStream(fis);
	            player = new Player(bis);
	        }
	        catch (Exception e) {
	            System.out.println("Problem playing file " + filename);
	            System.out.println(e);
	        }

	        // run in new thread to play in background
	        new Thread() {
	            public void run() {
	                try { player.play(); }
	                catch (Exception e) { 
	                	
	                	//System.out.println(e);
	                //süekli exception fýraltýyor
	                
	                }
	            }
	        }.start();




	    }
	 public void Cal(int v){
		
		 if(v==1){
			
			 Design.mp3.play();
			 
		 }else if(v==0){
			 Design.mp3.close();
		 }
	   
	 }
	 
	 
	public static Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
