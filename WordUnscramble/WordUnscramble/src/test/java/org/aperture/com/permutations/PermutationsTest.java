package org.aperture.com.permutations;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PermutationsTest {
	
	private Permutations permutations;
	private Set<String> expectedResult;
	
	@Before
	public void setup() {
		permutations = new Permutations();
		expectedResult = new HashSet<String>();
	}
	
	@After
	public void tearDown() {
		expectedResult = null;
	}
	
	@Test
	public void testPossibleCombinationsNull() {
		Set<String> combos = permutations.possibleCombinations(null);
		
		assertTrue(combos.size()==0);
	}
	
	@Test
	public void testPossibleCombinationsEmptyString() {
		Set<String> combos = permutations.possibleCombinations("");
		
		assertTrue(combos.size()==0);
	}

	@Test
	public void testPossibleCombinationsOneLetter() {
		Set<String> combos = permutations.possibleCombinations("a");
		
		assertTrue(combos.size()==1);
		assertTrue(combos.contains("a"));
	}
	
	@Test
	public void testPossibleCombinationsTwoLetters() {
		Set<String> combos = permutations.possibleCombinations("ab");
		
		expectedResult.add("ab");
		
		assertTrue(combos.size()==1);
		assertTrue(combos.containsAll(expectedResult));
	}
	
	@Test
	public void testPossibleCombinationsThreeLetters() {
		Set<String> combos = permutations.possibleCombinations("bca");
		
		expectedResult.add("ab");
		expectedResult.add("ac");
		expectedResult.add("bc");
		expectedResult.add("abc");
		
		assertTrue(combos.size()==4);
		assertTrue(combos.containsAll(expectedResult));
	}
	
	@Test
	public void testPossibleCombinationsFourLetters() {
		Set<String> combos = permutations.possibleCombinations("dcba");
		
		expectedResult.add("ab");
		expectedResult.add("ac");
		expectedResult.add("ad");
		expectedResult.add("bc");
		expectedResult.add("bd");
		expectedResult.add("cd");
		expectedResult.add("abc");
		expectedResult.add("abd");
		expectedResult.add("acd");
		expectedResult.add("bcd");
		expectedResult.add("abcd");
		
		assertTrue(combos.size()==11);
		assertTrue(combos.containsAll(expectedResult));
	}

}
