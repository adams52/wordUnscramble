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
		assertTrue(combos.contains("A"));
	}
	
	@Test
	public void testPossibleCombinationsTwoLetters() {
		Set<String> combos = permutations.possibleCombinations("ab");
		
		expectedResult.add("A");
		expectedResult.add("B");
		expectedResult.add("AB");
		
		assertTrue(combos.size()==3);
		assertTrue(combos.containsAll(expectedResult));
	}
	
	@Test
	public void testPossibleCombinationsThreeLetters() {
		Set<String> combos = permutations.possibleCombinations("bca");
		
		expectedResult.add("A");
		expectedResult.add("B");
		expectedResult.add("C");
		expectedResult.add("AB");
		expectedResult.add("AC");
		expectedResult.add("BC");
		expectedResult.add("ABC");
		
		assertTrue(combos.size()==7);
		assertTrue(combos.containsAll(expectedResult));
	}
	
	@Test
	public void testPossibleCombinationsFourLetters() {
		Set<String> combos = permutations.possibleCombinations("dcba");
		
		expectedResult.add("A");
		expectedResult.add("B");
		expectedResult.add("C");
		expectedResult.add("D");
		expectedResult.add("AB");
		expectedResult.add("AC");
		expectedResult.add("AD");
		expectedResult.add("BC");
		expectedResult.add("BD");
		expectedResult.add("CD");
		expectedResult.add("ABC");
		expectedResult.add("ABD");
		expectedResult.add("ACD");
		expectedResult.add("BCD");
		expectedResult.add("ABCD");
		
		assertTrue(combos.size()==15);
		assertTrue(combos.containsAll(expectedResult));
	}

}
