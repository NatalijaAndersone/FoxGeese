package com.example.fg;

public class Table {
    private int place;
    private String name;
    private int score;
    // Constructor to cellect data for results table
    public Table(int place, String name, int score) {
        this.place = place;
        this.name = name;
        this.score = score;
    }

    public int getPlace() {
        return place;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override   // Forms the line in results table
    public String toString(){
        if (name.length() <= 7) {
            return " " + place + "\t\t\t"+ name + "    \t\t\t\t"+ score;
        } else {
            return " " + place + "\t\t\t"+ name + "    \t\t\t"+ score;
        }
    }
}
