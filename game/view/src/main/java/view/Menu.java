package view;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import contract.ButtonState;

public class Menu extends GraphicsBuilder{
	private Map<String, Button> buttons = new HashMap<String, Button>();
	private ArrayList<String> button_order = new ArrayList<String>();
	private int offset_y = 0;
	private int margin_increment_y = 5;
	private boolean need_redraw = true;
	public Menu(RessourcesLoader r) {
		super(r);
	}
	public Menu setOffset(int y){
		offset_y = y;
		need_redraw = true;
		return this;
	}
	public Menu setMarginIncrement(int y){
		margin_increment_y = y;
		need_redraw=true;
		return this;
	}
	public void changeButtonState(String name, ButtonState state){
		this.buttons.get(name).setState(state);
		need_redraw=true;
	}
	public Image getImage(){
		int loc_offy = offset_y;
		if(need_redraw){
			int width = calWidth();
			setSize(width,calHeight());
			for(String v : button_order){
				drawImage(buttons.get(v).getImage(), width/2 - buttons.get(v).getWidth()/2, loc_offy);
				loc_offy += buttons.get(v).getHeight()+margin_increment_y;
			}
			need_redraw = false;
		}
		return bufferImage;
	}
	private int calWidth(){
		int max = 0;
		for(String v : button_order){
			if(max < buttons.get(v).getImage().getWidth(null)){
				max = buttons.get(v).getImage().getWidth(null);
			}
		}
		return max;
	}
	private int calHeight(){
		int h = 0;
		for(String v : button_order){
			h += buttons.get(v).getImage().getHeight(null)+margin_increment_y;
		}
		return h;
	}
	public Menu addButton(String string, Button b){
		need_redraw = true;
		buttons.put(string, b);
		button_order.add(string);
		return this;
	}
}
