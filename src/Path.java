import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Path {
	int x;
	int y;
	String name;
	//static yapmanın zararları burda anlaşıldı
	//static tanımlanan JLabel değişimlerden etkilenmiyordu
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
