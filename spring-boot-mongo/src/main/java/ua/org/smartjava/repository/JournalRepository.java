package ua.org.smartjava.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

import ua.org.smartjava.domain.Journal;

public interface JournalRepository extends MongoRepository<Journal, String> {
    public List<Journal> findByTitleLike(String word);
}
