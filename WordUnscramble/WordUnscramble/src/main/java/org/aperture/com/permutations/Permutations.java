package org.aperture.com.permutations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Permutations {
	
	public Set<String> possibleCombinations(String letters) {
		if (letters == null || letters.length() == 0) {
			return new HashSet<String>();
		}
		
		String localLetters = letters.toLowerCase();
		
		Set<String> combos = new HashSet<String>();
		if (localLetters.length() == 1) {
			combos.add(localLetters);
			return combos;
		}
		
		
		char[] array = localLetters.toCharArray();
		
		Arrays.sort(array);
		
		String sortedLetters = String.valueOf(array);
		combos.add(sortedLetters);
		
		StringBuilder newString;
		for (int x = 0; x < sortedLetters.length(); x++) {
			newString = new StringBuilder(sortedLetters);
			newString.deleteCharAt(x);
			combos.addAll(possibleCombinations(newString.toString()));
		}
		
		return combos;
	}
}
