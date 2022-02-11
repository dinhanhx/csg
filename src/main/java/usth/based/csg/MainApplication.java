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
import java.util.ArrayList;
import java.util.List;

import static usth.based.csg.createshape.*;


public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        TriangleMesh mesh1 = new createshape(100,50);
        MeshView meshview1 = new MeshView(mesh1);

        TriangleMesh mesh2 = new createshape(50,50);
        MeshView meshview2 = new MeshView(mesh2);
        meshview2.setTranslateX(400);

        TriangleMesh unionmesh = new TriangleMesh();

        unionmesh.getPoints().addAll(mesh1.getPoints());
        unionmesh.getPoints().addAll(mesh2.getPoints());
        unionmesh.getTexCoords().addAll(mesh1.getTexCoords());
        unionmesh.getTexCoords().addAll(mesh2.getTexCoords());
        unionmesh.getFaces().addAll(mesh1.getFaces());
        unionmesh.getFaces().addAll(mesh2.getFaces());
        System.out.print(unionmesh.getTexCoords());
        MeshView meshviewunion = new MeshView(unionmesh);
        Group root = new Group();
        root.getChildren().addAll(meshviewunion);


        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Scene scene = new Scene(root, 600,300);
        //Setting camera
        PerspectiveCamera camera = new PerspectiveCamera(false);
        camera.setTranslateX(-100);
        camera.setTranslateY(-100);
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