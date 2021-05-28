package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

    @FXML
    Button backButton, homeTeamBtn, tableBtn, guestTeamBtn;
    // -------methods------
    public void handleBtn1() throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));

        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root, 1315, 855));
    }

    public void handleHomeTeamBtn() throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("matchDetails.fxml"));

        Stage window = (Stage) homeTeamBtn.getScene().getWindow();
        window.setScene(new Scene(root, 1315, 855));
    }

    public void handleGuestBtn() throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("matchDetails1.fxml"));

        Stage window = (Stage) guestTeamBtn.getScene().getWindow();
        window.setScene(new Scene(root, 1315, 855));
    }

    public void handleTableBtn() throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("tableTeams.fxml"));

        Stage window = (Stage) tableBtn.getScene().getWindow();
        window.setScene(new Scene(root, 1315, 855));
    }

}
