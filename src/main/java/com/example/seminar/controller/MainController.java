package com.example.seminar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.seminar.model.DBFile;
import com.example.seminar.model.fileI;
import com.example.seminar.service.DBFileStorageService;

@Controller
public class MainController {
	
	@Autowired
    private DBFileStorageService dbFileStorageService;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
    
	@GetMapping("/listFiles")
	public String listFirstPage(Model model) {
		return findPaginated(1, "file_name", "asc", model);
	}
  
    @GetMapping("/files/delete")
	public String deleteFiles(@RequestParam String id) {
		
    	dbFileStorageService.deleteById(id);
		
		return "redirect:/listFiles";
	}
    
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
        @RequestParam("sortField") String sortField,
        @RequestParam("sortDir") String sortDir,
        Model model) {
        int pageSize = 5;

        Page < fileI > page = dbFileStorageService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List < fileI > listFiles = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listFiles", listFiles);
        return "listFiles";
    }
}