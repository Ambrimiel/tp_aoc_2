package tpaoc.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * @author  Olivier GUILLOU - Jeanne RAULT
 * <h1> tp_aoc2 </h1>
 * 22 janv. 2016
 * 
 */
public class DisplayTempoImplFx implements  Initializable {

	@FXML
	private Label labelTempo;
	
	/**
	 * @param textTempo
	 */
	public void setTextTempo(int textTempo) {
		labelTempo.setText(Integer.toString(textTempo));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {}

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
