package org.aperture.com.utility;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

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
		expectedKeys.add("aa");
		expectedKeys.add("ab");
		expectedKeys.add("abc");
		expectedKeys.add("abd");
		
		dictionary.populateDictionary("dictionaries/testWordList.txt");
		
		assertEquals(dictionary.getDictionary().keySet().size(), 4);
		assertEquals(dictionary.getDictionary().keySet(), expectedKeys);
		assertEquals(dictionary.getDictionary().get("aa").size(), 1);
		assertEquals(dictionary.getDictionary().get("ab").size(), 1);
		assertEquals(dictionary.getDictionary().get("abc").size(), 1);
		assertEquals(dictionary.getDictionary().get("abd").size(), 2);
	}

}
