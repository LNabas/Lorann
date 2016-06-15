package view;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class Tile extends GraphicsBuilder{

	public Tile(RessourcesLoader r) {
		super(r);
	}
	
	public Image getImage() {
		BufferedImage sol = ressources.getSprite("Sol");
		setSize(sol.getWidth(), sol.getHeight());
		drawImage(sol, 0, 0);
		return bufferImage;
	}

}
