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

import static usth.based.csg.createshape.*;


public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        TriangleMesh mesh = new createshape(100,50);
        MeshView meshview = new MeshView(mesh);
        PhongMaterial material1 = new PhongMaterial();
        material1.setSpecularColor(Color.BLUE);
        meshview.setMaterial(material1);
        meshview.setTranslateX(150);
        meshview.setTranslateY(150);
        Group root = new Group();
        root.getChildren().addAll(meshview);


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