package mainPackage;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class NotePadFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	static ThemeColor themeColor = new ThemeColor();
	JPanel panel;
	
	public NotePadFrame() {
		
		setTitle("My NotePad");
		setSize(1000, 560);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		panel = new JPanel();
		panel.setLayout(new GridLayout());
		
		initGUI();
	}

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
		
		scrollPane = new JScrollPane(textArea);
		panel.add(scrollPane);
		add(panel);
		
		textArea.setFont(new Font("Calibri", Font.PLAIN, 15));
	}
}
