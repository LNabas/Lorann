package view;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class Map extends GraphicsBuilder{

	public Map(RessourcesLoader r) {
		super(r);
	}
	public Image getImage() {
		BufferedImage sol = ressources.getSprite("Paul");
		int max = 10;
		setSize(sol.getWidth()*max, sol.getHeight()*max);
		for(int i = 0; i<max; i++){
			drawImage(sol, i*sol.getWidth(), i*sol.getHeight());
			drawImage(sol, (9-i)*sol.getWidth(), i*sol.getHeight());
		}
		return bufferImage;
	}
}
