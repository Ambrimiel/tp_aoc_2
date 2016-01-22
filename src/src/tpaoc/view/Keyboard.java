package tpaoc.view;

import java.util.HashMap;

public class Keyboard implements IKeyboard{
	
	private HashMap<Integer, IButton> myButtons;
	
	public Keyboard(){
		myButtons = new HashMap<Integer, IButton>();
	}

	@Override
	public boolean buttonClicked(int numOfButton) {
		
		return myButtons.get(numOfButton).isPressed();
	}
	
	
	// Getters and setters on the hashmap of buttons
	public IButton getButton(int id) {
		return myButtons.get(id);
	}

	
	public void addButton(Integer id, IButton button){
		myButtons.put(id, button);
	}
}
