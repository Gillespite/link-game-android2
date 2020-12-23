package com.example.new3;

public class item_data {
    private String name;
    private int score;
    private int level;

    public item_data(String name, int score, int level){
        this.name=name;
        this.score=score;
        this.level=level;
    }
    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
