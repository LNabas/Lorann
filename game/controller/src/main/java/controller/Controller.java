package controller;

import contract.ButtonState;
import contract.ControllerOrder;
import contract.IController;
import contract.IEntity;
import contract.IModel;
import contract.IView;
import contract.States;
import contract.TypeEntity;
import contract.VisualEntity;

/**
 * The Class Controller.
 * @author Romain, Lucas.
 */
public class Controller implements IController {
	/**
	 * @uml.property  name="turn"
	 */
	private int turn = 0;
	/**
	 * The view.
	 * @uml.property  name="view"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private IView		view;
	/**
	 * The model.
	 * @uml.property  name="model"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private IModel	model;
	/**
	 * @uml.property  name="posMenu"
	 */
	private int posMenu = 0;
	/**
	 * @uml.property  name="posMenuOpt"
	 */
	private int posMenuOpt = 0;
	/**
	 * @uml.property  name="xFireBall"
	 */
	private int xFireBall = 0;
	/**
	 * @uml.property  name="yFireBall"
	 */
	private int yFireBall = 0;
	/**
	 * Instantiates a new controller.
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
	 * @param view  the new view
	 * @uml.property  name="view"
	 */
	private void setView(final IView view) {
		this.view = view;
	}
	/**
	 * Sets the model.
	 * @param model  the new model
	 * @uml.property  name="model"
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
				model.Mappy();
				view.setState(States.GAME);
				break;
			case 1:
				view.setState(States.MENU_OPTIONS);
				view.getMenu().changeButtonState(this.posMenuOpt, ButtonState.CLICKED);
				return;
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
		IEntity p;
		switch (controllerOrder) {
		case UP:
			xFireBall = 0;
			yFireBall = 1;
			checkCasePlayer(model.getPlayer(), 0, -1);
			break;
		case UP_LEFT:
			xFireBall = 1;
			yFireBall = 1;
			checkCasePlayer(model.getPlayer(), -1, -1);
			break;
		case UP_RIGHT:
			xFireBall = -1;
			yFireBall = 1;
			checkCasePlayer(model.getPlayer(), 1, -1);
			break;
		case DOWN:
			xFireBall = 0;
			yFireBall = -1;
			checkCasePlayer(model.getPlayer(), 0, 1);
			break;
		case DOWN_LEFT:
			xFireBall = 1;
			yFireBall = -1;
			checkCasePlayer(model.getPlayer(), -1, 1);
			break;
		case DOWN_RIGHT:
			xFireBall = -1;
			yFireBall = -1;
			checkCasePlayer(model.getPlayer(), 1, 1);
			break;
		case LEFT:
			xFireBall = 1;
			yFireBall = 0;
			checkCasePlayer(model.getPlayer(), -1, 0);
			break;
		case RIGHT:
			xFireBall = -1;
			yFireBall = 0;
			checkCasePlayer(model.getPlayer(), 1, 0);
			break;
		case TICK:
			for(int x = 0; x<model.getMap().getWidth();x++){
				for(int y = 0; y<model.getMap().getHeight();y++){
					if(model.getMap().get(x, y) != null){
						model.getMap().get(x, y).set_turn(turn);
						model.getMap().get(x, y).move(model.getMap(), x, y);
					}
				}
			}
			turn++;
			break;
		case RAINBOW_FIREBALL:
			p = model.getMap().getPlayer();
			if (p.hasFB() && (model.getMap().get(p.getX() + xFireBall, p.getY() + yFireBall) == null)){ 
				p.LooseFB();
				model.getMap().addFireball(p.getX() + xFireBall, p.getY() + yFireBall, xFireBall, yFireBall);
			}
			break;
		case RETURN:
			view.setState(States.MENU);
			model.resetLevel();
			model.resetLives();
			view.resetKeys();
			view.getMenu().changeButtonState(posMenu+1, ButtonState.CLICKED);
			return;
		default:
			break;
		}
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
			view.getMenu().changeButtonState(posMenu+1, ButtonState.CLICKED);
			break;
		case RETURN:
			view.setState(States.MENU);
			view.getMenu().changeButtonState(posMenu+1, ButtonState.CLICKED);
			return;
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
	 * @param controllerOrder of type ControllerOrder.
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
		default:
			break;
		}
		model.ForceRedraw();
	}
	/** Check the position of the player on the map.
	 * @param entity type IEntity
	 * @param offset_x type int
	 * @param offset_y type int
	 */
	public void checkCasePlayer(IEntity entity, int offset_x, int offset_y){
		int posx = entity.getX();
		int posy = entity.getY();
		IEntity target_entity =  model.getMap().get(posx+offset_x, posy+offset_y);
		if(target_entity != null && entity!=null){
			switch(target_entity.getPermeability()){
			case PERMEABLE:
				switch(target_entity.getType()){
				case RFB:
					entity.GainFB();
					break;
				case KEY:
					model.getMap().OpenDoor();
					break;
				case ITEMGOOD:
					model.AddScore();
					break;
				default:
					break;
				}
				model.getMap().move(posx, posy, posx+offset_x, posy+offset_y);
				break;
			case IMPERMEABLE:
				if(target_entity.getType()==TypeEntity.DOOROPEN){
					if(model.MaxMap()>model.CurrentMap()){
						model.LoadNextMap();
					}else{
						view.printMessage("You won with "+Integer.toString(model.getScore())+" points!");
						model.resetLevel();
						model.resetLives();
						view.setState(States.MENU);
					}
				}
				if(target_entity.hit()){
					entity.die(model.getMap());
					model.ResetScore();
				}
				break;
			default:
				break;
			}
		}else if(entity!=null){
			if((offset_y==1)&&(offset_x==1)){
				entity.setSprite(VisualEntity.PLAYER_DR);
			}else if((offset_y==1)&&(offset_x==-1)){
				entity.setSprite(VisualEntity.PLAYER_DL);
			}else if((offset_y==-1)&&(offset_x==1)){
				entity.setSprite(VisualEntity.PLAYER_UR);
			}else if((offset_y==-1)&&(offset_x==-1)){
				entity.setSprite(VisualEntity.PLAYER_UL);
			}else if(offset_y==-1){
				entity.setSprite(VisualEntity.PLAYER_U);
			}else if(offset_y==1){
				entity.setSprite(VisualEntity.PLAYER_D);
			}else if(offset_x==1){
				entity.setSprite(VisualEntity.PLAYER_R);
			}else if(offset_x==-1){
				entity.setSprite(VisualEntity.PLAYER_L);
			}
			model.getMap().move(posx, posy, posx+offset_x, posy+offset_y);
		}
		
	}
}
