package view;

import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import jaco.mp3.player.MP3Player;
import contract.IController;
import contract.IEntity;
import contract.IMap;
import contract.IModel;
import contract.IView;
import contract.States;
import contract.TypeEntity;

/**
 * The Class ViewFrame.
 *
 * @author Doc0160
 */
class ViewFrame extends JFrame implements KeyListener {

	/**
	 * The model.
	 */
	private IModel						model;

	/**
	 * The controller.
	 */
	private IController				controller;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -697358409737458175L;
	private ViewPanel viewPanel;
	private View view;
	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @throws HeadlessException
	 *           the headless exception
	 * @throws FontFormatException 
	 */
	public ViewFrame(final IModel model, final View v) throws HeadlessException {
		this.buildViewFrame(model);
		view = v;
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param gc
	 *          the gc
	 * @throws FontFormatException 
	 */
	public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
		super(gc);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @throws HeadlessException
	 *           the headless exception
	 * @throws FontFormatException 
	 */
	public ViewFrame(final IModel model, final String title) throws HeadlessException {
		super(title);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @param gc
	 *          the gc
	 * @throws FontFormatException 
	 */
	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
		super(title, gc);
		this.buildViewFrame(model);
	}

	/**
	 * Gets the controller.
	 * @return  the controller
	 * @uml.property  name="controller"
	 */
	IController getController() {
		return this.controller;
	}

	/**
	 * Sets the controller.
	 * @param controller  the new controller
	 */
	protected void setController(final IController controller) {
		this.controller = controller;
	}

	/**
	 * Gets the model.
	 * @return  the model
	 */
	protected IModel getModel() {
		return this.model;
	}

	/**
	 * Sets the model.
	 * @param model  the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * Builds the view frame.
	 *
	 * @param model
	 *          the model
	 */
	private void buildViewFrame(final IModel model) {
		this.setModel(model);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(this);
		try {
			viewPanel = new ViewPanel(this);
			this.setIconImage(viewPanel.ressources.getSprite("Lorann"));
			this.setContentPane(viewPanel);
			this.setSize(400 + this.getInsets().left + this.getInsets().right, 
				400 + this.getInsets().top + this.getInsets().bottom);
			this.setLocationRelativeTo(null);
		} catch (IOException e) {
			this.printMessage("Can't load internal asset!");
			e.printStackTrace();
		} catch (FontFormatException e) {
			this.printMessage("Incorect font format!");
			e.printStackTrace();
		}
	}

	/**
	 * Prints the message.
	 *
	 * @param message
	 *          the message
	 */
	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
		for(int i = 0; i<this.view.keys.length; i++){
			this.view.keys_used[i]=true;
			if(this.view.keys_released[i]){
				this.view.keys[i]=false;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(final KeyEvent e) {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(final KeyEvent e) {
		view.keys_released[e.getKeyCode()]=false;
		view.keys[e.getKeyCode()]=true;
		view.keys_used[e.getKeyCode()]=false;
		switch(e.getKeyCode()){
		case 'M':
			this.viewPanel.music.skipForward();
			break;
		case 'L':
			this.viewPanel.music.skipBackward();
			break;
		case 'P':
			if(this.viewPanel.music.isPaused()){
				this.viewPanel.music.play();
			}else{
				this.viewPanel.music.pause();
			}
			break;
		case 'B':
			this.viewPanel.music.pause();
			Graphics g = viewPanel.getGraphics();
			IMap map = model.getMap();
			boolean found = false;
			IEntity Player;
			int x = 0;
			int y = 0;
			for(x = 0; x < map.getWidth() && !found; x++){
				for(y = 0; y < map.getHeight() && !found; y++){
					Player = map.get(x, y);
					if(Player!=null && Player.getType()==TypeEntity.PLAYER){
						found = true;
					}
				}
			}
			BufferedImage slorann = viewPanel.ressources.getSprite("SLORANN");
			BufferedImage kmhmh[] = {
					viewPanel.ressources.getSprite("KAMEHAMEHA1"),
					viewPanel.ressources.getSprite("KAMEHAMEHA2"),
					viewPanel.ressources.getSprite("KAMEHAMEHA3"),
					viewPanel.ressources.getSprite("KAMEHAMEHA4"),
			};
			int timing[]={
					900,
					1000,
					1000,
					1000,
			};
			MP3Player music = new MP3Player();
			music.addToPlayList(viewPanel.ressources.getSound("KMHMH"));
			music.play();
			g.drawImage(slorann, 
					viewPanel.margin_x+(int)((x-1)*slorann.getWidth()*viewPanel.s), viewPanel.margin_y+(int)((y-1)*slorann.getHeight()*viewPanel.s), 
					(int)(slorann.getWidth()*viewPanel.s), (int)(slorann.getHeight()*viewPanel.s), null);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {}
			for(int i = 0; i<kmhmh.length; i++){
				g.drawImage(kmhmh[i], 
						viewPanel.margin_x+(int)((x-1)*slorann.getWidth()*viewPanel.s)-(int)(kmhmh[i].getWidth()*viewPanel.s), viewPanel.margin_y+(int)((y-1)*slorann.getHeight()*viewPanel.s), 
						(int)(kmhmh[i].getWidth()*viewPanel.s), (int)(kmhmh[i].getHeight()*viewPanel.s), null);
				try {
					Thread.sleep(timing[i]);
				} catch (InterruptedException e1) {}
			}
			for(int i = x-2; i>0; i--){
				IEntity e2 = map.get(i, y-1);
				if(e2==null || (e2.getType()!=TypeEntity.KEY && e2.getType()!=TypeEntity.DOOROPEN && e2.getType()!=TypeEntity.DOORCLOSE))
					map.kill(i, y-1);
			}
			music.stop();
			this.viewPanel.music.play();
			break;
		default:
			this.getController().orderPerform(View.keyCodeToControllerOrder(this.viewPanel.getState(), e.getKeyCode()));
			break;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(final KeyEvent e) {
		view.keys_released[e.getKeyCode()]=true;
		if(view.keys_used[e.getKeyCode()]){
			view.keys[e.getKeyCode()]=false;
		}
	}
	/**
	 * @return view panel
	 */
	public ViewPanel getViewPanel() {
		return this.viewPanel;
	}
	public IView getView() {
		return view;
	}
}
