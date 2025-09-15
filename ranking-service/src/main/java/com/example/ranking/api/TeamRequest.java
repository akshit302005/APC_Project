package com.example.ranking.api;

public class TeamRequest {
    private String team;
    private int points;

    public TeamRequest() {}

    public String getTeam() { return team; }
    public void setTeam(String team) { this.team = team; }

    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }
}
