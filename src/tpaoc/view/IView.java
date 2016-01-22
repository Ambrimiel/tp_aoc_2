package tpaoc.view;


import tpaoc.controller.IController;

/**
 * @author <i> Olivier GUILLOU and Jeanne RAULT</i>
 * <h1> TP_AOC Metronome V1.2 </h1> 
 * <p><i>Interface: IView</i> 
 * Interface of the view. </p>
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
