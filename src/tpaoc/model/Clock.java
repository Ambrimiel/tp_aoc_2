package tpaoc.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

import tpaoc.commands.ICommand;

/**
 * @author <i> Olivier GUILLOU and Jeanne RAULT</i>
 * <h1> TP_AOC Metronome V1.2 </h1> 
 * <p><i>Class: Clock</i> 
 * Implementation of IClock  </p>
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
			timer.schedule(clTask, 0, (long) periodInSeconds);
		} catch (Exception e) {
			e.printStackTrace();
		}						      						

	}

	/**
	 * @see tpaoc.model.IClock#activateAfterWait(tpaoc.commands.ICommand, float)
	 */
	public void activateAfterWait(ICommand cmd,float waitInSeconds) {
		final ClockTask clTask = new ClockTask(cmd); 
		clocktasks.put(cmd, clTask);
		timer.schedule(clTask, (long) waitInSeconds); 

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
