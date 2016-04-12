import java.awt.Rectangle;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
//resimleri kücült
//koselerden daralt
//width height dynamic yap


//imageler y kordinatý arttýkca boyutda kücülecek

//this class aims to create working schema of virtual motors
public class Intelegent implements Runnable  {
	static ArrayList<Motors> list;
int sayac=-4;
static int gsayac=60;
JTextArea a;
int cc=0;
static int pause=0;
static Motors b_mtr;
	Intelegent(){

		 list= new ArrayList<Motors>();
	       // Motors nm=new Motors(250,120,100,300);
		 Motors nm=new Motors(250,120,50,130);
		  list.add(nm);
		   
			 nm=new Motors(322,180,50,130);
	    	list.add(nm);
	    			nm=new Motors(222,500,50,130);
	    	list.add(nm);
	    		nm=new Motors(100,220,50,130);
	    	list.add(nm);
	    		nm=new Motors(150,170,50,130);
	    	list.add(nm);
	    		nm=new Motors(250,620,50,130);
	    	list.add(nm);
	    	nm=new Motors(100,620,50,130);
	    	list.add(nm);
	    		nm=new Motors(360,600,50,130);
	    	list.add(nm); 
	    	/*	nm=new Motors(Design.deltax,Design.deltay,50,130);
	    	list.add(nm);*/
		 (new Thread(this)).start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		 while(true){
			 System.out.print("3");
			if(pause!=1){
				System.out.print("2");
			sayac++;
			
				if(sayac<1){
					
					if(Design.speed>0){
						Gframe.starter.setText("Punished!!");
						Design.speed=0;
						Design.hiz.setText("Hiz:0");
						sayac=-4;
					}else{
						int c=sayac*-1;
						if(sayac!=0)
						Gframe.starter.setText(String.valueOf(c));
						else
							Gframe.starter.setText("Baþla!!!");
						
								
					}
				
				
			}else {
				gsayac--;
				if(gsayac<0)
					gsayac=60;
				
				Design.sure=sayac;
				Gframe.starter.setVisible(false);
				 for (Motors mtr : list) {
					 Random rand = new Random();

					 int  n = rand.nextInt(10) + 1;
					 if(n%2==1){
						 n=n*-1;
					 }
					 
					 int fark=Design.r_speed/2;
					 if(Design.r_speed<=30)
						 fark=60;
//					 System.out.printf("%d",fark);
	if(Design.r_speed<50+n*10){
		fark=fark*-1;
	}
	if(Design.r_speed==0)
		fark=-70;
	if(Design.r_speed>90)
		fark=+5;
	 //control for any accident before increase y
	if(mtr.statu!=0){
	b_mtr=mtr;
	mtr.y+=n+fark;

	try {
		this.control();
		
		
	} catch (Exception e) {
		
	} 
	if(cc==1 ){
		mtr.y+=n-fark;
		
	}
	}
	
	
	
	
	
	
	if(mtr.y<100 && mtr.y>0){
		ImageIcon	imagex;
		if(Design.mode==1){
			imagex = new ImageIcon("sag2_1.png");
			
		 }else{
		  imagex = new ImageIcon("motor2_1.png");
		
		 }
		mtr.setIcon(imagex);
	}else if(mtr.y<=0){
		ImageIcon	imagex;
		if(Design.mode==1){
			imagex = new ImageIcon("sag2_2.png");
			
		 }else{
		  imagex = new ImageIcon("motor2_2.png");
		
		 }
		mtr.setIcon(imagex);
	}
		
	
	
	if((Design.deltax>=550 || Design.deltax<=70) || Design.progressBar.getValue()==0)
	{//bizim motor dýþarý çýktý
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
	
if((mtr.x>=530 || mtr.x<=80) && mtr.statu!=0){
	
		Patlama patla = new Patlama(mtr);
	
}
			
	//%33 percent to change x cordinate-> n%3=1
	else if(mtr.x!=530 && mtr.x!=80 && n%3==1){
			if(n>0){
				if((mtr.y<100 && mtr.y>0 )|| Design.mode==1){
					ImageIcon  imagex = new ImageIcon("sag2_1.png");
					mtr.setIcon(imagex);
				}else if(mtr.y<=0 || Design.mode==1){
					ImageIcon  imagex = new ImageIcon("sag2_2.png");
					mtr.setIcon(imagex);
				}
				
				else
				{ImageIcon  imagex = new ImageIcon("sag2.png");
				mtr.setIcon(imagex);
				}
			}else if(n<0){
				if((mtr.y<100 && mtr.y>0) || Design.mode==4){
					ImageIcon  imagex = new ImageIcon("sol2_1.png");
					mtr.setIcon(imagex);
				}else if(mtr.y<=0 || Design.mode==4){
					ImageIcon  imagex = new ImageIcon("sol2_2.png");
					mtr.setIcon(imagex);
				}else
				{ImageIcon  imagex = new ImageIcon("sol2.png");
				mtr.setIcon(imagex);
				}
			}

			mtr.x+=n;
			try {
				this.control();
				
				
			} catch (Exception e) {
				
			} 
			mtr.x-=2*n;
		}
		
		if(mtr.y<400)
			mtr.x-=n;
					
						            mtr.Display();
						try {
							//yana dönüþ effectlerini görünür kýlmak icin
							Thread.sleep(450);
							//uzaklaþtýkca kücül büyü
							if(mtr.statu==0){
								ImageIcon  imagex = new ImageIcon("patlama.gif");
								mtr.setIcon(imagex);
							}
							else if(mtr.y<100 && mtr.y>0){
								ImageIcon imagex;
								if(Design.mode==1){
									imagex = new ImageIcon("sag2_1.png");
									
								 }else if(Design.mode==4){
									 imagex = new ImageIcon("sol2_1.png");
								 }else
									 imagex = new ImageIcon("motor2_1.png");
							
									mtr.setIcon(imagex);
							}

							else if(mtr.y<=0){
								ImageIcon imagex;
								if(Design.mode==1){
									imagex = new ImageIcon("sag2_2.png");
									
								 }else if(Design.mode==4){
									 imagex = new ImageIcon("sol2_2.png");
								 }
									 else
								  imagex = new ImageIcon("motor2_2.png");
								mtr.setIcon(imagex);
								

						}	else{
							ImageIcon imagex;
							if(Design.mode==1){
								imagex = new ImageIcon("sag2.png");
								
							 }else if(Design.mode==4){
								 imagex = new ImageIcon("sol2.png");
							 }
								 else
							  imagex = new ImageIcon("motor2.png");
							
							mtr.setIcon(imagex);

							}
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					    }
				
			}
			try {
				Thread.sleep(700);
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
	}}
	private void control() {
		
		// TODO Auto-generated method stub 
		//bmtr suanki motor
		//xx arraydeki
		//design deki r1 bizim motoru temsil ediyor
		
		
		//bizim motor ve o anki hareketi yapan motor arasý etkileþim
		Rectangle r11 = new Rectangle(b_mtr.x,b_mtr.y, 50,130);
		 Rectangle r22 = new Rectangle(Design.deltax, Design.deltay, 50,130);
		 if(!r11.intersects(r22)){
			// System.out.print("its ok\n");
			 
		 }else{
			// System.out.print("üst üste\n");
			 Design.progressBar.setValue(Design.progressBar.getValue()-5);
				System.out.print("vurdu!!\n");

		 }
		 
		 
		 
		//pc motorlarý carpýsma önleme
		 for (Motors xx : list) {
			 if(Design.mode==1)//saga yaslan
				 xx.x+=10;
			 r11 = new Rectangle(xx.x,xx.y, 50,130);
			 	r22 = new Rectangle(b_mtr.x, b_mtr.y, 50,130);
				if(!r11.intersects(r22)  ){
				//	System.out.print("its ok\n");	
					
					 cc=0;
				 }else{
					//arrayde ayný motor match ederse hep üst üste bulucak	
					 if(xx.x!=b_mtr.x){
							cc=1;
							//System.out.print("üst üste\n");	
						}
						else {
							cc=0;
							//System.out.print("its ok\n");	
									
						}
					 
				 }
		 }
	}
}
