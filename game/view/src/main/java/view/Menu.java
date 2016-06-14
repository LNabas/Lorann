package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Menu implements IGraphicsBuilder{
	SpritesLoader sprites;
	public Menu setSprites(SpritesLoader s){
		sprites = s;
		return this;
	}
	public Image paint(){
		BufferedImage bufferImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB); 
		Graphics g = bufferImage.getGraphics();
		//
		Font font = new Font("Consolas", Font.PLAIN, 100);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawImage(sprites.getSprite("LockedButton"), 0, 0, null);
		int button_height = sprites.getSprite("LockedButton").getHeight();
		int button_width = sprites.getSprite("LockedButton").getHeight();
		g.drawString("Yeah !!!", button_width/2, button_height/2);
		//
		return bufferImage;
	}
}
