package view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Random;

public class Map extends GraphicsBuilder{
	private HashMap<String, Image> imgs = new HashMap<String, Image>();
	public Map(RessourcesLoader r) {
		super(r);
	}
	public Image getImage() {
		BufferedImage sol = ressources.getSprite("Sol");
		BufferedImage paul = ressources.getSpriteCopy("Sol");
		paul.getGraphics().drawImage(ressources.getSprite("Paul"), 0, 0, null);
		BufferedImage dc = ressources.getSpriteCopy("Sol");
		dc.getGraphics().drawImage(ressources.getSprite("DC"), 0, 0, null);
		BufferedImage don = ressources.getSpriteCopy("Sol");
		don.getGraphics().drawImage(ressources.getSprite("DO"), 0, 0, null);
		int max = 10;
		Random randomGenerator = new Random();
		setSize(paul.getWidth()*max, paul.getHeight()*max);
		for(int x = 0; x<max; x++){
			for(int y = 0; y<max; y++){
				int r = randomGenerator.nextInt(3);
				switch(r){
				case 0:
				drawImage(paul, x*paul.getWidth(), y*paul.getHeight());
				/*case 1:
				drawImage(dc, x*dc.getWidth(), y*dc.getHeight());*/
				default:
				drawImage(sol, x*sol.getWidth(), y*sol.getHeight());
				}
			}
		}
		return bufferImage;
	}
}
