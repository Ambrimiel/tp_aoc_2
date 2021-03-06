package tpaoc.application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import tpaoc.controller.Controller;
import tpaoc.controller.IController;
import tpaoc.view.View;


/**
 * @author <i> Olivier GUILLOU and Jeanne RAULT</i>
 * <h1> TP_AOC Metronome V1.2 </h1>
 * Main class
 */
public class Main extends Application {

	/**
	 * The Controller
	 */
	private IController controller;

	/**
	 * The Stage of javaFx
	 */
	private static Stage primaryStage;


	/**
	 * @return primaryStage
	 */
	public static Stage getStage() {
		return primaryStage;
	}

	@Override
	public void start(Stage primaryStage) {
		try {

			View view = new View();

			controller = new Controller(view);

			view.setCommand(controller);

			Scene scene = new Scene(view.getRoot(),700,500);

			scene.getStylesheets().add(Main.class.
					getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);

			primaryStage.setTitle("METRONOME V1.2 - AOC TP  GUILLOU - RAULT");

			primaryStage.show();

			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				public void handle(WindowEvent e) {
					Platform.exit();
					System.exit(0);
				}
			});

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The main method.
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
