package org.aperture.com.algorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.Set;

import org.aperture.com.dictionary.MapDictionary;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PermutationAlgorithmTest {
	
	private Algorithm permAlgo = new PermutationAlgorithm();
	private Algorithm mapAlgo = new PermutationAlgorithm();
	
	private String DICTIONARY_ENABLE = "dictionaries/enable.txt";
	
	private MapDictionary dictionary;
	
	@Before
	public void setup() {
		dictionary = new MapDictionary();
		dictionary.populateDictionary(DICTIONARY_ENABLE);
	}
	
	@Test
	public void compareAlgorithms() {
		Map<String, Set<String>> wordsBySizePerm = permAlgo.getWordsBySize("asdfuipo", dictionary);
		Map<String, Set<String>> wordsBySizeMap = mapAlgo.getWordsBySize("asdfuipo", dictionary);
		
		assertEquals(wordsBySizeMap, wordsBySizePerm);
		assertTrue(wordsBySizeMap.size() > 0);
	}
}
