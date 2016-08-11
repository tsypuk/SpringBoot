package ua.org.smartjava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ua.org.smartjava.domain.Journal;
import ua.org.smartjava.repository.JournalRepository;

@SpringBootApplication
public class SpringMongoAppApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringMongoAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoAppApplication.class, args);
	}

	@Bean
	CommandLineRunner start(JournalRepository journalRepository) {
		return args -> {
			LOGGER.info("Deleting data.");
			journalRepository.deleteAll();

			LOGGER.info("Inserting data.");
			journalRepository.save(new Journal("title1", "summary1", "01/01/2016"));
			journalRepository.save(new Journal("title2", "summary2", "01/01/2016"));
			journalRepository.save(new Journal("title3", "summary3", "01/01/2016"));
			journalRepository.save(new Journal("title4", "summary4", "01/01/2016"));
			journalRepository.save(new Journal("title5", "summary5", "01/01/2016"));

			LOGGER.info("Getting data.");
			journalRepository.findAll().forEach(entry -> LOGGER.info(entry.toString()));

		};
	}
}