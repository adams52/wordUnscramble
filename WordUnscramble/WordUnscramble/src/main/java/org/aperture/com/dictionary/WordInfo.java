package org.aperture.com.dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordInfo {
	
	private Set<String> words;
	private Map<Character, Integer> letterCount;
	
	public WordInfo() {
		words = new HashSet<String>();
		letterCount = new HashMap<Character, Integer>();
	}
	
	public Map<Character, Integer> getLetterCount() {
		return letterCount;
	}
	public void setLetterCount(Map<Character, Integer> letterCount) {
		this.letterCount = letterCount;
	}
	public Set<String> getWords() {
		return words;
	}
	public void setWords(Set<String> words) {
		this.words = words;
	}
	public void add(String word) {
		words.add(word);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((letterCount == null) ? 0 : letterCount.hashCode());
		result = prime * result + ((words == null) ? 0 : words.hashCode());
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
		WordInfo other = (WordInfo) obj;
		if (letterCount == null) {
			if (other.letterCount != null)
				return false;
		} else if (!letterCount.equals(other.letterCount))
			return false;
		if (words == null) {
			if (other.words != null)
				return false;
		} else if (!words.equals(other.words))
			return false;
		return true;
	}
	
	
}
