package mainPackage;

import java.awt.Color;

/*
 * GET/SET CLASS FOR THEME
 * I THINK IT'S PRETTY SEFLDESCRIPTIVE SO I'LL LEAVE IT WITH ONLY THIS COMMENT :)
 */

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
