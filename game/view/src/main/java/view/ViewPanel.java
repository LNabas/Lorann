package view;

import java.awt.Color;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import jaco.mp3.player.*;

import javax.swing.JPanel;

import contract.ButtonState;
enum ViewPanelState{
	MENU,
	LEVEL,
};
/**
 * The Class ViewPanel.
 *
 * @author Doc0160
 */
class ViewPanel extends JPanel implements Observer {
	private ViewPanelState state = ViewPanelState.MENU;
	private RessourcesLoader ressources;
	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;
	public Menu menu_principal;
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
		return menu_principal;
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
			if(menu_principal == null){
			    menu_principal = new Menu(ressources).setOffset(0).setMarginIncrement(7)
			    		.addButton("Logo", new Logo(ressources))
			    		.addButton("Start", new Button(ressources).setText("Start").setState(ButtonState.CLICKED))
			    		.addButton("Options", new Button(ressources).setText("Options").setState(ButtonState.LOCKED))
			    		.addButton("Quit", new Button(ressources).setText("Quit"));
			    music = new MP3Player();
			    music.setShuffle(true);
			    music.setRepeat(true);
			    music.addToPlayList(ressources.getSound("ESG"));
			    music.addToPlayList(ressources.getSound("WiL"));
			    music.addToPlayList(ressources.getSound("DDHO"));
			    music.addToPlayList(ressources.getSound("DDH"));
			    music.addToPlayList(ressources.getSound("BTTF"));
			    music.addToPlayList(ressources.getSound("IndianaJones"));
			    music.play();
			}
			int width = this.getWidth();
		    int height = this.getHeight();
		    if(this.getWidth() < this.getHeight()){
		    	height = width;
		    }else if(this.getWidth() > this.getHeight()){
		    	width = height;
		    }
		    int margin_x = (this.getWidth() - width)/2;
		    int margin_y = (this.getHeight() - height)/2;
		    graphics.drawImage(menu_principal.getImage(), margin_x, margin_y, width, height, null);
		    break;
		default:
			break;
		}
	}
}
