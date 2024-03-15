package com.proje.yemekapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.proje.yemekapp.Repositories.KurumRepository;
import com.proje.yemekapp.Repositories.MenuRepository;
import com.proje.yemekapp.Repositories.YemekRepository;
import com.proje.yemekapp.Utils.CreateTestData;

@SpringBootApplication

public class YemekappApplication {

	@Autowired
	KurumRepository kurumRepository;

	public static void main(String[] args ) {
		SpringApplication.run(YemekappApplication.class, args);

	}

	@Bean
	CommandLineRunner dbTester(
		KurumRepository kurumRepository,
		YemekRepository yemekRepository,
		MenuRepository yemekListeRepository,
		CreateTestData createTestData){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				createTestData.createDbTestData(kurumRepository,yemekListeRepository,yemekRepository);
			}			
		};
	}

}
