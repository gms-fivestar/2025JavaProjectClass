package week2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class df extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // 선택한 인덱스 가져오기

        ListView<String> lv = new ListView<>();
        ObservableList<String> ov = FXCollections.observableArrayList();

        lv.setItems(ov);

        ov.addAll("치킨", "피자", "떡볶이", "순대");

        lv.setOnMouseClicked(e->{
            System.out.println("클릭되었습니다.");

            String selected = lv.getSelectionModel().getSelectedItem();
            int index = lv.getSelectionModel().getSelectedIndex();

            System.out.println("Index : " + index + "selected : " + selected);
        });

        VBox vb = new VBox(lv);

        Scene sc = new Scene(vb, 500, 500);
        primaryStage.setScene(sc);
        primaryStage.setTitle("ListView");
        primaryStage.show();
    }
}
