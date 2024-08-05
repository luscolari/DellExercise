package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static String name = null;
    static Register registration = new Register();
    static Scanner in = new Scanner(System.in);

    public void starting() {
        // Initialization logic if needed
    }

    public Register getRegistration() {
        return registration;
    }

    public void addTeam(String name, String scream, int founded) {
        Team team = new Team(name, scream, founded);
        registration.addTeams(team);
    }

    public void removeTeam(String name) {
        List<Team> teams = registration.getTeams();
        teams.removeIf(team -> team.getName().equals(name));
    }

    public List<Team> listTeams() {
        return registration.getTeams();
    }

    public Team startChampionship() {
        List<Team> teams = registration.getTeams();
        if (teams.size() < 2) {
            throw new IllegalArgumentException("At least two teams are required to start a championship.");
        }
        Championship championship = new Championship(teams);
        return championship.start();
    }
}
