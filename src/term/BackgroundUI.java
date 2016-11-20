package term;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.*;
import java.awt.event.*;

public class BackgroundUI extends JPanel{
	
	public BackgroundUI(){		
	}
	


	public void paintComponent(Graphics g){
		ImageIcon backgroundImg = new ImageIcon("img/¹è°æ.png");
		g.drawImage(backgroundImg.getImage(), 0, 0, 1400, 1000, null);
		setOpaque(false);
		ImageIcon HfloorImage = new ImageIcon("img/stick.png");
		Image temp = HfloorImage.getImage();
		
		for(int i=0; i<10; i++){
			ImageIcon floor = new ImageIcon("img/floor"+Integer.toString(10-i)+".png");
			//JLabel floortmp = new JLabel(floor);
		   // floortmp.setBounds(5, 10 + i*70, 60, 50);
			Image temp1 = floor.getImage();
			g.drawImage(temp, 950, (i+1)*90, 200, 20, null);
		    g.drawImage(temp1, 15, (i+1)*90, 40, 20, null);
		}
		super.paintComponent(g);
	}	

	
	
	public static void main(String[] args){

		
		JFrame frame = new JFrame();
		frame.setTitle("Elevetor_Sohyun_Hayeon_Jiyoung");
		
		frame.add(new BackgroundUI());
		
		
		
			    
		frame.pack();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1400,1000);
	    frame.setVisible(true);
	    
		
		
	}	
	
}
