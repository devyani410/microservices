package com.microservice.InventoryService;

import com.microservice.InventoryService.Repository.InventoryRepositry;
import com.microservice.InventoryService.model.Inventory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
   @Bean
	public CommandLineRunner loadData(InventoryRepositry inventoryRepositry){
		return args -> {
			Inventory inventory=new Inventory();
			inventory.setSkuCode("iphone_14_max_pro");
			inventory.setQuanity(100);

			Inventory inventory1=new Inventory();
			inventory1.setSkuCode("iphone_14");
			inventory1.setQuanity(0);

			inventoryRepositry.save(inventory);
			inventoryRepositry.save(inventory1);

		};
   }
}
