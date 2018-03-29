import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class Dragon {
	//hp is 1-100 
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private final double PANELWIDTH = screenSize.getWidth(), PANELHEIGHT = screenSize.getHeight();
	
	private final double LIST_ONE_X = PANELWIDTH/13, LIST_TWO_X = (9/13)*PANELWIDTH; 
	private final double LIST_Y = PANELHEIGHT/7, LIST_WIDTH = (1/3)*PANELWIDTH, LIST_HEIGHT = (7/9)*PANELHEIGHT;
	
	private final int arcRound = 100;
	private final double TASKHEIGHT = (1/6)*LIST_HEIGHT;
	
	
	
	private int age, hp, condition, gender, type;
	private String genderString, maturityString;
	private String typeString, name; 
	private static int totalDragons; 
	private int ID; 
	private int maturity; 
	
	private String imagePath;
	private BufferedImage dragonPic;
	
	private static final int BABY = 0, JUVENILE = 1, ADULT = 2;
	private static final int DYING = 0, SICK = 1, OK = 2, HEALTHY = 3, EXCELLENT = 4;
	private static final int FEMALE = 0, MALE = 1;
	private static final int IMPERIAL = 0, FAE = 1, PEARLCATCHER = 2, COATL = 3, SKYDANCER = 4;
	
	public Dragon() { //default dragon
		age = 0;
		hp = 100; 
		condition = EXCELLENT; 
		maturity = BABY;
		
		setGender();
		setMaturityString();
		setDragonType();
		setBaby();
		
		totalDragons++;
		//name = "Dragon " + totalDragons; //does this automatically toString? 
		
	}
	
	public Dragon(int agu, int hpu, int condit, int gen, int typu, String namu, int matur) {
		age = agu; 
		hp = hpu; 
		condition = condit; 
		gender = gen; 
		type = typu;
		name = namu; 
		//totalDragons = totalDrags;
		maturity = matur;
		totalDragons++;
		setBaby();
		setMaturityString();
	}

	public Dragon(String namu) {
		this();
		name = namu;
	}
	
	public Dragon(String namu, String typu) {
		this();
		name = namu; 
		typeString = typu; 
	}
	
	public void draw(Graphics g) {
		g.drawImage(getImage(), LIST_ONE_X, LIST_ONE_Y, LIST_ONE_WIDTH, LIST_ONE_HEIGHT, null);
	}
	
	public void setName(String namu) {
		name = namu;
	}
	
	public void setAge (int ag) {
		age = ag;
	}
	
	public int setDragonType() {
		type = (int)(Math.random()*5);
		return type;
	}
	
	public void setBaby() {
		
		if (type == FAE) {
			imagePath = "/DragonImages/babyFae.png";
			URL url = getClass().getResource(imagePath);
			try {
				dragonPic = (BufferedImage)ImageIO.read(url);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			typeString = "fae";
		}
		else if (type == COATL) {
			imagePath = "/DragonImages/coatlBaby.png";
			URL url = getClass().getResource(imagePath);
			try {
				dragonPic = (BufferedImage)ImageIO.read(url);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			typeString = "coatl";
		}
		else if (type == PEARLCATCHER) {
			imagePath = "/DragonImages/babyPearlcatcher.png";
			URL url = getClass().getResource(imagePath);
			try {
				dragonPic = (BufferedImage)ImageIO.read(url);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			typeString = "pearlcatcher";
		}
		else if (type == SKYDANCER) {
			imagePath = "/DragonImages/babySkydancer.png";
			URL url = getClass().getResource(imagePath);
			try {
				dragonPic = (BufferedImage)ImageIO.read(url);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			typeString = "skydancer";
		}
		else if (type == IMPERIAL) {
			imagePath = "/DragonImages/imperialBaby.png";
			URL url = getClass().getResource(imagePath);
			try {
				dragonPic = (BufferedImage)ImageIO.read(url);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		typeString = "imperial";
	}
	
	public void evolve() {
		if (type == FAE) {
			imagePath = "/DragonImages/faeAdult.png";
			URL url = getClass().getResource(imagePath);
			try {
				dragonPic = (BufferedImage)ImageIO.read(url);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			typeString = "fae";
		}
		else if (type == COATL) {
			imagePath = "/DragonImages/coatlAdult.png";
			URL url = getClass().getResource(imagePath);
			try {
				dragonPic = (BufferedImage)ImageIO.read(url);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			typeString = "coatl";
		}
		else if (type == PEARLCATCHER) {
			imagePath = "/DragonImages/pearlcatcherAdult.png";
			URL url = getClass().getResource(imagePath);
			try {
				dragonPic = (BufferedImage)ImageIO.read(url);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			typeString = "pearlcatcher";
		}
		else if (type == SKYDANCER) {
			imagePath = "/DragonImages/skydancerAdult.png";
			URL url = getClass().getResource(imagePath);
			try {
				dragonPic = (BufferedImage)ImageIO.read(url);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			typeString = "skydancer";
		}
		else if (type == IMPERIAL) {
			imagePath = "/DragonImages/imperialAdult.png";
			URL url = getClass().getResource(imagePath);
			try {
				dragonPic = (BufferedImage)ImageIO.read(url);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		typeString = "imperial";
	}
	
	public BufferedImage getImage() {
		return dragonPic;
	}
	public int getImageWidth() {
		return dragonPic.getWidth();
	}
	public int getImageHeight() {
		return dragonPic.getHeight();
	}
	public int getAge() {
		return age; 
	}
	public int getHP() { 
		return hp;
	}
	public int getCondition() {
		return condition;
	}
	public String getGenderString() {
		return genderString; 
	}
	public String getType() {
		return typeString;
	}
	public String getName() {
		return name; 
	}
	public int getTotalDragons() {
		return totalDragons;
	}
	public void setHP(int num) {
		hp = num;
	}
	public int returnID() {
		return ID;
	}
	public void decreaseHP(int num) {
		hp -= num;
	}
	public void increaseHP(int num) {
		hp += num; 
	}
	public String calcCondition() {
		if (hp <= 20) return "dying"; 
		else if (hp <= 40) return "sick"; 
		else if (hp <= 60) return "ok"; 
		else if (hp <= 80) return "healthy"; 
		else return "excellent"; 
	}
	public String getMaturity() {
		return maturityString;
	}
	
	public String setMaturityString() {
		if (0 <= age &&  age < 20) maturityString = "baby";
		else if (20 <= age && age <= 30) maturityString = "juvenile";
		else if (age > 30) maturityString = "adult";
		return maturityString;
	}
	
	public int setGender() {
		gender = (int) (Math.random()*2);
		if (gender == FEMALE) {
			genderString = "female";
		}
		else genderString = "male";
		
		return gender; 
	}
	public void increaseAge(int num) {
		age += num; 
	}
	public boolean isDead() {
		if (hp == 0) return true;
		else return false; 
	}
	public boolean releasable() { 
		if (hp == 100 && maturity == ADULT) return true;
		else return false; 
	}

	public void setCondition(int nextInt) {
		// TODO Auto-generated method stub
		condition = nextInt;
	}

	public void setGender(String next) {
		// TODO Auto-generated method stub
		genderString = next;
	}

	public void setType(String next) {
		// TODO Auto-generated method stub
		typeString = next;
	}

	public void setTotalDragons(int next) {
		// TODO Auto-generated method stub
		totalDragons = next;
	}

	public void setMaturityString(String next) {
		// TODO Auto-generated method stub
		maturityString = next;
	}
	
}
