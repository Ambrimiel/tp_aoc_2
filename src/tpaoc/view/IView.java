package tpaoc.view;

import javafx.scene.Parent;
import tpaoc.controller.IController;

public interface IView {
	
	void setCommand(IController controller);

	/**
	 * 
	 * @param led
	 */
	void flash(int led);
	
	void updateLabelTempo(int tempo);

}
