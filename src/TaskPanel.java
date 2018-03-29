import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.util.Date;

public class TaskPanel extends JPanel{
	//private Graphics graphics;
	
	private DragonGame dg;
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private final double PANELWIDTH = screenSize.getWidth(), PANELHEIGHT = screenSize.getHeight();
	
	private final double LIST_ONE_X = PANELWIDTH/13, LIST_TWO_X = (9/13)*PANELWIDTH; 
	private final double LIST_Y = PANELHEIGHT/7, LIST_WIDTH = (1/3)*PANELWIDTH, LIST_HEIGHT = (7/9)*PANELHEIGHT;
	
	private final int arcRound = 100;
	private final double TASKHEIGHT = (1/6)*LIST_HEIGHT;
	
	private BufferedImage addTaskButton;
	
	public TaskPanel(DragonGame game) {
		dg = game;
		
		setPreferredSize(new Dimension(PANELWIDTH, PANELHEIGHT));// Otherwise, the frame starts off small
		this.setLayout(new BorderLayout());
		this.setLayout(null);
		this.setBackground(new Color(0x60AAB3));
		
		setUpLabels();
		setUpAddTaskButton();
		setUpHabitButtonMouseListener();
		setUpToDoButtonMouseListener();
		setUpHabitCheckboxMouseListener();
		setUpToDoCheckboxMouseListener();
		
	}
	
	public void setUpLabels() {
		JLabel habitLabel = new JLabel("Habits");
		habitLabel.setFont(new Font("Serif", Font.BOLD, 50));
		habitLabel.setBounds(PANELWIDTH/4-100, LIST_ONE_Y, 150, 150);
		this.add(habitLabel); //this shows the text that says "Task Label" 
		
		JLabel todoLabel = new JLabel("To Do");
		todoLabel.setFont(new Font("Serif", Font.BOLD, 50));
		todoLabel.setBounds((PANELWIDTH/4)*3-100, LIST_TWO_Y, 150, 150);
		this.add(todoLabel);
	}
	
