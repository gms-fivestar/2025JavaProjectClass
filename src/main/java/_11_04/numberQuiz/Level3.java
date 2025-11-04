package _11_04.numberQuiz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Level3 extends Application {
    // 해당 클래스의 인스턴스 변수가 됨. start() 메서드 안에서 사용하기 위해선
    // 이렇게 클래스의 인스턴스 변수로 선언해줘야 함
    int min;
    int max;
    int currentGuess;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label guess = new Label("지금부터 제가 1부터 100사이의 당신이 생각한 숫자를 맞추겠습니다.");

        Button upButton = new Button("up입니다.");
        Button downButton = new Button("down입니다.");
        Button correctButton = new Button("정답입니다!");
        Button startButton = new Button("시작하기");
        
        // 새로운 메서드 : setDisable() -> true로 설정하면, 해당 버튼을 클릭할 수 없어진다. false로 하면 클릭 가능해짐.
        upButton.setDisable(true);
        downButton.setDisable(true);
        correctButton.setDisable(true);

        startButton.setOnAction(e->{
            resetGame(false, startButton, upButton, downButton, correctButton);

            this.min = 1;
            this.max = 100;

            this.currentGuess = (this.min + this.max) / 2;
            guess.setText("당신이 생각한 숫자는 " + currentGuess + " 입니까?");
        });

        upButton.setOnAction(e-> {
            this.min = this.currentGuess + 1;

            if(this.min > this.max) {
                guess.setText("아니 당신..; 사기치는 거 아니에요?");
                resetGame(true, startButton, upButton, downButton, correctButton);
            }

            else {
                this.currentGuess = (this.min + this.max) / 2;
                guess.setText("당신이 생각한 숫자는 " + currentGuess + " 입니까?");
            }
        });

        downButton.setOnAction(e->{
            this.max = this.currentGuess - 1;

            if(this.min > this.max) {
                guess.setText("아니 당신..; 사기치는 거 아니에요?");
                resetGame(true, startButton, upButton, downButton, correctButton);
            }

            else {
                this.currentGuess = (this.min + this.max) / 2;
                guess.setText("당신이 생각한 숫자는 " + currentGuess + " 입니까?");
            }
        });

        correctButton.setOnAction(e -> {
            guess.setText("성공! 당신이 생각한 숫자는 " + this.currentGuess + " 입니다! 다시 시작하려면 시작하기 버튼을 누르세요.");
            resetGame(true, startButton, upButton, downButton, correctButton);
        });

        HBox buttons = new HBox(correctButton, downButton, upButton);
        VBox root = new VBox(guess, startButton, buttons);

        Scene scene = new Scene(root, 600, 600);

        primaryStage.setScene(scene);
        primaryStage.setTitle("lv3");
        primaryStage.show();
    }

    private void resetGame(boolean init, Button startButton, Button upButton, Button downButton, Button correctButton) {
        startButton.setDisable(!init);
        upButton.setDisable(init);
        downButton.setDisable(init);
        correctButton.setDisable(init);
    }
}
