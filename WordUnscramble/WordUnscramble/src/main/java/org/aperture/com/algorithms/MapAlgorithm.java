package org.aperture.com.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.aperture.com.utility.MapDictionary;

public class MapAlgorithm implements Algorithm {

	public Map<String, Set<String>> getWordsBySize(String letters, MapDictionary dictionary) {
		Map<Character, Integer> letterCount = getLetterCount(letters);
		
		Map<String, Set<String>> wordsBySize = new HashMap<String, Set<String>>();
		
		/* 
		 * Count each letter in the input, compare to count of letters in each word
		 */
		for (String key: dictionary.getDictionary().keySet()) {
			Map<Character, Integer> keyLetters = getLetterCount(key);
			boolean canMake = true;
			for (Character c: keyLetters.keySet()) {
				if (letterCount.getOrDefault(c, 0) < keyLetters.get(c)) {
					canMake = false;
				}
			}
			
			if (canMake) {
				if (wordsBySize.get("" + key.length()) == null) {
					wordsBySize.put("" + key.length(), new HashSet<String>());
				}
				wordsBySize.get("" + key.length()).addAll(dictionary.getDictionary().get(key));
			}
		}
		
		return wordsBySize;
	}
	
	public Map<Character, Integer> getLetterCount(String letters) {
		Map<Character, Integer> letterCount = new HashMap<Character, Integer>();
		
		for (char c: letters.toCharArray()) {
			letterCount.put(c, letterCount.getOrDefault(c, 0)+1);
		}
		
		return letterCount;
	}

}
