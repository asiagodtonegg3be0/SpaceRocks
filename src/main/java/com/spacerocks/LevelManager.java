package com.spacerocks;

/*
a Level object would be created when the game is started
reset the object on losing back to 1
increase when level has been won
get level at start of new level gives number of asteroids to spawn
*/
public class LevelManager {
    private int level = 1;

    public int getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }

    private int highestScore = 0;
    public void increaseLevel(){ //level can only be increased by one at a time (or reset)
        level++;
    }
    public int getLevel(){
        return level;
    }
    public void resetToFirstLevel(){
        level = 1;
    }
    public void updateHighestScore(int highestScore) { this.highestScore += highestScore; }
}
