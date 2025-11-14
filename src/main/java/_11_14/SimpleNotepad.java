package _11_14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SimpleNotepad extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // 1. BorderPane 생성 (오늘 배운 레이아웃!)
        BorderPane root = new BorderPane();

        // 2. 상단 영역: 버튼 3개
        Button btnNew = new Button("새로만들기");
        Button btnSave = new Button("저장");
        Button btnClose = new Button("닫기");

        // HBox로 버튼들을 가로로 배치 (week1에서 배웠던 HBox!)
        HBox topButtons = new HBox(10, btnNew, btnSave, btnClose);
        topButtons.setStyle("-fx-padding: 10;");  // 오늘 배운 setStyle로 여백 주기

        // 3. 중앙 영역: 텍스트 입력 공간 (week2에서 배운 TextArea!)
        TextArea textArea = new TextArea();

        // 4. 하단 영역: 글자 수 표시
        Label statusLabel = new Label("글자 수: 0");
        statusLabel.setStyle("-fx-padding: 10;");

        // 5. BorderPane에 배치 (오늘 배운 setTop, setCenter, setBottom!)
        root.setTop(topButtons);
        root.setCenter(textArea);
        root.setBottom(statusLabel);

        // === 기능 추가 ===

        // 새로만들기 버튼: 텍스트 영역 비우기
        btnNew.setOnAction(e -> {
            textArea.setText("");  // week2에서 배운 setText!
            System.out.println("새로 만들기 클릭됨");
        });

        // 저장 버튼: 현재 내용을 콘솔에 출력
        btnSave.setOnAction(e -> {
            String content = textArea.getText();  // week2에서 배운 getText!
            System.out.println("=== 저장된 내용 ===");
            System.out.println(content);
            System.out.println("==================");
        });

        // 닫기 버튼: 프로그램 종료
        btnClose.setOnAction(e -> {
            System.out.println("프로그램 종료");
            primaryStage.close();
        });

        // TextArea에 글자 입력할 때마다 글자 수 세기
        // week3에서 배운 addListener 사용!
        textArea.textProperty().addListener((obs, oldText, newText) -> {
            int length = newText.length();
            statusLabel.setText("글자 수: " + length);
        });

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("간단 메모장");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}