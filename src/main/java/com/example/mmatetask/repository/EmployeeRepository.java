package com.example.mmatetask.repository;

import com.example.mmatetask.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "SELECT e FROM Employee e WHERE e.salesPeriod<=:periodLimit")
    List<Employee> findAllEligibleForReport (Integer periodLimit);

}
