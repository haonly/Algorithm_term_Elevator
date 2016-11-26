package term;

/*
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.*;
import java.awt.event.*;

public class BackgroundUI extends JPanel{
	
	public BackgroundUI(){		
	}
	

	public void paintComponent(Graphics g){
		ImageIcon backgroundImg = new ImageIcon("img/glass2.png");
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
		    g.drawImage(temp1, 15, (i+1)*90, 50, 50, null);
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
*/

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.*;

public class BackgroundUI {

   private JPanel background_panel, elevator1_panel,elevator2_panel,elevator3_panel, floor_panel, ann_panel;
   private JFrame frame;
   private JButton[][] floor_button;
   private ImageIcon bg = null, elevator = null, floor = null, fbutton = null,show_floor=null, planet = null;
   static int elevator_x=177;
   static int elevator_y;
   Timer elevator_time=new Timer();

   public static int count = 0;

   public BackgroundUI() {

      // ��ü ������ ���
      frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(null);

      // ��� �г� ����
      bg = new ImageIcon("img/glass2.png");
      background_panel = new JPanel() {
         public void paintComponent(Graphics g) {
            g.drawImage(bg.getImage(), 0, 0, 1400, 1000, null);
            
            for(int i=1;i<=10;i++){
                show_floor = new ImageIcon("img/floor"+(11-i)+".png");
                 g.drawImage(show_floor.getImage(),40,-50+(i*90),60,60, null);               
            }
            for(int i = 1; i <= 10; i++){
            	planet = new ImageIcon("img/stair" +(11-i)+".png");
            	g.drawImage(planet.getImage(), 940, -60+(i*90), 50,50,null);
            }
         }
      };

      // ����������1 �г� ����
      elevator = new ImageIcon("img/elevator0.png");
      elevator1_panel = new JPanel() {
         public void paintComponent(Graphics g) {
            g.drawImage(elevator.getImage(),35,840, 70, 85, null);
         }
      };
      
      //2
      elevator2_panel = new JPanel() {
         public void paintComponent(Graphics g) {
            g.drawImage(elevator.getImage(),35,840,70, 85, null);
         }
      };
      
      //3
      elevator3_panel = new JPanel() {
         public void paintComponent(Graphics g) {
            g.drawImage(elevator.getImage(),35,840,70, 85, null);
         }
      };
      
      

      //floor �г� ����
      floor = new ImageIcon("img/stick.png");
      floor_button = new JButton[10][10];
      floor_panel = new JPanel() {
         public void paintComponent(Graphics g) {
 
            for (int i = 0; i < 10; i++) {
               g.drawImage(floor.getImage(), 20, (i + 1) * 90, 300, 15, null);
            }
            //��ư ��ġ ����
            for (int i = 0; i < 10; i++) {
               for (int j = 0; j < 10; j++) {
                  fbutton = new ImageIcon("img/f"+(j+1)+".png");
                  Image tempimg = fbutton.getImage();
                  tempimg = tempimg.getScaledInstance(30, 30, tempimg.SCALE_DEFAULT);
                  fbutton = new ImageIcon(tempimg);
                  floor_button[i][j] = new JButton(fbutton);
                  floor_button[i][j].setBackground(Color.black);
                  if (j > 4)
                     floor_button[i][j].setBounds(350+((j-5)*30),60+(i*90), 30, 30);
                  else
                     floor_button[i][j].setBounds(350+(j*30), 30+(i * 90), 30, 30);
                  
                  floor_panel.add(floor_button[i][j]);
               }
            }
         }

      };
      
      JTextField announce = new JTextField(10);
      ann_panel = new JPanel(){
    	  public void paintComponent(Graphics g){
    		  announce.setBounds(10, 30, 10,10);
    		  ann_panel.add(announce);
    	  }
      }; 
        
      // ������ ������
      elevator1_panel.setBorder(new BevelBorder(BevelBorder.RAISED));
      elevator1_panel.setLayout(new BorderLayout());
      
      elevator2_panel.setBorder(new BevelBorder(BevelBorder.RAISED));
      elevator2_panel.setLayout(new BorderLayout());
      
      elevator3_panel.setBorder(new BevelBorder(BevelBorder.RAISED));
      elevator3_panel.setLayout(new BorderLayout());

      // ���⵵ ������ ������
      floor_panel.setBorder(new BevelBorder(BevelBorder.RAISED));
      floor_panel.setLayout(new BorderLayout());
      
      ann_panel.setBorder(new BevelBorder(BevelBorder.RAISED));
      ann_panel.setLayout(new BorderLayout());

      // �гε��� ��ġ ����
      background_panel.setBounds(0, 0, 1400, 1000);
      background_panel.setVisible(true);

      elevator1_panel.setBounds(177, 0, 145, 1000);
      elevator1_panel.setVisible(true);
      
      elevator2_panel.setBounds(350, 0, 145, 1000);
      elevator2_panel.setVisible(true);
      
      elevator3_panel.setBounds(520, 0, 145, 1000);
      elevator3_panel.setVisible(true);

      floor_panel.setBounds(680, 0, 520, 1000);
      floor_panel.setVisible(true);
      
      ann_panel.setBounds(1200, 0, 300, 1000);
      ann_panel.setVisible(true);

      frame.add(elevator1_panel);
      frame.add(elevator2_panel);
      frame.add(elevator3_panel);
      frame.add(floor_panel);
      frame.add(background_panel);

      frame.setSize(1400, 1000);
      frame.setVisible(true);
      
      
      TimerTask elevator_task=new TimerTask(){
         public void run() {
            if(count<162){
                elevator_y = elevator_y -5;
                  elevator1_panel.setLocation(elevator_x, elevator_y);
                  count++;
                  frame.repaint();
            }
            else if(count>=100&&count<200){
               elevator_y = elevator_y +5;
               elevator1_panel.setLocation(elevator_x, elevator_y);
                  count++;
                  frame.repaint();
            }
            else if(count>=195){
               elevator_time.cancel();
            }
         }
         };
            
         elevator_time.schedule(elevator_task,0,1);
         
           
   }

   public static void main(String[] args) {

      BackgroundUI bgui = new BackgroundUI();

   }

}