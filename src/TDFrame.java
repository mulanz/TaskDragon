import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.Toolkit;

import javax.swing.*;


public class TDFrame extends JFrame{
	
	private DragonGame game = new DragonGame(this);
	JPanel topPanel = new JPanel();
	private TaskPanel taskPanel = new TaskPanel(game);
	private DragonPanel dragonPanel = new DragonPanel(game);
	private int counter;
	private JTabbedPane jtp; //this is tabbedPane
	private JLabel taskLabel, dragonLabel;
	private final int WIDTH = 2540, HEIGHT = 1280;
	private final int PANELWIDTH = 2540, PANELHEIGHT = 1280;
	private final int LIST_ONE_X = 135, LIST_ONE_Y = 135, LIST_ONE_WIDTH = 1000, LIST_ONE_HEIGHT = PANELHEIGHT-270;
	private final int LIST_TWO_X = 1405, LIST_TWO_Y = 135, LIST_TWO_WIDTH = 1000, LIST_TWO_HEIGHT = PANELHEIGHT-270;
	
	public TDFrame() {
		
		this.setTitle("TaskDragon");
		this.setSize(WIDTH, HEIGHT);
		this.setBackground(Color.GRAY);
		
		topPanel.setLayout(new BorderLayout());
		getContentPane().add(topPanel);
		
		jtp = new JTabbedPane();
		jtp.addTab("Task Panel", taskPanel);
		jtp.addTab("Dragon Panel", dragonPanel);
		jtp.setFont(new Font("Serif", Font.PLAIN, 30));
		topPanel.add(jtp, BorderLayout.CENTER);
		//game.readDatabase();
		if (game.getUser().getDragon().getAge() >= 20) {
			game.getUser().getDragon().evolve();
		}
		else game.getUser().getDragon().setBaby();
		repaint();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		       //game.writeDatabase();
		    }
		});
	}

	public static void main(String[] args) {
		TDFrame frame = new TDFrame();
		frame.pack();
		frame.setVisible(true);
		frame.start();
	}

	public void start() {
		System.out.println(game.getDate().toString());
		System.out.println(game.getUser().getDrags());
		if (counter == 1) {
		String namu = JOptionPane.showInputDialog(null,
                "Give your dragon a name!", "Dragon" + game.getUser().getDragon().getTotalDragons());
		if (namu != null) game.getUser().getDragon().setName(namu);
		else game.getUser().getDragon().setName("Dragon" + game.getUser().getDragon().getTotalDragons());
		}
		System.out.println("Current Date Num: " + game.getCurrentDateNum());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println("screen height: " + screenSize.getHeight());
		System.out.println("screen width: " + screenSize.getWidth());
	}
	
	public TaskPanel getTaskPanel() {
		return taskPanel;
	}
	
	public DragonPanel getDragonPanel() {
		return dragonPanel;
	}
	
	public DragonGame getGame() {
		return game;
	}
	
	public void setCounter(int n) {
		counter = n;
	}
}
