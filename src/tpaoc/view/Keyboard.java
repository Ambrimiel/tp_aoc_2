package tpaoc.view;

import java.util.HashMap;

import tpaoc.view.IButton;
import tpaoc.view.IKeyboard;

/**
 * @author <i> Olivier GUILLOU and Jeanne RAULT</i>
 * <h1> TP_AOC Metronome V1.2 </h1> 
 * <p><i>Class: Keyboard</i> 
 * Implementation of IKeyboard. </p>
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
