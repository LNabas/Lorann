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

public class RessourcesLoader {
	private Map<String, Sprite> sprites = new HashMap<String, Sprite>();
	private Map<String, CFont> fonts = new HashMap<String, CFont>();
	private Map<String, Color> colors = new HashMap<String, Color>();
	private Map<String, URL> sounds = new HashMap<String, URL>();
	public RessourcesLoader() throws IOException, FontFormatException{
		loadColors();
		loadFonts();
		loadSounds();
		loadSprites();
	}
	public void loadColors(){
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
	public void loadSounds(){
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
	public void loadFonts(){
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
	public BufferedImage getSprite(String name){
		return sprites.get(name).getImage();
	}
	public Font getFont(String name){
		return fonts.get(name).getFont();
	}
	public Font getFont(String name, int size){
		return fonts.get(name).getFont().deriveFont((float)size);
	}
	public void loadColor(String s, int r, int g, int b) throws IOException, FontFormatException{
		colors.put(s, new Color(r,g,b));
	}
	public Color getColor(String s){
		return colors.get(s);
	}
	public URL getSound(String name){
		return sounds.get(name);
	}
}
