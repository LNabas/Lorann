package view;

import java.awt.FontFormatException;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class ViewFrame.
 *
 * @author Doc0160
 */
class ViewFrame extends JFrame implements KeyListener {

	/**
	 * The model.
	 * @uml.property  name="model"
	 * @uml.associationEnd  
	 */
	private IModel						model;

	/**
	 * The controller.
	 * @uml.property  name="controller"
	 * @uml.associationEnd  
	 */
	private IController				controller;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -697358409737458175L;
	/**
	 * @uml.property  name="viewPanel"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="viewFrame:view.ViewPanel"
	 */
	private ViewPanel viewPanel;
	/**
	 * @uml.property  name="view"
	 * @uml.associationEnd  inverse="viewFrame:view.View"
	 */
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
	 * @uml.property  name="controller"
	 */
	protected void setController(final IController controller) {
		this.controller = controller;
	}

	/**
	 * Gets the model.
	 * @return  the model
	 * @uml.property  name="model"
	 */
	protected IModel getModel() {
		return this.model;
	}

	/**
	 * Sets the model.
	 * @param model  the new model
	 * @uml.property  name="model"
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
	 * @return
	 * @uml.property  name="viewPanel"
	 */
	public ViewPanel getViewPanel() {
		return this.viewPanel;
	}

	public IView getView() {
		return view;
	}
}
