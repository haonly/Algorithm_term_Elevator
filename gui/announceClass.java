package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import gui.BackgroundUI;

public class announceClass {

	private static JLabel ann;
	static JPanel[] ann_panel;

	public announceClass() {
		announce();
	}

	static void announce() {
		ann_panel = new JPanel[10];
		for (int i = 0; i < 10; i++) {
			ann_panel[i] = new JPanel() {
				public void paintComponent(Graphics g) {
					ann = new JLabel("GO TO");
					ann.setBounds(10, 40, 60,30);
					ann.setOpaque(true);
					ann.setBackground(Color.white);
				}
				
			};
			//ann.setBounds(10, 40, 60,30);
			//ann_panel[i].add(ann);
			ann_panel[i].setBounds(1200, 20 + i * 90, 200, 100);
			ann_panel[i].setBorder(new BevelBorder(BevelBorder.RAISED));
			ann_panel[i].setLayout(new BorderLayout());
			BackgroundUI.frame.add(ann_panel[i]);

		}

		BackgroundUI.frame.setSize(1400, 1000);
		BackgroundUI.frame.setVisible(true);
	}

}