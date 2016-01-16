package view;
/**
 * 
 * <h1> Metronome AOC. </h1>
 * @author Guillou-Rault
 *
 */
public interface ILEDManager {

	/**
	 * Turns on the LED numLED.
	 * @param numLED : int
	 */
	void turnOnLED(int numLED);
	
	/**
	 * Turns off the LED numLED.
	 * @param numLED : int
	 */
	void turnOffLED(int numLED);
}
