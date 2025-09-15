package com.example.ranking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rankings")
public class TeamRanking {

    @Id
    private String id;
    private String teamName;
    private int points;

    public TeamRanking() {}

    public TeamRanking(String teamName, int points) {
        this.teamName = teamName;
        this.points = points;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }

    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }
}
