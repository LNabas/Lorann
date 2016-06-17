package view;

import java.awt.Image;
import view.RessourcesLoader;
/**
 * @author Maxence, Gregory
 */
public class Logo extends Button{
	public Logo(RessourcesLoader r){
		super(r);
	}
	public Image getImage() {
		setSize(ressources.getSprite("Logo").getWidth(), ressources.getSprite("Logo").getHeight());
		drawImage(ressources.getSprite("Logo"), 0, 0);
		return bufferImage;
	}
}
