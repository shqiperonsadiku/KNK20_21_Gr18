package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainPageController {
    @FXML
    Button scoreOneBtn;
    // -------methods------
    public void handleBtn2() throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("matchDetails.fxml"));

        Stage window = (Stage) scoreOneBtn.getScene().getWindow();
        window.setScene(new Scene(root, 1315, 855));
    }


}
