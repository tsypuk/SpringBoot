package ua.org.smartjava.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ua.org.smartjava.domain.Journal;
import ua.org.smartjava.repository.JournalRepository;

@Service
public class JournalService {
    private static final Logger LOGGER = LoggerFactory.getLogger(JournalService.class);
    @Autowired
    JournalRepository journalRepository;

    public void insertData() throws ParseException {
        LOGGER.info("> Inserting data...");
        journalRepository.save(new Journal("title1", "summary1", "01/01/2016"));
        journalRepository.save(new Journal("title2", "summary2", "02/02/2016"));
        journalRepository.save(new Journal("title3", "summary3", "03/03/2016"));
        LOGGER.info("> Done.");
    }

    public List<Journal> findAll() {
        return journalRepository.findAll();
    }
}