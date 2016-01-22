package tpaoc.view;

/**
 * 
 * <h1> Metronome AOC. </h1>
 * @author Guillou-Rault
 *
 */
public interface IKeyboard {
	
	/**
	 * Returns if the button i is clicked.
	 * @param numOfButton .
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
