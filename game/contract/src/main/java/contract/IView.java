package contract;

/**
 * The Interface IView.
 * @author  Doc0160
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
	 * @param s  state
	 * @uml.property  name="state"
	 */
	void setState(States s);
	/**
	 * get state
	 * @return  States
	 * @uml.property  name="state"
	 * @uml.associationEnd  
	 */
	States getState();
	/**
	 * @uml.property  name="menu"
	 * @uml.associationEnd  
	 */
	IMenu getMenu();
	/**
	 * @uml.property  name="model"
	 * @uml.associationEnd  
	 */
	IModel getModel();
}
