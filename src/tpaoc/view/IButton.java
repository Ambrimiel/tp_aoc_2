package tpaoc.view;

import tpaoc.commands.ICommand;

/**
 * Button's interface.
 */
public interface IButton  {
	
	/**
	 * Command for the button
	 * @param command
	 */
	public void setCommand(ICommand command);
	
	public void setText(String text);

	public void setId(String id);
	
}
