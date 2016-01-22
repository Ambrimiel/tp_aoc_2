package tpaoc.view;

import java.util.ArrayList;

import tpaoc.commands.ICommand;

import tpaoc.view.IDisplayer;


/**
 * <h1> Metronome AOC. </h1>
 * @author Guillou-Rault
 */

public class Displayer implements IDisplayer {
	
	/**
	 * The leds.
	 */
	private ArrayList<LedFx> myLeds;
	
	/**
	 * Display for the tempo.
	 */
	private DisplayTempoImplFx displayTempo;

	
	/**
	 * Command in use.                                                                 
	 */
	private ICommand command;
	
	/**
	 * Manager for leds.
	 */
	public Displayer() {
		myLeds = new ArrayList<LedFx>();
	}
	
	
	/* (non-Javadoc)
	 * @see tpaoc.view.IDisplayer#turnOnLED(int)
	 */
	public final void turnOnLED(int numLED) {
		LedFx myled = myLeds.get(numLED-1);
		myled.turnOnLED();
		myled.setActivated(true);
	}


	/* (non-Javadoc)
	 * @see tpaoc.view.IDisplayer#turnOffLED(int)
	 */
	public final void turnOffLED(int numLED) {
		LedFx myled = myLeds.get(numLED-1);
		myled.turnOffLED();
		myled.setActivated(false);
	}

	

	/* (non-Javadoc)
	 * @see tpaoc.view.IDisplayer#addLed(tpaoc.view.LedFx)
	 */
	public void addLed(LedFx led){
		myLeds.add(led);
	}


	/* (non-Javadoc)
	 * @see tpaoc.view.IDisplayer#displayTempo(int)
	 */
	@Override
	public void displayTempo(int tempo) {
		displayTempo.setTextTempo(tempo);
	}


	/* (non-Javadoc)
	 * @see tpaoc.view.IDisplayer#setDisplayTempo(tpaoc.view.DisplayTempoImplFx)
	 */
	@Override
	public void setDisplayTempo(DisplayTempoImplFx myDisplayTempo) {
		this.displayTempo = myDisplayTempo;
	}



	/* (non-Javadoc)
	 * @see tpaoc.view.IDisplayer#setCommand(tpaoc.commands.ICommand)
	 */
	public void setCommand(ICommand command) {
		this.command = command;
	}

	
}
