module usth.based.csg {
    requires javafx.controls;
    requires javafx.fxml;


    opens usth.based.csg to javafx.fxml;
    exports usth.based.csg;
}