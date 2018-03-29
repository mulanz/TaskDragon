import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Todo extends Task { 
    private final int TASKHEIGHT = 150;
	 private final int PANELWIDTH = 2540, PANELHEIGHT = 1280;
	 private final int LIST_ONE_X = 135, LIST_ONE_Y = 135, LIST_ONE_WIDTH = 1000, LIST_ONE_HEIGHT = PANELHEIGHT-270;
	 private final int LIST_TWO_X = 1405, LIST_TWO_Y = 135, LIST_TWO_WIDTH = 1000, LIST_TWO_HEIGHT = PANELHEIGHT-270;
	 private static int totalTodoNum = 0;
	 private int todoID = 0;
	 
   public Todo(DragonGame game, String d){
       super(game, d);
       totalTodoNum++;
       todoID = totalTodoNum;
       //getDragonGame().getUser().addTodo(this);
       System.out.println("todoID= " + todoID);
       System.out.println("totalID= " + todoID);
       System.out.println("todo list size= " + this.getDragonGame().getUser().getTodoList().size());
   }
   
   
   public Todo(DragonGame game) {
   	super(game);
   	totalTodoNum++;
    todoID = totalTodoNum;
   	//getDragonGame().getUser().addTodo(this);
   }
   
   public Todo(DragonGame game, int ID, String d) {
	   super(game, d);
	   totalTodoNum++;
	   todoID = ID;
   }
   
   public int getTotalTodoNum() {
	   return totalTodoNum;
   }
   
   public int getTodoID() {
	   return todoID;
   }
   
   public void increaseTodoID() {
   	todoID++;
   	}
   public void decreaseTodoID() {
   	todoID--;
   }
   public void decreaseTotalTodoNum() {
   	totalTodoNum--;
   }
   
   public void draw(Graphics g) {
   	if (todoID%2 == 1)g.setColor(new Color(0xAFABD3));
   	else g.setColor(new Color(0xC6E4EF));
   	g.fill3DRect(LIST_TWO_X, LIST_TWO_Y+150*todoID, LIST_TWO_WIDTH, 150, true);
   	
   	g.setColor(Color.black);
   	g.setFont(new Font("Serif", Font.BOLD, 50));
   	g.drawString(getDescription(), LIST_TWO_X + (LIST_TWO_WIDTH/7), LIST_TWO_Y+((1+todoID)*(TASKHEIGHT))-(TASKHEIGHT/2));
   	
   	g.drawImage(getCheckbox(), LIST_TWO_X + 15, LIST_TWO_Y+((todoID)*(TASKHEIGHT)+TASKHEIGHT/9), 100, 100, null);
   }

}