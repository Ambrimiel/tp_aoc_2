package tpaoc.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;
import tpaoc.commands.ICommand;

/**
 * 
 * <h1> Metronome AOC. </h1>
 * @author Guillou-Rault
 *
 */
public class ThumbWheelFx implements IThumbWheel,Initializable {
	
	
	@FXML
	private Slider sliderThumb;
	
	private ICommand command;
	
	/**
	 * @param command the command to set
	 */
	public void setCommand(ICommand command) {
		this.command = command;
	}

	/**
	 * Position of the ThumbWheel.
	 */
	private float position;
	
	/**
	 * @see tpaoc.view.IThumbWheel#setPosition(float)
	 */
	public void setPosition(final float pPosition) {
		position = pPosition;
	}

	/**
	 * @see tpaoc.view.IThumbWheel#getPosition()
	 */
	public float getPosition() {
		return position;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		System.out.println("Slider added");
		
		/**
		 * A listener for the sliderThumb
		 */
		sliderThumb.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(final ObservableValue<? extends Number> observableValue, final Number oldValue, final Number newValue) {
				setPosition(newValue.floatValue());
				command.execute();
			}
		});	
	}
}
