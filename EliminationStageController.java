package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EliminationStageController {
    @FXML
    Button scoreOneBtn, groupABtn, groupBBtn, finalBtn, semiFinalsBtn, quarterFinalsBtn, round16Btn;

    public void handleFinalBtn() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("finalChl.fxml"));

        Stage window = (Stage) finalBtn.getScene().getWindow();
        window.setScene(new Scene(root, 1040, 710));
    }

    public void handleSemiFinalsBtn() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("semiFinalsChl.fxml"));

        Stage window = (Stage) semiFinalsBtn.getScene().getWindow();
        window.setScene(new Scene(root, 1040, 710));
    }

    public void handleQuarterFinalsBtn() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("quarterFinalsChl.fxml"));

        Stage window = (Stage) quarterFinalsBtn.getScene().getWindow();
        window.setScene(new Scene(root, 1040, 710));
    }

    public void handleRound16Btn() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("round16Chl.fxml"));

        Stage window = (Stage) round16Btn.getScene().getWindow();
        window.setScene(new Scene(root, 1040, 780));
    }

    public void handleScoreBtn() throws Exception {

        /*Parent root = FXMLLoader.load(getClass().getResource("matchDetails.fxml"));
        Stage window = (Stage) scoreOneBtn.getScene().getWindow();
        window.setScene(new Scene(root, 1340, 855));*/
        try {
            Parent root = FXMLLoader.load(getClass().getResource("matchDetails.fxml"));
            Stage window = new Stage();
            window.setScene(new Scene(root, 1340, 855));
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void handleGroupABtn() throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("groupA.fxml"));

        Stage window = (Stage) groupABtn.getScene().getWindow();
        window.setScene(new Scene(root, 1040, 710));
    }

    public void handleGroupBBtn() throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("groupB.fxml"));

        Stage window = (Stage) groupBBtn.getScene().getWindow();
        window.setScene(new Scene(root, 1040, 710));
    }
}
