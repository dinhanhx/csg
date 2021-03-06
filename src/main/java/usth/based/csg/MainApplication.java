package usth.based.csg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.stage.Stage;

import java.io.IOException;

import static usth.based.csg.Operation.union;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Sphere sphere1 = new Sphere(100, Point3D.ZERO);
        Sphere sphere2 = new Sphere(50, new Point3D(50, 0, 0));

        Cylinder cy1 = new Cylinder(64,30f,100f,new Point3D(200, 50, 0));
        Cube cube = new Cube(50, new Point3D(100, 0, 0));
        Pyramid py = new Pyramid(100,100, new Point3D(100, 0, 0));
        TriangleMesh bo = cube.getTriangleMesh();
        TriangleMesh cy = cy1.getTriangleMesh();
        TriangleMesh py1 = py.getTriangleMesh();
       // TriangleMesh um = union(sphere2.getTriangleMesh(), cy1.getTriangleMesh());
//        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        Group root = new Group();
        root.getChildren().addAll(new MeshView(py1));

        Scene scene = new Scene(root, 600, 300);
        //Setting camera
        PerspectiveCamera camera = new PerspectiveCamera(false);
        camera.setTranslateX(-200);
        camera.setTranslateY(-100);
        camera.setTranslateZ(0);
        scene.setCamera(camera);

        stage.setTitle("Union Operator Demo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}