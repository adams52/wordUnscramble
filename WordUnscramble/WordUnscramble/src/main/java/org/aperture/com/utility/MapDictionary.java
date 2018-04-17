package org.aperture.com.utility;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MapDictionary {
	
	private Map<String, List<String>> dictionary = new HashMap<String, List<String>>();
	
	public void populateDictionary(String fileLocation) {
		InputStream in = MapDictionary.class.getClassLoader().getResourceAsStream(fileLocation);
		Scanner s = new Scanner(in);
		String line = null;
		char[] array;
		String sortedLetters;
		while (s.hasNextLine()) {
			line = s.nextLine();
			array = line.toCharArray();
			Arrays.sort(array);
			sortedLetters = String.valueOf(array);
			if (getDictionary().get(sortedLetters)==null) {
				getDictionary().put(sortedLetters,  new ArrayList<String>());
			}
			getDictionary().get(sortedLetters).add(line);
		}
		s.close();
	}

	public Map<String, List<String>> getDictionary() {
		return dictionary;
	}

	public void setDictionary(Map<String, List<String>> dictionary) {
		this.dictionary = dictionary;
	}
}
