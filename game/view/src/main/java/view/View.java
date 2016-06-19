package view;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.SwingUtilities;
import contract.ControllerOrder;
import contract.IController;
import contract.IEntity;
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
	//public ArrayList<KeyEvent> keys = new ArrayList<KeyEvent>();
	public boolean keys[] = new boolean[255];
	public boolean keys_used[] = new boolean[255];
	public boolean keys_released[] = new boolean[255];
	private IModel model;
	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) throws HeadlessException {
		this.model=model;
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
			IEntity entity = model.getMap().getPlayer();
			if(entity.has_died()){
				entity.updated_died_status();
				if(entity.isAlive()){
					model.Mappy();
					entity.GainFB();
				}else{
					model.getMap().getPlayer().setLive(11);
					setState(States.MENU);
					entity.GainFB();
				}
			}
			boolean up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_Z];
			boolean down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
			boolean left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_Q];
			boolean right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
			boolean fb = keys[KeyEvent.VK_SPACE];
			boolean r_return = keys[KeyEvent.VK_BACK_SPACE] || keys[KeyEvent.VK_ESCAPE];
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
			for(int i = 0; i<keys.length; i++){
				keys_used[i]=true;
				if(keys_released[i]){
					keys[i]=false;
				}
			}
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
