package ua.org.smartjava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ua.org.smartjava.service.JournalService;

@SpringBootApplication
public class SpringBootJpaAppApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootJpaAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaAppApplication.class, args);
	}

	@Bean
	CommandLineRunner start(JournalService service) {
		return args -> {
			LOGGER.info("Inserting Data.");
			service.insertData();
			LOGGER.info("FindAll cata.");
			service.findAll().forEach(entry -> LOGGER.info(entry.toString()));
		};
	}
}
