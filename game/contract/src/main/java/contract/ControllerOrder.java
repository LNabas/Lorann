package contract;

/**
 * The Enum ControllerOrder.
 *
 * @author Doc0160
 */
public enum ControllerOrder {
	/**
	 * Nothing to do
	 */
	NULL,
	/**
	 * player up
	 */
	UP,
	/**
	 * player down
	 */
	DOWN,
	/**
	 * player left
	 */
	LEFT,
	/**
	 * player right
	 */
	RIGHT,
	/**
	 * play shoots a rainbow fireball
	 */
	RAINBOW_FIREBALL,
	/**
	 * game tick
	 * emitted at regular interval
	 */
	TICK, 
	/**
	 * menu validation
	 */
	SPACE,
	/**
	 * return to previous menu
	 */
	RETURN,
	
}
