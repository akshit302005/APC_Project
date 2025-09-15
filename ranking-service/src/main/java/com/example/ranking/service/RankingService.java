package com.example.ranking.service;

import com.example.ranking.model.MatchPayload;
import com.example.ranking.model.TeamRanking;
import com.example.ranking.repo.TeamRankingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingService {

    private final TeamRankingRepository rankingRepository;

    public RankingService(TeamRankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }

    public void updateRankings(MatchPayload matchPayload) {
        String teamA = matchPayload.getTeamA();
        String teamB = matchPayload.getTeamB();
        int scoreA = matchPayload.getScoreA();
        int scoreB = matchPayload.getScoreB();

        TeamRanking rankingA = rankingRepository.findByTeamName(teamA)
                .orElse(new TeamRanking(teamA, 0));
        TeamRanking rankingB = rankingRepository.findByTeamName(teamB)
                .orElse(new TeamRanking(teamB, 0));

        if (scoreA > scoreB) {
            rankingA.setPoints(rankingA.getPoints() + 3);
        } else if (scoreB > scoreA) {
            rankingB.setPoints(rankingB.getPoints() + 3);
        } else {
            rankingA.setPoints(rankingA.getPoints() + 1);
            rankingB.setPoints(rankingB.getPoints() + 1);
        }

        rankingRepository.save(rankingA);
        rankingRepository.save(rankingB);
    }

    public List<TeamRanking> getAllRankings() {
        return rankingRepository.findAll();
    }
}
