package org.example.testtask.repository;

import org.example.testtask.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectorRepository extends JpaRepository<Lector,Long> {
    @Query("SELECT l FROM Lector l WHERE LOWER(l.firstName) LIKE LOWER(CONCAT('%', :regex, '%')) " +
            "OR LOWER(l.lastName) LIKE LOWER(CONCAT('%', :regex, '%'))")
    List<Lector> globalSearch(String regex);
}
