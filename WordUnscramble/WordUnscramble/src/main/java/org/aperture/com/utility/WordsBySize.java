package org.aperture.com.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.aperture.com.permutations.Permutations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WordsBySize {
	
	static String DICTIONARY_ENABLE = "dictionaries/enable.txt";
	
	@Autowired
	private Permutations permutations;
	
	@Autowired
	private MapDictionary dictionary;
	
	/**
	 * Retrieves words by default dictionary (enable1)
	 * @param letters
	 * @return
	 */
	public Map<String, List<String>> getWordsBySize(String letters) {
		dictionary.populateDictionary(DICTIONARY_ENABLE);
		Set<String> combos = permutations.possibleCombinations(letters);
		
		
		Map<String, List<String>> wordsBySize = new HashMap<String, List<String>>();
		
		for (String key: combos) {
			List<String> words = dictionary.getDictionary().get(key);
			if (words != null) {
				for (String word: words) {
					if (wordsBySize.get("" + word.length()) == null) {
						wordsBySize.put("" + word.length(), new ArrayList<String>());
					}
					wordsBySize.get("" + word.length()).add(word);
				}
			}
		}
		return wordsBySize;
	}

	public void setPermutations(Permutations permutations) {
		this.permutations = permutations;
	}

	public void setDictionary(MapDictionary dictionary) {
		this.dictionary = dictionary;
	}
}
