package tpaoc.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import tpaoc.commands.ICommand;
import tpaoc.controller.IController;
import tpaoc.model.Constants;


public class View implements IView {

	
	/**
	 * The root layer
	 */
	private AnchorPane root;
	
	private IButton buttonStart;
	
	private IButton buttonStop;
	
	private IButton buttonDecreaseTimeByMeasure;
	
	private IButton buttonIncreaseTimeByMeasure;
	
	private IDisplayer ledManager;

	
	private ThumbWheelFx sliderThumb;
	
	private IDisplayTempo displayTempo;
	
	
	
	
	
	/* template for the button object */
	private static final String FXML_BUTTON = "Button.fxml";
	/* template for the led object */	
	private static final String FXML_LED = "Led.fxml";
	/* template for the Slider object */		
	private static final String FXML_THUMB = "ThumbWheel.fxml";
	/* template for the Slider object */		
	private static final String FXML_LABEL = "Label.fxml";
	

	private ICommand startCommand;
	
	
	public View() {
		root = new AnchorPane();
		
		List<Parent> parents = new ArrayList<>();
		ledManager = new Displayer();
		try {
			LedFx led1 = add(parents, FXML_LED, 600,150);
			led1.setId(1);
			ledManager.addLed(led1);
			LedFx led2 = add(parents, FXML_LED, 600,300);
			led2.setId(2);
			ledManager.addLed(led2);
			
			buttonStart = add(parents, FXML_BUTTON, 30, 350);
			buttonStart.setText("Start");
			buttonStart.setId("buttonStart");
			
			buttonStop = add(parents, FXML_BUTTON, 150, 350);
			buttonStop.setText("stop");
			buttonStop.setId("buttonStop");
			
			buttonDecreaseTimeByMeasure = add(parents, FXML_BUTTON, 270, 350);
			buttonDecreaseTimeByMeasure.setText("dec");
			buttonDecreaseTimeByMeasure.setId("buttonDec");
			
			buttonIncreaseTimeByMeasure = add(parents, FXML_BUTTON, 390, 350);
			buttonIncreaseTimeByMeasure.setText("inc");
			buttonIncreaseTimeByMeasure.setId("buttonInc");
			
			sliderThumb = add(parents, FXML_THUMB, 0, 0);
			sliderThumb.setPosition(Constants.DEFAULT_TEMPO);
			
			displayTempo = add(parents, FXML_LABEL, 0,0);
			displayTempo.setTextTempo(Constants.DEFAULT_TEMPO);
			
			root.getChildren().addAll(parents);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public IButton getButtonStart() {
		return buttonStart;
	}

	private <X> X add(List<Parent> parents, String fxml, int x, int y) throws IOException {
		
		FXMLLoader fxmlLoader = new FXMLLoader();

		Parent view = fxmlLoader.load(getClass().getResource(fxml).openStream());
		
		view.setLayoutX(x);
		view.setLayoutY(y);
		
		parents.add(view);
		
		return fxmlLoader.getController();
	}


	/**
	 * @return the root
	 */
	public AnchorPane getRoot() {
		return root;
	}
	

/*	
	public IDisplayer getTicLed() {
		return ticLed;
	}

	public IDisplayer getTacLed() {
		return tacLed;
	}
*/

	/**
	 * @param root the root to set
	 */
	public void setRoot(AnchorPane root) {
		this.root = root;
	}
	
	
	@Override
	public void setController(IController controller) {

		buttonStart.setCommand(() -> controller.startEngine());
		buttonStop.setCommand(() -> controller.stopEngine());
		buttonIncreaseTimeByMeasure.setCommand(() -> controller.increaseTimeByMeasure());
		buttonDecreaseTimeByMeasure.setCommand(() -> controller.decreaseTimeByMeasure());
		
		sliderThumb.setCommand(() -> controller.updateThumbWheel(sliderThumb));
		
	}
	
	public void flash(int led) {
		ledManager.turnOnLED(led);
		try {
			Thread.sleep(70);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ledManager.turnOffLED(led);
	
	}


	/**
	 * @return the buttonStop
	 */
	public IButton getButtonStop() {
		return buttonStop;
	}


	/**
	 * @return the buttonDecreaseTimeByMeasure
	 */
	public IButton getButtonDecreaseTimeByMeasure() {
		return buttonDecreaseTimeByMeasure;
	}


	/**
	 * @return the buttonIncreaseTimeByMeasure
	 */
	public IButton getButtonIncreaseTimeByMeasure() {
		return buttonIncreaseTimeByMeasure;
	}


	/**
	 * @return the sliderThumb
	 */
	public ThumbWheelFx getSliderThumb() {
		return sliderThumb;
	}
	
	

}
