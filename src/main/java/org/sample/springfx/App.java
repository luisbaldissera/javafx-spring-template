package org.sample.springfx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    private static ApplicationContext applicationContext;
    private static Stage primaryStage;

    @Override
    public void init() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("ui-beans.xml");
    }

    @Override
    public void start(Stage stage) throws Exception {        
        primaryStage = stage;
        var view = (FXMLView) applicationContext().getBean("mainPage");
        stage.setScene(view.getScene());
        stage.setTitle("My Application");
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        applicationContext = null;
    }

    public static ApplicationContext applicationContext() {
        return applicationContext;
    }

    public static Stage primaryStage() {
        return primaryStage;
    }
    
}
