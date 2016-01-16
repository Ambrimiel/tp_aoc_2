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
	
	private IButton decreaseTimeByMeasure;
	
	private IButton increaseTimeByMeasure;
	
	private IDisplayer ticLed;
	
	private IDisplayer tacLed;
	
	private ThumbWheelFx sliderThumb;
	
	
	
	
	
	/* template for the button object */
	private static final String FXML_BUTTON = "Button.fxml";
	
	private static final String FXML_LED = "Led.fxml";
	
	private static final String FXML_THUMB = "ThumbWheel.fxml";
	

	private ICommand startCommand;
	
	
	public View() {
		
		
		
		root = new AnchorPane();
		
		List<Parent> parents = new ArrayList<>();
		
		try {
			
			
			ticLed = create(parents, FXML_LED, 30,30);
			ticLed.setNumLED(1);
			tacLed = create(parents, FXML_LED, 30,30);
			tacLed.setNumLED(2);
			
			buttonStart = create(parents, FXML_BUTTON, 30, 350);
			buttonStart.setText("Start");
			buttonStart.setId("buttonStart");
			
			buttonStop = create(parents, FXML_BUTTON, 150, 350);
			buttonStop.setText("stop");
			buttonStop.setId("buttonStop");
			
			decreaseTimeByMeasure = create(parents, FXML_BUTTON, 270, 350);
			decreaseTimeByMeasure.setText("dec");
			decreaseTimeByMeasure.setId("buttonDec");
			
			increaseTimeByMeasure = create(parents, FXML_BUTTON, 390, 350);
			increaseTimeByMeasure.setText("inc");
			increaseTimeByMeasure.setId("buttonInc");
			
			sliderThumb = create(parents, FXML_THUMB, 0, 10);
			sliderThumb.setPosition(Constants.DEFAULT_TEMPO);
			
			
			
			


			
			root.getChildren().addAll(parents);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public IButton getButtonStart() {
		return buttonStart;
	}

	private <X> X create(List<Parent> parents, String fxml, int x, int y) throws IOException {
		
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
	


	/**
	 * @return the ticLed
	 */
	public IDisplayer getTicLed() {
		return ticLed;
	}


	/**
	 * @return the tacLed
	 */
	public IDisplayer getTacLed() {
		return tacLed;
	}


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
		
		sliderThumb.setCommand(() -> controller.updateThumbWheel(sliderThumb));
		
	}

}
