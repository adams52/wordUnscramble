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
}
