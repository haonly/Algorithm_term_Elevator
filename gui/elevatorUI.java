package gui;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import gui.BackgroundUI;

public class elevatorUI {

   private static ImageIcon elevator;
   static JPanel[] elevator_panel;

   public elevatorUI() {

	   elevator();
	  
	   
   }

   
   static void elevator() {
      elevator = new ImageIcon("img/elevator0.png");
      elevator_panel = new JPanel[3];
      for (int i = 0; i < 3; i++) {
         elevator_panel[i] = new JPanel() {
            public void paintComponent(Graphics g) {
               g.drawImage(elevator.getImage(),35, 840, 70, 85, null);

            }
         };

         elevator_panel[i].setBounds((i+1)*174,0,145,1000);
         elevator_panel[i].setBorder(new BevelBorder(BevelBorder.RAISED));
         elevator_panel[i].setLayout(new BorderLayout());
         BackgroundUI.frame.add(elevator_panel[i]);

      }
      
		

   }

}