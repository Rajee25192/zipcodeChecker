package com.zipcode.zipcodeChecker.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zipcode.zipcodeChecker.Repository.ValidatedRepository;
import com.zipcode.zipcodeChecker.Repository.ZipCodeRepository;
import com.zipcode.zipcodeChecker.entity.ZipCodes;
import com.zipcode.zipcodeChecker.service.ZipCodeService;

@Controller
@RequestMapping("/zipcodes/")
public class ZipCodeController {

	@Autowired
	private ZipCodeRepository zipcodeRepository;	
	
	@Autowired
	private ZipCodeService service;

	@Autowired
	private ValidatedRepository validateRepo;
	
	@GetMapping("showForm")
	public String showZipcodeForm(ZipCodes zipCodes) {
		return "add-zipcode";
	}
	
	@GetMapping("list")
	public String zipcodes(Model model) {
		model.addAttribute("zipCodes", this.zipcodeRepository.findAll());
		return "index";
	}
	
	@PostMapping("add")
	public String addZipCodes(@Valid ZipCodes zipCodes, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "add-zipcode";
		}
		
		this.zipcodeRepository.save(zipCodes);
		return "redirect:list";
	}
	
	@GetMapping("validate")
	public String validateZipCodes(Model model) {
		List<ZipCodes> zipcode = this.zipcodeRepository.findAll();
		service.mergeZipcodes(zipcode.stream().toArray(ZipCodes[]:: new));
		model.addAttribute("zipCodes", this.validateRepo.findAll());
		
		return "validated-zipcode";
	}

}
