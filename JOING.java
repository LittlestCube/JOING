package JOING;

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class JOING implements ActionListener { 
	
	static JOING app = new JOING();
	static JFrame frame = new JFrame("JOING");
	static JPanel win = new JPanel();
	static JTextArea tbox = new JTextArea(16, 40);
	static JButton comp = new JButton("Compress");
	static JButton decomp = new JButton("Decompress");
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == decomp) {
			tbox.setText(decompress(tbox.getText()));
		}
		
		if (src == comp) {
			tbox.setText(compress(tbox.getText()));
		}
	}
	
	public String checkBoxForCode(String[] compFile, String boxtext) {
		try {
			for (int i = 0; i < boxtext.length(); i++) {
				String currtext = boxtext.substring(i, boxtext.length());
				for (int ii = 0; ii < compFile.length && compFile[ii] != null; ii++) {
					if (currtext.startsWith("[" + compFile[ii].substring(0, 5) + "]")) {
						boxtext = boxtext.substring(0, i) + compFile[ii].substring(8, compFile[ii].length()) + currtext.substring(7, currtext.length());
					}
				}
			}
		} catch (Exception e) { System.err.println("Whoops! Error in function checkBoxForCode(String[] compFile): " + e.toString()); }
		return boxtext;
	}
	
	public String decompress(String text) {
		String[] compFile = {};
		try {
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("comptext.txt");
			System.out.println("we got this far");
			BufferedReader buff = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			List<String> arr = new ArrayList<String>();
			int i = 0;
			for (String line = ""; line != null; line = buff.readLine()) {
				if (line != "") {
					arr.add(line);
				}
			}
			compFile = arr.toArray(new String[arr.size()]);
			buff.close();
		} catch (Exception e) { System.err.println("Whoops! Error in function decompress(): " + e.toString()); }
		return checkBoxForCode(compFile, text);
	}
	
	public String checkBoxForText(String[] compFile, String boxtext) {
		try {
			for (int i = 0; i < boxtext.length(); i++) {
				String currtext = boxtext.substring(i, boxtext.length());
				for (int ii = compFile.length - 1; ii > -1; ii--) {
					String currcheck = compFile[ii].substring(8, compFile[ii].length());
					if (currtext.startsWith(currcheck)) {
						boxtext = boxtext.substring(0, i) + "[" + compFile[ii].substring(0, 5) + "]" + currtext.substring(currcheck.length(), currtext.length());
					}
				}
			}
		} catch (Exception e) { System.err.println("Whoops! Error in function checkBoxForText(String[] compFile): " + e.toString()); }
		return boxtext;
	}
	
	public String compress(String text) {
		String[] compFile = {};
		try {
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("comptext.txt");
			BufferedReader buff = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			List<String> arr = new ArrayList<String>();
			int i = 0;
			for (String line = ""; line != null; line = buff.readLine()) {
				if (line != "") {
					arr.add(line);
				}
			}
			compFile = arr.toArray(new String[arr.size()]);
			buff.close();
		} catch (Exception e) { System.err.println("Whoops! Error in function compress(): " + e.toString()); }
		return checkBoxForText(compFile, text);
	}
	
	public static void main(String args[]) {
		tbox.setLineWrap(true);
		win.add(tbox);
		win.add(comp);
		comp.addActionListener(app);
		win.add(decomp);
		decomp.addActionListener(app);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(win);
		frame.setSize(500, 320);
		frame.setResizable(true);
		frame.setVisible(true);
	}
}
