package tpaoc.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

import tpaoc.commands.ICommand;

/**
 * <h1>Metronome AOC</h1>.
 * @author Guillou-Rault
 */
public class Clock implements IClock {
	

	/**
	 * Timer that will call the scheduled.
	 */
	private Timer timer;

	/**
	 * MAp for the ClockTask
	 */
	private transient Map<ICommand, ClockTask> clocktasks;
	
	/**
	 * @see tpaoc.model.IClock#getTimer()
	 */
	public Timer getTimer() {
		return timer;
	}

	/**
	 * @see tpaoc.model.IClock#setTimer(java.util.Timer)
	 */
	public void setTimer(final Timer timer) {
		this.timer = timer;
	}

	/**
	 * Constructor.
	 */
	public Clock() {
		timer = new Timer();
		clocktasks = new HashMap<ICommand, ClockTask>();
	}


	/**
	 * @see tpaoc.model.IClock#periodicActivate(tpaoc.commands.ICommand, float)
	 */
	public void periodicActivate(final ICommand cmd, final float periodInSeconds) {
		final ClockTask clTask = new ClockTask(cmd); 
		clocktasks.put(cmd, clTask);
		
		try {
			timer.schedule(clTask, 0, (long) periodInSeconds); // Create Repetitively
		} catch (Exception e) {}						       // task for every
															   // periodInSeconds
							
	}

	/**
	 * @see tpaoc.model.IClock#activateAfterWait(tpaoc.commands.ICommand, float)
	 */
	public void activateAfterWait(ICommand cmd,float waitInSeconds) {
		final ClockTask clTask = new ClockTask(cmd); 
		clocktasks.put(cmd, clTask);
		timer.schedule(clTask, (long) waitInSeconds); // Create Repetitively task
													  // that begins after
													  // waitInSeconds
	}

	/**
	 * @see tpaoc.model.IClock#desactivate(tpaoc.commands.ICommand)
	 */
	public void desactivate(final ICommand cmd) {
		timer.cancel();
		timer.purge();
		timer = new Timer();
	}


	

	
	
}
