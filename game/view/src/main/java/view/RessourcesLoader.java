package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RessourcesLoader {
	private Map<String, Sprite> sprites = new HashMap<String, Sprite>();
	private Map<String, CFont> fonts = new HashMap<String, CFont>();
	private Map<String, Color> colors = new HashMap<String, Color>();
	private Map<String, URL> sounds = new HashMap<String, URL>();
	public RessourcesLoader() throws IOException, FontFormatException{
		loadColor("Gold", 255, 255, 0);
		loadColor("Black", 0, 0, 0);
		loadColor("White", 255, 255, 255);
		//
		loadFont("StraightToHellBB");
		//
		loadSound("BTTF", "Back to the Future Theme 8 Bit");
		loadSound("IndianaJones");
		//
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
	public void loadColor(String s, int r, int g, int b) throws IOException, FontFormatException{
		colors.put(s, new Color(r,g,b));
	}
	public Color getColor(String s){
		return colors.get(s);
	}
	public void loadSound(String s){
		loadSound(s, s);
	}
	public void loadSound(String name, String s){
		sounds.put(name, this.getClass().getClassLoader().getResource(s+".mp3"));
	}
	public URL getSound(String name){
		return sounds.get(name);
	}
}
