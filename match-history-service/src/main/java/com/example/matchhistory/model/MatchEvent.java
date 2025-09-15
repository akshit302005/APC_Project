package com.example.matchhistory.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "match_events")
public class MatchEvent {
    @Id
    private String id;

    private String teamA;
    private String teamB;
    private int scoreA;
    private int scoreB;
    private LocalDateTime matchTime;

    public MatchEvent() {}

    public MatchEvent(String teamA, String teamB, int scoreA, int scoreB, LocalDateTime matchTime) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
        this.matchTime = matchTime;
    }

    // Getters & Setters
    public String getId() { return id; }
    public String getTeamA() { return teamA; }
    public void setTeamA(String teamA) { this.teamA = teamA; }
    public String getTeamB() { return teamB; }
    public void setTeamB(String teamB) { this.teamB = teamB; }
    public int getScoreA() { return scoreA; }
    public void setScoreA(int scoreA) { this.scoreA = scoreA; }
    public int getScoreB() { return scoreB; }
    public void setScoreB(int scoreB) { this.scoreB = scoreB; }
    public LocalDateTime getMatchTime() { return matchTime; }
    public void setMatchTime(LocalDateTime matchTime) { this.matchTime = matchTime; }
}
