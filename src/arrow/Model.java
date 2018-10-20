package arrow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.awt.*;


public class Model extends Application {

    AnchorPane mapRootPane;
    Arrow arrow;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader menuFxmlLoader = new FXMLLoader(getClass().getResource("Map.fxml"));
        mapRootPane = menuFxmlLoader.load();
        arrow = new Arrow();

        mapRootPane.setOnMousePressed((event) -> {
            arrow.setStart(event.getX(), event.getY());
        });
        mapRootPane.setOnMouseDragged((event) -> {
            arrow.setEnd(event.getX(), event.getY());
            arrow.update();
        });
        mapRootPane.setOnMouseReleased((event) -> {
            arrow.setEnd(event.getX(), event.getY());
            arrow.update();
        });

        mapRootPane.getChildren().add(arrow);
        primaryStage.setTitle("Draw Arrow Demo");
        primaryStage.setScene(new Scene(mapRootPane, 800, 450));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
