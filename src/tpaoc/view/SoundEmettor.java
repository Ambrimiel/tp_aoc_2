package tpaoc.view;

import java.awt.Toolkit;

import tpaoc.view.ISoundEmettor;

/**
 * 
 * <h1> Metronome AOC. </h1>
 * @author Guillou-Rault
 * Make a simple sound
 */
public class SoundEmettor implements ISoundEmettor {

	/* (non-Javadoc)
	 * @see tpaoc.view.ISoundEmettor#makeSound()
	 */
	public void makeSound() {
		Toolkit.getDefaultToolkit().beep();
		
	}

}
