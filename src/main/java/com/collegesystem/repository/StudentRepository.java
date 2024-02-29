package com.collegesystem.repository;

import com.collegesystem.documents.Students;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepository extends MongoRepository<Students,String> {
    List<Students> findByName(String name);
    Students findByRoll(String roll);
    List<Students> findByGroup(String group);
    List<Students> findByYear(String year);
  
}
