import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;


public class DragonPanel extends JPanel{
	//private Graphics graphics;
	
	private DragonGame dg;
	private Timer timer;
	
	
	private final int WIDTH = 2540, HEIGHT = 1280;
	private int bgWidth; 
	private final int PANELWIDTH = 2540, PANELHEIGHT = 1280;
	private final int LIST_ONE_X = 135, LIST_ONE_Y = 135, LIST_ONE_WIDTH = 1000, LIST_ONE_HEIGHT = PANELHEIGHT-270;
	private final int LIST_TWO_X = 1405, LIST_TWO_Y = 135, LIST_TWO_WIDTH = 1000, LIST_TWO_HEIGHT = PANELHEIGHT-270;
	private final int arcRound = 100;
	
	public DragonPanel(DragonGame game) {
		dg = game;
		setPreferredSize(new Dimension(WIDTH, HEIGHT)); // Otherwise, the frame starts off small
		this.setLayout(new BorderLayout());
		this.setLayout(null);
		
	}

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setUp(g);
		dg.draw(g);
	}

	private void setUp(Graphics g) {
		g.setColor(Color.white);
		g.fillRoundRect(LIST_TWO_X, LIST_TWO_Y, LIST_TWO_WIDTH, LIST_TWO_HEIGHT, arcRound, arcRound);
		
		g.setColor(Color.black);
	   	g.setFont(new Font("Serif", Font.BOLD, 50));
		g.drawString("Dragon Stats", LIST_TWO_X+2*(LIST_TWO_WIDTH/7), LIST_TWO_Y+100);
		g.setFont(new Font("Serif", Font.PLAIN, 50));
		g.drawString("Name: " + dg.getUser().getDragon().getName(), LIST_TWO_X+100, LIST_TWO_Y + 300);
		g.drawString("Type: " + dg.getUser().getDragon().getType(), LIST_TWO_X+100, LIST_TWO_Y + 370);
		g.drawString("Gender: " + dg.getUser().getDragon().getGenderString(), LIST_TWO_X+100, LIST_TWO_Y + 440);
		g.drawString("Maturity: " + dg.getUser().getDragon().setMaturityString(), LIST_TWO_X+100, LIST_TWO_Y + 540);
		g.drawString("Health: " + dg.getUser().getDragon().calcCondition() + " | " + dg.getUser().getDragon().getHP() + "/100", LIST_TWO_X+100, LIST_TWO_Y+610);
		g.drawString("Age: " + dg.getUser().getDragon().getAge(), LIST_TWO_X + 100, LIST_TWO_Y+680);
		
		dg.getUser().getDragon().draw(g);
		
	}
	
	
	public DragonGame getGame() {
		return dg;
	}
}
