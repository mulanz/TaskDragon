
import java.util.ArrayList;
import java.util.List;

public class User {
    private Dragon drag;
    private ArrayList<Habit> habits = new ArrayList<Habit>();
    private ArrayList<Habit> completedHabits = new ArrayList<Habit>();
    //habits is different; idk how to do it, need a server
    private ArrayList<Todo> todos = new ArrayList<Todo>();
    private ArrayList<Todo> completedToDos = new ArrayList<Todo>();
    private ArrayList<Dragon> dragons = new ArrayList<Dragon>();

    private int totalTodosCompleted;
    private int todosCompletedToday;
    private int habitsCompletedToday;
    private int habitStreak;
    //perfect days, current streak, best streak, total tasks done, calendar perhaps? 
    public User(){
        drag = new Dragon();
        dragons.add(drag);
    }
    
    public User(Dragon dragon, ArrayList<Habit> habs, ArrayList<Habit> doneHabs, ArrayList<Todo> tods, ArrayList<Dragon> drags, int totTodosDone, int todosDoneToday, int habStreak) {
    	drag = dragon;
    	dragons.add(drag);
    	habits = habs;
    	completedHabits = doneHabs; 
    	completedToDos = tods;
    	dragons = drags;
    	totalTodosCompleted = totTodosDone;
    	todosCompletedToday = todosDoneToday;
    	habitStreak = habStreak;
    }
    
    public int getTotalTodosCompleted() {
    	return totalTodosCompleted;
    }
    
    public int getTodosCompletedToday() { 
    	return todosCompletedToday;
    }

    public int getHabitStreak() {
    	return habitStreak;
    }
    
    public void setTotalTodosCompleted(int set) {
    	totalTodosCompleted = set;
    }
    
    public void setTodosCompletedToday(int set) {
    	todosCompletedToday = set;
    }
    
    public void incrementHabitStreak(int num) {
    	habitStreak += num;
    }
    
    public void completeTodo(Todo m){
        drag.increaseAge(5);
        completedToDos.add(this.removeTodo(m));
        if (drag.releasable()) drag.evolve();
        this.totalTodosCompleted++;
    }

    public void completeHabit(Habit h){
       drag.increaseHP(5);
       if (drag.getHP() > 100) {
    	   drag.setHP(100);
       } 
       completedHabits.add(this.removeHabit(h));
       this.habitsCompletedToday++;
    }

    public Dragon getDragon(){
        return drag;
    }

    public void addHabit(Habit m){
        habits.add(m);
    }

    public Habit removeHabit(Habit m){
    	int p = habits.indexOf(m); 
    	habits.remove(m);
    	 if (habits.size() > 0) {
    		 for (int i = p; i < habits.size(); i++) {
    			 habits.get(i).decreaseHabitID();
    		 }
    	 }
    	m.decreaseTotalHabitNum();
       
        return m;
    }

    public void addTodo(Todo m){
        todos.add(m);
    }

    public Todo removeTodo(Todo m){
    	int p = todos.indexOf(m); 
    	todos.remove(m);
    	 if (todos.size() > 0) {
    		 for (int i = p; i < todos.size(); i++) {
    			 todos.get(i).decreaseTodoID();
    		 }
    	 }
    	m.decreaseTotalTodoNum();
    	
    	return m;
    }

    public Dragon release(Dragon g){
        dragons.add(g);
        drag = new Dragon();
        return g;

    }

    public ArrayList<Dragon> getDrags(){
        return dragons;
    }
    
    public ArrayList<Todo> getTodoList() {
    	return todos;
    }
    
    public ArrayList<Habit> getHabitList() {
    	return habits; 
    }
    
    public ArrayList<Todo> getCompletedTodoList() {
    	return completedToDos;
    }
    
    public ArrayList<Habit> getCompletedHabitList() {
    	return completedHabits;
    }

	public void setHabitsCompletedToday(int size) {
		// TODO Auto-generated method stub
		habitsCompletedToday = size;
	}

	public void setHabitStreak(int nextInt) {
		// TODO Auto-generated method stub
		habitStreak = nextInt;
	}
}