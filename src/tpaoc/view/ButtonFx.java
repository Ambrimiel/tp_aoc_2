package tpaoc.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import tpaoc.commands.ICommand;

public class ButtonFx implements IButton, Initializable {

	@FXML
	private Button button;
	
	private ICommand command;
	
	private Text text;

	
	
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
	 * @param text the text to set
	 */
	public void setText(Text text) {
		this.text = text;
	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		

		    System.err.println("Object added in view : ");	
		
	        button.setOnMouseClicked(event -> {
			
			
			if (button.getId().equals("buttonStart")) {
				System.err.println("The Button + " + button.getId() + " is clicked.");
			}
			
			if (button.getId().equals("buttonStop")) {
				System.err.println("The Button + " + button.getId() + " is clicked.");
			}
			
			if (button.getId().equals("buttonInc")) {
				System.err.println("The Button + " + button.getId() + " is clicked.");
			}
			
			if (button.getId().equals("buttonDec")) {
				System.err.println("The Button + " + button.getId() + " is clicked.");
			}
			
			if (command != null) {
				command.execute();
			} else {
				System.err.println("no command found !");
			}
		});

		
	}





	@Override
	public void setText(String text) {
		button.setText(text);
		
	}





	@Override
	public void setId(String id) {
		button.setId(id);
	}










}
