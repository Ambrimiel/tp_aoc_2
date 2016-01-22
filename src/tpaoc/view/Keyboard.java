package tpaoc.view;

import java.util.HashMap;

import tpaoc.view.IButton;
import tpaoc.view.IKeyboard;

/**
 * @author  Olivier GUILLOU - jeanne Rault
 * <h1> tp_aoc2 </h1>
 * 22 janv. 2016
 * 
 */
public class Keyboard implements IKeyboard{
	
	/**
	 * The bag for buttons
	 */
	private HashMap<Integer, IButton> myButtons;
	
	/**
	 * Constructor.
	 */
	public Keyboard(){
		myButtons = new HashMap<Integer, IButton>();
	}

	@Override
	public boolean buttonClicked(int numOfButton) {
		
		return myButtons.get(numOfButton).isPressed();
	}
	
	
	// Getters and setters on the hashmap of buttons
	
	
	/* (non-Javadoc)
	 * @see tpaoc.view.IKeyboard#getButton(int)
	 */
	public IButton getButton(int id) {
		return myButtons.get(id);
	}

	
	/* (non-Javadoc)
	 * @see tpaoc.view.IKeyboard#addButton(java.lang.Integer, tpaoc.view.IButton)
	 */
	public void addButton(Integer id, IButton button){
		myButtons.put(id, button);
	}
}
