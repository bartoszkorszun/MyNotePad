package mainPackage;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NotePadFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	static ThemeColor themeColor = new ThemeColor();
	static SetTextStyles sts = new SetTextStyles();
	static SaveText sText = new SaveText();
	JPanel panel;
	
	/*
	 * SETTING FRAME PROPERTIES
	 */
	
	public NotePadFrame() {
		
		setTitle("My NotePad");
		setSize(1000, 560);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("Resources/NotePadIcon.png"));
		setIconImage(icon.getImage());
		
		MenuBar.isThemeEnabled = false;
		
		panel = new JPanel();
		panel.setLayout(new GridLayout());
		
		initGUI();
	}

	/*
	 * INITIALIZING CONTENT OF USER INTERFACE
	 */
	
	JTextArea textArea;
	JScrollPane scrollPane;
	public void initGUI() {
		
		panel.removeAll();
		panel.revalidate();
		validate();
		repaint();
		
		setJMenuBar(new MenuBar());
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		
		textArea.setBackground(themeColor.getThemeColor());
		textArea.setForeground(themeColor.getFontColor());
		
		textArea.setText(sText.getSavedText());
		
		scrollPane = new JScrollPane(textArea);
		panel.add(scrollPane);
		add(panel);
		
		textArea.setFont(new Font(sts.getTextFont(), sts.getTextStyle(), sts.getTextSize()));
	}
}
