package tpaoc.model;

import java.util.Timer;

import tpaoc.commands.ICommand;

/**
 * <h1>Metronome AOC.</h1>
 * 
 * @author Guillou-Rault 
 * Invoker of the command pattern to manage 
 * the mark of time.
 */
public interface IClock {

	/**
	 * Periodic call of the execute() function of the command cmd.
	 * 
	 * @param cmd .
	 * @param periodInSeconds .
	 */
	void periodicActivate(ICommand cmd, float periodInSeconds);

	/**
	 * Activate the command after a wait.
	 * 
	 * @param cmd .
	 * @param waitInSeconds .
	 */
	void activateAfterWait(ICommand cmd, float waitInSeconds);

	/**
	 * Desactivate the command.
	 * 
	 * @param cmd .
	 */
	void desactivate(ICommand cmd);

	/**
	 * @param timer .
	 */
	void setTimer(Timer timer);

	/**
	 * @return {@link Timer}
	 */
	Timer getTimer();

}
