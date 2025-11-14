package _11_14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPanePractice extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
// 1. GridPane 생성
        GridPane root = new GridPane();

// (선택) UI 요소와 격자 테두리 사이의 여백
        root.setPadding(new Insets(10));

// (선택) 격자 칸 사이의 가로/세로 간격
        root.setHgap(10); // 수평(Horizontal) 간격
        root.setVgap(10); // 수직(Vertical) 간격

// (꿀팁) 그리드 선을 보이게 해서 디버깅하기
        root.setGridLinesVisible(true);

// 2. 라벨 생성
        Label label00 = new Label("(열=0, 행=0)");
        Label label10 = new Label("(열=1, 행=0)");
        Label label01 = new Label("(열=0, 행=1)");
        Label label11 = new Label("(열=1, 행=1)");
        Label label55 = new Label("(열=5, 행=5)");

// (선택) 구분이 쉽도록 배경색 추가
        label00.setStyle("-fx-background-color: #FFCCCC;");
        label10.setStyle("-fx-background-color: #CCFFCC;");
        label01.setStyle("-fx-background-color: #CCCCFF;");
        label11.setStyle("-fx-background-color: #FFFFCC;");

// 3. 그리드에 추가하기: add(Node, 열, 행)
        root.add(label00, 0, 0);
        root.add(label10, 1, 0);
        root.add(label01, 0, 1);
        root.add(label11, 1, 1);
        root.add(label55, 5, 5);

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("GridPane 좌표 테스트");
        primaryStage.show();
    }
}
