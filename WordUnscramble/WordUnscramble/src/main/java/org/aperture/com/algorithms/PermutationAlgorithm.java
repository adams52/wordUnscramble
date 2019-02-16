package org.aperture.com.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.aperture.com.permutations.Permutations;
import org.aperture.com.utility.MapDictionary;

public class PermutationAlgorithm implements Algorithm {
	
	private Permutations permutations = new Permutations();

	public Map<String, Set<String>> getWordsBySize(String letters, MapDictionary dictionary) {
		Set<String> combos = permutations.possibleCombinations(letters);
		
		Map<String, Set<String>> wordsBySize = new HashMap<String, Set<String>>();
		
		for (String key: combos) {
			Set<String> words = dictionary.getDictionary().get(key);
			if (words != null) {
				for (String word: words) {
					if (wordsBySize.get("" + word.length()) == null) {
						wordsBySize.put("" + word.length(), new HashSet<String>());
					}
					wordsBySize.get("" + word.length()).add(word);
				}
			}
		}
		
		return wordsBySize;
	}

}
