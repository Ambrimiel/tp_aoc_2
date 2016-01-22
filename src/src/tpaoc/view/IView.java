package tpaoc.view;

import javafx.scene.Parent;
import tpaoc.controller.IController;

public interface IView {
	

	/**
	 * @param controller
	 */
	void setCommand(IController controller);

	/**
	 * @param led
	 */
	void flash(int led);
	
	/**
	 * @param tempo
	 */
	void updateLabelTempo(int tempo);
	
	/**
	 * @return the sliderThumb
	 */
	IThumbWheel getSliderThumb();

}
