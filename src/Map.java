import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;


public class Map extends JFrame {
	Map(){
		setTitle("Map");
		setLayout(null);
		setSize(700,500);
		 
	        JLabel completed=new JLabel("Tamamlanan: %"+String.valueOf(Design.ortalama_hiz/180));
	       
	        completed.setForeground(Color.white);
	        completed.setBounds(300,100,200,50);
	        completed.setVisible(true);
	        add(completed);
	        
	        JProgressBar  progressBar = new JProgressBar(0, 100);
	        progressBar.setBounds(300,150,200,30);
	        progressBar.setValue(Design.ortalama_hiz/180);
	        progressBar.setStringPainted(true);
	        add(progressBar);
		
		
		JLabel imageLabel1;
		ImageIcon image = new ImageIcon("bgpicture2.png");
		imageLabel1= new JLabel(image); 
		 imageLabel1.setBounds(0,0, 700,450);
		 imageLabel1.setVisible(true);
	        add(imageLabel1);
		
	       
		setVisible(true);
		
		
		  
	}
}
