package view;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class GraphicsBuilder implements IGraphicsBuilder{
	protected RessourcesLoader ressources;
	BufferedImage bufferImage;
	Graphics graphics;
	public GraphicsBuilder(RessourcesLoader r) {
		ressources = r;
		bufferImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB); 
		graphics = bufferImage.getGraphics();
	}
	public Image getImage() {
		return null;
	}
	public void drawImage(Image image, int i, int j) {
		graphics.drawImage(image, i, j, null);
	}
	public void setSize(int x, int y) {
		bufferImage = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB); 
		graphics = bufferImage.getGraphics();
	}
	public void drawString(String s, int x, int y, Font f) {
		graphics.setFont(f);
		graphics.drawString(s, x, y);
	}
	public void drawString(String s, int x, int y) {
		graphics.drawString(s, x, y);
	}
	public void drawCenteredString(String s, int x, int y, Font f){
		FontMetrics metrics = graphics.getFontMetrics(f);
		x -= metrics.stringWidth(s)/2;
		// TODO(doc): correct that
		//y -= metrics.getHeight()/2;
		drawString( s, x, y, f);
	}
}
