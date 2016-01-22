/**
 * 
 */
package tpaoc.controller;

import java.util.Observer;

import tpaoc.view.IThumbWheel;

/**
 * @author <i> Olivier GUILLOU and Jeanne RAULT</i>
 * <h1> TP_AOC Metronome V1.2 </h1> 
 * The interface for the Controller.
 * Client and receiver for the command pattern to manage signals
 */
public interface IController extends Observer {
	
	/**
	 * Tells the GUI to mark tempo.
	 */
	void markTempo();

	/**
	 * Tells the GUI to mark measure.
	 */
	void markMeasure();
	
	// FXML functions
	
	/**
	 * Function called by the view. Starts the engine.
	 */
	void startEngine();
	
	/**
	 * Function called by the view. Stops the engine.
	 */
	void stopEngine();

	/**
	 * Function called by the view. Increases the number of time by measure.
	 */
	void increaseTimeByMeasure();
	
	/**
	 * Function called by the view. Decreases the number of time by measure.
	 */
	void decreaseTimeByMeasure();
	
	
	/**
	 * Function called by the view. Updates the thumbWheel.
	 * @param tw
	 */
	void updateThumbWheel(IThumbWheel tw);
}
