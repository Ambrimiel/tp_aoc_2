package tpaoc.commands;

/**
 * <h2><i>Project name : </i>Metronome</h2>
 * @author <i> Olivier GUILLOU and Jeanne RAULT</i>
 * The interface command to applied the command pattern for many signals.
 */

@FunctionalInterface
public interface ICommand {

	/**
	 * The execute method.
	 */
	void execute();

}
