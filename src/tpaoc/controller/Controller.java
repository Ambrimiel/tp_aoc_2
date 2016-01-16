package tpaoc.controller;

import java.util.Observable;

import tpaoc.model.Clock;
import tpaoc.model.Constants;
import tpaoc.model.Engine;
import tpaoc.model.IClock;
import tpaoc.model.IEngine;
import tpaoc.view.ThumbWheel;
import tpaoc.view.View;

/**
 * <h2><i>Project name : </i>Metronome</h2>
 * @author <i> Olivier GUILLOU and Jeanne RAULT</i>
 * <p><i>CLass The Controller</i>. The Front controller, is a class to
 * "découple" the view and the model.</p>
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

	/*
	 * =======================================================================
	 * Constructor(s) for this class
	 * =======================================================================
	 */

	/**
	 * Main constructor.
	 * @param guiView.
	 */
	public Controller(final View guiView) {
		engine = new Engine(this);
		clock = new Clock();
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
		
		// appeler la fonction du controllerView qui gere la led1 et le son ... 
		//a utiliser avec la clock
	}

	/**
	 * @see tpaoc.controller.IController#markMeasure()
	 */
	public final void markMeasure() {
		
		// appeler la fonction du controllerView qui gere la led2 et le son ... 
		//a utiliser avec la clock
	}

	
	public void updateThumbWheel(ThumbWheel tw){
		
		float position = tw.getPosition();
		engine.setTempo(Math.round(position));
		
	}
	

	/**
	 * @see tpaoc.controller.IController#startEngine()
	 */
	public final void startEngine() {
		if (!engine.isStarted()) {
			engine.setStarted(true);

			// et modifier l'apparence des boutons
		}
	}

	/**
	 * @see tpaoc.controller.IController#stopEngine()
	 */
	public final void stopEngine() {
		if (engine.isStarted()) {

			engine.setStarted(false);

			// return to defaults values
			engine.setTempo(Constants.DEFAULT_TEMPO);
			
			// remettre le texte du label du tempo au défaut
			engine.setNbTimeByM(Constants.DEF_TEMP_BY_TAC);
			// remettre les autres labels aux valeurs par défaut

			// et modifier l'apparence des boutons
			
		}
	}


	/**
	 * @see tpaoc.controller.IController#increaseTimeByMeasure()
	 */
	public final void increaseTimeByMeasure() {

		if ( engine.getNbTimeByM() < Constants.MAX_TEMPO_BY_TAC) {

			engine.setNbTimeByM(engine.getNbTimeByM() + 1);

			final int period = engine.calculatePeriod();

			//  changer le texte du label des mesures
			// et celui de la période
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

			final int period = engine.calculatePeriod();	

			//  changer le texte du label des mesures
			// et celui de la période
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
