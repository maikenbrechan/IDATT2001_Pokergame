module edu.ntnu.oblig {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.ntnu.oblig to javafx.fxml;
    exports edu.ntnu.oblig;
}