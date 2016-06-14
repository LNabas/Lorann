package view;

import java.io.IOException;
import java.util.ArrayList;

public class SpritesLoader {
	private ArrayList<Sprite> sprites;
	public SpritesLoader() throws IOException{
		sprites = new ArrayList<Sprite>();
		sprites.add(new Sprite("LockedButton"));
	}
}
