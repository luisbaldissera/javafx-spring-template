package org.sample.springfx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    private static ApplicationContext applicationContext;

    @Override
    public void init() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("ui-beans.xml");
    }

    @Override
    public void start(Stage stage) throws Exception {
        var view = (FXMLView) context().getBean("mainPage");
        stage.setScene(view.getScene());
        stage.setTitle("My Application");
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        applicationContext = null;
    }

    public static ApplicationContext context() {
        return applicationContext;
    }
    
}
