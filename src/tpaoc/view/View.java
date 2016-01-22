package tpaoc.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import tpaoc.commands.ICommand;
import tpaoc.controller.Controller;
import tpaoc.controller.IController;
import tpaoc.model.Constants;


public class View implements IView {
	
	/**
	 * The root layer
	 */
	private AnchorPane root;
	
	/**
	 * The keyBoard
	 */
	private IKeyboard keyBoard;
	
	private IDisplayer myDisplayer;

	private ThumbWheelFx sliderThumb;
	
	
	/* template for the button object */
	private static final String FXML_BUTTON = "Button.fxml";
	/* template for the led object */	
	private static final String FXML_LED = "Led.fxml";
	/* template for the Slider object */		
	private static final String FXML_THUMB = "ThumbWheel.fxml";
	/* template for the Slider object */		
	private static final String FXML_LABEL = "Label.fxml";
	

	public View() {
		root = new AnchorPane();
		
		List<Parent> parents = new ArrayList<>();
		myDisplayer = new Displayer();
		keyBoard = new Keyboard();
		try {
			LedFx led1 = add(parents, FXML_LED, 600,150);
			led1.setId(1);
			myDisplayer.addLed(led1);
			LedFx led2 = add(parents, FXML_LED, 600,300);
			led2.setId(2);
			myDisplayer.addLed(led2);
			
			ButtonFx buttonStart = add(parents, FXML_BUTTON, 30, 350);
			buttonStart.setText("Start");
			buttonStart.setId("buttonStart");
			keyBoard.addButton(1, buttonStart);
			
			ButtonFx buttonStop = add(parents, FXML_BUTTON, 150, 350);
			buttonStop.setText("Stop");
			buttonStop.setId("buttonStop");
			keyBoard.addButton(2, buttonStop);
			
			ButtonFx buttonIncreaseTimeByMeasure = add(parents, FXML_BUTTON, 390, 350);
			buttonIncreaseTimeByMeasure.setText("Inc");
			buttonIncreaseTimeByMeasure.setId("buttonInc");
			keyBoard.addButton(3, buttonIncreaseTimeByMeasure);
			
			ButtonFx buttonDecreaseTimeByMeasure = add(parents, FXML_BUTTON, 270, 350);
			buttonDecreaseTimeByMeasure.setText("Dec");
			buttonDecreaseTimeByMeasure.setId("buttonDec");
			keyBoard.addButton(4, buttonDecreaseTimeByMeasure);
			
			sliderThumb = add(parents, FXML_THUMB, 0, 0);
			sliderThumb.setPosition(Constants.DEFAULT_TEMPO);
			
			DisplayTempoImplFx myDisplayTempo = add(parents, FXML_LABEL, 0,0);
			myDisplayer.setDisplayTempo(myDisplayTempo);
			myDisplayer.displayTempo(Math.round(sliderThumb.getPosition()));
			
			root.getChildren().addAll(parents);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	
	/**
	 * @param root the root to set
	 */
	public void setRoot(AnchorPane root) {
		this.root = root;
	}
	
	
	@Override
	public void setCommand(IController controller) {
		// Setting the command for the button and updating it in the keyboard
		IButton buttonStart = keyBoard.getButton(1);
		buttonStart.setCommand(() -> controller.startEngine());
		keyBoard.addButton(1, buttonStart);
		
		IButton buttonStop = keyBoard.getButton(2);
		buttonStop.setCommand(() -> controller.stopEngine());
		keyBoard.addButton(2, buttonStop);
		
		IButton buttonIncreaseTimeByMeasure = keyBoard.getButton(3);
		buttonIncreaseTimeByMeasure.setCommand(() -> controller.increaseTimeByMeasure());
		keyBoard.addButton(3, buttonIncreaseTimeByMeasure);
		
		IButton buttonDecreaseTimeByMeasure = keyBoard.getButton(4);
		buttonDecreaseTimeByMeasure.setCommand(() -> controller.decreaseTimeByMeasure());
		keyBoard.addButton(4, buttonDecreaseTimeByMeasure);
		
		sliderThumb.setCommand(() -> controller.updateThumbWheel(sliderThumb));
		
	//	myDisplayer.setCommand(() -> controller.updateThumbWheel(sliderThumb));
	}
	
	public void flash(int led) {
		myDisplayer.turnOnLED(led);
		try {
			Thread.sleep(70);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		myDisplayer.turnOffLED(led);
	}
	

	public IThumbWheel getSliderThumb() {
		return sliderThumb;
	}


	@Override
	public void updateLabelTempo(int tempo) {
		myDisplayer.displayTempo(tempo);
	}	
}
