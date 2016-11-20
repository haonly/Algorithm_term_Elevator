package term;

import java.awt.*;
import javax.swing.*;

public class floorUI extends floor {

	protected Rectangle floorRect;
	public final Color FLOORCOLOR=Color.black;

	public floorUI(int px, int py, int width, int height, int floor, boolean isElevator) {
		super(floor, isElevator);
		int bX, bY, bWidth, bHeight;
		floorRect = new Rectangle(px, py, width, height);
		bX = px + 5;
		bY = py + height / 20;
		bWidth = width / 10;
		bHeight = height * 9 / 10;
	}

	public int getTopFloor() {
		return floorRect.y;
	}

	public int getWidth() {
		return floorRect.width;
	}

	public int getHeight() {
		return floorRect.height;
	}

	public int getPx() {
		return floorRect.x;
	}

	public int getPy() {
		return floorRect.y;
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setTitle("floor");
		Container cp = frame.getContentPane();
		cp.setLayout(new FlowLayout());
	
	}

}
