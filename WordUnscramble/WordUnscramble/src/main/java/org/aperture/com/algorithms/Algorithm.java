package org.aperture.com.algorithms;

import java.util.Map;
import java.util.Set;

import org.aperture.com.utility.MapDictionary;

public interface Algorithm {
	
	public Map<String, Set<String>> getWordsBySize(String letters, MapDictionary dictionary);
}
