package tpaoc.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import tpaoc.commands.ICommand;

/**
 * 
 * <h1> Metronome AOC. </h1>
 * @author Guillou-Rault
 *
 */
public class LedFx implements IDisplayer, Initializable {

	/**
	 * The circle who represent a LED for the tempo.
	 */
	@FXML
	private transient Circle led;


	/**
	 * 
	 */
	private ICommand command;

	/**
	 * 
	 */
	private boolean activated;

	/**
	 * @return activated .
	 */
	public final boolean isActivated() {
		return activated;
	}

	/**
	 * @param pActivated .
	 */
	public final void setActivated(final boolean pActivated) {
		this.activated = pActivated;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.err.println("Object  led added in view : ");	
	}

	@Override
	public void turnOnLED(int numLED) {
		System.out.println("turnOnLED" + numLED);
		if (numLED == 1){
			led.setFill(Color.YELLOW);
		}
		if (numLED == 2){
			led.setFill(Color.BLUE);
		}
	}

	@Override
	public void turnOffLED(int numLED) {
		led.setFill(Color.WHITE);
	}

	@Override
	public void setNumLED(int i) {
		//	led.setFill(Color.GREEN);

	}

}
