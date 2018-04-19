package org.aperture.com.controller;

import java.util.List;
import java.util.Map;

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
		Map<String, List<String>> results = wordsBySize.getWordsBySize(letters);
//		Map<String, List<String>> results = new HashMap<String, List<String>>();
//		List<String> a1 = new ArrayList<String>();
//		a1.add("a");
//		a1.add("b");
//		a1.add("c");
//		
//		List<String> a2 = new ArrayList<String>();
//		a2.add("aa");
//		a2.add("bb");
//		a2.add("cc");
//		
//		results.put("1", a1);
//		results.put("2", a2);
		
		
		model.addAttribute("letters", letters);
		model.addAttribute("results", results);
		return "results";
	}
}
