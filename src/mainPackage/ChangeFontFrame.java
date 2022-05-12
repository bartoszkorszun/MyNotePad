package mainPackage;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChangeFontFrame extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;

	public ChangeFontFrame() {
		
		setTitle("Change Font");
		setSize(445, 250);
		setResizable(false);
		setLocationRelativeTo(null);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		initGUI();
	}
	
	JButton apply;
	JList<JTextArea> fontList, styleList;
	JList<Integer> sizeList;
	public void initGUI() {
		
		JPanel panel = new JPanel();
		JPanel labelPanel = new JPanel();
		JPanel scrollPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		panel.setBackground(NotePadFrame.themeColor.getThemeColor());
		labelPanel.setBackground(NotePadFrame.themeColor.getThemeColor());
		buttonPanel.setBackground(NotePadFrame.themeColor.getThemeColor());
		
		JLabel fontLabel = new JLabel("Font", JLabel.CENTER);
		JLabel styleLabel = new JLabel("Style", JLabel.CENTER);
		JLabel sizeLabel = new JLabel("Size", JLabel.CENTER);
		
		fontLabel.setForeground(NotePadFrame.themeColor.getFontColor());
		styleLabel.setForeground(NotePadFrame.themeColor.getFontColor());
		sizeLabel.setForeground(NotePadFrame.themeColor.getFontColor());
		
		fontLabel.setBorder(BorderFactory.createLineBorder(NotePadFrame.themeColor.getFontColor()));
		styleLabel.setBorder(BorderFactory.createLineBorder(NotePadFrame.themeColor.getFontColor()));
		sizeLabel.setBorder(BorderFactory.createLineBorder(NotePadFrame.themeColor.getFontColor()));
		
		labelPanel.add(fontLabel);
		labelPanel.add(styleLabel);
		labelPanel.add(sizeLabel);

		labelPanel.setLayout(new GridLayout(1, 3));
		labelPanel.setPreferredSize(new Dimension(425, 20));
		
		String[] fontTab = {"Arial", "Calibri", "Comic Sans MS", "Georgia", "Lucida Handwriting", "Times New Roman", "Verdana"};
		JTextArea fa1 = new JTextArea();
		JTextArea fa2 = new JTextArea();
		JTextArea fa3 = new JTextArea();
		JTextArea fa4 = new JTextArea();
		JTextArea fa5 = new JTextArea();
		JTextArea fa6 = new JTextArea();
		JTextArea fa7 = new JTextArea();
		for(int i=0; i<7; i++) {
			switch(i) {
			case 0:
				fa1.setFont(new Font(fontTab[i], Font.PLAIN, 16));
			case 1:
				fa2.setFont(new Font(fontTab[i], Font.PLAIN, 16));
			case 2:
				fa3.setFont(new Font(fontTab[i], Font.PLAIN, 16));
			case 3:
				fa4.setFont(new Font(fontTab[i], Font.PLAIN, 16));
			case 4:
				fa5.setFont(new Font(fontTab[i], Font.PLAIN, 16));
			case 5:
				fa6.setFont(new Font(fontTab[i], Font.PLAIN, 16));
			case 6:
				fa7.setFont(new Font(fontTab[i], Font.PLAIN, 16));
			}
		}
		JTextArea[] fontAreas = {fa1, fa2, fa3, fa4, fa5, fa6, fa7};
		DefaultListModel<JTextArea> fontListModel = new DefaultListModel<>();
		for(int i=0; i<fontTab.length; i++) {
			fontListModel.addElement(fontAreas[i]);
		}
		fontList = new JList<>(fontListModel);
		
		String[] styleTab = {"Plain", "Bold", "Italic"};
		JTextArea sa1 = new JTextArea();
		JTextArea sa2 = new JTextArea();
		JTextArea sa3 = new JTextArea();
		JTextArea[] styleAreas = {sa1, sa2, sa3};
		DefaultListModel<JTextArea> styleListModel = new DefaultListModel<>();
		for(int i=0; i<styleTab.length; i++) {
			styleListModel.addElement(styleAreas[i]);
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
		
		fontList.setSelectedIndex(NotePadFrame.sts.getFontIndex());
		styleList.setSelectedIndex(NotePadFrame.sts.getTextStyle());
		sizeList.setSelectedIndex(NotePadFrame.sts.getSizeIndex());
		
		JScrollPane sp1 = new JScrollPane(fontList);
		JScrollPane sp2 = new JScrollPane(styleList);
		JScrollPane sp3 = new JScrollPane(sizeList);
		
		scrollPanel.add(sp1);
		scrollPanel.add(sp2);
		scrollPanel.add(sp3);
		
		scrollPanel.setLayout(new GridLayout(1, 3));
		scrollPanel.setPreferredSize(new Dimension(425, 150));
		
		apply = new JButton("Apply");
		apply.addActionListener(this);
		apply.setBackground(NotePadFrame.themeColor.getThemeColor());
		apply.setForeground(NotePadFrame.themeColor.getFontColor());
		apply.setBounds(345, 0, 80, 24);
		buttonPanel.setLayout(null);
		buttonPanel.add(apply);
		buttonPanel.setPreferredSize(new Dimension(425, 24));
		
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
				NotePadFrame.sts.setTextFont(fontList.getSelectedValue().toString()); NotePadFrame.sts.setFontIndex(choice);
			case 1:
				NotePadFrame.sts.setTextFont(fontList.getSelectedValue().toString()); NotePadFrame.sts.setFontIndex(choice);
			case 2:
				NotePadFrame.sts.setTextFont(fontList.getSelectedValue().toString()); NotePadFrame.sts.setFontIndex(choice);
			case 3:
				NotePadFrame.sts.setTextFont(fontList.getSelectedValue().toString()); NotePadFrame.sts.setFontIndex(choice);
			case 4:
				NotePadFrame.sts.setTextFont(fontList.getSelectedValue().toString()); NotePadFrame.sts.setFontIndex(choice);
			case 5:
				NotePadFrame.sts.setTextFont(fontList.getSelectedValue().toString()); NotePadFrame.sts.setFontIndex(choice);
			case 6:
				NotePadFrame.sts.setTextFont(fontList.getSelectedValue().toString()); NotePadFrame.sts.setFontIndex(choice);
			}
			
			choice = styleList.getSelectedIndex();
			switch(choice) {
			case 0:
				NotePadFrame.sts.setTextStyle(choice);
			case 1:
				NotePadFrame.sts.setTextStyle(choice);
			case 2:
				NotePadFrame.sts.setTextStyle(choice);
			}
			
			choice = sizeList.getSelectedIndex();
			switch(choice) {
			case 0:
				NotePadFrame.sts.setTextSize(sizeList.getSelectedValue()); NotePadFrame.sts.setSizeIndex(choice);
			case 1:
				NotePadFrame.sts.setTextSize(sizeList.getSelectedValue()); NotePadFrame.sts.setSizeIndex(choice);
			case 2:
				NotePadFrame.sts.setTextSize(sizeList.getSelectedValue()); NotePadFrame.sts.setSizeIndex(choice);
			case 3:
				NotePadFrame.sts.setTextSize(sizeList.getSelectedValue()); NotePadFrame.sts.setSizeIndex(choice);
			case 4:
				NotePadFrame.sts.setTextSize(sizeList.getSelectedValue()); NotePadFrame.sts.setSizeIndex(choice);
			case 5:
				NotePadFrame.sts.setTextSize(sizeList.getSelectedValue()); NotePadFrame.sts.setSizeIndex(choice);
			case 6:
				NotePadFrame.sts.setTextSize(sizeList.getSelectedValue()); NotePadFrame.sts.setSizeIndex(choice);
			case 7:
				NotePadFrame.sts.setTextSize(sizeList.getSelectedValue()); NotePadFrame.sts.setSizeIndex(choice);
			case 8:
				NotePadFrame.sts.setTextSize(sizeList.getSelectedValue()); NotePadFrame.sts.setSizeIndex(choice);
			case 9:
				NotePadFrame.sts.setTextSize(sizeList.getSelectedValue()); NotePadFrame.sts.setSizeIndex(choice);
			case 10:
				NotePadFrame.sts.setTextSize(sizeList.getSelectedValue()); NotePadFrame.sts.setSizeIndex(choice);
			}
			
			NotePadFrame.sText.setSavedText(RunNotePad.frame.textArea.getText());
			this.dispose();
			RunNotePad.frame.initGUI();
		}
	}
}
