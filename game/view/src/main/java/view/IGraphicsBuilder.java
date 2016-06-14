package view;

import java.awt.Image;

public interface IGraphicsBuilder {
	public Image paint();
	public IGraphicsBuilder setSprites(SpritesLoader sprites);
}
