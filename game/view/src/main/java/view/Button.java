package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * @author Doc0160
 *
 */
public class Button extends GraphicsBuilder{
	private String text = "";
	private Color color = new Color(0,0,0);
	private ButtonState state = ButtonState.NORMAL;
	public Button setState(ButtonState s){
		state = s;
		return this;
	}
	public Button(RessourcesLoader r){
		super(r);
		this.color = ressources.getColor("Gold");
	}
	public Image getImage() {
		BufferedImage b = ressources.getSprite("LockedButton");
		switch(state){
		case LOCKED:
			b = ressources.getSprite("LockedButton");
			break;
		case NORMAL:
			b = ressources.getSprite("NormalButton");
			break;
		case CLICKED:
			b = ressources.getSprite("ClickedButton");
			break;
		default:
			break;
		}
		setSize(b.getWidth(), b.getHeight());
		drawImage(b, 0, 0);
		//
		graphics.setColor(color);
		int button_width = getWidth();
		int button_height = getHeight();
		Font font = ressources.getFont("StraightToHellBB", 100);
		drawCenteredString(text, button_width/2, button_height/2, font);
		//
		return bufferImage;
	}
	public Button setColor(Color c){
		color = c;
		return this;
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
enum ButtonState{
	NORMAL,
	LOCKED,
	CLICKED,
};