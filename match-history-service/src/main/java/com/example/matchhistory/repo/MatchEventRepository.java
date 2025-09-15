package com.example.matchhistory.repo;

import com.example.matchhistory.model.MatchEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchEventRepository extends MongoRepository<MatchEvent, String> {}
