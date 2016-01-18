package tpaoc.view;

import java.util.ArrayList;


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
	ArrayList<LedFx> myLeds;
	
	
	/**
	 * Manager for leds.
	 */
	public Displayer() {
		myLeds = new ArrayList<LedFx>();
	}
	
	
	/* (non-Javadoc)
	 * @see tpaoc.view.ILEDManager#turnOnLED(int)
	 */
	public final void turnOnLED(int numLED) {
		LedFx myled = myLeds.get(numLED-1);
		myled.turnOnLED();
		myled.setActivated(true);
	}

	/* (non-Javadoc)
	 * @see tpaoc.view.ILEDManager#turnOffLED(int)
	 */
	public final void turnOffLED(int numLED) {
		LedFx myled = myLeds.get(numLED-1);
		myled.turnOffLED();
		myled.setActivated(false);
	}
	
	
	public void addLed(LedFx led){
		myLeds.add(led);
	}

}
