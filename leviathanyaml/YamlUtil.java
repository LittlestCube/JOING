package leviathanyaml;

import java.util.*;

public abstract class YamlUtil {
	
	public static int getKey(String key, String[][] entry) {
		for (int i = 0; i < entry[0].length; i++) {
			System.out.println(key + " " + entry[0][i]);
			if (entry[0][i].trim().equals(key.trim())) {
				return i;
			}
		}
		return -1;
	}
	
	public static int getKey(String key, String[][][] entry) {
		for (int i = 0; i < entry[0][0].length; i++) {
			if (entry[0][0][i].trim().equals(key.trim())) {
				return i;
			}
		}
		return -1;
	}
	
	public static void __ensureSize(List<String> arr, int size) {
		while (arr.size() < size) {
			arr.add(null);
		}
	}
	
	public static void _ensureSize(List<String[]> arr, int size) {
		while (arr.size() < size) {
			arr.add(null);
		}
	}
	
	public static void ensureSize(List<String[][]> arr, int size) {
		while (arr.size() < size) {
			arr.add(null);
		}
	}
	
	public static int[] convertIntegers(List<Integer> integers) {
		int[] ret = new int[integers.size()];
		Iterator<Integer> iterator = integers.iterator();
		for (int i = 0; i < ret.length; i++) {
			ret[i] = iterator.next().intValue();
		}
		return ret;
	}
}