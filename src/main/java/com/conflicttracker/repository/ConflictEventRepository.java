package com.conflicttracker.repository;

import com.conflicttracker.model.Conflict;
import com.conflicttracker.model.ConflictEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConflictEventRepository extends JpaRepository<ConflictEvent, Long> {
    List<ConflictEvent> findByConflict(Conflict conflict);
}