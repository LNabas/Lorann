package view;

import java.awt.Color;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import contract.ButtonState;
import contract.States;
import jaco.mp3.player.MP3Player;

/**
 * The Class ViewPanel.
 *
 * @author Doc0160
 */
class ViewPanel extends JPanel implements Observer {
	private States state = States.MENU;
	public RessourcesLoader ressources;
	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;
	public Menu menu_principal;
	public Menu menu_options; 
	public Map map;
	public MP3Player music;

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
		 music = new MP3Player();
		 music.setShuffle(true);
		 music.setRepeat(true);
		 for(Entry<String, URL> v : ressources.getSounds().entrySet()){
			 music.addToPlayList(ressources.getSound(v.getKey()));
		 }
		 music.play();
		 //
		 menu_principal = new Menu(ressources).setOffset(0).setMarginIncrement(7)
				 .addButton("Logo", new Logo(ressources))
				 .addButton("Start", new Button(ressources).setText("Start").setState(ButtonState.CLICKED))
				 .addButton("Options", new Button(ressources).setText("Options"))
				 .addButton("Quit", new Button(ressources).setText("Quit")); 
		 menu_options = new Menu(ressources).setOffset(0)
				 .addButton("1", new Button(ressources).setText("NOOB").setState(ButtonState.CLICKED))
				 .addButton("2", new Button(ressources).setText("Meh"))
				 .addButton("3", new Button(ressources).setText("OH YEAH"))
				 .addButton("4", new Button(ressources).setText("DUCK GOD"));
		 map = new Map(ressources, this.viewFrame.getModel().getMap());
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
	
	public Menu getMenu(){
		switch(state){
		case MENU:
			return menu_principal;
		case MENU_OPTIONS:
			return menu_options;
		default:
			return menu_principal;
		}
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		System.out.println("redraw");
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
		switch(state){
		case MENU:
			draw(menu_principal.getImage(), graphics);
		    break;
		case MENU_OPTIONS:
			draw(menu_options.getImage(), graphics);
		    break;    
		case GAME:
			draw(map.getImage(), graphics);
			break;
		default:
			break;
		}
	}
	private static float getScaleFactor(int iMasterSize, int iTargetSize) {
	    float dScale = 1;
	    if (iMasterSize > iTargetSize) {
	        dScale = (float) iTargetSize / (float) iMasterSize;
	    } else {
	        dScale = (float) iTargetSize / (float) iMasterSize;
	    }
	    return dScale;
	}
	private void draw(Image img, Graphics g){
		int width = this.getWidth();
		int height = this.getHeight();
		int img_width = img.getWidth(null);
		int img_height = img.getHeight(null);
	    float scale_w = getScaleFactor(img_width, width);
	    float scale_h = getScaleFactor(img_height, height);
	    float s = Math.min(scale_h, scale_w);
	    width = (int) (img_width*s);
	    height = (int) (img_height*s);
	    int margin_x = (this.getWidth() - width)/2;
	    int margin_y = (this.getHeight() - height)/2;
	    g.drawImage(img, margin_x, margin_y, width, height, null);
	}
	/**
	 * Return the current view state
	 * @return internal state of the panel
	 */
	public States getState() {
		return this.state;
	}
	/**
	 * Set current view state
	 * @param state
	 */
	public void setState(States s) {
		state=s;
		this.repaint();
	}
}
