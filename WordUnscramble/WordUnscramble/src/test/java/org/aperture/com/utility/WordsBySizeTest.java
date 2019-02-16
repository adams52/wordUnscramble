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
	private MapDictionary dictionary;
	
	@Mock
	private Context context;
	
	@Mock
	private LambdaLogger logger;
	
	@InjectMocks
	private WordsBySize wordsBySize;
	
	private Set<String> wordList;
	private Map<String, Set<String>> results;
	
	@Before
	public void setup() {
		results = new HashMap<String, Set<String>>();
		
		wordList = new HashSet<String>();
		wordList.add("a");
		wordList.add("b");
		
		results.put("a", wordList);
		results.put("b", wordList);
	}
	
	@Test
	public void getWordsBySize() {
		Mockito.when(context.getLogger()).thenReturn(logger);
		
		WordsBySize size = new WordsBySize();
		
		
		Map<String, String> input = new HashMap<String, String>();
		input.put("letters", "odg");
		
		String results = size.getWordsBySize(input, context);
		
		String expectedResult = "{\"2\":[\"od\",\"go\",\"do\"],\"3\":[\"dog\",\"god\"]}";
		
		assertEquals(expectedResult, results);
	}
}
