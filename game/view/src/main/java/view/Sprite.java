package view;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * @author Gregory, Maxence
 */
public class Sprite {
	/**
	 * @uml.property  name="image"
	 */
	private BufferedImage image;
	public Sprite(String name) throws IOException{
		image = ImageIO.read(this.getClass().getClassLoader().getResource(name));
	}
	/**
	 * retrun image
	 * @return  BufferedImage
	 * @uml.property  name="image"
	 */
	public BufferedImage getImage(){
		return image;
	}
}
