package week1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class _01_windows extends Application {

    public static void main(String[] args) { // 일반 main과 javafx의 main의 차이점 설명해주기. -> javafx의 main은 창을 닫아야 그제서야 프로세스가 종료된다. 다른 파일 하나 만들어서 보여주기
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // primaryStage.show();// 이걸 먼저 보여주기

        Button bt1 = new Button("버튼1번");
        Button bt2 = new Button("버튼2번");

        VBox vb = new VBox(bt1, bt2); // VBox, HBox 다 하고 보여주기. VBox는 컨테이너. 안보이지만 vbox를 담고있음.

        Scene scene = new Scene(vb, 500, 500); // 다 하고 Scene의 값에 따라 어떻게 되는지 보여주기. Scene은 한 "장면"을 의미한다.

        primaryStage.setScene(scene); // 창에 그 장면을 설정한다.
        primaryStage.setTitle("버튼 보여주기"); // 창의 제목을 지정한다
        primaryStage.show(); // 창을 보여준다
    }
}
