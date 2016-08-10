package ua.org.smartjava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ua.org.smartjava.service.JournalService;

@SpringBootApplication
public class SpringBootJdbcAppApplication implements CommandLineRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootJdbcAppApplication.class);

	@Autowired
	private JournalService journalService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcAppApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		LOGGER.info("Inserting data.");
		journalService.insertData();
		LOGGER.info("FindAll call.");
		journalService.findAll().forEach(entry -> LOGGER.info(entry.toString()));
	}
}
