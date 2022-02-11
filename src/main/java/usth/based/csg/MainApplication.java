package usth.based.csg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.transform.*;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Drawing a Box
        Box box = new Box();

        //Setting the properties of the Box
        box.setWidth(80.0);
        box.setHeight(50.0);
        box.setDepth(100.0);    

        Translate translate = new Translate(250,100,0);
        Rotate rotate = new Rotate(30,250,100);
        box.getTransforms().addAll(translate);
        Group root = new Group(box);

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Scene scene = new Scene(root, 600,300);
        //Setting camera
        PerspectiveCamera camera = new PerspectiveCamera(false);
        camera.setTranslateX(0);
        camera.setTranslateY(0);
        camera.setTranslateZ(0);
        scene.setCamera(camera);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}