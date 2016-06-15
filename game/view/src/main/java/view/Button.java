package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;

import contract.ButtonState;

/**
 * Awesome Button !
 * @author Doc0160
 *
 */
public class Button extends GraphicsBuilder{
	private String text = "";
	private ButtonState state = ButtonState.NORMAL;
	/**
	 * set state
	 * @param s ButtonState
	 * @return
	 */
	public Button setState(ButtonState s){
		state = s;
		return this;
	}
	/**
	 * Constructor
	 * @param r RessourcesLoader
	 */
	public Button(RessourcesLoader r){
		super(r);
	}
	public Image getImage() {
		BufferedImage b = ressources.getSprite("LockedButton");
		Color c = ressources.getColor("Metal");
		switch(state){
		case LOCKED:
			b = ressources.getSprite("LockedButton");
			c = ressources.getColor("DarkMetal");
			break;
		case NORMAL:
			b = ressources.getSprite("NormalButton");
			c = ressources.getColor("Metal");
			break;
		case CLICKED:
			b = ressources.getSprite("ClickedButton");
			c = ressources.getColor("Gold");
			break;
		default:
			break;
		}
		setSize(b.getWidth(), b.getHeight());
		drawImage(b, 0, 0);
		//
		graphics.setColor(c);
		int button_width = getWidth();
		int button_height = getHeight();
		Font font = ressources.getFont("GROBOLD", 70);
		drawCenteredString(text, button_width/2, button_height/2, font);
		//
		return bufferImage;
	}
	public Button setText(String t){
		text=t;
		return this;
	}
	public int getWidth(){
		return bufferImage.getWidth();
	}
	public int getHeight(){
		return bufferImage.getHeight();
	}
	
}
