package tpaoc.view;

import javafx.scene.control.Button;
import tpaoc.commands.ICommand;

/**
 * Button's interface.
 */
/**
 * @author  Olivier GUILLOU
 * <h1> tp_aoc2 <h1>
 * 22 janv. 2016
 * 
 */
public interface IButton  {
	
	 Boolean isPressed();
	
	/**
	 * Command for the button
	 * @param command
	 */
	void setCommand(ICommand command);
	
}
