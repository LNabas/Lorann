package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
/**
 * Awesome RessourceLoader !!!
 * @author Doc0160
 */
public class RessourcesLoader {
	/**
	 * @uml.property  name="sprites"
	 * @uml.associationEnd  qualifier="name:java.lang.String view.Sprite"
	 */
	private Map<String, Sprite> sprites = new HashMap<String, Sprite>();
	/**
	 * @uml.property  name="fonts"
	 * @uml.associationEnd  qualifier="name:java.lang.String view.CFont"
	 */
	private Map<String, CFont> fonts = new HashMap<String, CFont>();
	/**
	 * @uml.property  name="colors"
	 * @uml.associationEnd  qualifier="s:java.lang.String java.awt.Color"
	 */
	private Map<String, Color> colors = new HashMap<String, Color>();
	/**
	 * @uml.property  name="sounds"
	 * @uml.associationEnd  qualifier="name:java.lang.String java.net.URL"
	 */
	private Map<String, URL> sounds = new HashMap<String, URL>();
	public RessourcesLoader(){
		loadColors();
		loadFonts();
		loadSounds();
		loadSprites();
	}
	public Map<String, URL> getSounds(){
		return sounds;
	}
	private void loadColors(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(this.getClass().getClassLoader().getResource("colors").getFile()));
		    for(String line; (line = br.readLine()) != null; ) {
		        String array[] = line.split(":");
		        colors.put(array[0], new Color(Integer.parseInt(array[1]),Integer.parseInt(array[2]),Integer.parseInt(array[3])));
		    }
		    br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void loadSounds(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(this.getClass().getClassLoader().getResource("sounds").getFile()));
		    for(String line; (line = br.readLine()) != null; ) {
		        String array[] = line.split(":");
		        sounds.put(array[0], this.getClass().getClassLoader().getResource(array[1]));
		    }
		    br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void loadSprites() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(this.getClass().getClassLoader().getResource("sprites").getFile()));
		    for(String line; (line = br.readLine()) != null; ) {
		        String array[] = line.split(":");
		        sprites.put(array[0], new Sprite(array[1]));
		    }
		    br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void loadFonts(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(this.getClass().getClassLoader().getResource("fonts").getFile()));
		    for(String line; (line = br.readLine()) != null; ) {
		        String array[] = line.split(":");
		        fonts.put(array[0], new CFont(array[1]));
		    }
		    br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		}
	}
	/**
	 * get a sprite
	 * @param name of the sprite
	 * @return BuffuredImage
	 */
	public BufferedImage getSprite(String name){
		return sprites.get(name).getImage();
	}
	public BufferedImage getSpriteCopy(String name){
		BufferedImage img = sprites.get(name).getImage();
		BufferedImage b = new BufferedImage(img.getWidth(),img.getHeight(),BufferedImage.TYPE_INT_ARGB);
		b.getGraphics().drawImage(img, 0, 0, null);
		return b;
	}
	/**
	 * get a font
	 * @param name of the font
	 * @return Font
	 */
	public Font getFont(String name){
		return fonts.get(name).getFont();
	}
	/**
	 * get a font with a size
	 * @param name name of the font
	 * @param size size of the font
	 * @return Font
	 */
	public Font getFont(String name, int size){
		return fonts.get(name).getFont().deriveFont((float)size);
	}
	/**
	 * get a color
	 * @param s name of color
	 * @return Color
	 */
	public Color getColor(String s){
		return colors.get(s);
	}
	/**
	 * get url to a sound
	 * @param name of sound
	 * @return URL
	 */
	public URL getSound(String name){
		return sounds.get(name);
	}
}
