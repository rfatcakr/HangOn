import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Path {
	int x;
	int y;
	String name;
	//static yapman�n zararlar� burda anla��ld�
	//static tan�mlanan JLabel de�i�imlerden etkilenmiyordu
	  JLabel imageLabel1;
	Path(String name,int y){
		this.name=name;
		this.y=y;
		ImageIcon image = new ImageIcon(name);
		 imageLabel1= new JLabel(image); 
		 imageLabel1.setBounds(x,y, 700,450);
	       
	        Main.gf.add(imageLabel1);
	}
	 void Display(){
        imageLabel1.setBounds(x,y, 700,450);
		imageLabel1.setVisible(true);
	}
	 void hide(){
		imageLabel1.setVisible(false);
			
	}
}
