/**
 * 
 */
package tpaoc.controller;

import java.util.Observer;

/**
 * <h1> Metronome AOC. </h1>
 * @author Guillou-Rault
 * Client and the receiver for the command pattern to manage signals
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
}
