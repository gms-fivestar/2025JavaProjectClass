package week1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class _04_Mission_Counter extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label numLabel = new Label("0");
        Button plusButton1 = new Button("+1");
        Button plusButton10 = new Button("+10");
        Button plusButton100 = new Button("+100");

        plusButton1.setOnAction(e -> {
            String n = numLabel.getText();
            n = Integer.toString(Integer.parseInt(n) + 1);
            numLabel.setText(n);
        });

        plusButton10.setOnAction(e -> {
            String n = numLabel.getText();
            n = Integer.toString(Integer.parseInt(n) + 10);
            numLabel.setText(n);
        });

        plusButton100.setOnAction(e -> {
            String n = numLabel.getText();
            n = Integer.toString(Integer.parseInt(n) + 100);
            numLabel.setText(n);
        });

        VBox vb = new VBox(numLabel, plusButton1, plusButton10, plusButton100);
        Scene scene = new Scene(vb, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("카운터");
        primaryStage.show();
    }
}
