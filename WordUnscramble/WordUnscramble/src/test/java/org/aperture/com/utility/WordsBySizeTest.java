package org.aperture.com.utility;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.aperture.com.permutations.Permutations;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WordsBySizeTest {
	
	@Mock
	private Permutations permutations;
	
	@Mock
	private MapDictionary dictionary;
	
	@InjectMocks
	private WordsBySize wordsBySize;
	
	private Set<String> expectedResults;
	private List<String> wordList;
	private Map<String, List<String>> results;
	
	@Before
	public void setup() {
		expectedResults = new HashSet<String>();
		expectedResults.add("a");
		expectedResults.add("b");
		
		results = new HashMap<String, List<String>>();
		
		wordList = new ArrayList<String>();
		wordList.add("a");
		wordList.add("b");
		
		results.put("a", wordList);
		results.put("b", wordList);
	}
	
	@Test
	public void getWordsBySize() {
		Mockito.when(permutations.possibleCombinations(Mockito.anyString())).thenReturn(expectedResults);
		Mockito.when(dictionary.getDictionary()).thenReturn(results);
		Mockito.when(dictionary.getDictionary()).thenReturn(results);
		
		Map<String, List<String>> wordList = wordsBySize.getWordsBySize("abc");
		
		Mockito.verify(dictionary).populateDictionary(WordsBySize.DICTIONARY_ENABLE);
		
		
		assertTrue(wordList.keySet().size()==1);
		assertTrue(wordList.get("1").size()==4);
	}
}
