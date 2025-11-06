package week1;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// 임포트가 뭔지 설명해주기, 그리고 여기서 임포트를 쉽게 하는 방법 설명

public class _02_Button extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button bt = new Button("클릭");

        bt.setOnAction(e -> {
            System.out.println("클릭했습니다.");
        });

        VBox vb = new VBox(bt);

        Scene scene = new Scene(vb, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("버튼실습");
        primaryStage.show();
    }
}
