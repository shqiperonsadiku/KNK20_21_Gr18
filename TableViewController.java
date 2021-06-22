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

public class TableViewController implements Initializable {
    @FXML
    private TableView<ModelTable> table;
    @FXML
    private TableColumn<ModelTable, String> col_id;
    @FXML
    private TableColumn<ModelTable, String> col_homeTeam;
    @FXML
    private TableColumn<ModelTable, String> col_score;
    @FXML
    private TableColumn<ModelTable, String> col_guestTeam;

    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            Connection con = DbConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("select * from scores");

            while (rs.next()) {
                oblist.add(new ModelTable(rs.getString("id"), rs.getString("Home Team"),
                        rs.getString("Score"), rs.getString("Guest Team")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(TableViewController.class.getName()).log(Level.SEVERE, null, ex);
        }


        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_homeTeam.setCellValueFactory(new PropertyValueFactory<>("homeTeam"));
        col_score.setCellValueFactory(new PropertyValueFactory<>("score"));
        col_guestTeam.setCellValueFactory(new PropertyValueFactory<>("guestTeam"));

        table.setItems(oblist);
    }
}
