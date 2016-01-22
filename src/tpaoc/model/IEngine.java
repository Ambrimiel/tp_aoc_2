package tpaoc.model;

import java.util.Map;

import tpaoc.commands.ICommand;

/**
 * 
 * <h1> Metronome AOC. </h1>
 * @author Guillou-Rault
 *
 */
public interface IEngine {
	
	/**
	 * Sees if tempo has been updated after its 
	 * last modification, looking at updatedTempo.
	 * @return boolean
	 */
	boolean isUpdatedTempo();

	/**
	 * Sees if nbTimeByM has been updated after
	 *  its last modification, looking at 
	 *  updatedNbTimeByM.
	 * @return boolean
	 */
	boolean isUpdatedNbTimeByM();

	/**
	 * Sees if started has been updated after 
	 * its last modification, looking at 
	 * updatedStarted.
	 * @return boolean
	 */
	boolean isUpdatedStarted();
	
	
	/**
	 * @return Integer : the tempo 
	 */
	Integer getTempo();
	
	/**
	 * 
	 * @return Integer : number of times by mesure
	 */
	Integer getNbTimeByM();
	
	/**
	 * 
	 * @return boolean : 
	 */
	boolean isStarted();
	
	/**
	 * 
	 * @param tempo .
	 */
	void setTempo(Integer tempo);
	
	/**
	 * 
	 * @param timeByM .
	 */
	void setNbTimeByM(Integer timeByM);
	
	/**
	 * 
	 * @param started .
	 */
	void setStarted(boolean started);

	
	/**
	 * Calls the clock to begin the tic tac.
	 */
	void beginTicTac();
	
	/**
	 * Calls the clock to deactivate and reactivate the tic tac.
	 */
	void updateTicTac();
	
	/**
	 * Calls the clock to deactivate the tic tac.
	 */
	void stopTicTac();

	/**
	 * 
	 * @param updatedTempo .
	 */
	void setUpdatedTempo(boolean updatedTempo);

	/**
	 * 
	 * @param updatedNbTimeByM .
	 */
	void setUpdatedNbTimeByM(boolean updatedNbTimeByM);

	/**
	 * 
	 * @param updatedStarted .
	 */
	void setUpdatedStarted(boolean updatedStarted);

	/**
	 * 
	 * Calculates, sets and returns the period.
	 * @return period
	 */
	int calculatePeriod();

	int getPeriod();



}