package contract;

/**
 * The Interface IView.
 *
 * @author Doc0160
 */
public interface IView {

	/**
	 * Prints the message.
	 *
	 * @param message
	 *          the message
	 */
	void printMessage(final String message);
	/**
	 * set state
	 * @param s state
	 */
	void setState(States s);
	/**
	 * get state
	 * @return States
	 */
	States getState();
	IMenu getMenu();
	IModel getModel();
}
