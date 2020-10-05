package org.sample.springfx;

import java.io.IOException;

import org.springframework.core.io.Resource;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class FXMLView {
    
    private Scene scene;
    private Object controller;

    public FXMLView(Resource fxmlFile) {
        try {
            var loader = new FXMLLoader();
            var url = fxmlFile.getURL();
            loader.setLocation(url);
            var root = (Parent) loader.load();
            var scene = new Scene(root);
            this.controller = loader.getController();
            this.scene = scene;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Scene getScene() {
        return scene;
    }

    public <T> T getController() {
        return (T) controller;
    }
}
