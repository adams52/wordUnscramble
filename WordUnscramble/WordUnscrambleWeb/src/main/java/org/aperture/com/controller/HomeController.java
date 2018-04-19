package org.aperture.com.controller;

import java.util.Map;
import java.util.Set;

import org.aperture.com.utility.WordsBySize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@Autowired
	private WordsBySize wordsBySize;
	
	@GetMapping("/wordUnscramble")
	public String home(@RequestParam(name="letters") String letters, Model model) {
		Map<String, Set<String>> results = wordsBySize.getWordsBySize(letters);
		
		
		model.addAttribute("letters", letters);
		model.addAttribute("results", results);
		return "results";
	}
}
