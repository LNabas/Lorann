package view;

import java.awt.Image;
/**
 * Builder on graphics
 * @author Doc0160
 *
 */
public interface IGraphicsBuilder {
	/**
	 * draw and return image
	 * @return Image
	 */
	public Image getImage();
	/**
	 * Draw Image on another image
	 * @param image the image to be drawn
	 * @param x at position x
	 * @param y at position y
	 */
	public void drawImage(Image image, int x, int y);
	/**
	 * Draw string 
	 * @param s string
	 * @param x at position x
	 * @param y at pos y
	 */
	public void drawString(String s, int x, int y);
	/**
	 * resize
	 * @param x
	 * @param y
	 */
	public void setSize(int x, int y);
}
