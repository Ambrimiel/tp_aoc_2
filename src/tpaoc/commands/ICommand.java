package tpaoc.commands;

/**
 * @author <i> Olivier GUILLOU and Jeanne RAULT</i>
 * <h1> TP_AOC Metronome V1.2 </h1> 
 * The interface for the Command patterns.
 */

@FunctionalInterface
public interface ICommand {

	/**
	 * The execute method.
	 */
	void execute();

}
