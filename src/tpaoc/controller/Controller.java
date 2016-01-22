package tpaoc.controller;

import java.util.Observable;

import tpaoc.model.Clock;
import tpaoc.model.Constants;
import tpaoc.model.Engine;
import tpaoc.model.IClock;
import tpaoc.model.IEngine;
import tpaoc.view.IThumbWheel;
import tpaoc.view.IView;
import tpaoc.view.SoundEmettor;


/**
 * @author <i> Olivier GUILLOU and Jeanne RAULT</i>
 * <h1> TP_AOC Metronome V1.2 </h1>
 * Controller class
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

	/**
	 * The View
	 */
	private final transient IView view;

	/*
	 * =======================================================================
	 * Constructor(s) for this class
	 * =======================================================================
	 */

	/**
	 * Main constructor.
	 * @param guiView.
	 */
	public Controller(IView view) {
		engine = new Engine(this);
		clock = new Clock();
		soundEmettor =  new SoundEmettor();
		this.view = view;
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
		clock.activateAfterWait(() -> view.flash(1),
				Constants.FLASH_TIME);
		clock.activateAfterWait(() -> soundEmettor.makeSound(),
				Constants.FLASH_TIME);
	}

	/**
	 * @see tpaoc.controller.IController#markMeasure()
	 */
	public final void markMeasure() {
		clock.activateAfterWait(() -> view.flash(2),
				Constants.FLASH_TIME);
	}


	/* (non-Javadoc)
	 * @see tpaoc.controller.IController#updateThumbWheel(tpaoc.view.IThumbWheel)
	 */
	public void updateThumbWheel(IThumbWheel thumbWheel){
		float position = thumbWheel.getPosition();
		engine.setTempo(Math.round(position));
	}



	/**
	 * @see tpaoc.controller.IController#startEngine()
	 */
	public final void startEngine() {
		if (!engine.isStarted()) {
			engine.calculatePeriod();
			engine.setStarted(true);
		}
	}

	/**
	 * @see tpaoc.controller.IController#stopEngine()
	 */
	public final void stopEngine() {
		if (engine.isStarted()) {
			engine.setStarted(false);
			engine.setTempo(Constants.DEFAULT_TEMPO);
			engine.setNbTimeByM(Constants.DEF_TEMP_BY_TAC);
		}
	}


	/**
	 * @see tpaoc.controller.IController#increaseTimeByMeasure()
	 */
	public final void increaseTimeByMeasure() {
		if(engine.getNbTimeByM() < Constants.MAX_TEMPO_BY_TAC)
			engine.setNbTimeByM(engine.getNbTimeByM() + 1);
		else
			engine.setNbTimeByM(Constants.MAX_TEMPO_BY_TAC);
	}

	/**
	 * @see tpaoc.controller.IController#decreaseTimeByMeasure()
	 */
	public final void decreaseTimeByMeasure() {
		int currentNb = engine.getNbTimeByM();
		if (currentNb > Constants.MIN_TEMPO) {
			currentNb--;
			engine.setNbTimeByM(currentNb);
		}else{
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
				engine.calculatePeriod();
				view.updateLabelTempo(engine.getTempo());
				engine.setUpdatedTempo(true);
			}
		}
		
		// Time by measure
		if (!engine.isUpdatedNbTimeByM()) {
			// update of the tic tac in the engine
			if (engine.isStarted()) 
				engine.updateTicTac();
			engine.setUpdatedNbTimeByM(true);
		}
		
		// Started
		if (!engine.isUpdatedStarted()) {
			if (engine.isStarted())
				engine.beginTicTac();
			else
				engine.stopTicTac();
			engine.setUpdatedStarted(true);
		}
	}
}
