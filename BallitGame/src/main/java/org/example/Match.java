package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Match {
    private Team team1;
    private Team team2;
    private int score1;
    private int score2 ;

    private int b1 = 0;

    private int b2 = 0;

    private int p1 = 0;

    private int p2 = 0;

    private int ads1 = 0;

    private int ads2 = 0;
    private final List<Team> collection;
    private Scanner scanner;

    public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        this.collection = new ArrayList<Team>();
        this.scanner = new Scanner(System.in);
        score1 = 50;
        score2 = 50;
    }

    public Team play() {
        System.out.println("Match: " + team1.getName() + " VS " + team2.getName());
        System.out.println(team1.getName() + ": " + team1.getScore() + " points");
        System.out.println(team2.getName() + ": " + team2.getScore() + " points");
        boolean finished = false;

        while (!finished) {
            System.out.println("Choose an action: \n1. Blot to " + team1.getName() +
                    "\n2. Blot to " + team2.getName() + "\n3. Plif to " + team1.getName() +
                    "\n4. Plif to " + team1.getName() + "\n5. Encerrar partida" + "\n6. Advrungh");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    score1 += 5;
                    b1++;
                    break;
                case 2:
                    score2 += 5;
                    team2.setScore(score1);
                    b2++;
                    break;
                case 3:
                    score1 += 1;
                    team1.setScore(score1);
                    p1++;
                    break;
                case 4:
                    score2 += 1;

                    p2++;
                    break;
                case 5:
                    finished = true;
                    break;

                case 6:
                    advrungh();
                    break;
                default:
                    System.out.println("Unkwon choice. Try again!.");
            }
            System.out.println(team1.getName() + ": " + score1 + " points");
            System.out.println(team2.getName() + ": " + score2 + " points");
            team1.setScore(score1);
            team2.setScore(score2);
            team1.setBlots(b1);
            team2.setBlots(b2);
            team1.setPlifs(p1);
            team2.setPlifs(p2);
        }

        if (score1 == score2) {
            System.out.println("Its a tie! Break the tie with grusht.");
            grusht();
        }

        return score1 > score2 ? team1 : team2;
    }

    private void grusht() {
        System.out.println("Which scream was louder? (1 - " +
                team1.getName() + " 2 - " + team2.getName());
        String finalAnswer = scanner.next();

        if(finalAnswer.equals( team1.getName())){
            score1+= 3;
        } else{
            score1+=3;
        }
    }

    private void advrungh() {
        System.out.println("Choose a team to advrungh:");
        System.out.println("1: " + team1.getName());
        System.out.println("2: " + team2.getName());
        int teamChoice = scanner.nextInt();
        if (teamChoice == 1) {
            score1 -= 10;
            ads1++;
        } else if (teamChoice == 2) {
            score2 -= 10;
            ads2++;
        } else {
            System.out.println("Unkown choice. Try again.");
        }
        team1.setAdvs(ads1);
        team2.setAdvs(ads2);
        team1.setScore(score1);
        team2.setScore(score2);
    }


}

