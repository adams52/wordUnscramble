package org.aperture.com.dictionary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.aperture.com.algorithms.MapAlgorithm;

public class MapDictionary {
	
	private Map<String, WordInfo> dictionary = new HashMap<String, WordInfo>();
	
	public void populateDictionary(String fileLocation) {
		try (Scanner s = new Scanner(MapDictionary.class.getClassLoader().getResourceAsStream(fileLocation))){
			String line = null;
			while (s.hasNextLine()) {
				line = s.nextLine();
				addWord(line);
			}
		}
	}
	
	public void addWord(String word) {
		char[] sortedArray = word.toCharArray();
		Arrays.sort(sortedArray);
		String sortedKey = String.valueOf(sortedArray);
		
		if (getDictionary().get(sortedKey)==null) {
			getDictionary().put(sortedKey,  new WordInfo());
		}
		getWordList(sortedKey).add(word);
		
		if (getLetterCount(sortedKey).size() == 0) {
			getLetterCount(sortedKey).putAll(MapAlgorithm.getLetterCount(word));
		}
		
	}
	
	public Set<String> getWordList(String sortedKey) {
		return dictionary.get(sortedKey).getWords();
	}
	
	public Map<Character, Integer> getLetterCount(String sortedKey) {
		return dictionary.get(sortedKey).getLetterCount();
	}

	public Map<String, WordInfo> getDictionary() {
		return dictionary;
	}

	public void setDictionary(Map<String, WordInfo> dictionary) {
		this.dictionary = dictionary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dictionary == null) ? 0 : dictionary.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MapDictionary other = (MapDictionary) obj;
		if (dictionary == null) {
			if (other.dictionary != null)
				return false;
		} 
		
		for (String key: dictionary.keySet()) {
			if (other.dictionary.get(key) == null) {
				return false;
			}
			
			if (!dictionary.get(key).equals(other.dictionary.get(key))) {
				return false;
			}
		}
		
		return true;
	}
	
	
}
