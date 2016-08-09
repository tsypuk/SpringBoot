package ua.org.smartjava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import ua.org.smartjava.domain.Journal;
import ua.org.smartjava.repository.JournalRepository;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Controller
public class JournalController {

    @Autowired
    JournalRepository journalRepository;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("journal", journalRepository.findAll());
        return "index";
    }

    @RequestMapping(value = "/journal", produces = {APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody List<Journal> getJournla() {
        return journalRepository.findAll();
    }
}