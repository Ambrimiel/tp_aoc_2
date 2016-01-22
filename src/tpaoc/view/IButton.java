package tpaoc.view;

import javafx.scene.control.Button;
import tpaoc.commands.ICommand;

/**
 * @author <i> Olivier GUILLOU and Jeanne RAULT</i>
 * <h1> TP_AOC Metronome V1.2 </h1> 
 * <p><i>Interface: IButton</i> 
 * Interface of the buttons. </p>
 */
public interface IButton  {
	
	 Boolean isPressed();
	
	/**
	 * Command for the button
	 * @param command
	 */
	void setCommand(ICommand command);
	
}
