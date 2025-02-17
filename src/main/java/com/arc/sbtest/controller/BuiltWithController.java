package com.arc.sbtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.arc.sbtest.repository.BuiltWithRepository;

@Controller
@RequestMapping("/bw")
public class BuiltWithController 
{
	@Autowired
	BuiltWithRepository builtWithRepository;

	@GetMapping("/tech-stack")
	public String builtWith(Model model, @RequestParam(defaultValue="0") int page)
	{ 
		model.addAttribute("data", builtWithRepository.findAll(new PageRequest(page, 5)));
		return "built_with";
	}
}
