package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import command.ICommand;
import controller.IController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;


public class View implements IView {

	
	/**
	 * The root layer
	 */
	private AnchorPane root;
	
	private IButton buttonStart;
	
	private IButton buttonStop;
	
	
	
	
	
	/* template for the button object */
	private static final String FXML_BUTTON = "Button.fxml";
	

	private ICommand startCommand;
	
	
	public View() {
		
		
		
		root = new AnchorPane();
		
		List<Parent> parents = new ArrayList<>();
		
		try {
			
			buttonStart = create(parents, FXML_BUTTON, 30, 120);
			buttonStart.setText("Start");
			buttonStart.setId("buttonStart");
			//buttonStart.setCommand(() -> controller.startEngine());
			
			
			buttonStop = create(parents, FXML_BUTTON, 150, 120);
			buttonStop.setText("stop");
			buttonStop.setId("buttonStop");
			
			root.getChildren().addAll(parents);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public IButton getButtonStart() {
		return buttonStart;
	}

	private <X> X create(List<Parent> parents, String fxmlButton, int x, int y) throws IOException {
		
		FXMLLoader fxmlLoader = new FXMLLoader();

		Parent view = fxmlLoader.load(getClass().getResource(fxmlButton).openStream());
		
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
	public void setController(IController controller) {
		
		buttonStart.setCommand(() -> controller.startEngine());
	}

}
