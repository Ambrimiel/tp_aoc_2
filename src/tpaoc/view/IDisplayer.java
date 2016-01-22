package tpaoc.view;

import tpaoc.commands.ICommand;

/**
 * @author <i> Olivier GUILLOU and Jeanne RAULT</i>
 * <h1> TP_AOC Metronome V1.2 </h1> 
 * <p><i>Interface: IDisplayer</i> 
 * Interface to manage the leds and the display of the tempo. </p>
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
	 * Displays the tempo.
	 * @param tempo
	 */
	void displayTempo(int tempo);
	
	/**
	 * Adds a led to the ArrayList.
	 */
	void addLed(LedFx led);

	/**
	 * @param myDisplayTempo
	 */
	void setDisplayTempo(DisplayTempoImplFx myDisplayTempo);

	/**
	 * @param command
	 */
	void setCommand(ICommand command);

}
