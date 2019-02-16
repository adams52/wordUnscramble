package org.aperture.com.utility;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.aperture.com.permutations.Permutations;
import org.json.JSONObject;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class WordsBySize {
	
	static String DICTIONARY_ENABLE = "dictionaries/enable.txt";
	
	private Permutations permutations = new Permutations();
	private MapDictionary dictionary = new MapDictionary();
	
	public WordsBySize() {
		dictionary.populateDictionary(DICTIONARY_ENABLE);
	}
	
	
	
	/**
	 * Retrieves words by default dictionary (enable1)
	 * @param letters
	 * @return
	 */
	public Map<String, Set<String>> getWordsBySize(Map<String, String> input, Context context) {
		LambdaLogger logger = context.getLogger();
		logger.log("!!! Input: " + input + " !!!");
		Set<String> combos = permutations.possibleCombinations(input.get("letters"));
		
		
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
		
		JSONObject object = new JSONObject(wordsBySize);
		
		logger.log("!!! Output: " + wordsBySize + " !!!");
		return wordsBySize;
	}

	public void setPermutations(Permutations permutations) {
		this.permutations = permutations;
	}

	public void setDictionary(MapDictionary dictionary) {
		this.dictionary = dictionary;
	}
}
