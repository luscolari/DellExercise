package org.example;
public class Team {
    private String name, scream;
    private int founded, score, blots, plifs, advs;

    public Team(){
        name = null;
        scream = null;
        founded = 0;
        score = 50;
        blots = 0;
        plifs = 0;
        advs = 0;
    }
    public Team(String name, String scream, int foundationYear){
        this.name = name;
        this.scream = scream;
        this.founded = foundationYear;
        this.score = 50;
        score = 50;
        blots = 0;
        plifs = 0;
        advs = 0;
    }

    @Override
    public String toString() {
        return "org.example.org.example.Team{" +
                "name='" + name + '\'' +
                ", scream='" + scream + '\'' +
                ", year of foudantion='" + founded + '\'' +
                ", blots='" + blots + '\'' +
                ", plifs='" + plifs + '\'' +
                ", advs='" + advs + '\'' +
                ", score='" + score + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore (){
        return score;
    }

    public String getScream() {
        return scream;
    }

    public int getAdvs() {
        return advs;
    }

    public int getBlots() {
        return blots;
    }

    public void setPlifs(int plifs) {
        this.plifs = plifs;
    }

    public void setAdvs(int advs) {
        this.advs = advs;
    }

    public void setBlots(int blots) {
        this.blots = blots;
    }

    public int getPlifs() {
        return plifs;
    }

    public int getFounded() {
        return founded;
    }
}