	public void setUpAddTaskButton() {
		URL url = getClass().getResource("/Images/addButton.png");
		try {
			addTaskButton =(BufferedImage)ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			addTaskButton =(BufferedImage)ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setUpHabitButtonMouseListener() {
		MouseListener habitButton = 
		         new MouseListener()
		         {

					Rectangle imageBounds = new Rectangle( LIST_ONE_X +LIST_ONE_WIDTH - 480, LIST_ONE_Y -30, 200, 200);
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						if (e.getButton() == 1 && imageBounds.contains(e.getX(), e.getY())) {
							String newHabit = JOptionPane.showInputDialog(null,
			                        "Input a new habit", null); 
			                if (newHabit != null) dg.getUser().addHabit(new Habit(dg, newHabit));
			                System.out.println("habit list size when added= " + dg.getUser().getHabitList().size());
			                dg.repaint();
						}
					} 

					@Override
					public void mouseEntered(MouseEvent e) { //what's wrong with this? 
						// TODO Auto-generated method stub
						if (e.MOUSE_ENTERED == 1 && imageBounds.contains(e.getXOnScreen(), e.getYOnScreen())) {
							dg.getFrame().setCursor(new Cursor(Cursor.HAND_CURSOR));
						
							dg.repaint();
						}
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
		            
		         };
		this.addMouseListener(habitButton);
	}
	
	public void setUpToDoButtonMouseListener() {
		MouseListener todoButton = 
		         new MouseListener()
		         {

					Rectangle imageBounds = new Rectangle( LIST_TWO_X +LIST_TWO_WIDTH - 480, LIST_TWO_Y -30, 200, 200);
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						if (e.getButton() == 1 && imageBounds.contains(e.getX(), e.getY())) {
							String newToDo = JOptionPane.showInputDialog(null,
			                        "Input a new todo", null); 
			                if (newToDo != null) dg.getUser().addTodo(new Todo(dg,newToDo));
			                System.out.println("todo list size when added = " +dg.getUser().getTodoList().size());
			                dg.repaint();
						}
					}

					@Override
					public void mouseEntered(MouseEvent e) { //what's wrong with this? 
						// TODO Auto-generated method stub
						if (imageBounds.contains(e.getX(),e.getY()))
						dg.getFrame().setCursor(Cursor.HAND_CURSOR);
						
						dg.repaint();
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
		            
		         };
		this.addMouseListener(todoButton);
	}
	
	public void setUpHabitCheckboxMouseListener() {
		MouseListener habitCheck = 
		         new MouseListener()
		         {

					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						if (e.getButton() == 1 && e.getX() >= LIST_ONE_X + 15 && e.getX() <= LIST_ONE_X + 115) {
							for (int i = 0; i < dg.getUser().getHabitList().size(); i++) {
								if (e.getY() >= LIST_ONE_Y+((dg.getUser().getHabitList().get(i).getHabitID())*(TASKHEIGHT)+TASKHEIGHT/9) && e.getY() <= LIST_ONE_Y+((dg.getUser().getHabitList().get(i).getHabitID())*(TASKHEIGHT)+TASKHEIGHT/9)+100) {
									dg.getUser().completeHabit(dg.getUser().getHabitList().get(i));
									dg.getUser().getDragon().calcCondition();
									dg.getUser().setHabitsCompletedToday(dg.getUser().getCompletedHabitList().size());
								}
								dg.repaint();
							}
							if (dg.getUser().getHabitList().size() > 0) {
							System.out.println("totalIDalt= " + dg.getUser().getHabitList().get(dg.getUser().getHabitList().size()-1).getTotalHabitNum());
							}
							for (Habit h : dg.getUser().getHabitList()) {
							System.out.println("habitIDalt= " + h.getHabitID());
							}
							System.out.println("habit list size= " + dg.getUser().getHabitList().size());
							System.out.println("finished habit list size=" + dg.getUser().getCompletedHabitList().size());
							dg.repaint();
						}
					}

					@Override
					public void mouseEntered(MouseEvent e) { //what's wrong with this? 
						// TODO Auto-generated method stub
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
		            
		         };
		this.addMouseListener(habitCheck);
	}
	
	public void setUpToDoCheckboxMouseListener() {
		MouseListener todoCheck = 
		         new MouseListener()
		         {

					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						if (e.getButton() == 1 && e.getX() >= LIST_TWO_X + 15 && e.getX() <= LIST_TWO_X + 115) {
							for (int i = 0; i < dg.getUser().getTodoList().size(); i++) {
								if (e.getY() >= LIST_TWO_Y+((dg.getUser().getTodoList().get(i).getTodoID())*(TASKHEIGHT)+TASKHEIGHT/9) && e.getY() <= LIST_TWO_Y+((dg.getUser().getTodoList().get(i).getTodoID())*(TASKHEIGHT)+TASKHEIGHT/9)+100) {
									dg.getUser().completeTodo(dg.getUser().getTodoList().get(i));
									dg.getUser().getDragon().setMaturityString();
									System.out.println(dg.getUser().getDragon().setMaturityString());
									
									if (dg.getUser().getDragon().getAge() == 20) { 
										dg.getUser().getDragon().evolve();
										JOptionPane.showMessageDialog(null, "Your dragon has evolved! Head over to the Dragon Tab to see!", "Congrats!", JOptionPane.INFORMATION_MESSAGE);
									}
									break;
								}
							}
							dg.repaint();
							if (dg.getUser().getTodoList().size() > 0) {
							System.out.println("totalIDalt= " + dg.getUser().getTodoList().get(dg.getUser().getTodoList().size()-1).getTotalTodoNum());
							}
							for (Todo t : dg.getUser().getTodoList()) {
							System.out.println("todoIDalt= " + t.getTodoID());
							}
							System.out.println("todo list size= " + dg.getUser().getTodoList().size());
							System.out.println("finished todo list size=" + dg.getUser().getCompletedTodoList().size());
						}
					}

					@Override
					public void mouseEntered(MouseEvent e) { //what's wrong with this? 
						// TODO Auto-generated method stub
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
		            
		         };
		this.addMouseListener(todoCheck);
	}
	
	public void setUpOldButtons() {
		/*JButton habitButton = new JButton("Add Habit");
		habitButton.setLayout(null);
		this.add(habitButton);
		habitButton.setVisible(true);
		habitButton.setFont(new Font("Serif", Font.BOLD,30));
		habitButton.setBounds(new Rectangle(LIST_ONE_X +LIST_ONE_WIDTH - 400, LIST_TWO_Y + 35, 250, 100)); //how come i can't multiply
		habitButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	String newHabit = JOptionPane.showInputDialog(null,
                        "Input a new habit", null); 
                if (newHabit != null) game.getUser().addHabit(new Habit(game,newHabit));
                dg.repaint();
            }
        });*/
		
		/*JButton todoButton = new JButton(new ImageIcon(addTodo));
		habitButton.setLayout(null);
		this.add(todoButton);
		todoButton.setVisible(true);
		todoButton.setBorder(BorderFactory.createEmptyBorder());
		todoButton.setContentAreaFilled(false);
		todoButton.setFont(new Font("Serif", Font.BOLD,30));
		todoButton.setBounds(new Rectangle(LIST_TWO_X +LIST_TWO_WIDTH - 400, LIST_TWO_Y + 35, 250, 100)); //how come i can't multiply
		todoButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	String newToDo = JOptionPane.showInputDialog(null,
                        "Input a new todo", null); 
                if (newToDo != null) game.getUser().addTodo(new Todo(game,newToDo));
                dg.repaint();
            }
        });*/
		//this is like hardcoded bc of that :( 
		/*JTextField field = new JTextField();
		field.setBounds(10, 50, 300, 40);
		this.add(field);*/
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setUp(g);
		dg.draw(g);
		for (Habit h : dg.getUser().getHabitList()) {
			h.draw(g);
		}
		for (Todo t : dg.getUser().getTodoList()) {
			t.draw(g);
		}
		
	}

	private void setUp(Graphics g) {
		g.setColor(new Color(0xFFFFFF));
		g.fillRoundRect(LIST_ONE_X, LIST_ONE_Y, LIST_ONE_WIDTH, LIST_ONE_HEIGHT, arcRound, arcRound);
		g.fillRoundRect(LIST_TWO_X, LIST_TWO_Y, LIST_TWO_WIDTH, LIST_TWO_HEIGHT, arcRound, arcRound);
		g.drawImage(addTaskButton, LIST_TWO_X +LIST_TWO_WIDTH - 480, LIST_TWO_Y -30, 200, 200, null);
		g.drawImage(addTaskButton, LIST_ONE_X +LIST_ONE_WIDTH - 480, LIST_ONE_Y -30, 200, 200, null);
	}
	
	public DragonGame getGame() {
		return dg;
	}
}
