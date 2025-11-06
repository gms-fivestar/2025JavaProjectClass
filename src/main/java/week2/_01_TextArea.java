package week2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class _01_TextArea extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    // 1. 일단 기본적으로 TextArea 만 보여주기
    // 2. 버튼 설정하기
    // 3. 버튼에 이벤트 달고, 기능 추가하기

    @Override
    public void start(Stage primaryStage) {
        TextArea te = new TextArea();
        Button bt1 = new Button("GetText");
        Button bt2 = new Button("SetText");

        bt1.setOnAction(e->{
            String text = te.getText();
            System.out.println(text);
        });

        bt2.setOnAction(e->{
            te.setText("text Changed");
        });

        VBox vb = new VBox(te, bt1, bt2);

        Scene scene = new Scene(vb, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("TextArea");
        primaryStage.show();
    }
}
