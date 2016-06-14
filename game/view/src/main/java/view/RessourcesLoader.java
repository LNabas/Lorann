package view;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RessourcesLoader {
	private Map<String, Sprite> sprites;
	private Map<String, CFont> fonts;
	public RessourcesLoader() throws IOException, FontFormatException{
		sprites = new HashMap<String, Sprite>();
		fonts = new HashMap<String, CFont>();
		loadFont("StraightToHellBB");
		loadSprite("LockedButton");
		loadSprite("NormalButton");
		loadSprite("ClickedButton");
	}
	public BufferedImage getSprite(String name){
		return sprites.get(name).getImage();
	}
	public Font getFont(String name){
		return fonts.get(name).getFont();
	}
	public Font getFont(String name, int size){
		return fonts.get(name).getFont().deriveFont((float)size);
	}
	public void loadSprite(String s) throws IOException{
		sprites.put(s, new Sprite(s));
	}
	public void loadFont(String s) throws IOException, FontFormatException{
		fonts.put(s, new CFont(s));
	}
}
