package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IEntity;
import contract.IModel;
import contract.IView;
import contract.Permeability;

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
	 * https://www.youtube.com/watch?v=FQiyOuqrk68
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case UP:
				checkCase(model.getPlayer(), 0, -1);
				break;
			case DOWN:
				checkCase(model.getPlayer(), 0, 1);
				break;
			case LEFT:
				checkCase(model.getPlayer(), 1, 0);
				break;
			case RIGHT:
				checkCase(model.getPlayer(), -1, 0);
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
	
	public void checkCase(IEntity entity, int offset_x, int offset_y){
		int posx = model.getPlayer().getX();
		int posy = model.getPlayer().getY();
		IEntity target_entity =  model.getMap().get(posx+offset_x, posy+offset_y);
		Permeability permeability = target_entity.getPermeability();
		
		switch(permeability){
			case PERMEABLE:
				model.getPlayer().setY(target_entity.getY());
				model.getPlayer().setX(target_entity.getX());
				break;
			case IMPERMEABLE:
				if(target_entity.hit()){
					entity.die();
				}
				break;
			default:
				break;
		}
		
	}
}
