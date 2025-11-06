package week1;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class _03_Label extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label lb = new Label("Study");
        Button bt = new Button("라벨 바꾸기");

        bt.setOnAction(e->{
            lb.setText("study싫어");
        });

        Button bt2 = new Button("라벨 가져오기");

        bt2.setOnAction(e->{
            String text = lb.getText();
            System.out.println(text);
        });

        VBox vb = new VBox(lb, bt, bt2);

        Scene scene = new Scene(vb, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("라벨");
        primaryStage.show();
    }
}
