package mainPackage;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NotePadFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	public NotePadFrame() {
		
		setTitle("My NotePad");
		setSize(1000, 560);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initGUI();
	}

	JTextArea textArea;
	public void initGUI() {
		
		setJMenuBar(new MenuBar());
		
		textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		add(scrollPane);
		
		textArea.setFont(new Font("Calibri", Font.PLAIN, 15));
	}
}
