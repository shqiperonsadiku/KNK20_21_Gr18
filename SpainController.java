package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpainController implements Initializable {

    @FXML
    Button scoreOneBtn, homeBtn, chlBtn, spainBtn, englandBtn;

    public void handleSpainBtn() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("spain.fxml"));

        Stage window = (Stage) spainBtn.getScene().getWindow();
        window.setScene(new Scene(root, 1340, 780));
    }

    public void handleEnglandBtn() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("england.fxml"));

        Stage window = (Stage) englandBtn.getScene().getWindow();
        window.setScene(new Scene(root, 1340, 780));
    }

    public void handleHomeBtn() throws Exception {

        Stage window = (Stage) homeBtn.getScene().getWindow();
        window.close();
    }

    public void handleChlBtn() throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("groupA.fxml"));
            Stage window = new Stage();
            window.setScene(new Scene(root, 1040, 710));
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    @FXML
    private TableView<LaLigaTable> table;
    @FXML
    private TableColumn<LaLigaTable, String> col_position;
    @FXML
    private TableColumn<LaLigaTable, String> col_teamName;
    @FXML
    private TableColumn<LaLigaTable, String> col_played;
    @FXML
    private TableColumn<LaLigaTable, String> col_wins;
    @FXML
    private TableColumn<LaLigaTable, String> col_draws;
    @FXML
    private TableColumn<LaLigaTable, String> col_losses;
    @FXML
    private TableColumn<LaLigaTable, String> col_goalsFor;
    @FXML
    private TableColumn<LaLigaTable, String> col_goalsAgainst;
    @FXML
    private TableColumn<LaLigaTable, String> col_goalsDifference;
    @FXML
    private TableColumn<LaLigaTable, String> col_points;

    ObservableList<LaLigaTable> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            Connection con = DbConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("select * from laliga");

            while (rs.next()) {
                oblist.add(new LaLigaTable(rs.getString("Position"), rs.getString("Team Name"),
                        rs.getString("Played"), rs.getString("Wins"), rs.getString("Draws"), rs.getString("Losses"),
                        rs.getString("Goals For"), rs.getString("Goals Against"),
                        rs.getString("Goals Difference"), rs.getString("Points")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(TableViewController.class.getName()).log(Level.SEVERE, null, ex);
        }


        col_position.setCellValueFactory(new PropertyValueFactory<>("position"));
        col_teamName.setCellValueFactory(new PropertyValueFactory<>("teamName"));
        col_played.setCellValueFactory(new PropertyValueFactory<>("played"));
        col_wins.setCellValueFactory(new PropertyValueFactory<>("wins"));
        col_draws.setCellValueFactory(new PropertyValueFactory<>("draws"));
        col_losses.setCellValueFactory(new PropertyValueFactory<>("losses"));
        col_goalsFor.setCellValueFactory(new PropertyValueFactory<>("goalsFor"));
        col_goalsAgainst.setCellValueFactory(new PropertyValueFactory<>("goalsAgainst"));
        col_goalsDifference.setCellValueFactory(new PropertyValueFactory<>("goalsDifference"));
        col_points.setCellValueFactory(new PropertyValueFactory<>("points"));

        table.setItems(oblist);
    }
}
