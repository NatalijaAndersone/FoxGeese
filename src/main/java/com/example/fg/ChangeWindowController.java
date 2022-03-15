package com.example.fg;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
public class ChangeWindowController{
    int fox_score = 0;      //Points in the beginning of the game
    int geese_score = 15;

    private static final int TILE_WIDTH = 48;
    private static final int TILE_HEIGHT = 48;

    private static final int PANE_WIDTH = 700;
    private static final int PANE_HEIGHT = 400;

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
//Changes to screen where fox wins
    public void changeToFoxWins(ActionEvent event) throws IOException {
        Parent ruleP = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fox-wins.fxml")));
        //Parent ruleP = FXMLLoader.load(getClass().getResource("Rules.fxml"));
        Scene ruleScene =  new Scene(ruleP);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(ruleScene);
        window.show();
    }
//Changes to screen where Geese win
    public void changeToGeeseWin(ActionEvent event) throws IOException {
        Parent ruleP = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("geese-win.fxml")));
        //Parent ruleP = FXMLLoader.load(getClass().getResource("Rules.fxml"));
        Scene ruleScene =  new Scene(ruleP);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(ruleScene);
        window.show();
    }

    //  Players names from PlayerNameScreen window
    @FXML
    private TextField player_fox_txt;
    @FXML
    private TextField player_goose_txt;

    public void Start_game(ActionEvent event) throws Exception {
        String player_fox = player_fox_txt.getText();
        String player_goose = player_goose_txt.getText();
        System.out.println(player_fox);
        System.out.println(player_goose);
        //DataBase db = new DataBase();

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
        // Images of buttons on the right
        Image image_c = new Image(new FileInputStream("src\\main\\resources\\tiles\\cave_small.png"));
        Image image_f = new Image(new FileInputStream("src\\main\\resources\\tiles\\fox_flag_small1.png"));
        Image image_g = new Image(new FileInputStream("src\\main\\resources\\tiles\\roasted_goose_small1.png"));

        build();

        pane.setMinSize(PANE_WIDTH, PANE_HEIGHT);
        pane.setPrefSize(PANE_WIDTH, PANE_HEIGHT);
        pane.setMaxSize(PANE_WIDTH, PANE_HEIGHT);


        Button button_c = new Button("",new ImageView(image_c));
        Button button_f = new Button("",new ImageView(image_f));
        Button button_g = new Button("",new ImageView(image_g));

        button_c.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("Accepted");
                // Switches to quit game window
                Parent ruleP = null;
                try {
                    ruleP = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Quit-game.fxml")));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                //Parent ruleP = FXMLLoader.load(getClass().getResource("PlayerNameScreen.fxml"));
                Scene ruleScene =  new Scene(ruleP);
                Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();
                window.setScene(ruleScene);
                window.show();
            }

        });

        button_f.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("Accepted_fox: " + fox_score);
                fox_score --;
                /*
                try {
                    build();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                */
                // Switches to fox surrender window
                Parent ruleP = null;
                try {
                    ruleP = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Fox-surrender.fxml")));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                //Parent ruleP = FXMLLoader.load(getClass().getResource("PlayerNameScreen.fxml"));
                Scene ruleScene =  new Scene(ruleP);
                Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();
                window.setScene(ruleScene);
                window.show();
            }
        });

        button_g.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("Accepted_g");
                // Switches to geese surrender window
                Parent ruleP = null;
                try {
                    ruleP = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Geese-surrender.fxml")));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                //Parent ruleP = FXMLLoader.load(getClass().getResource("PlayerNameScreen.fxml"));
                Scene ruleScene =  new Scene(ruleP);
                Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();
                window.setScene(ruleScene);
                window.show();
            }
        });

        button_c.setLayoutX(600);
        button_c.setLayoutY(20);
        button_f.setLayoutX(600);
        button_f.setLayoutY(80);
        button_g.setLayoutX(600);
        button_g.setLayoutY(140);

        pane.getChildren().add(button_c);
        pane.getChildren().add(button_f);
        pane.getChildren().add(button_g);

        Scene scene = new Scene(pane);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Play Fox & Geese!");
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
        if ((column == 6 && row == 8-3) || (column == 8 && row == 6-3) || (column == 8 && row == 8-3) || (column == 8 && row == 10-3) || (column == 10 && row == 8-3)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_p5.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 7 && row == 8-3) || (column == 8 && row == 7-3) || (column == 8 && row == 9-3) || (column == 9 && row == 8-3)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_c2468.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 5 && row == 7-3) || (column == 7 && row == 5-3)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_p1.png"));
            label.setGraphic(new ImageView(image));
        }else if ((column == 6 && row == 7-3) || (column == 8 && row == 5-3) || (column == 10 && row == 7-3)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_p2.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 9 && row == 5-3) || (column == 11 && row == 7-3)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_p3.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 5 && row == 8-3) || (column == 7 && row == 6-3) || (column == 7 && row == 10-3)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_p4.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 9 && row == 6-3) || (column == 9 && row == 10-3) || (column == 11 && row == 8-3)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_p6.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 5 && row == 9-3) || (column == 7 && row == 11-3)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_p7.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 6 && row == 9-3) || (column == 8 && row == 11-3) || (column == 10 && row == 9-3)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_p8.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 9 && row == 11-3) || (column == 11 && row == 9-3)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_p9.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 7 && row == 7-3)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_c1.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 9 && row == 7-3)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_c7.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 7 && row == 9-3)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_c3.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 9 && row == 9-3)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass_c9.png"));
            label.setGraphic(new ImageView(image));
            //  Shows Fox and Geese icons on the left
        } else if ((column == 1 && row == 2)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\fox_grass.png"));
            label.setGraphic(new ImageView(image));
        } else if ((column == 1 && row == 3)) {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\goose_grass.png"));
            label.setGraphic(new ImageView(image));
            //  Writes scores
        } else if ((column == 2 && row == 2)) {
            label.setFont(Font.font(null, FontWeight.BOLD, 90));
            BackgroundFill bf = new BackgroundFill(Color.rgb(98,157,90),
                    CornerRadii.EMPTY , Insets.EMPTY);
            Background bg = new Background(bf); //Background of points
            label.setBackground(bg);            // set background
            label.setText(String.valueOf(fox_score));
        } else if ((column == 2 && row == 3)) {
            label.setFont(Font.font(null, FontWeight.BOLD, 90));
            BackgroundFill bf = new BackgroundFill(Color.rgb(98,157,90),
                    CornerRadii.EMPTY , Insets.EMPTY);
            Background bg = new Background(bf); //Background of points
            label.setBackground(bg);            // set background
            label.setText(String.valueOf(geese_score));

        } else {
            Image image = new Image(new FileInputStream("src\\main\\resources\\tiles\\grass.png"));
            label.setGraphic(new ImageView(image));
        }
        new Scene(label);
        return label.snapshot(null, null);
    }
}