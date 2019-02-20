package com.stackroute.pie.repository;

import com.stackroute.pie.domain.Insurer;
import com.stackroute.pie.domain.Policy;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.*;

public interface ExternalDbRepository extends MongoRepository<Insurer,Long> {

    List<Policy> findByInsurerName(String insurerName);



}
