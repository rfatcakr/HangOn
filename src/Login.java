import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;



public class Login extends JFrame{
	static int ff=0;
	public static Design a;
	public static JTextField tt;
	public JPasswordField tt2;
	
	
	
	public Login(){
		super("Login System");
		setLayout(null);
		 JLabel label = new JLabel("Name:");
		 JLabel label2 = new JLabel("Password:");
		 label.setBounds(10,20,50,10);
	 tt=new JTextField();
	 tt.setBounds(90,18,150,20);
	 tt2=new JPasswordField();
	 tt2.setBounds(90,48,150,20);
	 JButton b= new JButton();
	 b.setText("Login");
	 JButton b2= new JButton();
	 b2.setText("Help");
	 b.setBounds(80, 80, 70,30);
	 b2.setBounds(150, 80, 70,30);
		 label2.setBounds(10,50,100,10);
		 add(label);
		 add(label2);
		 add(tt);
		 add(tt2);
		 add(b);
		 add(b2);
		 
	
		 handler handless=new handler();
			b.addActionListener(handless);
		 super.setSize(300,150);
		super.setVisible(true);
	}
	
	public  class handler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()!=null){
				
				Scanner s=null;
				try {
					s = new Scanner(new File("myfile.txt"));
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				ArrayList<String> list = new ArrayList<String>();
				while (s.hasNext()){
				    list.add(s.next());
				}
				s.close();
				String passText = new String(tt2.getPassword());
				int z=0;
				String aa=tt.getText()+passText;
				for(String o:list){
					if( o.equals(aa)) { 
					    
					    JOptionPane.showMessageDialog(null,"Login Completed","INFORMATION", JOptionPane.PLAIN_MESSAGE);
					   z=1;
					   Gframe.imageLabel.setVisible(false);
					   
					   a=new Design();
					  ff=1;
					    dispose();
					  break;
					  }
				}
					
				
				
if(z==0){
				try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("myfile.txt", true)))) {
				    
					out.print(tt.getText());
					out.print(tt2.getPassword());
					out.println("");
					   JOptionPane.showMessageDialog(null,"Register Completed","INFORMATION", JOptionPane.PLAIN_MESSAGE);
					   ff=1;
					   Gframe.imageLabel.setVisible(false);
					 
					   a=new Design();
					  
					   dispose();
				}catch (IOException e1) {
					System.out.print("err");
				    //exception handling left as an exercise for the reader
				}
				
			
			}}
		}
		}
	public boolean con(){
		return true;
	}
	
}
