package controller;

import contract.ButtonState;
import contract.ControllerOrder;
import contract.IController;
import contract.IEntity;
import contract.IModel;
import contract.IView;
import contract.Permeability;
import contract.States;
import contract.TypeEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 * @author Romain, Lucas.
 */
public class Controller implements IController {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;
	private int posMenu = 0;
	private int xFireBall = 0;
	private int yFireBall = 0;
	private boolean munFireBall = true;
	private int posMenuOpt = 0;
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
	
	private void orderPerformMenu(final ControllerOrder controllerOrder){
		System.out.println(controllerOrder);
		view.getMenu().changeButtonState(posMenu+1, ButtonState.NORMAL);
		switch(controllerOrder){
		case UP:
			posMenu--;
			break;
		case DOWN:
			posMenu++;
			break;
		case SPACE:
			switch(posMenu){
			case 0:
				view.setState(States.GAME);
				break;
			case 1:
				view.setState(States.MENU_OPTIONS);	
				break;
			case 2:
				System.exit(0);
			}
			break;
		default:
			break;
		}
		if(posMenu < 0){
			posMenu = 2;
		}
		else if(posMenu > 2){
			posMenu = 0;
		}
	
		
	view.getMenu().changeButtonState(posMenu+1, ButtonState.CLICKED);
	}
	
	/** To launch the rainbow fire ball. 
	 * @param controllerOrder : ControllerOrder
	 */
	private void orderPerformJeu(final ControllerOrder controllerOrder){
		switch(controllerOrder){
		case UP :
			xFireBall = 0;
			yFireBall = -1;
			break;
		case RIGHT:
			xFireBall = -1;
			yFireBall = 0;
			break;
		case LEFT:
			xFireBall = 1;
			yFireBall = 0;
		case DOWN:
			xFireBall = 0;
			yFireBall = 1;
			break;
		default:
			break;
	}
		switch (controllerOrder) {
			case UP:
				checkCasePlayer(model.getPlayer(), 0, -1);
				break;
			case DOWN:
				checkCasePlayer(model.getPlayer(), 0, 1);
				break;
			case LEFT:
				checkCasePlayer(model.getPlayer(), -1, 0);
				break;
			case RIGHT:
				checkCasePlayer(model.getPlayer(), 1, 0);
				break;
			case TICK:
				IEntity Player = this.model.getMap().getPlayer();
				IEntity Fireball = this.model.getMap().getFireBall();
				for(int x = 0; x<model.getMap().getWidth();x++)
				{
					for(int y = 0; y<model.getMap().getHeight();y++)
					{
						model.getMap().get(x, y).move(model.getMap(), x, y);//TODO modifier plus tard.
					}
					
				}
				break;
			case RAINBOW_FIREBALL:
				if (munFireBall){ 
				munFireBall = false ;
				checkCaseFireBall(model.getFireball(), xFireBall, yFireBall);
				}
				else{}
				break;
			case RETURN:
				view.setState(States.MENU);
				break;

			default:
				break;
		}
		model.ForceRedraw();
	}
	/** To use the Keyboard
	 * @param controllerOrder : ControllerOrder
	 */
	
	private void orderPerformOption(final ControllerOrder controllerOrder){
		view.getMenu().changeButtonState(posMenuOpt, ButtonState.NORMAL);
		switch(controllerOrder){
		case UP:
			posMenuOpt--;
			break;
		case DOWN:
			posMenuOpt++;
			break;
		case SPACE:
			model.setDifficulty(posMenuOpt);
			view.setState(States.MENU);
			break;
		case RETURN:
			view.setState(States.MENU);
			break;
		default:
			break;
		}
		if(posMenuOpt < 0){
			posMenuOpt = 3;
		}
		else if(posMenuOpt > 3){
			posMenuOpt = 0;
		}
		view.getMenu().changeButtonState(posMenuOpt, ButtonState.CLICKED);

	}
	/** To use the menu 
	 * @param ControllerOrder of type ControllerOrder.
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch(view.getState()){
		case MENU:
			orderPerformMenu(controllerOrder);
			break;
		case MENU_OPTIONS:
			orderPerformOption(controllerOrder);
			break;
		case MENU_QUIT:
			break;
		case GAME:
			orderPerformJeu(controllerOrder);
		}
	}
	/** Check the position of the player on the map.
	 * @param entity type IEntity
	 * @param offset_x type int
	 * @param offset_y type int
	 */
	
	public void checkCasePlayer(IEntity entity, int offset_x, int offset_y){
		int posx = model.getPlayer().getX();
		int posy = model.getPlayer().getY();
		IEntity target_entity =  model.getMap().get(posx+offset_x, posy+offset_y);
		Permeability permeability;
		if(target_entity != null){
			permeability = target_entity.getPermeability();
		}else{
			permeability = Permeability.PERMEABLE;
		}
		
		switch(permeability){
			case PERMEABLE:
				model.getMap().move(posx, posy, posx+offset_x, posy+offset_y);
				if(entity.getType()==TypeEntity.DOOROPEN){
					view.setState(States.MENU);
				}
				
				break;
			case IMPERMEABLE:
				if(target_entity.hit()){
					entity.die();
					if(entity.isAlive()){
						//Refresh
					}
					else{
						view.setState(States.MENU);
					}
				}
				break;
			default:
				break;
		}
		
	}
	/** Check the position of the FireBall on the map.
	 * @param entity : IEntity
	 * @param offset_x : int
	 * @param offset_y : int
	 */
	   public void checkCaseFireBall(IEntity entity, int offset_x, int offset_y){
		   int posx = model.getFireball().getX();
			int posy = model.getFireball().getY();
			IEntity target_entity =  model.getMap().get(posx+offset_x, posy+offset_y);
			Permeability permeability;
			if(target_entity != null){
				permeability = target_entity.getPermeability();
			}else{
				permeability = Permeability.PERMEABLE;
			}
			switch(permeability){
			case PERMEABLE:
				model.getMap().move(posx, posy, posx+offset_x, posy+offset_y);
				break;
			case IMPERMEABLE:
				if(target_entity.hit()){
					target_entity.die();
				}
				else{
					if (offset_x == 1 || offset_y == 1 || offset_x == -1 || offset_y == -1 ){
						offset_x *= -1;
						offset_y *= -1;
				}
				}
				break;
			default:
				break;
			}
	}
}
