import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Habit extends Task{
	 private final int TASKHEIGHT = 150;
	 private final int PANELWIDTH = 2540, PANELHEIGHT = 1280;
	 private final int LIST_ONE_X = 135, LIST_ONE_Y = 135, LIST_ONE_WIDTH = 1000, LIST_ONE_HEIGHT = PANELHEIGHT-270;
	 private final int LIST_TWO_X = 1405, LIST_TWO_Y = 135, LIST_TWO_WIDTH = 1000, LIST_TWO_HEIGHT = PANELHEIGHT-270;
	 private static int totalHabitNum = 0;
	 private int habitID = 0;
	 
    public Habit(DragonGame game, String d){
        super(game, d);
        totalHabitNum++;
        habitID = totalHabitNum;
        //getDragonGame().getUser().addHabit(this);
        System.out.println("habitID= " + habitID);
        System.out.println("totalID= " + habitID);
        System.out.println("habit list size= " + this.getDragonGame().getUser().getHabitList().size());
    }
    
    public Habit(DragonGame game) {
    	super(game);
    	totalHabitNum++;
        habitID = totalHabitNum;
    	//getDragonGame().getUser().addHabit(this);
    }
    
    public Habit(DragonGame dragonGame, int nextInt, String nextLine) {
		// TODO Auto-generated constructor stub
    	super(dragonGame, nextLine);
    	habitID = nextInt;
    	totalHabitNum++;
    }

	public int getHabitID() {
    	return habitID;
    }
    
    public void increaseHabitID() {
    	habitID++;
    	}
    public void decreaseHabitID() {
    	habitID--;
    }
    public int getTotalHabitNum() {
    	return totalHabitNum;
    }
    public void decreaseTotalHabitNum() {
    	totalHabitNum--;
    }
    
    public void decreaseTotalHabitNum(int i) {
    	totalHabitNum-= i;
    }
    public void draw(Graphics g) {
    	if (habitID%2 == 1)g.setColor(new Color(0xAFABD3));
    	else g.setColor(new Color(0xC6E4EF));
    	g.fill3DRect(LIST_ONE_X, LIST_ONE_Y+150*habitID, LIST_ONE_WIDTH, 150, true);
    	
    	g.setColor(Color.black);
    	g.setFont(new Font("Serif", Font.BOLD, 50));
    	g.drawString(getDescription(), LIST_ONE_X + (LIST_ONE_WIDTH/7), LIST_ONE_Y+((1+habitID)*(TASKHEIGHT))-(TASKHEIGHT/2));
    	
    	g.drawImage(getCheckbox(), LIST_ONE_X + 15, LIST_ONE_Y+((habitID)*(TASKHEIGHT)+TASKHEIGHT/9), 100, 100, null);
    }
    

}