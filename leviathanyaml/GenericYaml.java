package leviathanyaml;

import java.io.*;
import java.util.*;

public class GenericYaml {
	
	static File ymlfile;
	static FileReader fr;
	static BufferedReader buffr;
	
	public GenericYaml(File f) {
		ymlfile = f;
	}
	
	public String readValue(String key) {
		String line = "";
		String ret = "";
		try {
			fr = new FileReader(ymlfile);
			buffr = new BufferedReader(fr);
			while (line != null) {
				line = buffr.readLine();
				if (line.trim().startsWith(key)) {
					ret = line.substring(line.lastIndexOf(":") + 2, line.length());
				}
			}
		} catch (Exception e) { System.out.println(e.toString()); }
		return ret;
	}
	
	public String readLine(int lineNo) {
		String line = "";
		String ret = "";
		int lineNo2 = 0;
		try {
			fr = new FileReader(ymlfile);
			buffr = new BufferedReader(fr);
			while (line != null) {
				line = buffr.readLine();
				lineNo2++;
				if (lineNo2 == lineNo) {
					ret = line;
				}
			}
		} catch (Exception e) { System.out.println(e.toString()); }
		return ret;
	}
	
	public String readLineValue(int lineNo) {
		String line = "";
		String ret = "";
		int lineNo2 = 0;
		try {
			fr = new FileReader(ymlfile);
			buffr = new BufferedReader(fr);
			while (line != null) {
				line = buffr.readLine();
				lineNo2++;
				if (lineNo2 == lineNo) {
					ret = line.substring(line.lastIndexOf(":") + 2, line.length());
				}
			}
		} catch (Exception e) { System.out.println(e.toString()); }
		return ret;
	}
}