package org.aperture.com.controller;

import java.util.Map;
import java.util.Set;

import org.aperture.com.permutations.Permutations;
import org.aperture.com.utility.MapDictionary;
import org.aperture.com.utility.WordsBySize;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	
	@CrossOrigin(origins = "*")
	@GetMapping("/wordUnscramble")
	public String home(@RequestParam(name="letters") String letters, Model model) {
		WordsBySize wordsBySize = new WordsBySize();
		MapDictionary dictionary = new MapDictionary();
		Permutations perm = new Permutations();
		
		wordsBySize.setDictionary(dictionary);
		wordsBySize.setPermutations(perm);
		
		Map<String, Set<String>> results = wordsBySize.getWordsBySize(letters);
		
		JSONObject jsonObject = new JSONObject(results);
		
		model.addAttribute("letters", letters);
		model.addAttribute("results", results);
		
		
		return "results";//jsonObject.toString();
	}
}
