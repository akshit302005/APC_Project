package com.example.ranking.repo;

import com.example.ranking.model.TeamRanking;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TeamRankingRepository extends MongoRepository<TeamRanking, String> {
    Optional<TeamRanking> findByTeamName(String teamName);
}
