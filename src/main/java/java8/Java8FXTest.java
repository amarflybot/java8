package java8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * Created by amarendra on 28/08/17.
 */
public class Java8FXTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Simple UI

        Label message = new Label("Hello Amar!");
        message.setFont(new Font(100));
        primaryStage.setScene(new Scene(message));
        primaryStage.setTitle("Hello");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
