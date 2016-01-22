package tpaoc.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import tpaoc.commands.ICommand;

/**
 * @author <i> Olivier GUILLOU and Jeanne RAULT</i>
 * <h1> TP_AOC SoundEmettor V1.2 </h1> 
 * <p><i>Class: ThumbWheelFx</i> 
 * Implementation of IThumbWheel. </p>
 */
public class ThumbWheelFx implements IThumbWheel, Initializable {
	
	
	@FXML
	private Slider sliderThumb;
	
	/**
	 * The command
	 */
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
	
		// default value of the slider
		sliderThumb.setValue(60D);
		
		/**
		 * A listener for the sliderThumb
		 */
		sliderThumb.valueProperty().addListener(new ChangeListener<Number>() {
			
			public void changed(final ObservableValue<? extends Number> observableValue, final Number oldValue, final Number newValue) {
				setPosition(newValue.floatValue());
	        	// Executing needed command
				if (command != null) {
					command.execute();
				}

			}
		});	
	}

	@Override
	public void setPosition(int position) {
		this.position = position;
	}
}
