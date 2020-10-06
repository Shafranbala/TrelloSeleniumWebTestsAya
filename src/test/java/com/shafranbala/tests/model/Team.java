package com.shafranbala.tests.model;

public class Team {
    private String teamName;
    private String teamType;


    public String getTeamName() {
        return teamName;
    }

    public String getTeamType() {
        return teamType;
    }

    public Team withTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public Team withTeamType(String teamType) {
        this.teamType = teamType;
        return this;
    }
}
