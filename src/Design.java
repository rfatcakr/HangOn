import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;








import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;


public class Design implements Runnable,KeyListener{
	static int mode=0;
	int a=2;
	static Rectangle r1;
//sound system
	static Voice mp3 = new Voice();
	static int statu=0;
//end sound system
static int ortalama_hiz;
static int speed=0;
int way=7000;
int way2=11000;
int way3=18000;
static int r_speed=0;
	JLabel imageLabel1;
	  JLabel imageLabel2;
	  static int deltax=350;
		static int deltay=300;
		 static JLabel e;
		static JProgressBar  progressBar = new JProgressBar(0, 100);
		static int sure=0;
		static JLabel timer=new JLabel("Süre:0");
		 static JLabel hiz=new JLabel("Hiz:0");
		 static JLabel remain=new JLabel("Süre:0");
		 static JLabel skore=new JLabel("Skore:0");
		static ArrayList<Path> pathlist;
		
		static String picture="motor.png";
	public Design() {
		a=0;

		ImageIcon imagex = new ImageIcon(picture);
    	
    	
	    e= new JLabel(imagex); 
	        e.setBounds(350,300,50,130);
	        e.setVisible(true);
	        Main.gf.add(e);
	       
	        
	        

	        ///timer cagýran yapý
	        Intelegent az=new Intelegent();
	        
	        JLabel xx=new JLabel("Güc");
	        xx.setBounds(0,100,40,30);
	        xx.setVisible(true);
	        Main.gf.add(xx);
	   	 
	       
	        progressBar.setBounds(0,120,50,30);
	        progressBar.setValue(100);
	        progressBar.setStringPainted(true);
	        Main.gf.add(progressBar);
	      
	   

	       Main.gf.addKeyListener(this);
	       remain.setBounds(0,0,70,30);
	       skore.setBounds(0,30,80,30);
	       Main.gf.add(remain);
	       Main.gf.add(skore);
	       timer.setBounds(500, 0, 60, 30);
	     
	       Main.gf.add(timer);
	      
	       hiz.setBounds(610,0,60,30);
	       Main.gf.add(hiz);
	       
	       
	       
	       //path built
	       pathlist= new ArrayList<Path>();
	       Path np3=new Path("egim.png",-450);
		    
	        pathlist.add(np3);  
	       
	       Path np=new Path("road.png",0);
	       pathlist.add(np);
	       Path np11=new Path("egim2.png",-450);
	       pathlist.add(np11);
	        np=new Path("road2.png",0);
	        pathlist.add(np);
	 
	       
				            
		        
		    	
		      
		        
		        
		        
		        
		        
		        
		        
		        
		        
				
		        
		        
		        
		        
		        
		        
		        
		
	 Thread thread = new Thread(this);
		thread.start();

		
				
		
	}

	
	@Override
	public void run() {
		while(true){
			
			
			//average hýz*sure=gidilen yol hiz diye yanlýþ tanýmladým
			
			if(sure!=0 && Intelegent.pause!=1)
		    	ortalama_hiz+=r_speed/sure;

			remain.setText("Süre "+String.valueOf(Intelegent.gsayac));
			//gidilen yol / 50 puan olsun
			
			skore.setText("Skore "+String.valueOf(ortalama_hiz/5));
			timer.setText("Süre "+String.valueOf(sure));
		// TODO Auto-generated method stub
			
//	 System.out.printf("yüzde tamamlanan %d\n",ortalama_hiz/100);
			
			if((mode==1 || mode==2) && Intelegent.pause!=1){
			
				//viraj tersine kayýyor motor
				int xc=e.getBounds().x-1;
			e.setBounds(xc,e.getBounds().y,e.getBounds().width,e.getBounds().height);
			
			
			for(Path d:pathlist){
				if(d.name=="egim.png" && d.y>=0){
					if(d.x>-50){
						d.x-=10;
					d.Display();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
				}
			}
			}
			
			if((mode==3 || mode==4) && mode!=5){
				int xc=0;
				//viraj tersine kayýyor motor
				if(r_speed!=0)
					xc=e.getBounds().x+1;
				else
					xc=e.getBounds().x;
			e.setBounds(xc,e.getBounds().y,e.getBounds().width,e.getBounds().height);
			
			
			for(Path d:pathlist){
				if(d.name=="egim2.png" && d.y>=0){
					if(d.x>-50){
						d.x-=10;
					d.Display();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
				}
			}
			}
			
	//if()	
			
			//check point controller
			if(ortalama_hiz>way && Intelegent.gsayac>0 && way!=11000){
			way=11000;
			
				Gframe.starter.setVisible(true);
				Gframe.starter.setText("Check pointe eriþildi.");
				progressBar.setValue(100);
				Intelegent.gsayac=60+Intelegent.gsayac;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Gframe.starter.setVisible(false);
			
			}else if(Intelegent.gsayac<=0 && ortalama_hiz<7000 ){
				Gframe.starter.setVisible(true);
				Gframe.starter.setText("Check pointe kaçtý.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//
				Gframe.starter.setText("Game Over!!!");
				Intelegent.pause=1;
				Gframe.starter.setVisible(false);
				Save x=new Save();
			}else if(ortalama_hiz>way && Intelegent.gsayac>0 && way!=18000){
			way=18000;
			
				Gframe.starter.setVisible(true);
				Gframe.starter.setText("Check pointe eriþildi.");
				progressBar.setValue(100);
				Intelegent.gsayac=60+Intelegent.gsayac;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Gframe.starter.setVisible(false);
			
			}else if(Intelegent.gsayac<=0 && ortalama_hiz<11000 ){
				Gframe.starter.setVisible(true);
				Gframe.starter.setText("Check pointe kaçtý.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//
				Gframe.starter.setText("Game Over!!!");
				Intelegent.pause=1;
				Gframe.starter.setVisible(false);
				Save x=new Save();
			}else if(ortalama_hiz>=18000){
				Gframe.starter.setVisible(true);
				Gframe.starter.setText("Oyun baþarýyla tamamlandý.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//
				Save x=new Save();
				Intelegent.pause=1;
				
			}
			
			
			
			
			
			System.out.printf("%d\n",ortalama_hiz);
			if(ortalama_hiz>8000 && mode!=2 && ortalama_hiz<8500){
				
				for(Path v:pathlist){
					if(v.name=="road.png" || v.name=="road2.png"){
						v.y+=50;
						mode=1;
							
						for(Path d:pathlist){
							if(d.name=="egim.png" && d.y<0){
							d.y+=50;
							d.Display();
							}
							if(d.name=="egim.png" && d.y>=0){
								mode=2;
								v.y=-450;
							
							}
							
						}
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			}else if(ortalama_hiz>8500 && mode==2 && ortalama_hiz<16500){
				
				for(Path v:pathlist){
					if(v.name=="egim.png"){
						v.y+=50;
						v.Display();
					
					}
					if(v.name=="road.png" || v.name=="road2.png"){
						v.y+=50;
						v.Display();
						if(v.y>=0){
							mode=0;
						}
					}
					
					
				}
			}else if(ortalama_hiz>16500 && mode!=3 && ortalama_hiz<17000){
				for(Path v:pathlist){
					if(v.name=="road.png" || v.name=="road2.png" && v.y<-400){
						v.y+=50;
						mode=4;
							
						for(Path d:pathlist){
							if(d.name=="egim2.png" && d.y<0){
							d.y+=50;
							d.Display();
							}
							if(d.name=="egim2.png" && d.y>=0){
								mode=3;
								v.y=-450;
							
							}
							
						}
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}else if(ortalama_hiz>=17000 && ortalama_hiz<18000){
				
				for(Path v:pathlist){
					if(v.name=="egim2.png"){
						v.y+=50;
						v.Display();
					
					}
					if(v.name=="road.png" || v.name=="road2.png"){
						if(v.y<0){
						v.y+=50;
						mode=5;
						v.Display();
						}
						
					}
					
					
				}
			}
if(Intelegent.pause!=1){			
		if(a==0 && speed!=0){
			for(Path v:pathlist){
				if(v.name=="road.png"){
					v.Display();
				}else if(v.name=="road2.png"){
					v.hide();
				
				
				}
				
			}
			
			//imageLabel1.setVisible(false);
			//imageLabel2.setVisible(true);
	a=1;
		}else if (a!=0 && speed!=0){
			
			//imageLabel1.setVisible(true);
			//imageLabel2.setVisible(false);
			
			for(Path v:pathlist){
				if(v.name=="road.png"){
					v.hide();
			}else if(v.name=="road2.png"){
					v.Display();
				
				}
				
			}
			
			 a=0;
	}
}
		try {
			Thread.sleep(speed);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ses ver
		
			if(r_speed>-10 && statu==0){
				statu=1;

				mp3.Cal(1);
				
			}
			if(r_speed<10 ){
				statu=0;
				mp3.Cal(0);
			}
		}
		
	}

	@Override
	public void keyPressed(KeyEvent er) {
		// TODO Auto-generated method stub
		
		 if (er.getKeyCode() == KeyEvent.VK_LEFT && Intelegent.pause!=1){
		        
		        for (Motors xx : Intelegent.list) {
		        	
					 Rectangle		 r11 = new Rectangle(xx.x,xx.y, 50,130);
					 Rectangle	r22 = new Rectangle(Design.deltax-10, Design.deltay, 50,130);
						if(!r11.intersects(r22)){
					//	 System.out.print("its ok11\n");
						 move(deltax, 0);
						 }else{
							 System.out.print("kaza\n");
							 Design.progressBar.setValue(Design.progressBar.getValue()-10);
  							 //kaza
						 }
				 }
		        
		        
		        ImageIcon imagex = new ImageIcon("sol.png");
	    		
		    	e.setIcon(imagex);     
		         
		 }
		    else if (er.getKeyCode() == KeyEvent.VK_RIGHT && Intelegent.pause!=1){
		        for (Motors xx : Intelegent.list) {
		        	
		  					 Rectangle		 r11 = new Rectangle(xx.x,xx.y, 50,130);
		  					 Rectangle	r22 = new Rectangle(Design.deltax+10, Design.deltay, 50,130);
		  						if(!r11.intersects(r22)){
		  						 move(-deltax, 0);
		  						 }else{
		  							 System.out.print("kaza\n");
		  							 Design.progressBar.setValue(Design.progressBar.getValue()-10);
		  							 //kaza
		  						 }
		  				 }
		  		        
		    	
		    	  ImageIcon imagex = new ImageIcon("sag.png");
		    		
		    	e.setIcon(imagex);	
		  	   
		    
		 		
		      
		    }
		    else if (er.getKeyCode() == KeyEvent.VK_UP && Intelegent.pause!=1){
		    	
		    	if(r_speed==100)
		    	{
		    		
		    	}else 	if(speed==0 && r_speed!=90){
		    		speed=1000;
		    		r_speed=10;
		    	}
		    	
		    	else{
		    		speed=speed-100;
		    		r_speed=r_speed+10;
		    	}
		    	String gs="Hiz:"+String.valueOf(r_speed);
		    
		    	hiz.setText(gs);
		    	
		       //hizlan
		    }
		    else if (er.getKeyCode() == KeyEvent.VK_DOWN && Intelegent.pause!=1){
		    	  //yavaþla
		     if(r_speed>0){
		    	 speed=speed+100;
		    	 r_speed=r_speed-10;
		     }
		     if(r_speed==0)
		    	 speed=0;
		     String gs="Hiz:"+String.valueOf(r_speed);
		    	hiz.setText(gs);
		      
		    }
	}

public void	move(int delta_x,int delta_y){
	if(delta_x!=0){
		if(delta_x>0){
		
		if(deltax!=30){
		
			deltax=deltax-10;
			
			
			
			
			e.setBounds(deltax,deltay,e.getWidth(),e.getHeight());
		Main.gf.repaint();}
		}else
		{
			if(deltax!=730){
			deltax=deltax+10;
			e.setBounds(deltax,deltay,e.getWidth(),e.getHeight());
			r1 = new Rectangle(deltax, deltay, e.getWidth(),e.getHeight());
			Main.gf.repaint();
			}
		}
	}

	
}

	@Override
	public void keyReleased(KeyEvent er) {
		// TODO Auto-generated method stub
		ImageIcon imagex = new ImageIcon("motor.png");
		
    	e.setIcon(imagex);
	}

	@Override
	public void keyTyped(KeyEvent er) {
		// TODO Auto-generated method stub
		
	}
	public void restart(){
		
	}
}
