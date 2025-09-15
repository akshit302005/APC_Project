package com.example.ranking.api;

import com.example.ranking.model.MatchPayload;
import com.example.ranking.model.TeamRanking;
import com.example.ranking.service.RankingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rankings")
public class RankingController {

    private final RankingService rankingService;

    public RankingController(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    // Called from match-history-service
    @PostMapping("/update")
    public void updateRanking(@RequestBody MatchPayload matchPayload) {
        rankingService.updateRankings(matchPayload);
    }

    // For testing/viewing rankings
    @GetMapping("/all")
    public List<TeamRanking> getAllRankings() {
        return rankingService.getAllRankings();
    }
}
