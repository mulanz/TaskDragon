import java.util.ArrayList;


public class Wilderness {
	private ArrayList<Dragon> released = new ArrayList<Dragon>(); 
	private int numReleased; 
	
	public Wilderness() { 
		numReleased = 0;
	}
	
	public void addDragon(Dragon dro) {
		released.add(dro);
		numReleased ++;
	}
	
	
}
