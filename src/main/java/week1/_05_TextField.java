package week1;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class _05_TextField extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override

    /*가장 먼저 기본 틀 알려주기 -> textfield
    * 그 다음에 tf.setPromptText
    * 그 다음에 버튼 2개 만들고
    * 그 다음에 버튼으로 getText하는 거 알려주기
    * 그 다음에 tf.setOnAction알려주고
    * 그 다음에 bt2.fire 알려주기
    * */
    public void start(Stage primaryStage) {
        TextField tf = new TextField(); // 먼저 보여준 다음 나중에 다 알려주기

        tf.setPromptText("입력하세요"); // 나중에 알려주기

        Button bt = new Button("GetText");
        Button bt2 = new Button("SetText");

        bt.setOnAction(e->{
            String text = tf.getText().trim();

            System.out.println(text);
        });

        bt2.setOnAction(e->{
            tf.setText("Text Changed");
        });

        tf.setOnAction(e->{
            bt2.fire(); // 강제로 이벤트를 발생시키는 것. 나중에 알려주기
        });

        VBox vb = new VBox(tf, bt, bt2);
        Scene sc = new Scene(vb, 500, 500);

        primaryStage.setScene(sc);
        primaryStage.show();
    }
}
