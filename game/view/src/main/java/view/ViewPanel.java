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
				 .addButton("4", new Button(ressources).setText("MY FATHER WAS KILLED BY A DUCK"));
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
			return null;
		}
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
		switch(state){
		case MENU:
			draw(menu_principal.getImage(), graphics);
		    break;
		case MENU_OPTIONS:
			draw(menu_options.getImage(), graphics);
		    break;    
		case GAME:
			draw(new Map(ressources).getImage(), graphics);
			break;
		default:
			break;
		}
	}
	private void draw(Image img, Graphics g){
		int width = this.getWidth();
		int height = this.getHeight();
		float img_width = img.getWidth(null);
		float img_height = img.getHeight(null);
	    float img_ratio = 0;
	    if(width < height){
	    	img_ratio = img_height/img_width;
	    	height = (int)(width*img_ratio);
	    }else if(this.getWidth() > this.getHeight()){
	    	img_ratio = img_width/img_height;
	    	width = (int)(height*img_ratio);
	    }
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
	}
}
