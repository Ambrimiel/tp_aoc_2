package controller;

import command.ICommand;
import view.View;

public class Controller implements IController {

	private View view;
	
	private ICommand startCommand;

	public Controller(View view) {
		this.view = view;
	}
	
	
	@Override
	public void startEngine() {
		System.err.println("Start  !!!! the model");
		
	}
	

}
