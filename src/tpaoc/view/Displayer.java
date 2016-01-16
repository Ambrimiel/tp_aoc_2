package tpaoc.view;

import java.util.HashMap;

/**
 * 
 * <h1> Metronome AOC. </h1>
 * @author Guillou-Rault
 *
 */
public class Displayer implements IDisplayer {
	
	/**
	 * The leds.
	 */
	HashMap<Integer, LedFx> myLeds;
	
	/**
	 * Numero of led;
	 */
	private int numLED;
	
	/**
	 * Manager for leds.
	 */
	public Displayer() {
		myLeds = new HashMap<Integer, LedFx>();
		myLeds.put(1, new LedFx());
		myLeds.put(2, new LedFx());
	}
	
	
	/* (non-Javadoc)
	 * @see tpaoc.view.ILEDManager#turnOnLED(int)
	 */
	public final void turnOnLED(int numLED) {
		LedFx myled = myLeds.get((Integer) numLED);
		myled.setActivated(true);
	}

	/* (non-Javadoc)
	 * @see tpaoc.view.ILEDManager#turnOffLED(int)
	 */
	public final void turnOffLED(int numLED) {
		LedFx myled = myLeds.get((Integer) numLED);
		myled.setActivated(false);
	}


	@Override
	public void setNumLED(int i) {
		this.numLED = i;
	}

}
