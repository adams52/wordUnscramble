package org.aperture.com.utility;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MapDictionary {
	
	private Map<String, Set<String>> dictionary = new HashMap<String, Set<String>>();
	
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
				getDictionary().put(sortedLetters,  new HashSet<String>());
			}
			getDictionary().get(sortedLetters).add(line);
		}
		s.close();
	}

	public Map<String, Set<String>> getDictionary() {
		return dictionary;
	}

	public void setDictionary(Map<String, Set<String>> dictionary) {
		this.dictionary = dictionary;
	}
}
