package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * The Class ViewPanel.
 *
 * @author Doc0160
 */
class ViewPanel extends JPanel implements Observer {
	private RessourcesLoader ressources;
	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public ViewPanel(final ViewFrame viewFrame) throws IOException, FontFormatException {
		this.setViewFrame(viewFrame);
		ressources = new RessourcesLoader();
		viewFrame.getModel().getObservable().addObserver(this);
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	@SuppressWarnings("unused")
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.setColor(Color.BLACK);
	    graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
	    Image g = new Menu(ressources).getImage();
	    int min = (this.getWidth() < this.getHeight()) ? this.getWidth() : this.getHeight();
	    int margin_x = (this.getWidth() - min)/2;
	    int margin_y = (this.getHeight() - min)/2;
	    graphics.drawImage(g, margin_x, margin_y, min, min, null);
	}
}
