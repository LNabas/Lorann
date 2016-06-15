package view;

import java.awt.FontFormatException;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IMenu;
import contract.IModel;
import contract.IView;
import contract.States;

/**
 * The Class View.
 *
 * @author Doc0160
 */
public class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 * @throws FontFormatException 
	 * @throws HeadlessException 
	 */
	public View(final IModel model) throws HeadlessException {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}
	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(States s, final int keyCode) {
		switch (s) {
		case GAME:
			return keyCodeToControllerOrderGame(keyCode);
		case MENU:
			return keyCodeToControllerOrderMenu(keyCode);
		default:
			return null;
		}
	}
	private static ControllerOrder keyCodeToControllerOrderMenu(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_UP:
			return ControllerOrder.UP;
		case KeyEvent.VK_DOWN:
			return ControllerOrder.DOWN;
		case KeyEvent.VK_SPACE:
			return ControllerOrder.RAINBOW_FIREBALL;
		default:
			return ControllerOrder.NULL;
		}
	}
	protected static ControllerOrder keyCodeToControllerOrderGame(final int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_UP:
			return ControllerOrder.UP;
		case KeyEvent.VK_DOWN:
			return ControllerOrder.DOWN;
		case KeyEvent.VK_LEFT:
			return ControllerOrder.LEFT;
		case KeyEvent.VK_RIGHT:
			return ControllerOrder.RIGHT;
		case KeyEvent.VK_SPACE:
			return ControllerOrder.RAINBOW_FIREBALL;
		default:
			return ControllerOrder.NULL;
		}
	}
	

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
	public States getState() {
		return this.viewFrame.getViewPanel().getState();
	}
	public void setState(States s){
		this.viewFrame.getViewPanel().setState(s);
	}
	public IMenu getMenu() {
		return viewFrame.getViewPanel().getMenu();
	}
}
