package view;

import java.awt.Image;

public interface IGraphicsBuilder {
	public Image getImage();
	public void drawImage(Image image, int x, int y);
	public void drawString(String s, int x, int y);
	public void setSize(int x, int y);
}
