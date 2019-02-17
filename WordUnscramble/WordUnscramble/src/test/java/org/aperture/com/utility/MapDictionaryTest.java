package org.aperture.com.utility;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.aperture.com.dictionary.MapDictionary;
import org.junit.Before;
import org.junit.Test;

public class MapDictionaryTest {
	
	private MapDictionary dictionary;
	private Set<String> expectedKeys;
	
	@Before
	public void setup() {
		dictionary = new MapDictionary();
		expectedKeys = new HashSet<String>();
	}

	@Test
	public void testPopulateDictionary() {
		dictionary.populateDictionary("dictionaries/testWordList.txt");
		expectedKeys.add("aa");
		expectedKeys.add("ab");
		expectedKeys.add("abc");
		expectedKeys.add("abd");
		
		assertEquals(dictionary.getDictionary().keySet().size(), 4);
		assertEquals(dictionary.getDictionary().keySet(), expectedKeys);
		assertEquals(dictionary.getDictionary().get("aa").getWords().size(), 1);
		assertEquals(dictionary.getDictionary().get("ab").getWords().size(), 1);
		assertEquals(dictionary.getDictionary().get("abc").getWords().size(), 1);
		assertEquals(dictionary.getDictionary().get("abd").getWords().size(), 2);
		
		assertEquals(dictionary.getDictionary().get("aa").getLetterCount().get('a'), (Integer)2);
		assertEquals(dictionary.getDictionary().get("ab").getLetterCount().get('a'), (Integer)1);
		assertEquals(dictionary.getDictionary().get("ab").getLetterCount().get('b'), (Integer)1);
		assertEquals(dictionary.getDictionary().get("abc").getLetterCount().get('a'), (Integer)1);
		assertEquals(dictionary.getDictionary().get("abd").getLetterCount().get('a'), (Integer)1);
	}

}
