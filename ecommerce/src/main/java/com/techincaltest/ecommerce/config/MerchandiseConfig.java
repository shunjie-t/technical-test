package com.techincaltest.ecommerce.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.techincaltest.ecommerce.model.MerchandiseModel;
import com.techincaltest.ecommerce.repository.MerchandiseRepository;

@Configuration
public class MerchandiseConfig {
	@Bean
    public CommandLineRunner commandLineRunner(MerchandiseRepository repository) {
		MerchandiseModel Item1 = new MerchandiseModel("Wine","Port Late Bottled Vintage",9.61,"http://dummyimage.com/217x100.png/cc0000/ffffff");
		MerchandiseModel Item2 = new MerchandiseModel("Tart Shells","Savory, 3",3.72,"http://dummyimage.com/136x100.png/cc0000/ffffff");
		MerchandiseModel Item3 = new MerchandiseModel("Liquor","Bacardi Mojito",40.88,"http://dummyimage.com/214x100.png/dddddd/000000");
		MerchandiseModel Item4 = new MerchandiseModel("Sugar","Raw sugar",3.59,"http://dummyimage.com/189x100.png/5fa2dd/ffffff");
		return args -> {
			repository.saveAll(List.of(Item1, Item2, Item3, Item4));
		};
	}
}
