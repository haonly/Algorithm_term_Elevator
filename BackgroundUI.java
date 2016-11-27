package term;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class BackgroundUI {

   private static JPanel background_panel;
   private static JPanel elevator1_panel;
   private static JPanel elevator2_panel;
   private static JPanel elevator3_panel;
   private static JPanel floor_panel;
   private static JPanel[] ann_panel;
   private static JTextField ann;
   private static JLabel go;
   private static JFrame frame;
   private static JButton[][] floor_button;
   private static ImageIcon bg = null;
   private static ImageIcon elevator = null;
   private static ImageIcon floor = null;
   private static ImageIcon fbutton = null;
   private static ImageIcon show_floor = null;
   private static ImageIcon planet = null;
   static int elevator_x = 177;
   static int elevator_y;
   static Timer elevator_time = new Timer();
   static int dest_floor;
   static int[] count_time={7,20,35,52,71,91,105,130,146,162};

   
   public static int count = 0;

   public BackgroundUI() {
      
      buttonListener btlistener=new buttonListener();

      // 전체 프레임 등록
      frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(null);

      allFloor();
      background();
      elevator1();
      elevator2();
      elevator3();
      floor(btlistener);
      //move();

      for(int i=0;i<10;i++){
    	  frame.add(ann_panel[i]);
      }
      frame.add(elevator1_panel);
      frame.add(elevator2_panel);
      frame.add(elevator3_panel);
      frame.add(floor_panel);     
      frame.add(background_panel);

      frame.setSize(1400, 1000);
      frame.setVisible(true);

   }

   public static void background() {
      bg = new ImageIcon("img/glass2.png");
      background_panel = new JPanel() {
         public void paintComponent(Graphics g) {
            g.drawImage(bg.getImage(), 0, 0, 1400, 1000, null);

            for (int i = 1; i <= 10; i++) {
               show_floor = new ImageIcon("img/floor" + (11 - i) + ".png");
               g.drawImage(show_floor.getImage(), 40, -50 + (i * 90), 60, 60, null);
            }
            
               for(int i = 1; i <= 10; i++){
                   planet = new ImageIcon("img/stair" +(11-i)+".png");
                   g.drawImage(planet.getImage(), 940, -60+(i*90), 50,50,null);
                }
             }
      };
      
      background_panel.setBounds(0, 0, 1400, 1000);
      background_panel.setVisible(true);
   }

   public static void elevator1() {

      elevator = new ImageIcon("img/elevator0.png");
      elevator1_panel = new JPanel() {
         public void paintComponent(Graphics g) {
            g.drawImage(elevator.getImage(), 35, 840, 70, 85, null);
         }
      };
      
      elevator1_panel.setBounds(177, 0, 150, 1000);
      elevator1_panel.setVisible(true);
   }

   public static void elevator2() {
      
      elevator2_panel = new JPanel() {
         public void paintComponent(Graphics g) {
            g.drawImage(elevator.getImage(), 35, 840,  70, 85, null);
         }
      };
      
      elevator2_panel.setBounds(350, 0, 145, 1000);
      elevator2_panel.setVisible(true);

   }

   public static void elevator3() {
      
      elevator3_panel = new JPanel() {
         public void paintComponent(Graphics g) {
            g.drawImage(elevator.getImage(), 35, 840,  70, 85, null);
         }
      };
      
      
      elevator3_panel.setBounds(520, 0, 145, 1000);
      elevator3_panel.setVisible(true);

   }
   
   
 
   public static void allFloor(){
	   ann_panel = new JPanel[10];
	   for(int i=0;i<10;i++){
		   ann_panel[i] = new JPanel(){
			   public void paintConponent(Graphics g){
				   go = new JLabel("GO TO");
				   go.setBounds(10, 40, 60, 30);
				   go.setOpaque(true);
				   go.setBackground(Color.white);
				   ann = new JTextField(20);
				   //ann_panel.add(go);
				   
				 /*  for(int i=0; i<10; i++){
						 go.setBounds(10, 40+i*90, 60, 30);
						 ann_panel.add(go);
						 ann.setBounds(53, 40+i*90, 100, 30);
						 ann_panel.add(ann);
					 }
					 
					 */
			   }
		   };
		   ann_panel[i].setBounds(1200, 20+i*90, 200, 100);
		   ann_panel[i].setVisible(true);
		   ann_panel[i].setBorder(new BevelBorder(BevelBorder.RAISED));
		   ann_panel[i].setLayout(new BorderLayout());
	   }
   }
   
   
   public static void floor(buttonListener btlistener){
      
      floor = new ImageIcon("img/stick.png");
      floor_button = new JButton[10][10];
      
      floor_panel = new JPanel() {
         public void paintComponent(Graphics g) {
            
            for (int i = 0; i < 10; i++) {
               g.drawImage(floor.getImage(), 20, (i + 1) * 90, 300, 15, null);
            }
            // 버튼 위치 지정
            for (int i = 0; i < 10; i++) {
               for (int j = 0; j < 10; j++) {
                  fbutton = new ImageIcon("img/f" + (j + 1) + ".png");
                  Image tempimg = fbutton.getImage();
                  tempimg = tempimg.getScaledInstance(30, 30, tempimg.SCALE_DEFAULT);
                  fbutton = new ImageIcon(tempimg);
                  floor_button[i][j] = new JButton(fbutton);
                  floor_button[i][j].setBackground(Color.black);
                  if (j > 4)
                     floor_button[i][j].setBounds(350 + ((j - 5) * 30), 60 + (i * 90), 30, 30);
                  else
                     floor_button[i][j].setBounds(350 + (j * 30), 30 + (i * 90), 30, 30);

                  floor_panel.add(floor_button[i][j]);
                  floor_button[i][j].addActionListener(btlistener);

               }
            }
         }

      };
      
      floor_panel.setBounds(680, 0, 700, 1000);
      floor_panel.setVisible(true);
   }
   
   public static void move(){

      TimerTask elevator_task = new TimerTask() {
         public void run() {
            if (count < count_time[dest_floor]) {
               elevator_y = elevator_y - 5;
               elevator1_panel.setLocation(elevator_x, elevator_y);
               count++;
               frame.repaint();
            } else if (count >=count_time[dest_floor] && count < 2*count_time[dest_floor]) {
               elevator_y = elevator_y + 5;
               elevator1_panel.setLocation(elevator_x, elevator_y);
               count++;
               frame.repaint();
            } else if (count >= 2*count_time[dest_floor]) {
               elevator_time.cancel();
            }
         }
      };

      elevator_time.schedule(elevator_task, 0, 1);
   }
   
   class buttonListener implements ActionListener{
      

      @Override
      public void actionPerformed(ActionEvent e) {
         
         
         for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){      
               if(e.getSource()==BackgroundUI.floor_button[i][j]){
               dest_floor=j;
               BackgroundUI.move();
               break;
               }
            }
         }
         
      }
      
   }
   
   

   public static void main(String[] args) {

      BackgroundUI bgui = new BackgroundUI();

   }

}
