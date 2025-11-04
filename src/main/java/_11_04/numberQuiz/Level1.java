package _11_04.numberQuiz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class Level1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label title = new Label("숫자를 입력하세요.");
        TextField tf = new TextField();
        Label result = new Label();
        Random random = new Random();

        int n = random.nextInt(10) + 1;

        tf.setPromptText("1부터 10 사이의 숫자를 맞추어보세요");

        tf.setOnAction(e->{
            int answer = Integer.parseInt(tf.getText());

            if(answer == n) {
                result.setText("정답입니다 !!");
            }

            else {
                result.setText("아.. 틀렸어요..");
            }
        });

        VBox vb = new VBox(title, tf, result);
        Scene sc = new Scene(vb, 500, 500);

        primaryStage.setScene(sc);
        primaryStage.setTitle("숫자 맞추기 게임");
        primaryStage.show();
    }
}
