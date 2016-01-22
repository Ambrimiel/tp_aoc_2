package tpaoc.model;

import java.util.TimerTask;
import tpaoc.commands.ICommand;

/**
 * @author <i> Olivier GUILLOU and Jeanne RAULT</i>
 * <h1> TP_AOC Metronome V1.2 </h1> 
 * <p><i>Class: ClockTask</i> 
 * Used by Clock to execute commands periodically. </p>
 */
public class ClockTask extends TimerTask {
	
	/**
	 * The current command activated.
	 */
	private final transient ICommand cmd;
	
	/**
	 * Main contructor.
	 * @param cmd .
	 */
	public ClockTask(final ICommand cmd) {
		super();
		this.cmd = cmd;
	}

	
	/**
	 * @see java.util.TimerTask#run()
	 */
	public void run() {
	cmd.execute();
	}

}
