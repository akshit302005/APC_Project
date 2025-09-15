package com.example.matchhistory.repo;

import com.example.matchhistory.model.MatchEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatchEventRepository extends MongoRepository<MatchEvent, String> {
}
