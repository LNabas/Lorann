package view;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	private BufferedImage image;
	public Sprite(String name) throws IOException{
		image = ImageIO.read(this.getClass().getClassLoader().getResource(name));
	}
	/**
	 * retrun image
	 * @return BufferedImage
	 */
	public BufferedImage getImage(){
		return image;
	}
}
