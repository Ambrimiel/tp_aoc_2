package tpaoc.controller;

import java.util.Observable;

import javafx.scene.paint.Color;
import tpaoc.model.Clock;
import tpaoc.model.Constants;
import tpaoc.model.Engine;
import tpaoc.model.IClock;
import tpaoc.model.IEngine;
import tpaoc.view.IThumbWheel;
import tpaoc.view.SoundEmettor;
import tpaoc.view.IView;

/**
 * <h2><i>Project name : </i>Metronome</h2>
 * @author <i> Olivier GUILLOU and Jeanne RAULT</i>
 * <p><i>CLass The Controller</i>. The Front controller, is a class to
 * "d�couple" the view and the model.</p>
 * <pre>By convention the tic is the Tempo's  and tac is Measure's name 
 * for this Metronome.</pre>
 */
public class Controller implements IController {

	/*
	 * ====================================================================
	 * Pattern attributes (used for implement command's pattern
	 * =====================================================================
	 */

	/**
	 * The engine (represents business model).
	 */
	private final transient IEngine engine;

	/**
	 * The clock.
	 */
	private final transient IClock clock;

	/**
	 * @param guiView
	 */
	private final transient SoundEmettor soundEmettor;

	private final transient IView guiView;

	/*
	 * =======================================================================
	 * Constructor(s) for this class
	 * =======================================================================
	 */

	/**
	 * Main constructor.
	 * @param guiView.
	 */
	public Controller(IView guiView) {
		engine = new Engine(this);
		clock = new Clock();
		soundEmettor =  new SoundEmettor();
		this.guiView = guiView;
	}

	/*
	 * =======================================================================
	 * METHODS
	 * =======================================================================
	 */

	/**
	 * @see tpaoc.controller.IController#markTempo()
	 */
	public final void markTempo() {
		clock.activateAfterWait(() -> guiView.flash(1),
				Constants.FLASH_TIME);
		clock.activateAfterWait(() -> soundEmettor.makeSound(),
				Constants.FLASH_TIME);
	}

	/**
	 * @see tpaoc.controller.IController#markMeasure()
	 */
	public final void markMeasure() {
		clock.activateAfterWait(() -> guiView.flash(2),
				Constants.FLASH_TIME);
		//clock.activateAfterWait(() -> soundEmettor.makeSound(),
		//		Constants.FLASH_TIME);
		
	}


	public void updateThumbWheel(IThumbWheel tw){
		float position = tw.getPosition();
		System.out.println("position : " + position);
		engine.setTempo(Math.round(position));
	}



	/**
	 * @see tpaoc.controller.IController#startEngine()
	 */
	public final void startEngine() {
		if (!engine.isStarted()) {
			engine.calculatePeriod();
			engine.setStarted(true);
			System.out.println("engine is started " + engine.getTempo());
			// et modifier l'apparence des boutons
		}
	}

	/**
	 * @see tpaoc.controller.IController#stopEngine()
	 */
	public final void stopEngine() {
		if (engine.isStarted()) {
			System.out.println("engine is stopped " + engine.getTempo());
			// et modifier l'apparence des boutons
			engine.setStarted(false);

			// return to defaults values
			engine.setTempo(Constants.DEFAULT_TEMPO);
			engine.setNbTimeByM(Constants.DEF_TEMP_BY_TAC);
			// remettre les autres labels aux valeurs par d�faut

			// et modifier l'apparence des boutons
		}
	}


	/**
	 * @see tpaoc.controller.IController#increaseTimeByMeasure()
	 */
	public final void increaseTimeByMeasure() {

		if ( engine.getNbTimeByM() < Constants.MAX_TEMPO_BY_TAC) {

			engine.setNbTimeByM(engine.getNbTimeByM() + 1);

			System.out.println("increaseTimeByMeasure" + engine.getNbTimeByM());
		} else {
			engine.setNbTimeByM(Constants.MAX_TEMPO_BY_TAC);
		}

	}

	/**
	 * @see tpaoc.controller.IController#decreaseTimeByMeasure()
	 */
	public final void decreaseTimeByMeasure() {

		int currentNb = engine.getNbTimeByM();
		if (currentNb > Constants.MIN_TEMPO) {
			currentNb--;
			engine.setNbTimeByM(currentNb);

			System.out.println("increaseTimeByMeasure" + engine.getNbTimeByM());
			//  changer le texte du label des mesures
			// et celui de la periode
		} else {
			engine.setNbTimeByM(Constants.MIN_TEMPO);
		}

	}


	/**
	 * Observable update method
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable observable, final Object arg) {
		// Tempo
		if (!engine.isUpdatedTempo()) {
			if (engine.isStarted()) {
				engine.updateTicTac();
			}
			// modifier le label du tempo
			guiView.updateLabelTempo(engine.getTempo());
			engine.setUpdatedTempo(true);
		}
		// Time by measure
		if (!engine.isUpdatedNbTimeByM()) {
			// update of the tic tac in the engine
			if (engine.isStarted()) {
				engine.updateTicTac();
			}
			engine.setUpdatedNbTimeByM(true);
		}
		// Started
		if (!engine.isUpdatedStarted()) {
			if (engine.isStarted()) {
				engine.beginTicTac();
			} else {
				engine.stopTicTac();
			}
			engine.setUpdatedStarted(true);
		}

	}

}
