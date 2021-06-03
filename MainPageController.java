package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class MainPageController {

    Main main = new Main();

    public void changeLanguage(ActionEvent event) throws Exception{
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();

        ResourceBundle bundle = ResourceBundle.getBundle("resources.labelText", main.getLocale());
        Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"), bundle);
        primaryStage.setTitle("Football app");
        primaryStage.setScene(new Scene(root, 1340, 855));
        primaryStage.show();
    }

    @FXML
    Button scoreOneBtn, homeBtn, chlBtn, alBtn, enBtn;
    // -------methods------

    public void handleAlBtn(ActionEvent event) throws Exception {

        try {
            main.setLocale(new Locale("al_AL"));
            changeLanguage(event);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void handleEnBtn(ActionEvent event) throws Exception {

        try {
            main.setLocale(new Locale("en_UK"));
            changeLanguage(event);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void handleScoreBtn() throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("matchDetails.fxml"));
        Stage window = (Stage) scoreOneBtn.getScene().getWindow();
        window.setScene(new Scene(root, 1340, 855));

    }

    public void handleHomeBtn() throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));

        Stage window = (Stage) homeBtn.getScene().getWindow();
        window.setScene(new Scene(root, 1340, 855));
    }

    public void handleChlBtn() throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("chlPage.fxml"));

        Stage window = (Stage) chlBtn.getScene().getWindow();
        window.setScene(new Scene(root, 1340, 855));
    }

    /*
    public void button(ActionEvent actionEvent) throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        String sql = "INSERT INTO footballscores VALUES('barcelona','3 : 1','real madrid')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }*/

}
