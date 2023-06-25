package com.techincaltest.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.techincaltest.ecommerce.model.MerchandiseModel;
import com.techincaltest.ecommerce.model.MerchandiseRequest;
import com.techincaltest.ecommerce.repository.MerchandiseRepository;

@Service
public class MerchandiseService {
	@Autowired
	private MerchandiseRepository repository;
	
	@Cacheable(value="merchandise")
	public List<MerchandiseModel> displayCaterlog() {
		return repository.findAll();
	}
	
	@CacheEvict(value="merchandise", allEntries=true)
	public MerchandiseModel addMerchandise(MerchandiseRequest request) {
		MerchandiseModel model = new MerchandiseModel(request.getMerchandiseName(), request.getMerchandiseDescription(), request.getMerchandisePrice(), request.getMerchandiseImage());
		return repository.save(model);
	}
	
	@CacheEvict(value="merchandise", allEntries=true)
	public MerchandiseModel updateMerchandise(MerchandiseRequest request) {
		Optional<MerchandiseModel> model = repository.findById(request.getMerchandiseId());
		if(model.isPresent()) {
			if(request.getMerchandiseName() != null || request.getMerchandiseName() != "") {
				model.get().setMerchandiseName(request.getMerchandiseName());
			}
			if(request.getMerchandiseDescription() != null || request.getMerchandiseDescription() != "") {
				model.get().setMerchandiseDescription(request.getMerchandiseDescription());
			}
			if(request.getMerchandisePrice() != 0.0) {
				model.get().setMerchandisePrice(request.getMerchandisePrice());
			}
			if(request.getMerchandiseImage() != null || request.getMerchandiseImage() != "") {
				model.get().setMerchandiseImage(request.getMerchandiseImage());
			}
			return repository.save(model.get());
		}
		return null;
	}
	
	@CacheEvict(value="merchandise", allEntries=true)
	public boolean removeMerchandise(MerchandiseRequest request) {
		Optional<MerchandiseModel> model = repository.findById(request.getMerchandiseId());
		if(model.isPresent()) {
			repository.deleteById(model.get().getMerchandiseId());
		}
		return model.isPresent();
	}
}
