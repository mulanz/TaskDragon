import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class DragonGame {
	
	private User user; 
	private Wilderness wilderness;
	private Graveyard graveyard;
	private TDFrame frame;
	private Date date;
	private String currentDateNum;
	private File file;
	private Scanner s;
	
	public DragonGame(TDFrame fra) { 
		date = new Date();
		frame = fra;
		user = new User(); 
		wilderness = new Wilderness();
		graveyard = new Graveyard();
		//file = new File("C://Users/Milan/workspace/TaskDragon/src/Database.txt");
		file = new File("Storage.txt");
	}
	
	public void readDatabase() {
		try {
			if (!file.exists()) {
				frame.setCounter(1);
				return;
			}
			
			s = new Scanner(file); 
			s.next();
			s.next();
			String currentDate = s.next();
			s.next();
			s.next();
			s.next();
			/*System.out.println(s.nextInt());
			System.out.println(s.nextInt());
			System.out.println(s.nextInt());
			System.out.println(s.next());
			System.out.println(s.next());
			System.out.println(s.next());*/
			
			int age, hp, condition, totaldragon;
			String gender, type, maturity, name;
			
			age = s.nextInt();
			hp = s.nextInt();
			condition = s.nextInt();
			gender = s.next();
			type = s.next();
			name = s.next();
			totaldragon = s.nextInt();
			maturity = s.next();
			
			if (true) {
				System.out.println("age = " + age);
				System.out.println("hp = " + hp);
				System.out.println("condition = " + condition);
				System.out.println("gender = " + gender);
				System.out.println("type = " + type);
				System.out.println("name = " + name);
				System.out.println("totaldragon = " + totaldragon);
				System.out.println("maturity = " + maturity);
			}
			user.getDragon().setAge(age);
			user.getDragon().setHP(hp);
			user.getDragon().setCondition(condition);
			user.getDragon().setGender(gender);
			user.getDragon().setType(type);
			user.getDragon().setName(name);
			user.getDragon().setTotalDragons(totaldragon);
			user.getDragon().setMaturityString(maturity);
			int toDoListSize = s.nextInt();
			int i = 0;
			while (i < toDoListSize) {
				user.getTodoList().add(new Todo(this, s.nextInt(), s.next()));
				i++;
			}
			int habitListSize = s.nextInt();
			i = 0;
			int counter = 1;
			while (i < habitListSize) {
				user.getHabitList().add(new Habit(this, counter++, s.next()));
				i++;
			}
			int completedHabitListSize = s.nextInt();
			i = 0; 
			while (i < completedHabitListSize) {
				user.getCompletedHabitList().add(new Habit(this, counter++, s.next()));
				user.getCompletedHabitList().get(i).decreaseTotalHabitNum();
				i++;
			}
			System.out.println(s.nextInt());
			//user.getDragon().setTotalDragons(s.nextInt());
			/*String taskListString = s.nextLine();
			String habitListString = s.nextLine();
			String dragonlistString = s.nextLine();*/
			user.setTotalTodosCompleted(s.nextInt());
			user.setTodosCompletedToday(s.nextInt());
			user.setHabitsCompletedToday(s.nextInt());
			user.setHabitStreak(s.nextInt());
			
			if (currentDateNum == currentDate) {
				System.out.println("date aint equal");
				for (int p = 0; p < user.getCompletedHabitList().size(); p++) {
					user.addHabit(user.getCompletedHabitList().remove(p));
				}
			}
			currentDateNum = currentDate;
		}
		catch (IOException e){
			e.printStackTrace();
		}
		
	}
	
	public void writeDatabase() {
		try {
			file.delete(); 
			//file = new File("C://Users/Milan/workspace/TaskDragon/src/Database.txt");
			file = new File("Storage.txt");
			if (!file.exists()) System.out.println("file doesn't work");
			FileWriter fw = new FileWriter(file, false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println(date.toString());
			/*current dragon*/ pw.println(user.getDragon().getAge() + " " + user.getDragon().getHP() + " " + user.getDragon().getCondition() + " " + user.getDragon().getGenderString() + " " + user.getDragon().getType() + " " + user.getDragon().getName() + " " + user.getDragon().getTotalDragons() + " " + user.getDragon().getMaturity());
			pw.println(user.getTodoList().size());
			/*todoList*/ for (int i = 0; i < user.getTodoList().size(); i++) { 
				pw.println(user.getTodoList().get(i).getTodoID());		
				pw.println(user.getTodoList().get(i).getDescription());
			}
			
			pw.println(user.getHabitList().size());
			for (int i = 0; i < user.getHabitList().size(); i++) {
				//pw.println(user.getHabitList().get(i).getHabitID());
				pw.println(user.getHabitList().get(i).getDescription());
			}
			pw.println(user.getCompletedHabitList().size());
			
			/*habitList*/ for (int i = 0; i < user.getCompletedHabitList().size(); i++) {
				//pw.println(user.getCompletedHabitList().get(i).getHabitID());
				pw.println(user.getCompletedHabitList().get(i).getDescription());
			} 
			pw.println(user.getDragon().getTotalDragons());

			/*misc*/ pw.println(user.getTotalTodosCompleted() + " " + user.getTodosCompletedToday() + " " + user.getCompletedHabitList().size() + " " + user.getHabitStreak());
			pw.close();
		}
		catch (IOException e) { 
			System.out.println("Exception Occurred"); 
			e.printStackTrace();
		}
	}
	
	public String getCurrentDateNum() {
		return currentDateNum;
	}
	
	public void createHabit(Habit m) {
		user.addHabit(m);
	}
  public void removeHabit(Habit m) {
		user.removeHabit(m);
	}
	public void createTask(Todo m) {
		user.addTodo(m);
	}
	public void removeTask(Todo m) {
		user.removeTodo(m);
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	public TDFrame getFrame() { 
		return frame;
	}
	
	public void repaint() {
		frame.repaint();
	}
	
	public User getUser() {
		return user;
	}
	
	public Date getDate() {
		return date;
	}

}

