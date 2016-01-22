package tpaoc.view;

/**
 * @author <i> Olivier GUILLOU and Jeanne RAULT</i>
 * <h1> TP_AOC Metronome V1.2 </h1> 
 * <p><i>Interface: IKeyboard</i> 
 * Interface to manage the buttons. </p>
 */
public interface IKeyboard {
	
	/**
	 * Returns if the button i is clicked.
	 * @param numOfButton.
	 * @return boolean 
	 */
	boolean buttonClicked(int numOfButton);
	
	/**
	 * Adds a button in the keyboard
	 * @param id
	 * @param button
	 */
	void addButton(Integer id, IButton button);

	/**
	 * @param id
	 * @return
	 */
	IButton getButton(int id);

}
