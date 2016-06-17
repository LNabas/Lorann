package view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import contract.IMap;
import contract.VisualEntity;
/**
 * Graphical Map
 * @author Doc0160
 *
 */
public class Map extends GraphicsBuilder{
	private IMap map;
	public Map(RessourcesLoader r, IMap map) {
		super(r);
		this.map = map;
	}
	public Image getImage() {
		BufferedImage sol = ressources.getSpriteCopy("Sol");
		BufferedImage paul = ressources.getSpriteCopy("Sol");
		paul.getGraphics().drawImage(ressources.getSprite("Paul"), 0, 0, null);
		BufferedImage dc = ressources.getSpriteCopy("Sol");
		dc.getGraphics().drawImage(ressources.getSprite("DC"), 0, 0, null);
		BufferedImage don = ressources.getSpriteCopy("Sol");
		don.getGraphics().drawImage(ressources.getSprite("DO"), 0, 0, null);
		BufferedImage henry = ressources.getSpriteCopy("Sol");
		henry.getGraphics().drawImage(ressources.getSprite("Henry"), 0, 0, null);
		BufferedImage pierre = ressources.getSpriteCopy("Sol");
		pierre.getGraphics().drawImage(ressources.getSprite("Pierre"), 0, 0, null);
		BufferedImage purse = ressources.getSpriteCopy("Sol");
		purse.getGraphics().drawImage(ressources.getSprite("Purse"), 0, 0, null);
		if(map==null){
			System.exit(0);
		}
		setSize(paul.getWidth()*map.getWidth(), paul.getHeight()*map.getHeight());
		for(int i = 0; i < map.getWidth(); i++){
			for(int j = 0; j < map.getHeight(); j++){
				VisualEntity t = map.get(i, j).getVisualType();
				switch(t){
				case PAUL:
					drawImage(paul, i*paul.getWidth(), j*paul.getHeight());
					break;
				case PLAYER:
					drawImage(henry, i*henry.getWidth(), j*henry.getHeight());
					break;
				case KEY:
					drawImage(purse, i*purse.getWidth(), j*purse.getHeight());
					break;
				default:
					drawImage(sol, i*sol.getWidth(), j*sol.getHeight());
					break;
				}
			}
		}
		return bufferImage;
	}
}
