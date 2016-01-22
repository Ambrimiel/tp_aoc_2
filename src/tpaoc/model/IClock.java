package tpaoc.model;

import java.util.Timer;

import tpaoc.commands.ICommand;

/**
 * @author <i> Olivier GUILLOU and Jeanne RAULT</i>
 * <h1> TP_AOC Metronome V1.2 </h1>
 * <p><i>Interface: IClock</i> 
 * Invoker of the command pattern to mark the time.</p>
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
	 * @param timer.
	 */
	void setTimer(Timer timer);

	/**
	 * @return {@link Timer}
	 */
	Timer getTimer();
}
