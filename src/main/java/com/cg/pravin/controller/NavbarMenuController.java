package com.cg.pravin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pravin.modal.NavgationMenu;
import com.cg.pravin.services.NavigationMenuServices;

@RestController
@CrossOrigin("*")
@RequestMapping("/navmenu")
public class NavbarMenuController {

	@Autowired
	private NavigationMenuServices navgationmenuservices;
	
	private static final Logger LOG = LoggerFactory.getLogger(NavbarMenuController.class);
	
	@GetMapping("/getallnavs")
	public List<NavgationMenu> getAllNavs(){
		LOG.info("getAll Navs Controller");
		return navgationmenuservices.getAll(); 
	}
	
	@PostMapping("/savemenu")
	public NavgationMenu saveNavMenu(@RequestBody NavgationMenu navmenu) {
		LOG.info("saveNavMenu controller");
		NavgationMenu nav = navgationmenuservices.saveNavbarOption(navmenu);
		LOG.info("response returned");
		return nav;
	}
	
	
}
