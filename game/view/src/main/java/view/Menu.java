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
	public Menu(RessourcesLoader r) {
		super(r);
	}
	public Menu setOffset(int x){
		offset_x = x;
		return this;
	}
	public Menu setMarginIncrement(int x){
		margin_increment_x = x;
		return this;
	}
	public Image getImage(){
		setSize(400,600);
		for(String v : button_order){
			drawImage(buttons.get(v).getImage(), 0, offset_x);
			offset_x += buttons.get(v).getHeight()+margin_increment_x;
		}
		return bufferImage;
	}
	public Menu addButton(String string, Button b){
		buttons.put(string, b);
		button_order.add(string);
		return this;
	}
}
