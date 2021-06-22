package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.String;

public class LaLigaController implements Initializable {
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
                        rs.getString("Goals Difference"),rs.getString("Points")));
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