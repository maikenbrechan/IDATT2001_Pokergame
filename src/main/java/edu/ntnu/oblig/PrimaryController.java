package edu.ntnu.oblig;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    public void dealHand(){
        tf.setText("hand dealt");
    }

    @FXML
    private TextField tf;
}
