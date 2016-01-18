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
public class LedFx implements Initializable {

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
	public void initialize(URL location, ResourceBundle resources) {
		System.err.println("Object  led added in view : ");	
	}


	public void turnOnLED() {
		System.out.println("turnOnLED " + id);
		if (id == 1){
			led.setFill(Color.YELLOW);
		}
		if (id == 2){
			led.setFill(Color.BLUE);
		}
	}


	public void turnOffLED() {
		led.setFill(Color.WHITE);
	}
	
	
	public void setId(int number){
		this.id = number;
	}

}
