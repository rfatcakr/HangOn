import javax.swing.ImageIcon;


public class Patlama {

	
	Motors mtr;
	Patlama(Motors mtr){

		this.mtr=mtr;


		ImageIcon imagex = new ImageIcon("patlama1.png");

		mtr.setIcon(imagex);
		mtr.statu=0;
		int i=0;
		int g=0;
		for(Motors v:Intelegent.list){
			if(v.statu==0)
				g=i;
		i++;
		}
		
		//Intelegent.list.remove(g);
		
		Gframe.starter.setVisible(true);
		Gframe.starter.setText(String.valueOf(g)+" NO'lu motor oyun dýþýna atýldý");
		System.out.print("motorlar carpýþtý");
		i=0;
		while(i<3){
			if(i==1)
				imagex = new ImageIcon("patlama1.png");
			else if(i==2)
				imagex = new ImageIcon("patlama2.png");
			else 
				imagex = new ImageIcon("patlama3.png");
			mtr.setIcon(imagex);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;
		}
		Gframe.starter.setVisible(false);
		mtr.m1.setVisible(false);
		mtr.x1=0;
		mtr.y1=0;
		mtr.y=0;
		mtr.x=0;
		mtr.statu=0;		
		
		
	}
	
}
