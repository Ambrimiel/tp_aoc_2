package tpaoc.view;

import java.awt.Toolkit;

import tpaoc.view.ISoundEmettor;

/**
 * @author <i> Olivier GUILLOU and Jeanne RAULT</i>
 * <h1> TP_AOC SoundEmettor V1.2 </h1> 
 * <p><i>Class: LedFx</i> 
 * Implementation of ISoundEmettor. </p>
 */
public class SoundEmettor implements ISoundEmettor {

	/* (non-Javadoc)
	 * @see tpaoc.view.ISoundEmettor#makeSound()
	 */
	public void makeSound() {
		Toolkit.getDefaultToolkit().beep();
		
	}

}
