import java.util.ArrayList;
import java.util.List;

public class Graveyard {
	List<Dragon> dead = new ArrayList<Dragon>();
	public Graveyard(){
		
	}
	
	public void addDead(Dragon d){
		dead.add(d);
	}
}
