import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Motors {

int x,y;
int x1,y1;
JLabel m1;
int statu=1;
Rectangle r1;
		Motors(int x,int y,int x1,int y1){
					
		this.x=x;
		this.y=y;
		this.x1=x1;
		this.y1=y1;
			
		
		
			ImageIcon  imagex ;
			if(statu==0){
				 imagex = new ImageIcon("patlama.gif");
				 
			}
			 else if(y<100 && y>0){
			{
				
				if(Design.mode==1){
					imagex = new ImageIcon("sag2_1.png");
					
				 }else
					 imagex = new ImageIcon("motor2_1.png");
			}
				

		}else if(y<=0){
			if(Design.mode==1){
				imagex = new ImageIcon("sag2_2.png");
				
			 }else
			 imagex = new ImageIcon("motor2_2.png");
		}	else{
			if(Design.mode==1){
				imagex = new ImageIcon("sag2_2.png");
				
			 }else
		  imagex = new ImageIcon("motor2.png");
		

		}
			   m1= new JLabel(imagex); 
			        m1.setBounds(x,y,x1,y1);
			        m1.setVisible(true);
			        Main.gf.add(m1);
		
			        r1 = new Rectangle(x, y, m1.getWidth(),m1.getHeight());
		
		
					
			}
void Display(){
	 m1.setBounds(x,y,x1,y1);
}
public void setIcon(ImageIcon imagex) {
	// TODO Auto-generated method stub
	m1.setIcon(imagex);
}



}
