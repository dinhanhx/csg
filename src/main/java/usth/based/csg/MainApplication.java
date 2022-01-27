import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

    Button button;
    public static void main(string[]args){
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("CSG Project");
        button = new Button();
        button.setText("Click");

        StackPane layout = new StackPane();
        layout.getChilderen().add(button);

        Scene scene = new  scene(layout, 300, 250);
        primaryStage.actScene(scene);
        primaryStage.show();

    }

}