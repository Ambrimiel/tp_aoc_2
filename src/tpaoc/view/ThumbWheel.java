package tpaoc.view;

/**
 * 
 * <h1> Metronome AOC. </h1>
 * @author Guillou-Rault
 *
 */
public class ThumbWheel implements IThumbWheel {

	/**
	 * Position of the ThumbWheel.
	 */
	private float position;
	
	/**
	 * @see tpaoc.view.IThumbWheel#setPosition(float)
	 */
	public void setPosition(final float pPosition) {
		position = pPosition;
	}

	/**
	 * @see tpaoc.view.IThumbWheel#getPosition()
	 */
	public float getPosition() {
		return position;
	}

}
