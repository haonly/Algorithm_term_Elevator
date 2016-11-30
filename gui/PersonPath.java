package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import gui.BackgroundUI;

public class PersonPath {

	private static ImageIcon monster;
	static JPanel[] path_panel;

	public PersonPath() {
		floor_path();
	}

	static void floor_path() {
		monster = new ImageIcon("img/walk.png");
		path_panel = new JPanel[10];
		for (int i = 0; i < 10; i++) {
			path_panel[i] = new JPanel() {
				public void paintComponent(Graphics g) {
					g.drawImage(monster.getImage(), 0, 0, 30, 40, null);

				}
			};

			path_panel[i].setBounds(700, 20 + i * 90, 260, 70);
			path_panel[i].setBorder(new BevelBorder(BevelBorder.RAISED));
			path_panel[i].setLayout(new BorderLayout());
			BackgroundUI.frame.add(path_panel[i]);

		}

	}

}