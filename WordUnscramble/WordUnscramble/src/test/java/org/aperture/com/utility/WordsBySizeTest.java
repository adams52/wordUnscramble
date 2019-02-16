package org.aperture.com.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
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

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

@RunWith(MockitoJUnitRunner.class)
public class WordsBySizeTest {
	
	@Mock
	private Permutations permutations;
	
	@Mock
	private MapDictionary dictionary;
	
	@Mock
	private Context context;
	
	@Mock
	private LambdaLogger logger;
	
	@InjectMocks
	private WordsBySize wordsBySize;
	
	private Set<String> expectedResults;
	private Set<String> wordList;
	private Map<String, Set<String>> results;
	
	@Before
	public void setup() {
		expectedResults = new HashSet<String>();
		expectedResults.add("a");
		expectedResults.add("b");
		
		results = new HashMap<String, Set<String>>();
		
		wordList = new HashSet<String>();
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
		Mockito.when(context.getLogger()).thenReturn(logger);
		
		Map<String, String> input = new HashMap<String, String>();
		input.put("letters", "abc");
		
		Map<String, Set<String>> wordList = wordsBySize.getWordsBySize(input, context);
		
		
		assertEquals(wordList.keySet().size(),1);
		assertEquals(wordList.get("1").size(),2);
	}
}
