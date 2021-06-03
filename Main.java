package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {
    private Locale locale = new Locale("en_UK");

    public Locale getLocale(){
        return locale;
    }

    public void setLocale(Locale locale){
        this.locale = locale;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Locale locale = new Locale("en_UK");
        ResourceBundle bundle = ResourceBundle.getBundle("resources.labelText", locale);
        Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"), bundle);
        primaryStage.setTitle("Football app");
        primaryStage.setScene(new Scene(root, 1340, 855));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
