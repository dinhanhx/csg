package usth.based.csg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Drawing a Rectangle
        Rectangle rectangle = new Rectangle();

        //Setting the properties of the rectangle
        rectangle.setX(150.0f);
        rectangle.setY(75.0f);
        rectangle.setWidth(300.0f);
        rectangle.setHeight(150.0f);
        //Creating a Group object
        Group root = new Group(rectangle);

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Scene scene = new Scene(root, 600,300);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}