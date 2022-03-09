package com.example.fg;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class ChangeWindowController{

    private static final int TILE_WIDTH = 48;
    private static final int TILE_HEIGHT = 48;

    private static final int PANE_WIDTH = 720;
    private static final int PANE_HEIGHT = 720;

    private final DoubleProperty xOffset = new SimpleDoubleProperty();
    private final DoubleProperty yOffset = new SimpleDoubleProperty();

    private final IntegerProperty tileXOffset = new SimpleIntegerProperty();
    private final IntegerProperty tileYOffset = new SimpleIntegerProperty();

    private final Pane pane = new Pane();

    private ImageView[][] tiles;

    //Method to change to rule section
    @FXML
    public void changeToRules(ActionEvent event) throws IOException {
        Parent ruleP = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Rules.fxml")));
        //Parent ruleP = FXMLLoader.load(getClass().getResource("Rules.fxml"));
        Scene ruleScene =  new Scene(ruleP);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(ruleScene);
        window.show();
    }
    //Goes back to main menu.
    @FXML
    public void changeToMain(ActionEvent event) throws IOException {
        Parent ruleP = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        //Parent ruleP = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene ruleScene =  new Scene(ruleP);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(ruleScene);
        window.show();
    }
    //Goes to Player interface
    public void changeToPlayerName(ActionEvent event) throws IOException {
        Parent ruleP = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PlayerNameScreen.fxml")));
        //Parent ruleP = FXMLLoader.load(getClass().getResource("PlayerNameScreen.fxml"));
        Scene ruleScene =  new Scene(ruleP);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(ruleScene);
        window.show();
    }

    @FXML
    private TextField player_fox_txt;
    @FXML
    private TextField player_goose_txt;

    public void Start_game(ActionEvent event) throws Exception {
        String player_fox = player_fox_txt.getText();
        String player_goose = player_goose_txt.getText();
        System.out.println(player_fox);
        System.out.println(player_goose);
        DataBase db = new DataBase();
        db.insertIntoDB(player_fox,  20);
        db.insertIntoDB(player_goose,  18);

        runGame(event);

    }

    public void changeToScore(ActionEvent event) throws IOException {
        Parent ruleP = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Score_table.fxml")));
        //Parent ruleP = FXMLLoader.load(getClass().getResource("Scores.fxml"));
        Scene ruleScene =  new Scene(ruleP);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(ruleScene);
        window.show();

    }

    public void runGame(ActionEvent event) throws Exception {

        build();

        pane.setMinSize(PANE_WIDTH, PANE_HEIGHT);
        pane.setPrefSize(PANE_WIDTH, PANE_HEIGHT);
        pane.setMaxSize(PANE_WIDTH, PANE_HEIGHT);

        Scene scene = new Scene(pane);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void build() throws FileNotFoundException {

        int numTileCols = (PANE_WIDTH / TILE_WIDTH + 2);
        int numTileRows = (PANE_HEIGHT / TILE_HEIGHT + 2);

        tiles = new ImageView[numTileCols][numTileRows];

        for (int colIndex = 0; colIndex < numTileCols; colIndex++) {

            final int col = colIndex;

            for (int rowIndex = 0; rowIndex < numTileRows; rowIndex++) {

                final int row = rowIndex;

                ImageView tile = new ImageView();
                tile.setImage(getImage(col - tileXOffset.get(), row - tileYOffset.get()));
                tile.setFitWidth(TILE_WIDTH);
                tile.setFitHeight(TILE_HEIGHT);

                xOffset.addListener((obs, oldOffset, newOffset) -> {
                    double offset = newOffset.intValue() % TILE_WIDTH + (col - 1) * TILE_WIDTH;
                    tile.setLayoutX(offset);
                });
                tile.setLayoutX(xOffset.intValue() % TILE_WIDTH + (col - 1) * TILE_WIDTH);

                yOffset.addListener((obs, oldOffset, newOffset) -> {
                    double offset = newOffset.intValue() % TILE_HEIGHT + (row - 1) * TILE_HEIGHT;
                    tile.setLayoutY(offset);
                });
                tile.setLayoutY(yOffset.intValue() % TILE_HEIGHT + (row - 1) * TILE_HEIGHT);

                pane.getChildren().add(tile);

                tiles[col][row] = tile;

            }
        }
    }

    private Image getImage(int column, int row) throws FileNotFoundException {
        Label label = new Label();

        if ((column == 6 && row == 8) || (column == 8 && row == 6) || (column == 8 && row == 8) || (column == 8 && row == 10) || (column == 10 && row == 8)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_p5.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 7 && row == 8) || (column == 8 && row == 7) || (column == 8 && row == 9) || (column == 9 && row == 8)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_c2468.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 5 && row == 7) || (column == 7 && row == 5)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_p1.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 6 && row == 7) || (column == 8 && row == 5) || (column == 10 && row == 7)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_p2.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 9 && row == 5) || (column == 11 && row == 7)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_p3.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 5 && row == 8) || (column == 7 && row == 6) || (column == 7 && row == 10)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_p4.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 9 && row == 6) || (column == 9 && row == 10) || (column == 11 && row == 8)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_p6.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 5 && row == 9) || (column == 7 && row == 11)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_p7.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 6 && row == 9) || (column == 8 && row == 11) || (column == 10 && row == 9)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_p8.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 9 && row == 11) || (column == 11 && row == 9)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_p9.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 7 && row == 7)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_c1.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 9 && row == 7)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_c7.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 7 && row == 9)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_c3.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 9 && row == 9)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_c9.png"));
            label.setGraphic(new ImageView(image));
        } else {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass.png"));
            label.setGraphic(new ImageView(image));
        }

        new Scene(label);
        return label.snapshot(null, null);
    }
}