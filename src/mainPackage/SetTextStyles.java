package mainPackage;

public class SetTextStyles {

	String textFont = "Calibri";
	int textStyle = 0, textSize = 15;
	
	public void setTextFont(String tf) {
		
		textFont = tf;
	}
	
	public void setTextStyle(int tst) {
		
		textStyle = tst;
	}
	
	public void setTextSize(int tsi) {
		
		textSize = tsi;
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
}
