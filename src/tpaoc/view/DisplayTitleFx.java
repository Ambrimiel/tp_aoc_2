package tpaoc.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * @author <i> Olivier GUILLOU and Jeanne RAULT</i>
 * <h1> TP_AOC Metronome V1.2 </h1> 
 * <p><i>Class: DisplayTitleFx</i> 
 * Used to display the title. </p>
 */
public class DisplayTitleFx implements  Initializable {

	@FXML
	private Label labelTitle;
	
	/**
	 * @param textTempo
	 */
	public void setTextTempo(String textTempo) {
		labelTitle.setText(textTempo);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {}

	/**
	 * @return the labelTitle
	 */
	public Label getLabelTitle() {
		return labelTitle;
	}

	/**
	 * @param labelTitle the labelTitle to set
	 */
	public void setLabelTitle(Label labelTitle) {
		this.labelTitle = labelTitle;
	}

}
