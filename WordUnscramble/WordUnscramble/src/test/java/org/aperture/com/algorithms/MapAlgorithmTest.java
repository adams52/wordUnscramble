package org.aperture.com.algorithms;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.aperture.com.dictionary.MapDictionary;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MapAlgorithmTest {
	
	private String DICTIONARY_ENABLE = "dictionaries/enable.txt";
	
	private MapDictionary dictionary;
	
	private MapAlgorithm algo;
	
	
	@Before
	public void setup() {
		dictionary = new MapDictionary();
		dictionary.populateDictionary(DICTIONARY_ENABLE);
		algo = new MapAlgorithm();
	}
	
	@Test
	public void getWordsBySize() {
		String expectedResults = "{2=[od, go, do], 3=[dog, god]}";
		assertEquals(expectedResults, algo.getWordsBySize("odg", dictionary).toString());
	}
	
	@Test
	public void getLetterCountTest() {
		Map<Character, Integer> letterCount = algo.getLetterCount("afsdfff");
		assertEquals(letterCount.get('a'), (Integer)1);
		assertEquals(letterCount.get('s'), (Integer)1);
		assertEquals(letterCount.get('d'), (Integer)1);
		assertEquals(letterCount.get('f'), (Integer)4);
		assertEquals(letterCount.get('z'), null);
	}
}
