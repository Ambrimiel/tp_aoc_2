package tpaoc.view;

import java.util.HashMap;

/**
 * 
 * <h1> Metronome AOC. </h1>
 * @author Guillou-Rault
 *
 */
public class LEDManager implements ILEDManager {
	
	/**
	 * The leds.
	 */
	HashMap<Integer, LED> myLeds;
	
	/**
	 * Manager for leds.
	 */
	public LEDManager() {
		myLeds = new HashMap<Integer, LED>();
		myLeds.put(1, new LED());
		myLeds.put(2, new LED());
	}
	
	
	/* (non-Javadoc)
	 * @see tpaoc.view.ILEDManager#turnOnLED(int)
	 */
	public final void turnOnLED(int numLED) {
		LED myled = myLeds.get((Integer) numLED);
		myled.setActivated(true);
	}

	/* (non-Javadoc)
	 * @see tpaoc.view.ILEDManager#turnOffLED(int)
	 */
	public final void turnOffLED(int numLED) {
		LED myled = myLeds.get((Integer) numLED);
		myled.setActivated(false);
	}

}
