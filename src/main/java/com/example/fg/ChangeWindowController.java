package com.example.fg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class ChangeWindowController{

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
    private TextField player_name_txt;

    public void Start_game(ActionEvent event){
        String player_name = player_name_txt.getText();
        System.out.println(player_name);
        DataBase db = new DataBase();
        db.insertIntoDB(player_name,  21);
    }

    public void changeToScore(ActionEvent event) throws IOException {
        Parent ruleP = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Score_table.fxml")));
        //Parent ruleP = FXMLLoader.load(getClass().getResource("Scores.fxml"));
        Scene ruleScene =  new Scene(ruleP);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(ruleScene);
        window.show();

    }

}