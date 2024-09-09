package com.hexaware.app.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.app.Entity.Student;

@Repository
public interface RepStudent extends CrudRepository<Student, Integer> {

}
