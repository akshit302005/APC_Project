package com.example.ranking.api;

import com.example.ranking.model.Team;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/ranking")
public class RankingController {

    private final Map<String, Integer> teamPoints = new HashMap<>();

    // Accept JSON in request body
    @PostMapping("/add")
    public String addResult(@RequestBody TeamRequest request) {
        String team = request.getTeam();
        int points = request.getPoints();
        teamPoints.put(team, teamPoints.getOrDefault(team, 0) + points);
        return "Points updated for " + team;
    }

    @GetMapping("/leaderboard")
    public List<Team> getLeaderboard() {
        List<Team> leaderboard = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : teamPoints.entrySet()) {
            leaderboard.add(new Team(entry.getKey(), entry.getValue()));
        }
        leaderboard.sort((a, b) -> b.getPoints() - a.getPoints());
        return leaderboard;
    }
}
