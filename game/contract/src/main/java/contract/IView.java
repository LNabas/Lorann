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
	void setState(States s);
	States getState();
	IMenu getMenu();
}
