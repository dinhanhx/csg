package usth.based.csg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.transform.*;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Drawing a cylinder
        Cylinder cylinder = new Cylinder(30.0,100.0);
        Translate translate = new Translate(250,100,100);
        cylinder.getTransforms().addAll(translate);

        PhongMaterial material5 = new PhongMaterial();
        material5.setDiffuseColor(Color.BLANCHEDALMOND);

        cylinder.setMaterial(material5);

        Group root = new Group(cylinder);

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Scene scene = new Scene(root, 600,300);
        //Setting camera
        PerspectiveCamera camera = new PerspectiveCamera(false);
        camera.setTranslateX(0);
        camera.setTranslateY(-120);
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