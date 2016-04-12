import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;


public class Records extends JFrame {
	
	public Records(){

		super("Rercords Tabel");
		setLayout(null);
		
Scanner s=null;
		
		try {
			s= new Scanner(new File("scores.txt"));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		JTextArea jta=new JTextArea();
		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNext()){
		    list.add(s.next());
		    
		}
		int i=0;
		for(String o:list){
			jta.setText(jta.getText() +" "+ o);
			if(i%2==1)
		jta.setText(jta.getText()+"\n");
			i++;
		}
		s.close();
		jta.setEditable(false);
		jta.setBounds(0,0,200,200);
		super.add(jta);
		
		setSize(200,200);
		
		super.dispose();
		
		super.setVisible(true);
		
	}
	
	
}
