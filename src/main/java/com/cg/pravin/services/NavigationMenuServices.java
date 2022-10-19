package com.cg.pravin.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pravin.modal.NavgationMenu;
import com.cg.pravin.repository.NavgationMenuRepository;

@Service
public class NavigationMenuServices {

	@Autowired
	private NavgationMenuRepository naviMenuRepository;
	
	private static final Logger LOG = LoggerFactory.getLogger(NavigationMenuServices.class);
	
	public List<NavgationMenu> getAll(){
		return naviMenuRepository.findAll();
	}
	
	public NavgationMenu saveNavbarOption(NavgationMenu navobj) {
		LOG.info("saveNavbarOption service");
		return naviMenuRepository.save(navobj);
	}
}
