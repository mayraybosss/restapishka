package com.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    String FIND_BY_TITTLE_SEARCH = "SELECT * FROM events WHERE title = :title";

    @Query(value = FIND_BY_TITTLE_SEARCH, nativeQuery = false)
    List<Event> findByTitle(String title);
}

