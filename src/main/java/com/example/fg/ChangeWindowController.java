package com.example.fg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangeWindowController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    //Method to change to rule section
    @FXML
    public void changeToRules(ActionEvent event) throws IOException {
        Parent ruleP = FXMLLoader.load(getClass().getResource("Rules.fxml"));
        Scene ruleScene =  new Scene(ruleP);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(ruleScene);
        window.show();
    }
 //Goes back to main menu.
    @FXML
    public void changeToMain(ActionEvent event) throws IOException {
        Parent ruleP = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene ruleScene =  new Scene(ruleP);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(ruleScene);
        window.show();
    }
    //Goes to Player interface
    public void changeToPlayerName(ActionEvent event) throws IOException {
        Parent ruleP = FXMLLoader.load(getClass().getResource("PlayerNameScreen.fxml"));
        Scene ruleScene =  new Scene(ruleP);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(ruleScene);
        window.show();
    }
    public void changeToScore(ActionEvent event) throws IOException {
        Parent ruleP = FXMLLoader.load(getClass().getResource("Scores.fxml"));
        Scene ruleScene =  new Scene(ruleP);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(ruleScene);
        window.show();
    }
}