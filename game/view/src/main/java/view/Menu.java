package view;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Menu extends GraphicsBuilder{
	private Map<String, Button> buttons = new HashMap<String, Button>();
	private ArrayList<String> button_order = new ArrayList<String>();
	private int offset_x = 0;
	private int margin_increment_x = 5;
	private boolean need_redraw = true;
	public Menu(RessourcesLoader r) {
		super(r);
	}
	public Menu setOffset(int x){
		offset_x = x;
		need_redraw = true;
		return this;
	}
	public Menu setMarginIncrement(int x){
		margin_increment_x = x;
		need_redraw=true;
		return this;
	}
	public void changeButtonState(String name, ButtonState state){
		this.buttons.get(name).setState(state);
		need_redraw=true;
	}
	public Image getImage(){
		int loc_offx = offset_x;
		if(need_redraw){
			setSize(400,600);
			for(String v : button_order){
				drawImage(buttons.get(v).getImage(), 0, loc_offx);
				loc_offx += buttons.get(v).getHeight()+margin_increment_x;
			}
			need_redraw = false;
		}
		return bufferImage;
	}
	public Menu addButton(String string, Button b){
		need_redraw = true;
		buttons.put(string, b);
		button_order.add(string);
		return this;
	}
}
