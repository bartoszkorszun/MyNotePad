package mainPackage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ChangeFontFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	public ChangeFontFrame() {
		
		setTitle("Change Font");
		setSize(445, 250);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		initGUI();
	}
	
	JButton apply;
	JList<String> fontList, styleList;
	JList<Integer> sizeList;
	public void initGUI() {
		
		JPanel panel = new JPanel();
		JPanel labelPanel = new JPanel();
		JPanel scrollPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		labelPanel.setBackground(NotePadFrame.themeColor.getThemeColor());
		buttonPanel.setBackground(NotePadFrame.themeColor.getThemeColor());
		
		JLabel fontLabel = new JLabel("Font", JLabel.CENTER);
		JLabel styleLabel = new JLabel("Style", JLabel.CENTER);
		JLabel sizeLabel = new JLabel("Size", JLabel.CENTER);
		
		fontLabel.setForeground(NotePadFrame.themeColor.getFontColor());
		styleLabel.setForeground(NotePadFrame.themeColor.getFontColor());
		sizeLabel.setForeground(NotePadFrame.themeColor.getFontColor());
		
		labelPanel.add(fontLabel);
		labelPanel.add(styleLabel);
		labelPanel.add(sizeLabel);
		
		labelPanel.setLayout(new GridLayout(1, 3));
		
		String[] fontTab = {"Arial", "Calibri", "Comic Sans MS", "Georgia", "Lucida Handwriting", "Times New Roman", "Verdana"};
		DefaultListModel<String> fontListModel = new DefaultListModel<>();
		for(int i=0; i<fontTab.length; i++) {
			fontListModel.addElement(fontTab[i]);
		}
		fontList = new JList<>(fontListModel);
		
		String[] styleTab = {"Plain", "Bold", "Italic"};
		DefaultListModel<String> styleListModel = new DefaultListModel<>();
		for(int i=0; i<styleTab.length; i++) {
			styleListModel.addElement(styleTab[i]);
		}
		styleList = new JList<>(styleListModel);
		
		int[] sizeTab = {10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};
		DefaultListModel<Integer> sizeListModel = new DefaultListModel<>();
		for(int i=0; i<sizeTab.length; i++) {
			sizeListModel.addElement(sizeTab[i]);
		}
		sizeList = new JList<>(sizeListModel);
		
		fontList.setBackground(NotePadFrame.themeColor.getThemeColor());
		fontList.setForeground(NotePadFrame.themeColor.getFontColor());
		styleList.setBackground(NotePadFrame.themeColor.getThemeColor());
		styleList.setForeground(NotePadFrame.themeColor.getFontColor());
		sizeList.setBackground(NotePadFrame.themeColor.getThemeColor());
		sizeList.setForeground(NotePadFrame.themeColor.getFontColor());
		
		JScrollPane sp1 = new JScrollPane(fontList);
		JScrollPane sp2 = new JScrollPane(styleList);
		JScrollPane sp3 = new JScrollPane(sizeList);
		
		scrollPanel.add(sp1);
		scrollPanel.add(sp2);
		scrollPanel.add(sp3);
		
		scrollPanel.setLayout(new GridLayout(1, 3));
		
		apply = new JButton("Apply");
		apply.addActionListener(this);
		apply.setBackground(NotePadFrame.themeColor.getThemeColor());
		apply.setForeground(NotePadFrame.themeColor.getFontColor());
		buttonPanel.add(apply);
		
		panel.add(labelPanel);
		panel.add(scrollPanel);
		panel.add(buttonPanel);
		
		add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		
		if(o == apply) {
			
			int choice = fontList.getSelectedIndex();
			switch(choice) {
			case 0:
				NotePadFrame.sts.setTextFont(fontList.getSelectedValue());
			case 1:
				NotePadFrame.sts.setTextFont(fontList.getSelectedValue());
			case 2:
				NotePadFrame.sts.setTextFont(fontList.getSelectedValue());
			case 3:
				NotePadFrame.sts.setTextFont(fontList.getSelectedValue());
			case 4:
				NotePadFrame.sts.setTextFont(fontList.getSelectedValue());
			case 5:
				NotePadFrame.sts.setTextFont(fontList.getSelectedValue());
			case 6:
				NotePadFrame.sts.setTextFont(fontList.getSelectedValue());
			}
			
			choice = styleList.getSelectedIndex();
			switch(choice) {
			case 0:
				NotePadFrame.sts.setTextStyle(styleList.getSelectedIndex());
			case 1:
				NotePadFrame.sts.setTextStyle(styleList.getSelectedIndex());
			case 2:
				NotePadFrame.sts.setTextStyle(styleList.getSelectedIndex());
			}
			
			choice = sizeList.getSelectedIndex();
			switch(choice) {
			case 0:
				NotePadFrame.sts.setTextSize(sizeList.getSelectedValue());
			case 1:
				NotePadFrame.sts.setTextSize(sizeList.getSelectedValue());
			case 2:
				NotePadFrame.sts.setTextSize(sizeList.getSelectedValue());
			case 3:
				NotePadFrame.sts.setTextSize(sizeList.getSelectedValue());
			case 4:
				NotePadFrame.sts.setTextSize(sizeList.getSelectedValue());
			case 5:
				NotePadFrame.sts.setTextSize(sizeList.getSelectedValue());
			case 6:
				NotePadFrame.sts.setTextSize(sizeList.getSelectedValue());
			case 7:
				NotePadFrame.sts.setTextSize(sizeList.getSelectedValue());
			case 8:
				NotePadFrame.sts.setTextSize(sizeList.getSelectedValue());
			case 9:
				NotePadFrame.sts.setTextSize(sizeList.getSelectedValue());
			case 10:
				NotePadFrame.sts.setTextSize(sizeList.getSelectedValue());
			}
			
			NotePadFrame.sText.setSavedText(RunNotePad.frame.textArea.getText());
			this.dispose();
			RunNotePad.frame.initGUI();
		}
	}
}
