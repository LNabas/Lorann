package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller implements IController {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMessage("Appuyer sur les touches 'E', 'F', 'D' ou 'I', pour afficher Hello world dans la langue d votre choix.");
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *          the new view
	 */
	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case UP:
				this.model.loadMessage("GB");
				break;
			case DOWN:
				this.model.loadMessage("FR");
				break;
			case LEFT:
				this.model.loadMessage("DE");
				break;
			case RIGHT:
				this.model.loadMessage("ID");
				break;
			case TICK:
				this.model.loadMessage("ID");
				break;
			case RAINBOW_FIREBALL:
				this.model.loadMessage("ID");
				break;
			default:
				break;
		}
	}
	
	public void checkCase(final ControllerOrder controllerOrder){
		switch(controllerOrder){
		case UP:
			model.Player.get
			break;
		case DOWN:
			this.model.loadMessage("FR");
			break;
		case LEFT:
			this.model.loadMessage("DE");
			break;
		case RIGHT:
			this.model.loadMessage("ID");
			break;
		case TICK:
			this.model.loadMessage("ID");
			break;
		case RAINBOW_FIREBALL:
			this.model.loadMessage("ID");
			break;
		default:
			break;
	}
		
}
}
