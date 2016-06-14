package view;

import java.awt.Image;

public class Menu extends GraphicsBuilder{
	public Menu(RessourcesLoader r) {
		super(r);
	}
	public Image getImage(){
		Button b = new Button(ressources).setText("test");
		setSize(500,500);
		//
		drawImage(b.getImage(), 0, 0);
		//
		return bufferImage;
	}
}
