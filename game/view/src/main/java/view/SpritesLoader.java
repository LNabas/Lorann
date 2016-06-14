package view;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SpritesLoader {
	private Map<String, Sprite> sprites;
	public SpritesLoader() throws IOException{
		sprites = new HashMap<String, Sprite>();
		sprites.put("LockedButton", new Sprite("LockedButton"));
	}
	public BufferedImage getSprite(String name){
		return sprites.get(name).getImage();
	}
}
