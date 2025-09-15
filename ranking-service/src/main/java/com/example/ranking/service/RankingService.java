package com.example.ranking.service;

import com.example.ranking.model.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class RankingService {
    public List<Team> getRankings() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("Team A", 10));
        teams.add(new Team("Team B", 15));
        teams.add(new Team("Team C", 8));
        teams.sort(Comparator.comparingInt(Team::getPoints).reversed());
        return teams;
    }
}
