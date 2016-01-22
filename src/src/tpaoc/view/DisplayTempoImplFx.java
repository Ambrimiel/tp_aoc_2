package tpaoc.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class DisplayTempoImplFx implements Initializable{

	@FXML
	private Label labelTempo;
	
	public void setTextTempo(int textTempo) {
		labelTempo.setText(Integer.toString(textTempo));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("adding label tempo");
		
	}

	/**
	 * @return the labelTempo
	 */
	public Label getLabelTempo() {
		return labelTempo;
	}

	/**
	 * @param labelTempo the labelTempo to set
	 */
	public void setLabelTempo(Label labelTempo) {
		this.labelTempo = labelTempo;
	}
	
	

}
