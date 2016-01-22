package tpaoc.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import tpaoc.commands.ICommand;
import tpaoc.view.IButton;

/**
 * @author <i> Olivier GUILLOU and Jeanne RAULT</i>
 * <h1> TP_AOC Metronome V1.2 </h1> 
 * <p><i>Class: ButtonFx</i> 
 * Implementation of IButton. </p>
 */
public class ButtonFx implements IButton, Initializable {

	@FXML
	private Button button;
	private ICommand command;
	private Text text;
	private Boolean isPressed;
	
	@Override
	public void setCommand(ICommand command) {
		this.command = command;
	}

	/**
	 * @return the text
	 */
	public Text getText() {
		return text;
	}

	/**
	 * @param text -  the text to set
	 */
	public void setText(Text text) {
		this.text = text;
	}


	/**
	 * @param text - text for the button
	 */
	public void setText(String text) {
		button.setText(text);
	}
	
	
	/**
	 * @param id - Id for the button
	 */
	public void setId(String id) {
		button.setId(id);
	}

	// Initialize
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	    System.err.println("Object added in view : ");	
	    
        button.setOnMouseClicked(event -> {
        	
        	isPressed = true;

        	// Executing command needed
			if (command != null) {
				command.execute();
			} else {
				System.err.println("no command found !");
			}
        });
	}

	
	@Override
	public Boolean isPressed() {
		return isPressed;
	}

	/**
	 * @param button
	 */
	public void setButton(Button button) {
		this.button = button;
	}
}
