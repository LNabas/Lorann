package view;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class CFont {
	/**
	 * @uml.property  name="font"
	 */
	private Font font;
	public CFont(String name) throws IOException, FontFormatException{
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(name+".ttf");
		font = Font.createFont(Font.TRUETYPE_FONT, is);
		is.close();
	}
	/**
	 * get font
	 * @return  Font
	 * @uml.property  name="font"
	 */
	public Font getFont(){
		return font;
	}
}
