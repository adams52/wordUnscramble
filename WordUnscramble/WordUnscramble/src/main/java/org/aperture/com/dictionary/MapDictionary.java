package org.aperture.com.dictionary;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.aperture.com.algorithms.MapAlgorithm;

public class MapDictionary {
	
	private Map<String, WordList> dictionary = new HashMap<String, WordList>();
	
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
				getDictionary().put(sortedLetters,  new WordList());
			}
			getDictionary().get(sortedLetters).add(line);
			getDictionary().get(sortedLetters).getLetterCount().putAll(MapAlgorithm.getLetterCount(sortedLetters));
		}
		s.close();
	}

	public Map<String, WordList> getDictionary() {
		return dictionary;
	}

	public void setDictionary(Map<String, WordList> dictionary) {
		this.dictionary = dictionary;
	}
}
