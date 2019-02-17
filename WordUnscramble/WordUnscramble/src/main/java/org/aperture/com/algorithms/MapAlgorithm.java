package org.aperture.com.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.aperture.com.dictionary.MapDictionary;
import org.aperture.com.dictionary.WordInfo;

public class MapAlgorithm implements Algorithm {

	public Map<String, Set<String>> getWordsBySize(String letters, MapDictionary dictionary) {
		Map<Character, Integer> letterCount = getLetterCount(letters);
		
		Map<String, Set<String>> wordsBySize = new HashMap<String, Set<String>>();
		
		/* 
		 * Count each letter in the input, compare to count of letters in each word
		 */
		for (String sortedLetters: dictionary.getDictionary().keySet()) {
			WordInfo wordList = dictionary.getDictionary().get(sortedLetters);
			boolean canMake = true;
			for (Character c: wordList.getLetterCount().keySet()) {
				if (letterCount.getOrDefault(c, 0) < wordList.getLetterCount().get(c)) {
					canMake = false;
				}
			}
			
			if (canMake) {
				if (wordsBySize.get("" + sortedLetters.length()) == null) {
					wordsBySize.put("" + sortedLetters.length(), new HashSet<String>());
				}
				wordsBySize.get("" + sortedLetters.length()).addAll(dictionary.getDictionary().get(sortedLetters).getWords());
			}
		}
		
		return wordsBySize;
	}
	
	public static Map<Character, Integer> getLetterCount(String letters) {
		Map<Character, Integer> letterCount = new HashMap<Character, Integer>();
		
		for (char c: letters.toCharArray()) {
			letterCount.put(c, letterCount.getOrDefault(c, 0)+1);
		}
		
		return letterCount;
	}

}
