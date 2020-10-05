package org.sample.springfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainPageController {
    
    @FXML
    private Label label;

    @FXML
    private Button clickme;

    @FXML
    private void onClicked(ActionEvent event) {
        label.setText("Yout clicked!");
    }

}
