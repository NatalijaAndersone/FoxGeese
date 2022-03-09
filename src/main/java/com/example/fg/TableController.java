package com.example.fg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class TableController implements Initializable {
    DataBase db = new DataBase();

    @FXML
    private ListView<Table> listView_f;

    @FXML
    private ListView<Table> listView_g;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView_f.getItems().addAll(db.getNames("F"));  // Shows results in result table
        listView_g.getItems().addAll(db.getNames("G"));  // Shows results in result table

    }

    @FXML   // Buton 'Back' to main / first window
    public void changeToMain(ActionEvent event) throws IOException {
        Parent ruleP = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        //Parent ruleP = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene ruleScene =  new Scene(ruleP);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(ruleScene);
        window.show();
    }

}
