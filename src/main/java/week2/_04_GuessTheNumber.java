package week2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class _04_GuessTheNumber extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ListView<String> lv = new ListView<>();
        ObservableList<String> ov = FXCollections.observableArrayList();
        Button bt = new Button("도전!");
        Label lb = new Label("숫자를 맞춰보세요~!");
        TextField tf = new TextField();
        lv.setItems(ov);

        int answer = 52;

        bt.setOnAction(e->{
            int n = Integer.parseInt(tf.getText());

            if(n > answer) {
                ov.add(n + "보다 작답니다!!");
            }
            else if(n < answer) {
                ov.add(n + "보다 크답니다!!");
            }
            else {
                lb.setText("와우 !! 정답입니다 !! 축하드려요 !!");
                ov.removeAll();
            }
        });

        VBox vb = new VBox(lv, bt, lb, tf);

        Scene scene = new Scene(vb, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("숫자맞추기게임");
        primaryStage.show();
    }
}
