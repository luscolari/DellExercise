package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Championship {
    private List<Team> teams;
    private Scanner scanner;

    private int ads = 0;

    public Championship(List<Team> teams) {
        if (teams.size() < 2 || teams.size() > 16 || teams.size() % 2 != 0) {
            throw new IllegalArgumentException("The championship must have a total pair and have 8 to 16 teams.");
        }
        this.teams = new ArrayList<>(teams);
        this.scanner = new Scanner(System.in);
    }

    public Team start() {
        Random rand = new Random();
        while (teams.size() > 1) {
            List<Team> winners = new ArrayList<>();
            Collections.shuffle(teams, rand);

            System.out.println("Do you want to apply a advrungh? 1 - yes; 2 - no");
            int choice = scanner.nextInt();

            if (choice == 1) {
                advrungh();
            } else {
                System.out.println("Rounds:");
                for (int i = 0; i < teams.size(); i += 2) {
                    Team team1 = teams.get(i);
                    Team team2 = teams.get(i + 1);
                    System.out.println((i / 2 + 1) + ": " + team1.getName() + " VS " + team2.getName());
                }

                boolean allMatchesCompleted = false;
                while (!allMatchesCompleted) {
                    System.out.println("Choose a round to administrate:" +
                            " (1-" + (teams.size() / 2) + "):");
                    int matchChoice = scanner.nextInt() - 1;

                    if (matchChoice >= 0 && matchChoice < teams.size() / 2) {
                        Team team1 = teams.get(matchChoice * 2);
                        Team team2 = teams.get(matchChoice * 2 + 1);
                        Match match = new Match(team1, team2);
                        Team winner = match.play();
                        winners.add(winner);
                    } else {
                        System.out.println("Unkown choice. Try again.");
                    }

                    allMatchesCompleted = winners.size() == teams.size() / 2;
                }

                teams = winners;
            }

        }
        return teams.get(0);
    }

    public void advrungh() {
        System.out.println("Choose a team to advrungh:");
        for (int i = 0; i < teams.size(); i++) {
            System.out.println((i + 1) + ": " + teams.get(i).getName());
        }
        int teamChoice = scanner.nextInt() - 1;
        if (teamChoice >= 0 && teamChoice < teams.size()) {
            int score = teams.get(teamChoice).getScore();
            teams.get(teamChoice).setScore(score - 10);
            ads = teams.get(teamChoice).getAdvs() + 1;
            teams.get(teamChoice).setAdvs(ads);
            System.out.println("Advrungh to" + teams.get(teamChoice).getName() + ". Points: " + teams.get(teamChoice).getScore());
        } else {
            System.out.println("Unkown choice. Try again.");
        }
    }

}


