package _10_28;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class _01_calc extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();

        Button plus = new Button("덧셈");
        Button minus = new Button("뺄셈");
        Button mul = new Button("곱셈");
        Button div = new Button("나눗셈");

        Label result = new Label();

        plus.setOnAction(e->{
            int a = Integer.parseInt(tf1.getText());
            int b = Integer.parseInt((tf2.getText()));

            int res = a + b;

            result.setText(Integer.toString(res));
        });

        minus.setOnAction(e->{
            int a = Integer.parseInt(tf1.getText());
            int b = Integer.parseInt((tf2.getText()));

            int res = a - b;

            result.setText(Integer.toString(res));
        });
        mul.setOnAction(e->{
            int a = Integer.parseInt(tf1.getText());
            int b = Integer.parseInt((tf2.getText()));

            int res = a * b;

            result.setText(Integer.toString(res));
        });
        div.setOnAction(e->{
            int a = Integer.parseInt(tf1.getText());
            int b = Integer.parseInt((tf2.getText()));

            int res;

            try {
                res = a / b;
                result.setText(Integer.toString(res));
            }
            catch (Exception exception) {
                result.setText("0으로 나눌 순 없습니다.");
            }
        });













        HBox tfBox = new HBox(tf1, tf2);
        HBox buttonBox = new HBox(plus, minus, mul, div);
        VBox root = new VBox(tfBox, buttonBox, result);

        Scene scene = new Scene(root, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
