package com.techpro.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techpro.project.model.People;

@Repository
public interface PeopleRepository extends CrudRepository<People, Integer> {
    People findByEmail(String email);
}

//public interface DepartmentRepository extends JpaRepository<Department, Long> {}
//public interface DepartmentRepository extends CrudRepository<Department, Long> {}
