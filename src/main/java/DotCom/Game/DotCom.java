package DotCom.Game;

import java.util.ArrayList;

public class DotCom {
	private ArrayList<String> locationCells;
	private String name;
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setLocationCells(ArrayList<String> loc) {
		locationCells = loc;
	}
	
	public String checkYorself(String userGuess) {
		String result = "miss";
		int index = locationCells.indexOf(userGuess);
		if (index>=0) {
			locationCells.remove(index);
			
			if (locationCells.isEmpty()) {
				result = "kill";
				System.out.println("Ouch, you sunk "+name+"!");
			} else {
				result = "hit";
			}
		}
		return result;
	}

}
