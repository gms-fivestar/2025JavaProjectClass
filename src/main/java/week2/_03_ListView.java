package week2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class _03_ListView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // ListView : 여러 개의 데이터를 화면에 '리스트' 형태로 보여줄 수 있는 UI 도구
        // <String> : String(문자열)만 넣을 수 있다는 의미 (자료형 제한, 제네릭)
        // 하지만 학생들은 아직 <> 문법을 배우지 않았으므로, "문자만 넣을 수 있다" 정도로 설명해주면 됨
        ListView<String> lv = new ListView<>();
        Button addButton = new Button("더하기");
        Button removeButton = new Button("빼기");
        Button setButton = new Button("바꾸기");
        Button containsButton = new Button("검사하기");

        TextField tf = new TextField();

        // ObservableList : 데이터를 '저장'하는 상자
        // lv와 ov의 차이
        //   - lv : "화면에 보여주는 상자"
        //   - ov : "실제로 데이터를 담는 상자"
        ObservableList<String> ov = FXCollections.observableArrayList();

        // lv.setItems(ov);
        // ListView(lv)와 ObservableList(ov)를 연결해주는 코드
        // 즉, "데이터 저장소 ov"에 뭔가를 넣으면 자동으로 "화면 lv"에도 보이게 되는 것
        lv.setItems(ov);

        ov.addAll("떡볶이", "치킨", "피자", "순대");

        addButton.setOnAction(e->{
            ov.add(tf.getText());
        });
        removeButton.setOnAction(e->{
            ov.remove(tf.getText());
        });
        setButton.setOnAction(e->{
            ov.set(0, tf.getText());
        });
        containsButton.setOnAction((e-> {
            String text = tf.getText();

            if(ov.contains(text)) {
                System.out.println(text + "는 리스트에 존재합니다.");
            }
            else {
                System.out.println(text + "는 리스트에 존재하지 않습니다..");
            }
        }));


        // VBox : 화면에 넣을 UI들을 위에서 아래로 차곡차곡 쌓는 레이아웃
        VBox vb = new VBox(lv, tf, addButton, removeButton, setButton, containsButton);

        Scene sc = new Scene(vb, 500, 500);

        primaryStage.setScene(sc);
        primaryStage.setTitle("ListView");
        primaryStage.show();
    }
}
