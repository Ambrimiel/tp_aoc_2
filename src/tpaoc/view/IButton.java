package tpaoc.view;

import tpaoc.commands.ICommand;

/**
 * Button's interface.
 */
public interface IButton  {
	
	 Boolean isPressed();
	
	/**
	 * Command for the button
	 * @param command
	 */
	void setCommand(ICommand command);
	
	void setText(String text);

	void setId(String id);
	
}
