package view;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

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
	public ArrayList<KeyEvent> keys = new ArrayList<KeyEvent>();

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) throws HeadlessException {
		this.viewFrame = new ViewFrame(model, this);
		SwingUtilities.invokeLater(this);
		this.viewFrame.setVisible(true);
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
		case MENU_OPTIONS:
		case MENU:
			return keyCodeToControllerOrderMenu(keyCode);
		default:
			return keyCodeToControllerOrderNULL(keyCode);
		}
	}
	private static ControllerOrder keyCodeToControllerOrderMenu(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_Z:
		case KeyEvent.VK_UP:
			return ControllerOrder.UP;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			return ControllerOrder.DOWN;
		case KeyEvent.VK_ENTER:
		case KeyEvent.VK_SPACE:
			return ControllerOrder.SPACE;
		case KeyEvent.VK_BACK_SPACE:
		case KeyEvent.VK_ESCAPE:
			return ControllerOrder.RETURN;
		default:
			return ControllerOrder.NULL;
		}
	}
	private static ControllerOrder keyCodeToControllerOrderNULL(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_BACK_SPACE:
		case KeyEvent.VK_ESCAPE:
			return ControllerOrder.RETURN;
		default:
			return ControllerOrder.NULL;
		}
	}
	protected static ControllerOrder keyCodeToControllerOrderGame(final int keyCode) {
		return ControllerOrder.NULL;
	}
	
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}
	private Date ts = new Date();
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		if((this.viewFrame.getViewPanel().getState() == States.GAME)
				&& (this.viewFrame.getController()!=null)
				&& (new Date().getTime()-ts.getTime())>100){
			boolean up = false;
			boolean down = false;
			boolean left = false;
			boolean right = false;
			boolean fb = false;
			boolean r_return = false;
			for(Iterator<KeyEvent> i = this.keys.iterator(); i.hasNext();){
				int keyCode = i.next().getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_Z:
				case KeyEvent.VK_UP:
					up = true;
				case KeyEvent.VK_S:
				case KeyEvent.VK_DOWN:
					down = true;
					break;
				case KeyEvent.VK_Q:
				case KeyEvent.VK_LEFT:
					left = true;
					break;
				case KeyEvent.VK_D:
				case KeyEvent.VK_RIGHT:
					right = true;
					break;
				case KeyEvent.VK_SPACE:
					fb = true;
					break;
				case KeyEvent.VK_BACK_SPACE:
				case KeyEvent.VK_ESCAPE:
					r_return = true;
					break;
				default:
					break;
				}
			}
			if(up && left){
				this.viewFrame.getController().orderPerform(ControllerOrder.UP_LEFT);
			}else if(up && right){
				this.viewFrame.getController().orderPerform(ControllerOrder.UP_RIGHT);
			}else if(down && right){
				this.viewFrame.getController().orderPerform(ControllerOrder.DOWN_RIGHT);
			}else if(down && left){
				this.viewFrame.getController().orderPerform(ControllerOrder.DOWN_LEFT);
			}else if(left){
				this.viewFrame.getController().orderPerform(ControllerOrder.LEFT);
			}else if(right){
				this.viewFrame.getController().orderPerform(ControllerOrder.RIGHT);
			}else if(up){
				this.viewFrame.getController().orderPerform(ControllerOrder.UP);
			}else if(down){
				this.viewFrame.getController().orderPerform(ControllerOrder.DOWN);
			}
			if(fb){
				this.viewFrame.getController().orderPerform(ControllerOrder.RAINBOW_FIREBALL);
			}
			if(r_return){
				this.viewFrame.getController().orderPerform(ControllerOrder.RETURN);
			}
			keys.clear();
			this.viewFrame.getController().orderPerform(ControllerOrder.TICK);
			ts = new Date();
		}
		SwingUtilities.invokeLater(this);
		this.viewFrame.repaint();
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
