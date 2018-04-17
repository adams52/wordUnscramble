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
		expectedKeys.add("AA");
		expectedKeys.add("AB");
		expectedKeys.add("ABC");
		expectedKeys.add("ABD");
		
		dictionary.populateDictionary("dictionaries/testWordList.txt");
		
		assertEquals(dictionary.getDictionary().keySet().size(), 4);
		assertEquals(dictionary.getDictionary().keySet(), expectedKeys);
		assertEquals(dictionary.getDictionary().get("AA").size(), 1);
		assertEquals(dictionary.getDictionary().get("AB").size(), 1);
		assertEquals(dictionary.getDictionary().get("ABC").size(), 1);
		assertEquals(dictionary.getDictionary().get("ABD").size(), 2);
	}

}
