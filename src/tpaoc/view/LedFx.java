package tpaoc.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * @author <i> Olivier GUILLOU and Jeanne RAULT</i>
 * <h1> TP_AOC Metronome V1.2 </h1> 
 * <p><i>Class: LedFx</i> 
 * Allows to manage the leds. </p>
 */
public class LedFx implements Initializable {

	/**
	 * The circle who represent a LED for the tempo.
	 */
	@FXML
	private transient Circle led;

	/**
	 * State of led
	 */
	private boolean activated;
	
	/**
	 * Id for the led
	 */
	private int id;

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
	public void initialize(URL location, ResourceBundle resources) {}


	/**
	 * Method for turned On the Led : (Color RED OR GREEN) 
	 */
	public void turnOnLED() {
		if (id == 1)
			led.setFill(Color.RED);
		
		if (id == 2)
			led.setFill(Color.BLUE);
	}

	/**
	 * Method for turned OFF (WHite) the Led
	 */
	public void turnOffLED() {
		led.setFill(Color.WHITE);
	}
	
	
	/**
	 * @param number
	 */
	public void setId(int number){
		this.id = number;
	}

}
