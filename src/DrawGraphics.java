package src;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;

public class DrawGraphics extends JPanel {
	int stage = 0;
	public DrawGraphics() {
		setSize(150,300);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		Graphics2D g2 = (Graphics2D) g;
		int defaultX = 30;
		int defaultY = 175;
		g2.setStroke(new BasicStroke(1));
		switch (stage) {
			case 1:
				g2.drawLine(defaultX, defaultY, defaultX + 40, defaultY);
				g.drawLine(defaultX + 120, 0, defaultX + 120, 300);
				break;
			case 2:
				g2.drawLine(defaultX, defaultY, defaultX + 40, defaultY);
				g2.drawLine(defaultX + 20, defaultY - 100, defaultX + 20, defaultY);
				g.drawLine(defaultX + 120, 0, defaultX + 120, 300);
				break;
			case 3:
				g2.drawLine(defaultX, defaultY, defaultX + 40, defaultY);
				g2.drawLine(defaultX + 20, defaultY - 100, defaultX + 20, defaultY);
				g2.drawLine(defaultX + 20, defaultY - 100, defaultX + 80, defaultY - 100);
				g.drawLine(defaultX + 120, 0, defaultX + 120, 300);
				break;
			case 4:
				g2.drawLine(defaultX, defaultY, defaultX + 40, defaultY);
				g2.drawLine(defaultX + 20, defaultY - 100, defaultX + 20, defaultY);
				g2.drawLine(defaultX + 20, defaultY - 100, defaultX + 80, defaultY - 100);
				g2.drawLine(defaultX + 20, defaultY - 80, defaultX + 40, defaultY - 100);
				g.drawLine(defaultX + 120, 0, defaultX + 120, 300);
				break;
			case 5:
				g2.drawLine(defaultX, defaultY, defaultX + 40, defaultY);
				g2.drawLine(defaultX + 20, defaultY - 100, defaultX + 20, defaultY);
				g2.drawLine(defaultX + 20, defaultY - 100, defaultX + 80, defaultY - 100);
				g2.drawLine(defaultX + 20, defaultY - 80, defaultX + 40, defaultY - 100);
				g2.drawLine(defaultX + 80, defaultY - 100, defaultX + 80, defaultY - 90);
				g.drawLine(defaultX + 120, 0, defaultX + 120, 300);
				break;
			case 6:
				g2.drawLine(defaultX, defaultY, defaultX + 40, defaultY);
				g2.drawLine(defaultX + 20, defaultY - 100, defaultX + 20, defaultY);
				g2.drawLine(defaultX + 20, defaultY - 100, defaultX + 80, defaultY - 100);
				g2.drawLine(defaultX + 20, defaultY - 80, defaultX + 40, defaultY - 100);
				g2.drawLine(defaultX + 80, defaultY - 100, defaultX + 80, defaultY - 90);
				// glowa:
				g2.drawOval(defaultX + 75, defaultY - 90, 10, 10);
				g2.drawOval(defaultX + 77, defaultY - 86, 1, 1);
				g2.drawOval(defaultX + 82, defaultY - 86, 1, 1);
				g2.drawLine(defaultX + 78, defaultY - 83, defaultX + 82, defaultY - 83);
				g.drawLine(defaultX + 120, 0, defaultX + 120, 300);
				break;
			case 7:
				g2.drawLine(defaultX, defaultY, defaultX + 40, defaultY);
				g2.drawLine(defaultX + 20, defaultY - 100, defaultX + 20, defaultY);
				g2.drawLine(defaultX + 20, defaultY - 100, defaultX + 80, defaultY - 100);
				g2.drawLine(defaultX + 20, defaultY - 80, defaultX + 40, defaultY - 100);
				g2.drawLine(defaultX + 80, defaultY - 100, defaultX + 80, defaultY - 90);
				// glowa:
				g2.drawOval(defaultX + 75, defaultY - 90, 10, 10);
				g2.drawOval(defaultX + 77, defaultY - 86, 1, 1);
				g2.drawOval(defaultX + 82, defaultY - 86, 1, 1);
				g2.drawLine(defaultX + 78, defaultY - 83, defaultX + 82, defaultY - 83);
				// tulow i rece:
				g2.drawLine(defaultX + 80, defaultY - 80, defaultX + 80, defaultY - 60);
				g2.drawLine(defaultX + 80, defaultY - 80, defaultX + 72, defaultY - 68);
				g2.drawLine(defaultX + 80, defaultY - 80, defaultX + 88, defaultY - 68);
				g.drawLine(defaultX + 120, 0, defaultX + 120, 300);
				break;
			case 8:
				g2.drawLine(defaultX, defaultY, defaultX + 40, defaultY);
				g2.drawLine(defaultX + 20, defaultY - 100, defaultX + 20, defaultY);
				g2.drawLine(defaultX + 20, defaultY - 100, defaultX + 80, defaultY - 100);
				g2.drawLine(defaultX + 20, defaultY - 80, defaultX + 40, defaultY - 100);
				g2.drawLine(defaultX + 80, defaultY - 100, defaultX + 80, defaultY - 90);
				// glowa:
				g2.drawOval(defaultX + 75, defaultY - 90, 10, 10);
				g2.drawOval(defaultX + 77, defaultY - 86, 1, 1);
				g2.drawOval(defaultX + 82, defaultY - 86, 1, 1);
				g2.drawLine(defaultX + 78, defaultY - 83, defaultX + 82, defaultY - 83);
				// tulow i ręce:
				g2.drawLine(defaultX + 80, defaultY - 80, defaultX + 80, defaultY - 60);
				g2.drawLine(defaultX + 80, defaultY - 80, defaultX + 72, defaultY - 68);
				g2.drawLine(defaultX + 80, defaultY - 80, defaultX + 88, defaultY - 68);
				// nogi:
				g2.drawLine(defaultX + 80, defaultY - 60, defaultX + 70, defaultY - 45);
				g2.drawLine(defaultX + 80, defaultY - 60, defaultX + 90, defaultY - 45);
				g.drawLine(defaultX + 120, 0, defaultX + 120, 300);
				break;
			default:
				g.drawLine(defaultX + 120, 0, defaultX + 120, 300);
				break;
		}
}
}
