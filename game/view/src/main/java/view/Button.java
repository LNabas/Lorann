package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Button extends GraphicsBuilder{
	private String text;
	private Color color;
	public Button(RessourcesLoader r){
		super(r);
		setColor(new Color(240,240,240)).setText("");
	}
	public Image getImage() {
		BufferedImage b = ressources.getSprite("NormalButton");
		setSize(b.getWidth(), b.getHeight());
		graphics.drawImage(b, 0, 0, null);
		//
		graphics.setColor(color);
		int button_height = b.getHeight();
		int button_width = b.getHeight();
		Font font = ressources.getFont("StraightToHellBB", 100);
		drawString(text, button_width/2, button_height/2, font);
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
	
}
