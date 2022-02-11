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

import static usth.based.csg.Primitive.CreateSphere;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        TriangleMesh m = new TriangleMesh();

        // POINTS
        m.getPoints().addAll(0f, 0f, -0.951057f, 0f, 0f, 0.951057f, -0.850651f, 0f, -0.425325f, 0.850651f, 0f,
                0.425325f, 0.688191f, -0.5f, -0.425325f, 0.688191f, 0.5f, -0.425325f, -0.688191f, -0.5f, 0.425325f,
                -0.688191f, 0.5f, 0.425325f, -0.262866f, -0.809017f, -0.425325f, -0.262866f, 0.809017f, -0.425325f,
                0.262866f, -0.809017f, 0.425325f, 0.262866f, 0.809017f, 0.425325f);

        // TEXTURES
        m.getTexCoords().addAll(0.181818f, 0f, 0.363636f, 0f, 0.545455f, 0f, 0.727273f, 0f, 0.909091f, 0f,
                0.0909091f, 0.333333f, 0.272727f, 0.333333f, 0.454545f, 0.333333f, 0.636364f, 0.333333f, 0.818182f,
                0.333333f, 1f, 0.333333f, 0f, 0.666667f, 0.181818f, 0.666667f, 0.363636f, 0.666667f, 0.545455f,
                0.666667f, 0.727273f, 0.666667f, 0.909091f, 0.666667f, 0.0909091f, 1f, 0.272727f, 1f, 0.454545f, 1f,
                0.636364f, 1f, 0.818182f, 1f);

        // FACES
        m.getFaces().addAll(1, 6, 11, 5, 7, 0, 1, 12, 7, 11, 6, 5, 1, 7, 6, 6, 10, 1, 1, 13, 10, 12, 3, 6, 1, 8, 3,
                7, 11, 2, 4, 14, 8, 13, 0, 7, 5, 9, 4, 8, 0, 3, 9, 15, 5, 14, 0, 8, 2, 10, 9, 9, 0, 4, 8, 16, 2, 15,
                0, 9, 11, 5, 9, 6, 7, 12, 7, 11, 2, 12, 6, 17, 6, 6, 8, 7, 10, 13, 10, 12, 4, 13, 3, 18, 3, 7, 5, 8,
                11, 14, 4, 13, 10, 14, 8, 19, 5, 8, 3, 9, 4, 15, 9, 14, 11, 15, 5, 20, 2, 9, 7, 10, 9, 16, 8, 15, 6,
                16, 2, 21);
        MeshView meshview = new MeshView(m);
        PhongMaterial material1 = new PhongMaterial();
        material1.setDiffuseColor(Color.BLUE);
        meshview.setMaterial(material1);
        Group root = new Group(meshview);


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