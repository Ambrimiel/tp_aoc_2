package tpaoc.view;


import tpaoc.controller.IController;

/**
 * @author  Olivier GUILLOU - Jeanne Rault
 * <h1> tp_aoc2 </h1>
 * 22 janv. 2016
 * 
 */
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
