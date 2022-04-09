package com.spacerocks;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

// This class is responsible for handling the GUI elements of the game
public class Screen {
    // We may decide that these can be modifiable - to be discussed
    private static final int SCREEN_WIDTH = 500;
    private static final int SCREEN_HEIGHT = 500;

    // I added "final" to these because IntelliJ suggested it. If we ended up
    // using more JavaFX elements we can remove this.
    private Stage gameStage;
    //Pane Creation
    private Pane pane;
    private Scene scene;
    private UI ui;
    private Spawner spawner;
    //Getter for the screen Width
    public static int getScreenWidth(){
        return SCREEN_WIDTH;
    }
    //Getter for the screen Height
    public static int getScreenHeight(){
        return SCREEN_HEIGHT;
    }

    private Game game;

    public Pane getPane() { return pane; }
    public Scene getScene() { return scene; }

    private static Screen screenInstance = null;

    private Screen() {}

    public static Screen getScreenInstance() {
        if (screenInstance == null) {
            screenInstance = new Screen();
        }
        return screenInstance;
    }


    public void initScreen(Stage gameStage) {
        this.gameStage = gameStage;
        resetScreen();
        spawner = new Spawner(this);
        ui = new UI(this);
        gameStage.setTitle("SpaceRocks");
        setDefaultScreenProperties();
        loadNewContent();
    }

    //Getter for the spawner
    public Spawner getSpawner(){return spawner;}

    public UI getUI() { return ui; }

    public void setDefaultScreenProperties() {
        pane.setPrefSize(SCREEN_HEIGHT, SCREEN_WIDTH);
        //Use the fill function to set the background image. Set the image as a shape first.
        //System.out.println("Setting");
        Image image = new Image("file:images/img.jpg");
        //System.out.println("Setting2");
        ImagePattern pattern = new ImagePattern(image);
        pane.setStyle("-fx-background-color: transparent;");
        scene.setFill(pattern);
        //System.out.println("Setting3");
    }

    public void setMenuScreen() {
        if (game != null) { game = null; };
        resetScreen();
        ui.initMenuUI();
        loadNewContent();
    }

    public void setGameScreen() {
        resetScreen();
        ui.initScoreUI();
        loadNewContent();
        game = new Game(this);
        game.play();
    }

    public void setHighScoreScreen() {
        resetScreen();
        ui.initHighScoreUI();
        loadNewContent();
    }

    public void resetScreen() {
        pane = new Pane();
        scene = new Scene(pane);
        setDefaultScreenProperties();
    }

    public void loadNewContent() {
        gameStage.setScene(scene);
        gameStage.show();
    }

}