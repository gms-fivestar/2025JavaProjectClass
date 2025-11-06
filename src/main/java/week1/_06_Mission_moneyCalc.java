package week1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class _06_Mission_moneyCalc extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TextField moneyTextField = new TextField();
        Button bt5percent = new Button("5%");
        Button bt10percent = new Button("10%");
        Button bt15percent = new Button("15%");
        Label totalMoney = new Label("총 금액");

        moneyTextField.setPromptText("10년간 1년에 얼마씩 넣을건가요..");

        bt5percent.setOnAction(e->{
            double money = Double.parseDouble(moneyTextField.getText());

            for (int i = 0; i < 5; i++) {
                money *= 1.05;
            }

            totalMoney.setText(Double.toString(money));
        });

        bt10percent.setOnAction(e->{
            double money = Double.parseDouble(moneyTextField.getText());

            for (int i = 0; i < 5; i++) {
                money *= 1.1;
            }

            totalMoney.setText(Double.toString(money));
        });

        bt15percent.setOnAction(e->{
            double money = Double.parseDouble(moneyTextField.getText());

            for (int i = 0; i < 5; i++) {
                money *= 1.15;
            }

            totalMoney.setText(Double.toString(money));
        });


        VBox vb = new VBox(moneyTextField, bt5percent, bt10percent, bt15percent, totalMoney);
        Scene sc = new Scene(vb, 500, 500);
        primaryStage.setScene(sc);
        primaryStage.setTitle("주식 수익률 계산기");
        primaryStage.show();
    }
}
