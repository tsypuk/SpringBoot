package ua.org.smartjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.org.smartjava.domain.Journal;

public interface JournalRepository extends JpaRepository<Journal, Long> {

}