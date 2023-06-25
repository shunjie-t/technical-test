package com.techincaltest.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techincaltest.ecommerce.model.MerchandiseModel;
import com.techincaltest.ecommerce.model.MerchandiseRequest;
import com.techincaltest.ecommerce.service.MerchandiseService;

@RestController
@RequestMapping(path = "/merchandise")
@CrossOrigin("*")
public class MerchandiseController {
	@Autowired
	private MerchandiseService merchandizeService;
	
	@GetMapping("/retrieve")
	public List<MerchandiseModel> displayCaterlog() {
		return merchandizeService.displayCaterlog();
	}
	
	@PostMapping("/add")
	public void addMerchandise(@RequestBody MerchandiseRequest request) {
		merchandizeService.updateMerchandise(request);
	}
	
	@PostMapping("/update")
	public void updateMerchandise(@RequestBody MerchandiseRequest request) {
		merchandizeService.updateMerchandise(request);
	}

	@PostMapping("/remove")
	public void removeMerchandise(@RequestBody MerchandiseRequest request) {
		merchandizeService.removeMerchandise(request);
	}
}
