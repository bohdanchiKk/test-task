package org.example.testtask.repository;

import org.example.testtask.dto.DepartmentStatisticsDTO;
import org.example.testtask.entity.Department;
import org.hibernate.annotations.processing.Find;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Optional<Department> findByName(String department);
    @Query("SELECT new org.example.testtask.dto.DepartmentStatisticsDTO("
            + "SUM(CASE WHEN l.degree = 'assistant' THEN 1 ELSE 0 END), "
            + "SUM(CASE WHEN l.degree = 'associate_professor' THEN 1 ELSE 0 END), "
            + "SUM(CASE WHEN l.degree = 'professor' THEN 1 ELSE 0 END)) "
            + "FROM Department d "
            + "LEFT JOIN d.lectors l "
            + "WHERE d.name = :name")
    DepartmentStatisticsDTO findByNameWithLectors(@Param("name") String name);
}
