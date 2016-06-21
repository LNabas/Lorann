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
	/**
	 * The frame.
	 */
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
	private Date ts_player = new Date();
	private Date ts_game = new Date();
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		if(this.viewFrame.getViewPanel().getState() == States.GAME && this.viewFrame.getController()!=null){
			if((this.viewFrame.getController()!=null)
					&& ((new Date().getTime()-ts_game.getTime())>(400/model.Difficulty()))){
				this.viewFrame.getController().orderPerform(ControllerOrder.TICK);
				/*for(int i = 0; i<keys.length; i++){
					keys_used[i]=true;
					keys_released[i]=true;
					keys[i]=false;
				}*/
				ts_game = new Date();
			}
			if((new Date().getTime()-ts_player.getTime())>100){
				IEntity entity = model.getMap().getPlayer();
				if(entity.has_died()){
					model.removeLife();
					entity.updated_died_status();
					if(model.getLives()>0){
						model.Mappy();
						entity.GainFB();
					}else{
						this.printMessage("You loose !");
						model.resetLevel();
						model.resetLives();
						setState(States.MENU);
						entity.GainFB();
					}
				}
				boolean up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_Z] || keys[KeyEvent.VK_A] || keys[KeyEvent.VK_E];
				boolean down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S] || keys[KeyEvent.VK_W] || keys[KeyEvent.VK_X];
				boolean left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_Q] || keys[KeyEvent.VK_A] || keys[KeyEvent.VK_W];
				boolean right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D] || keys[KeyEvent.VK_E] || keys[KeyEvent.VK_X];
				boolean fb = keys[KeyEvent.VK_SPACE];
				boolean r_return = keys[KeyEvent.VK_BACK_SPACE] || keys[KeyEvent.VK_ESCAPE];
				if(up && left){
					this.viewFrame.getController().orderPerform(ControllerOrder.UP_LEFT);
					this.viewFrame.setIconImage(this.viewFrame.getViewPanel().ressources.getSprite("LorannUL"));
				}else if(up && right){
					this.viewFrame.getController().orderPerform(ControllerOrder.UP_RIGHT);
					this.viewFrame.setIconImage(this.viewFrame.getViewPanel().ressources.getSprite("LorannUR"));
				}else if(down && right){
					this.viewFrame.getController().orderPerform(ControllerOrder.DOWN_RIGHT);
					this.viewFrame.setIconImage(this.viewFrame.getViewPanel().ressources.getSprite("LorannDR"));
				}else if(down && left){
					this.viewFrame.getController().orderPerform(ControllerOrder.DOWN_LEFT);
					this.viewFrame.setIconImage(this.viewFrame.getViewPanel().ressources.getSprite("LorannDL"));
				}else if(left){
					this.viewFrame.getController().orderPerform(ControllerOrder.LEFT);
					this.viewFrame.setIconImage(this.viewFrame.getViewPanel().ressources.getSprite("LorannL"));
				}else if(right){
					this.viewFrame.getController().orderPerform(ControllerOrder.RIGHT);
					this.viewFrame.setIconImage(this.viewFrame.getViewPanel().ressources.getSprite("LorannR"));
				}else if(up){
					this.viewFrame.getController().orderPerform(ControllerOrder.UP);
					this.viewFrame.setIconImage(this.viewFrame.getViewPanel().ressources.getSprite("LorannU"));
				}else if(down){
					this.viewFrame.getController().orderPerform(ControllerOrder.DOWN);
					this.viewFrame.setIconImage(this.viewFrame.getViewPanel().ressources.getSprite("LorannD"));
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
				ts_player = new Date();
			}
		}
		/*try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			//e.printStackTrace();
		}*/
		SwingUtilities.invokeLater(this);
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
	/**
	 * @return
	 * @uml.property  name="model"
	 */
	public IModel getModel() {
		return model;
	}
}
