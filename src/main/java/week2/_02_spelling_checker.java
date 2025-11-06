package week2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class _02_spelling_checker extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // HBox 가르쳐추기
        // HBox 를 VBox 안에다 넣는 거 가르쳐주기
        // contains, replace 메서드 써야한다는 거 가르쳐주기

        TextArea before = new TextArea();
        Button bt = new Button("검사하기");
        TextArea after = new TextArea();
        Label lb = new Label("검사할 문장을 입력해주세요.");

        bt.setOnAction(e->{
            String text = before.getText();

            int count = 0;

            if (text.contains("마춤뻡")) {
                text = text.replace("마춤뻡", "맞춤법");
                count++;
            }
            if (text.contains("사생활치매")) {
                text = text.replace("사생활치매", "사생활침해");
                count++;
            }
            if (text.contains("골이따분한 성격")) {
                text = text.replace("골이따분한 성격", "고리타분한 성격");
                count++;
            }

            after.setText(text);
            lb.setText("현재" + count + "개의 오타가 발견되었습니다.");
        });

        HBox hb = new HBox(10, before, after);
        VBox root = new VBox(hb, bt, lb);

        Scene sc = new Scene(root, 500, 500);

        primaryStage.setScene(sc);
        primaryStage.setTitle("맞춤법 검사기");
        primaryStage.show();
    }
}
