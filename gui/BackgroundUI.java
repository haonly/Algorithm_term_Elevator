package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.*;

public class BackgroundUI {

   private static JTextField ann;
   private static JLabel go;
   private static JPanel background_panel;
   private static JPanel elevator1_panel;
   private static JPanel elevator2_panel;
   private static JPanel elevator3_panel;
   private static JPanel floor_panel;
   public static JFrame frame;
   private static JButton[][] floor_button;
   private static ImageIcon bg = null;
   private static ImageIcon elevator = null;
   private static ImageIcon floor = null;
   private static ImageIcon fbutton = null;
   private static ImageIcon show_floor = null;
   private static ImageIcon planet = null;
   private static ImageIcon character=null;
   static int elevator_x = 177;
   static int elevator_y;
   static int dest_floor, curr_floor=1;
   static int[] count_time = { 0, 18, 35, 52, 71,89, 105, 125, 143, 161 };
   public static int count = 0;
private static ImageIcon monster;

   buttonListener btlistener = new buttonListener();
   PersonPath p;
   elevatorUI e;
   announceClass an;
   // Elevator e1 = new Elevator(1);
   // Elevator e2 = new Elevator(2);
   // Elevator e3 = new Elevator(3);

   public BackgroundUI() {

      // 전체 프레임 등록
      frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(null);
      
      //floor_path();
      background(btlistener);

      p = new PersonPath();
      e = new elevatorUI();
      an = new announceClass();
      //monster();
      // move();
      
     
      frame.add(background_panel);

   }



   public static void background(buttonListener btlistener) {

      
      bg = new ImageIcon("img/glass2.png");
      floor = new ImageIcon("img/stick.png");
      floor_button = new JButton[10][10];
      
      background_panel = new JPanel() {
         public void paintComponent(Graphics g) {
            g.drawImage(bg.getImage(), 0, 0, 1400, 1000, null);

            for (int i = 1; i <= 10; i++) {
               show_floor = new ImageIcon("img/floor" + (11 - i) + ".png");
               g.drawImage(show_floor.getImage(), 40, -50 + (i * 90), 60, 60, null);
            }

            for (int i = 1; i <= 10; i++) {
               planet = new ImageIcon("img/s" + (11 - i) + ".png");
               g.drawImage(planet.getImage(), 940, -67 + (i * 90), 65, 65, null);
            }
            
            
            for (int i = 0; i < 10; i++) {
               g.drawImage(floor.getImage(), 700, (i + 1) * 90, 300, 15, null);
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
                     floor_button[i][j].setBounds(1030 + ((j - 5) * 30), 60 + (i * 90), 30, 30);
                  else
                     floor_button[i][j].setBounds(1030 + (j * 30), 30 + (i * 90), 30, 30);

                  background_panel.add(floor_button[i][j]);
                  floor_button[i][j].setActionCommand(Integer.toString(10 - i) + " " + Integer.toString(j + 1));
                  floor_button[i][j].addActionListener(btlistener);

               }
            }
         }
      };

      background_panel.setBounds(0, 0, 1400, 1000);
      background_panel.setVisible(true);
   }





   public static void up_move() {
      Timer elevator_time = new Timer();
      TimerTask elevator_task = new TimerTask() {
         public void run() {

            int temp = count_time[dest_floor - 1] - count_time[curr_floor - 1];

            if (count <= temp) {
               elevator_y = elevator_y - 5;
               elevator1_panel.setLocation(elevator_x, elevator_y);
               count++;
               elevator1_panel.repaint();
            } else if (count > temp && count <= count_time[dest_floor - 1] + 3) {
               elevator_y = elevator_y;
               elevator1_panel.setLocation(elevator_x, elevator_y);
               count++;
               elevator1_panel.repaint();
            }

            else{
               count=0;
               elevator_time.cancel();
            }
         }
      };

      elevator_time.schedule(elevator_task, 0, 5);
   }

   public static void down_move() {

      Timer elevator_time = new Timer();
      TimerTask elevator_task = new TimerTask() {
         public void run() {
            int temp = count_time[curr_floor - 1] - count_time[dest_floor - 1];

            if (count <= temp) {
               elevator_y = elevator_y + 5;
               elevator1_panel.setLocation(elevator_x, elevator_y);
               count++;
               elevator1_panel.repaint();
            } else if (count > temp && count <= count_time[dest_floor - 1] + 3) {
               elevator_y = elevator_y;
               elevator1_panel.setLocation(elevator_x, elevator_y);
               count++;
               elevator1_panel.repaint();
            }

            else{
               count=0;
               elevator_time.cancel();
            }
         }
      };

      elevator_time.schedule(elevator_task, 0, 5);
   }

   class buttonListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         String value = e.getActionCommand();
         String[] CF = value.split(" ");

         curr_floor = Integer.parseInt(CF[0]);
         System.out.println("Current Floor : " + curr_floor);

         dest_floor = Integer.parseInt(CF[1]);
         System.out.println("Destination : " + dest_floor);

         if (curr_floor == dest_floor)
            ;
         else {
            // optimal select = new optimal(e1,e2,e3);
            // select.setCurr(curr_floor);
            // select.setDest(dest_floor);
            if (curr_floor < dest_floor)
               up_move();
            else
               down_move();
         }

      }
   }// class end
   
   
   
   public static void main(String[] args){
      
      BackgroundUI p = new BackgroundUI();
      
      
   }
  
 }