import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Save {
 Save(){
	 
	 ImageIcon imagex ;
		
		Gframe.starter.setVisible(true);
		Gframe.starter.setText("Oyun bitti!!!");
		if(Intelegent.pause!=1){
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("scores.txt", true)))) {
		    
			out.print(Login.tt.getText());
			
			out.print(" "+String.valueOf(Design.ortalama_hiz));
			out.println("\n");
			
			   
			 
		}catch (IOException e1) {
			System.out.print("err");
		    //exception handling left as an exercise for the reader
		}
		}
		
		int i;
		i=0;
		while(i<3){
			if(i==1){
				imagex = new ImageIcon("patlama1.png");
				Design.e.setIcon(imagex);
			}
			else if(i==2)
			{	imagex = new ImageIcon("patlama2.png");
				Design.e.setIcon(imagex);
			}
			else {
				imagex = new ImageIcon("patlama3.png");
				Design.e.setIcon(imagex);
			}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;
		}
		if(Intelegent.pause!=1){
		   JOptionPane.showMessageDialog(null,"GAME OVER","INFORMATION", JOptionPane.PLAIN_MESSAGE);
		   
		Records z=new Records();
		}
		Intelegent.pause=1;
	 
 }
}
