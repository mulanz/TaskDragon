import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JLabel;


public class Task {
    private boolean complete = false;
    private String description;
    private Color taskColor;
    private DragonGame game;
    private static int totalTaskNum = 0;
    private int taskID = 0;
    
    private final int TASKHEIGHT = 150;
    
    private final int PANELWIDTH = 2540, PANELHEIGHT = 1280;
	private final int LIST_ONE_X = 135, LIST_ONE_Y = 135, LIST_ONE_WIDTH = 1000, LIST_ONE_HEIGHT = PANELHEIGHT-270;
	private final int LIST_TWO_X = 1405, LIST_TWO_Y = 135, LIST_TWO_WIDTH = 1000, LIST_TWO_HEIGHT = PANELHEIGHT-270;
	private final int arcRound = 100;
	private BufferedImage checkBox;
	private String imagePath;

    public Task(DragonGame gamu, String d){
        description = d;
        taskColor = new Color(0x1A3159);
        game = gamu;
        totalTaskNum++;
        setImage();
    }
    public Task(DragonGame gamu) {
    	this(gamu, "");
    	setImage();
    }
    
    public void setImage() {
    	URL url = getClass().getResource("/Images/uncheckedCheckbox.png");
    	try {
    	checkBox =(BufferedImage)ImageIO.read(url);
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public BufferedImage getCheckbox() {
    	return checkBox;
    }

    public boolean getCompletion(){
        return complete;

    }

    public void setCompeletion(boolean x){
        complete = x;
    }
    
    public DragonGame getDragonGame() {
    	return game;
    }
    public int getTotalTaskNum() {
    	return totalTaskNum;
    }
    
    public int getTaskID() {
    	return taskID;
    }

    public String getDescription(){
        return description;
    }
}