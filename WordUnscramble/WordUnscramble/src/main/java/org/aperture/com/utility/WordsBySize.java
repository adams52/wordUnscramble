package org.aperture.com.utility;

import java.util.Map;
import java.util.Set;

import org.aperture.com.algorithms.Algorithm;
import org.aperture.com.algorithms.MapAlgorithm;
import org.json.JSONObject;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class WordsBySize {
	
	static String DICTIONARY_ENABLE = "dictionaries/enable.txt";
	
	private MapDictionary dictionary = new MapDictionary();
	private Algorithm algorithm;
	
	public WordsBySize() {
		dictionary.populateDictionary(DICTIONARY_ENABLE);
		algorithm = new MapAlgorithm();
	}
	
	/**
	 * Retrieves words by default dictionary (enable1)
	 * @param letters
	 * @return
	 */
	public String getWordsBySize(Map<String, String> input, Context context) {
		LambdaLogger logger = context.getLogger();
		logger.log("!!! Input: " + input + " !!!");
		
		Map<String, Set<String>> wordsBySize = algorithm.getWordsBySize(input.get("letters"), dictionary);
		
		JSONObject object = new JSONObject(wordsBySize);
		
		logger.log("!!! Output: " + wordsBySize + " !!!");
		return object.toString();
	}

	public void setDictionary(MapDictionary dictionary) {
		this.dictionary = dictionary;
	}
}
