package view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

import contract.IMap;
/**
 * Graphical Map
 * @author Doc0160
 *
 */
public class Map extends GraphicsBuilder{
	@SuppressWarnings("unused")
	private IMap map;
	public Map(RessourcesLoader r) {
		super(r);
	}
	public void setMap(IMap m){
		map = m;
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
		int max = 10;
		Random randomGenerator = new Random();
		setSize(paul.getWidth()*max, paul.getHeight()*max);
		for(int x = 0; x<max; x++){
			for(int y = 0; y<max; y++){
				int r = randomGenerator.nextInt(10);
				switch(r){
				case 0:
				drawImage(paul, x*paul.getWidth(), y*paul.getHeight());
				break;
				case 1:
				drawImage(dc, x*dc.getWidth(), y*dc.getHeight());
				break;
				case 2:
				drawImage(don, x*don.getWidth(), y*don.getHeight());
				break;
				case 3:
				drawImage(henry, x*henry.getWidth(), y*henry.getHeight());
				break;
				case 4:
				drawImage(pierre, x*pierre.getWidth(), y*pierre.getHeight());
				break;
				default:
				drawImage(sol, x*sol.getWidth(), y*sol.getHeight());
				break;
				}
			}
		}
		return bufferImage;
	}
}
