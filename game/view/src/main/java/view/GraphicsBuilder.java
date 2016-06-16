package view;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
/**
 * I build graphics !
 * @author Doc0160
 *
 */
public class GraphicsBuilder implements IGraphicsBuilder{
	protected RessourcesLoader ressources;
	protected BufferedImage bufferImage;
	protected Graphics graphics;
	/**
	 * Constructor
	 * @param r RessourceLoader
	 */
	public GraphicsBuilder(RessourcesLoader r) {
		ressources = r;
		bufferImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB); 
		graphics = bufferImage.getGraphics();
	}
	public Image getImage() {
		return bufferImage;
	}
	public void drawImage(Image image, int i, int j) {
		graphics.drawImage(image, i, j, null);
	}
	public void setSize(int x, int y) {
		bufferImage = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB); 
		graphics = bufferImage.getGraphics();
	}
	/**
	 * Draw String
	 * @param s text
	 * @param x pos x
	 * @param y pos y
	 * @param f font
	 */
	public void drawString(String s, int x, int y, Font f) {
		graphics.setFont(f);
		graphics.drawString(s, x, y);
	}
	public void drawString(String s, int x, int y) {
		graphics.drawString(s, x, y);
	}
	/**
	 * Draw Centered Text
	 * @param s text
	 * @param x pos x
	 * @param y pos y
	 * @param f font
	 */
	public void drawCenteredString(String s, int x, int y, Font f){
		FontMetrics metrics = graphics.getFontMetrics(f);
		x -= metrics.stringWidth(s)/2;
		// TODO(doc): correct that
		y += metrics.getHeight()/4;
		drawString(s, x, y, f);
	}
}
