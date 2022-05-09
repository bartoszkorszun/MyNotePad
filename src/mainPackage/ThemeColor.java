package mainPackage;

import java.awt.Color;

public class ThemeColor {

	Color backGroundColor = Color.WHITE;
	Color foreGroundColor = Color.BLACK;
	
	public void setThemeColor(Color tc) {
		
		this.backGroundColor = tc;	
	}
	
	public void setFontColor(Color fc) {
		
		this.foreGroundColor = fc;
	}
	
	public Color getThemeColor() {
		
		return this.backGroundColor;
	}
	
	public Color getFontColor() {
		
		return this.foreGroundColor;
	}
}
