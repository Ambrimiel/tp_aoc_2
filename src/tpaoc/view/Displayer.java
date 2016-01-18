package tpaoc.view;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


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
	private ArrayList<LedFx> myLeds;
	
	private int textTempo;
	
	private DisplayTempoImplFx displayTempo;
	
	/**
	 * Manager for leds.
	 */
	public Displayer() {
		myLeds = new ArrayList<LedFx>();
	}
	
	
	public final void turnOnLED(int numLED) {
		LedFx myled = myLeds.get(numLED-1);
		myled.turnOnLED();
		myled.setActivated(true);
	}


	public final void turnOffLED(int numLED) {
		LedFx myled = myLeds.get(numLED-1);
		myled.turnOffLED();
		myled.setActivated(false);
	}

	
	//
	// Getters and Setters
	//
	public void addLed(LedFx led){
		myLeds.add(led);
	}


	@Override
	public void displayTempo(int tempo) {
		displayTempo.setTextTempo(tempo);
		
	}


	@Override
	public void setDisplayTempo(DisplayTempoImplFx myDisplayTempo) {
		this.displayTempo = myDisplayTempo;
	}

	
}
