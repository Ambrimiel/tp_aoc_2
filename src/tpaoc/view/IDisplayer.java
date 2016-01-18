package tpaoc.view;
/**
 * 
 * <h1> Metronome AOC. </h1>
 * @author Guillou-Rault
 *
 */
public interface IDisplayer {

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
	
	/**
	 * Adds a led to the ArrayList.
	 */
	void addLed(LedFx led);
	
}
