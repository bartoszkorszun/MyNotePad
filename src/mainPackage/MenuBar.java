package mainPackage;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuBar extends JMenuBar implements ActionListener {

	private static final long serialVersionUID = 1L;

	public MenuBar() {
		
		file();
		edit();
		format();
		theme();
		
		setBackground(NotePadFrame.themeColor.getThemeColor());
	}
	
	JMenu file;
	JMenuItem open, save;
	public void file() {
		
		file = new JMenu("File");
		file.setForeground(NotePadFrame.themeColor.getFontColor());
		add(file);
		
		open = new JMenuItem("Open");
		open.setBackground(NotePadFrame.themeColor.getThemeColor());
		open.setForeground(NotePadFrame.themeColor.getFontColor());
		file.add(open);
		open.addActionListener(this);
		
		save = new JMenuItem("Save");
		save.setBackground(NotePadFrame.themeColor.getThemeColor());
		save.setForeground(NotePadFrame.themeColor.getFontColor());
		file.add(save);
		save.addActionListener(this);
	}
	
	JMenu edit;
	JMenuItem copy, paste;
	public void edit() {
		
		edit = new JMenu("Edit");
		edit.setForeground(NotePadFrame.themeColor.getFontColor());
		add(edit);
		
		copy = new JMenuItem("Copy");
		copy.setBackground(NotePadFrame.themeColor.getThemeColor());
		copy.setForeground(NotePadFrame.themeColor.getFontColor());
		edit.add(copy);
		copy.addActionListener(this);
		
		paste = new JMenuItem("Paste");
		paste.setBackground(NotePadFrame.themeColor.getThemeColor());
		paste.setForeground(NotePadFrame.themeColor.getFontColor());
		edit.add(paste);
		paste.addActionListener(this);
	}
	
	JMenu format;
	JMenuItem font;
	public void format() {
		
		format = new JMenu("Format");
		format.setForeground(NotePadFrame.themeColor.getFontColor());
		add(format);
		
		font = new JMenuItem("Font");
		font.setBackground(NotePadFrame.themeColor.getThemeColor());
		font.setForeground(NotePadFrame.themeColor.getFontColor());
		format.add(font);
		font.addActionListener(this);
	}
	
	JMenu theme;
	JMenuItem light, dark;
	static boolean isThemeEnabled;
	public void theme() {
		
		theme = new JMenu("Theme");
		theme.setForeground(NotePadFrame.themeColor.getFontColor());
		add(theme);
		
		light = new JMenuItem("Light");
		light.setBackground(NotePadFrame.themeColor.getThemeColor());
		light.setForeground(NotePadFrame.themeColor.getFontColor());
		light.setEnabled(isThemeEnabled);
		theme.add(light);
		light.addActionListener(this);
		
		dark = new JMenuItem("Dark");
		dark.setBackground(NotePadFrame.themeColor.getThemeColor());
		dark.setForeground(NotePadFrame.themeColor.getFontColor());
		dark.setEnabled(!isThemeEnabled);
		theme.add(dark);
		dark.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object object = e.getSource();
		
		if(object == open) {
			openTxTFile();
		}
		if(object == save) {	
			saveTxTFile();
		}
		if(object == copy) {
			copyText();
		}
		if(object == paste) {
			pasteText();
		}
		if(object == font) {
			
		}
		if(object == light) {
			setLightTheme();
		}
		if(object == dark) {
			setDarkTheme();
		}
	}
	
	File saveFile;
	FileWriter fw;
	public void saveTxTFile() {
		
		JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new File("."));
	    chooser.setApproveButtonText("Save");
	    chooser.setDialogTitle("Save");
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt");
	    chooser.setFileFilter(filter);
	    
	    int option = chooser.showSaveDialog(this);
	    
	    if (option == JFileChooser.APPROVE_OPTION) {
	    	saveFile = new File(chooser.getSelectedFile().toString() + ".txt");
            fw = null;
            
            if (saveFile.exists()) {
            	int overwrite = JOptionPane.showConfirmDialog(null, "Do you want to overwrite it?", "This file already exists!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            	if (overwrite == JOptionPane.YES_OPTION) {
            		saveFile();
            	}
            }else {
		    	saveFile();
            }
	    }
	}
	
	public void saveFile() {
		
		String contains = RunNotePad.frame.textArea.getText();
		try {
            fw = new FileWriter(saveFile);
            fw.write(contains);
            fw.flush();

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if(fw != null) {
                try {
                    fw.close();
                } catch (IOException ex) {
                	ex.printStackTrace();
                }
            }
        }
	}
	
	public void openTxTFile() {
		
		JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new File("."));
	    chooser.setApproveButtonText("Open");
	    chooser.setDialogTitle("Open");
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt");
	    chooser.setFileFilter(filter);
	    
	    int option = chooser.showOpenDialog(this);
	    
	    if(option == JFileChooser.APPROVE_OPTION) {
	    	
	    	File openFile = new File(chooser.getSelectedFile().toString());
	    	if (openFile.exists()) {
		    	try {
		    		FileReader fr = new FileReader(openFile);
			    	BufferedReader br = new BufferedReader(fr);
		    	    StringBuilder sb = new StringBuilder();
		    	    String line = br.readLine();
	
		    	    while (line != null) {
		    	        sb.append(line);
		    	        sb.append(System.lineSeparator());
		    	        line = br.readLine();
		    	    }
		    	    RunNotePad.frame.textArea.setText(sb.toString());
		    	    br.close();
		    	}catch (IOException e) {
		    		e.printStackTrace();
		    	}
	    	}else {
	    		JOptionPane.showMessageDialog(null, "No file chosen");
	    	}
	    }
	}
	
	Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
	public void copyText() {
		
		StringSelection stringSelection = new StringSelection(RunNotePad.frame.textArea.getText());
		clpbrd.setContents (stringSelection, null);
	}
	
	public void pasteText() {
		
		DataFlavor flavor = DataFlavor.stringFlavor;
	    if (clpbrd.isDataFlavorAvailable(flavor)) {
	      try {
	        String text = (String) clpbrd.getData(flavor);
	        RunNotePad.frame.textArea.append(text);
	      } catch (UnsupportedFlavorException e) {
	        System.out.println(e);
	      } catch (IOException e) {
	        System.out.println(e);
	      }
	    }
	}
 
	public void setLightTheme() {
		
		NotePadFrame.themeColor.setThemeColor(Color.WHITE);
		NotePadFrame.themeColor.setFontColor(Color.BLACK);
		
		isThemeEnabled = !isThemeEnabled;
		RunNotePad.frame.initGUI();
	}
	
	public void setDarkTheme() {
		
		NotePadFrame.themeColor.setThemeColor(Color.BLACK);
		NotePadFrame.themeColor.setFontColor(Color.WHITE);
		
		isThemeEnabled = !isThemeEnabled;
		RunNotePad.frame.initGUI();
	}
}
