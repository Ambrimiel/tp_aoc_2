package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import tpaoc.controller.Controller;
import tpaoc.controller.IController;
import tpaoc.view.ButtonFx;
import tpaoc.view.View;



public class Main extends Application {
	

	
	private IController controller;
	
	
	 private static Stage primaryStage;
		
	public static Stage getStage() {
		return primaryStage;
	}
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			View view = new View();
			controller = new Controller(view);
			view.setController(controller);
			
			
			Scene scene = new Scene(view.getRoot(),700,500);

			scene.getStylesheets().add(Main.class.
				getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
		
			primaryStage.setTitle("METRONOME V1 - AOC TP  GUILLOU - RAULT");

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
	




	public static void main(String[] args) {
		launch(args);
	}
}
