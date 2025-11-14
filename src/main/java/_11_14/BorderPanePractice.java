package _11_14;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPanePractice extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label topLabel = new Label("위");
        Label midLabel = new Label("중간");
        Label botLabel = new Label("아래");
        Label rightLabel = new Label("오른쪽");
        Label leftLabel = new Label("왼쪽");

        topLabel.setStyle("-fx-background-color: #FFCCCC;");
        midLabel.setStyle("-fx-background-color: #CCFFCC;");
        botLabel.setStyle("-fx-background-color: #CCCCFF;");
        rightLabel.setStyle("-fx-background-color: #FFFFCC;");
        leftLabel.setStyle("-fx-background-color: #FFCCFF;");

        BorderPane root = new BorderPane();

        root.setTop(topLabel);
        root.setBottom(botLabel);
        root.setLeft(leftLabel);
        root.setRight(rightLabel);
        root.setCenter(midLabel);

        BorderPane.setAlignment(topLabel, Pos.CENTER);
        BorderPane.setAlignment(botLabel, Pos.CENTER);
        BorderPane.setAlignment(leftLabel, Pos.CENTER);
        BorderPane.setAlignment(rightLabel, Pos.CENTER);
        BorderPane.setAlignment(midLabel, Pos.CENTER);

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BorderPane 실습");
        primaryStage.show();
    }
}
