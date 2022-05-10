package mainPackage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ChangeFontFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	public ChangeFontFrame() {
		
		setTitle("Change Font");
		setSize(355, 200);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		initGUI();
	}
	
	public void initGUI() {
		
		JPanel panel = new JPanel();
		
		JLabel fontLabel = new JLabel("Font");
		JLabel styleLabel = new JLabel("Style");
		JLabel sizeLabel = new JLabel("Size");
		
		JScrollPane sp1 = new JScrollPane();
		JScrollPane sp2 = new JScrollPane();
		JScrollPane sp3 = new JScrollPane();
		
		JButton apply = new JButton("Apply");
		
		add(panel);
	}
}
