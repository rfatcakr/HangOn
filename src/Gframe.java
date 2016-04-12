import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class Gframe extends JFrame {
	
	JMenuBar menuBar;
	 static JLabel imageLabel;
	 static JLabel starter;
	 static JLabel timer;
	public Gframe(){
		super("Game");
		setLayout(null);
		
		 menuBar = new JMenuBar();
		 handler handless=new handler();
		JMenu submenu,sm1,sm2;
		submenu = new JMenu("GAME");
		JMenuItem sm3=new JMenuItem("START");
		sm3.addActionListener(handless);
		JMenuItem sm=new JMenuItem("PAUSE");
		
		JMenuItem menuItem = new JMenuItem("RESTART");
		menuItem.addActionListener(handless);
		JMenuItem menuItem2 = new JMenuItem("MAP");
		submenu.add(sm3);
		submenu.add(sm);
		submenu.add(menuItem);
		submenu.add(menuItem2);
		menuBar.add(submenu);
		sm.addActionListener(handless);
		////////
		submenu = new JMenu("USER");
		 sm3=new JMenuItem("LOGIN");
		 sm=new JMenuItem("HIGH SCORE");

			sm.addActionListener(handless);
		submenu.add(sm3);
		submenu.add(sm);
		menuBar.add(submenu);
		//
		 submenu = new JMenu("QUIT");
	
		sm=new JMenuItem("EXIT");
		submenu.add(sm);
		sm.addActionListener(handless);
		menuBar.add(submenu);
		super.setJMenuBar(menuBar);
		
		sm3.addActionListener(handless);
		
		menuItem2.addActionListener(handless);
		
		
		ImageIcon image = new ImageIcon("bgpicture.png");
      imageLabel = new JLabel(image); 
        imageLabel.setBounds(0, 0, 700,450);
        imageLabel.setVisible(true);
        add(imageLabel);
        
        //geri sayan þey
        starter=new JLabel("");
        starter.setBounds(100, 50, 200, 50);
        starter.setForeground(Color.white);
		 starter.setVisible(true);
	
		add(starter);
		
	}
	public  class handler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand()=="MAP"){
				Map map=new Map();
			}else if(e.getActionCommand()=="LOGIN"){

				Login aa=new Login();
				if(Login.ff==0){
					System.out.print(Login.ff);
					
				}
			}else if(e.getActionCommand()=="PAUSE"){
				Intelegent.pause=1;
			}else if(e.getActionCommand()=="START"){
				Intelegent.pause=0;
				
			}else if(e.getActionCommand()=="EXIT"){

				System.exit(0);
				
			}else if(e.getActionCommand()=="HIGH SCORE"){
				Records aa=new Records();
			}	else if(e.getActionCommand()=="RESTART"){
				
			}
		}
		}

	
}
