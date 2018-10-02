package com.mii.sakura;

import com.mii.sakura.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories(repositoryFactoryBeanClass=UserRepository.class)
@SpringBootApplication
public class SakuraHtmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SakuraHtmlApplication.class, args);
	}
}
