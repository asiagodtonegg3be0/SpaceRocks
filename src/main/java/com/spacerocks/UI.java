package com.spacerocks;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class UI {
    private final Pane gamePane;

    private final Text scoreText = new Text(10, 30, "Score:");
    private Text scoreValue = new Text (75, 31, "0");

    private final Text livesText = new Text(400, 30, "Lives:");
    private Text livesValue = new Text(460, 30, "3");

    public UI(Pane gamePane) {
        this.gamePane = gamePane;
        initScoreUI();
    }

    public void addScoreValue(int score) {
        int newScore = getTextValue(scoreValue) + score;
        scoreValue.setText(Integer.toString(newScore));
    }

    public void removeLife() {
        int newLives = getTextValue(livesValue) - 1;
        livesValue.setText(Integer.toString(newLives));
    }

    public void resetUIValues() {
        scoreValue.setText("0");
        livesValue.setText("3");
    }

    private int getTextValue(Text text) {
        return Integer.parseInt(text.getText());
    }

    private void initScoreUI() {
        setDefaultTextProperties(scoreText);
        setDefaultTextProperties(scoreValue);
        setDefaultTextProperties(livesText);
        setDefaultTextProperties(livesValue);
        gamePane.getChildren().add(scoreText);
        gamePane.getChildren().add(scoreValue);
        gamePane.getChildren().add(livesText);
        gamePane.getChildren().add(livesValue);
    }

    private void setDefaultTextProperties(Text text) {
        text.setFill(Color.WHITE);
        text.setFont(Font.font("arial", FontWeight.BOLD, 20));
    }

}