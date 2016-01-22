package tpaoc.model;

import java.util.TimerTask;
import tpaoc.commands.ICommand;

/**
 * <h1> Metronome AOC. </h1>
 * @author Guillou-Rault
 * The ClockTask for manage task's time.
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
