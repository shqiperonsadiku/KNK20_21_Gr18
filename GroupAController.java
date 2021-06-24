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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GroupAController implements Initializable {

    @FXML
    private BorderPane mainPane;

    /*@FXML
    private void handleFinalBtn(ActionEvent event){
        System.out.println("you clicked me");
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("groupsTable");
        mainPane.setCenter(view);
    }*/


    @FXML
    Button scoreOneBtn, groupABtn, groupBBtn;

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

    @FXML
    private TableView<GroupAchl> table;
    @FXML
    private TableColumn<GroupAchl, String> col_position;
    @FXML
    private TableColumn<GroupAchl, String> col_teamName;
    @FXML
    private TableColumn<GroupAchl, String> col_played;
    @FXML
    private TableColumn<GroupAchl, String> col_wins;
    @FXML
    private TableColumn<GroupAchl, String> col_draws;
    @FXML
    private TableColumn<GroupAchl, String> col_losses;
    @FXML
    private TableColumn<GroupAchl, String> col_goalsFor;
    @FXML
    private TableColumn<GroupAchl, String> col_goalsAgainst;
    @FXML
    private TableColumn<GroupAchl, String> col_goalsDifference;
    @FXML
    private TableColumn<GroupAchl, String> col_points;

    ObservableList<GroupAchl> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            Connection con = DbConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("select * from groupa");

            while (rs.next()) {
                oblist.add(new GroupAchl(rs.getString("Position"), rs.getString("Team Name"),
                        rs.getString("P"), rs.getString("W"), rs.getString("D"), rs.getString("L"),
                        rs.getString("F"), rs.getString("A"),
                        rs.getString("GD"),rs.getString("PTS")));
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
