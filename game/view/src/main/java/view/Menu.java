package view;

import java.awt.Image;
import java.util.ArrayList;

public class Menu extends GraphicsBuilder{
	private ArrayList<Button> buttons;
	public Menu(RessourcesLoader r) {
		super(r);
		buttons = new ArrayList<Button>();
	}
	public Image getImage(){
		setSize(500,600);
		//
		int offset_x = 0;
		for(Button v : buttons){
			drawImage(v.getImage(), 0, offset_x);
			offset_x += v.getHeight();
		}
		//
		return bufferImage;
	}
	public Menu addButton(Button b){
		buttons.add(b);
		return this;
	}
}
