package mainPackage;

public class SetTextStyles {

	String textFont = "Calibri";
	int textStyle = 0, textSize = 16, fontIndex = 1, sizeIndex = 3;
	
	public void setTextFont(String tf) {
		
		textFont = tf;
	}
	
	public void setTextStyle(int tst) {
		
		textStyle = tst;
	}
	
	public void setTextSize(int tsi) {
		
		textSize = tsi;
	}
	
	public void setFontIndex(int fi) {
		
		fontIndex = fi;
	}
	
	public void setSizeIndex(int si) {
		
		sizeIndex = si;
	}
	
	public String getTextFont() {
		
		return textFont;
	}
	
	public int getTextStyle() {
		
		return textStyle;
	}
	
	public int getTextSize() {
		
		return textSize;
	}
	
	public int getFontIndex() {
		
		return fontIndex;
	}
	
	public int getSizeIndex() {
		
		return sizeIndex;
	}
}
