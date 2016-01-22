package tpaoc.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * @author <i> Olivier GUILLOU and Jeanne RAULT</i>
 * <h1> TP_AOC Metronome V1.2 </h1> 
 * <p><i>Class: DisplayTempoImplFx</i> 
 * Used to display the tempo. </p>
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
