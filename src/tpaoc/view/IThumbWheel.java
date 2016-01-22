package tpaoc.view;

/**
 * @author <i> Olivier GUILLOU and Jeanne RAULT</i>
 * <h1> TP_AOC Metronome V1.2 </h1> 
 * <p><i>Interface: IThumbWheel</i> 
 * Interface of the ThumbWheel. </p>
 */
public interface IThumbWheel {
	
	/**
	 * Returns the current position of the ThumbWheel.
	 * @return float
	 */
	float getPosition();
	
	/**
	 * 
	 * @param position :
	 */
	void setPosition(float position);
	
	/**
	 * Returns the current position of the ThumbWheel.
	 * @return float
	 */
	void setPosition(int position);

}
