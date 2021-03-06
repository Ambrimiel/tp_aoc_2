package tpaoc.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import tpaoc.commands.ICommand;
import tpaoc.controller.IController;

/**
 * @author <i> Olivier GUILLOU and Jeanne RAULT</i>
 * <h1> TP_AOC Metronome V1.2 </h1> 
 * <p><i>Class: Engine</i> 
 * Implementation of IEngine. </p>
 */

public class Engine extends Observable implements IEngine {

	// ========================================================
	// Properties
	// ========================================================

	/**
	 * Maps for the commands.
	 */
	private transient Map<String, ICommand> commands;

	/**
	 * The clock Manage the time. (Ordonnanceur)
	 */
	private final transient IClock clock;

	/**
	 * The Controller.
	 */
	private final transient IController controller;

	/**
	 * Tempo.
	 */
	private Integer tempo;

	/**
	 * Number of times in a measure.
	 */
	private Integer nbTimeByM;

	/* STATES PROPERTIES */

	/**
	 * Engine is started.
	 */
	private boolean started;

	/**
	 * Says if tempo was changed.
	 */
	private boolean updatedTempo;

	/**
	 * Says if the number of time by measure was changed.
	 */
	private boolean updatedNbTimeByM;

	/**
	 * Says if started was changed.
	 */
	private boolean updatedStarted;

	/**
	 * The period.
	 */
	private transient int period;

	// ========================================================
	// Constructor
	// ========================================================

	/**
	 * Main constructor.
	 * @param pcontroller to set.
	 */
	public Engine(final IController pcontroller) {
		super();
		// Init commands.
		engineInitCommands();

		// Initial first running states
		started = false;
		updatedNbTimeByM = true;
		updatedStarted = true;
		updatedTempo = true;

		this.tempo = Constants.DEFAULT_TEMPO;
		this.nbTimeByM = Constants.DEF_TEMP_BY_TAC;

		clock = new Clock();

		// Getting the controller and adding it as the observer
		this.controller = pcontroller;
		addObserver(controller);

	}
	
	
	
	// ========================================================
	// Getters and Setters
	// ========================================================

	/**
	 * @see tpaoc.model.IEngine#setTempo(java.lang.Integer)
	 */
	public final void setTempo(final Integer pTempo) {
		this.tempo = pTempo;
		
		// Setting updated to false so the controller will know.
		updatedTempo = false;

		// Notify the controller, which will update.
		setChanged();
		notifyObservers();
	}

	
	/**
	 * @see tpaoc.model.IEngine#setNbTimeByM(java.lang.Integer)
	 */
	public final void setNbTimeByM(final Integer timeByM) {
		this.nbTimeByM = timeByM;
		// setting updated to false so the controller will know
		updatedNbTimeByM = false;

		// notify the controller, which will update
		setChanged();
		notifyObservers();
	}

	
	/**
	 * @see tpaoc.model.IEngine#setStarted(boolean)
	 */
	public void setStarted(final boolean pStarted) {
		this.started = pStarted;
		
		// setting updated to false so the controller will know
		updatedStarted = false;

		// notify the controller, which will update
		setChanged();
		notifyObservers();
	}
	
	
	/**
	 * @see tpaoc.model.IEngine#isUpdatedTempo()
	 */
	public final boolean isUpdatedTempo() {
		return updatedTempo;
	}
	
	
	/**
	 * @see tpaoc.model.IEngine#isUpdatedNbTimeByM()
	 */
	public final boolean isUpdatedNbTimeByM() {
		return updatedNbTimeByM;
	}
	
	
	/**
	 * @see tpaoc.model.IEngine#isUpdatedStarted()
	 */
	public final boolean isUpdatedStarted() {
		return updatedStarted;
	}
	
	
	/**
	 * @see tpaoc.model.IEngine#setUpdatedTempo(boolean)
	 */
	public final void setUpdatedTempo(boolean updatedTempo) {
		this.updatedTempo = updatedTempo;
	}
	
	
	/**
	 * @see tpaoc.model.IEngine#setUpdatedNbTimeByM(boolean)
	 */
	public final void setUpdatedNbTimeByM(boolean updatedNbTimeByM) {
		this.updatedNbTimeByM = updatedNbTimeByM;
	}
	
	
	/**
	 * @see tpaoc.model.IEngine#setUpdatedStarted(boolean)
	 */
	public final void setUpdatedStarted(boolean updatedStarted) {
		this.updatedStarted = updatedStarted;
	}
	
	
	/**
	 * @see tpaoc.model.IEngine#getTempo()
	 */
	public final Integer getTempo() {
		return tempo;
	}
	
	/**
	 * @see tpaoc.model.IEngine#getNbTimeByM()
	 */
	public final Integer getNbTimeByM() {
		return nbTimeByM;
	}
	
	
	/**
	 * @see tpaoc.model.IEngine#isStarted()
	 */
	public final boolean isStarted() {
		return started;
	}
	
	
	/**
	 * @return commands 
	 */
	public Map<String, ICommand> getCommands() {
		return commands;
	}
	
	
	/**
	 * @param commands
	 */
	public void setCommands(Map<String, ICommand> commands) {
		this.commands = commands;
	}


	@Override
	public int getPeriod() {
		return this.period;
	}
	

	// ========================================================
	// Methods
	// ========================================================
	
	/**
	 * @see tpaoc.model.IEngine#beginTicTac()
	 */
	public final void beginTicTac() {
		clock.periodicActivate(getCommands().get("Tic"), period);
		clock.periodicActivate(getCommands().get("Tac"), period * nbTimeByM);
	}

	
	/**
	 * @see tpaoc.model.IEngine#stopTicTac()
	 */
	public final void stopTicTac() {
		clock.activateAfterWait(getCommands().get("Stop"), Constants.DELAY_AFTER_WAIT);
	}
	

	/**
	 * @see tpaoc.model.IEngine#updateTicTac()
	 */
	public final void updateTicTac() {
		clock.activateAfterWait(getCommands().get("UpdateTicTac"), Constants.DELAY_AFTER_WAIT);
	}

	
	/**
	 * @see tpaoc.model.IEngine#calculatePeriod()
	 */
	public int calculatePeriod() {
		if (tempo < Constants.MIN_TEMPO) { tempo = Constants.MIN_TEMPO; }
		
		if (tempo > Constants.MAX_TEMPO) { tempo = Constants.MAX_TEMPO; }
		
		this.period = ((nbTimeByM*10000) / tempo);
		return period;
	}

	
	
	
	// ========================================================
	// Private methods
	// ========================================================

	/**
	 * Will be called by the anonymous Tic command, which is called by the
	 * clock.
	 */
	private void tic() {
		controller.markTempo();
	}

	/**
	 * Will be called by the anonymous Tac command, which is called by the
	 * clock.
	 */
	private void tac() {
		controller.markMeasure();
	}

	/**
	 * Init commands for Engine
	 */
	private void engineInitCommands() {
		setCommands(new HashMap<String, ICommand>());

		// Setting the command to mark the time
		getCommands().put("Tic", () -> tic());
		// Setting the command to mark the measure
		getCommands().put("Tac", () -> tac());

		// Setting the command to update tic tac if tempo
		// or nb of times by measures has changed
		getCommands().put("UpdateTicTac", () -> {
			clock.desactivate(getCommands().get("tac"));
			clock.desactivate(getCommands().get("tac"));
			beginTicTac();
		});

		getCommands().put("Stop", () -> {
			clock.desactivate(getCommands().get("tac"));
			clock.desactivate(getCommands().get("tac"));
		});
	}
	
}
