package tpaoc.view;

/**
 * 
 * <h1> Metronome AOC. </h1>
 * @author Guillou-Rault
 *
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

}
