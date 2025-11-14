package _11_14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {

    // 계산기 상태 3개만!
    private String firstNumber = null;   // 첫 번째 숫자 (null이면 아직 안 들어옴)
    private String operator = null;      // 연산자 (null이면 아직 안 들어옴)
    private String secondNumber = null;  // 두 번째 숫자 (null이면 아직 안 들어옴)

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane buttonsPane = new GridPane();
        TextField result = new TextField("0");
        result.setEditable(false);
        result.setStyle("-fx-font-size: 24px; -fx-alignment: center-right;");

        VBox root = new VBox(result, buttonsPane);
        VBox.setVgrow(buttonsPane, Priority.ALWAYS);

        // 버튼 생성
        Button bt1 = new Button("1");
        Button bt2 = new Button("2");
        Button bt3 = new Button("3");
        Button bt4 = new Button("4");
        Button bt5 = new Button("5");
        Button bt6 = new Button("6");
        Button bt7 = new Button("7");
        Button bt8 = new Button("8");
        Button bt9 = new Button("9");
        Button bt0 = new Button("0");
        Button bt_div = new Button("/");
        Button bt_mul = new Button("x");
        Button bt_minus = new Button("-");
        Button bt_plus = new Button("+");
        Button bt_equal = new Button("=");

        // 버튼 배치
        buttonsPane.add(bt7, 0, 0);
        buttonsPane.add(bt8, 1, 0);
        buttonsPane.add(bt9, 2, 0);
        buttonsPane.add(bt_div, 3, 0);

        buttonsPane.add(bt4, 0, 1);
        buttonsPane.add(bt5, 1, 1);
        buttonsPane.add(bt6, 2, 1);
        buttonsPane.add(bt_mul, 3, 1);

        buttonsPane.add(bt1, 0, 2);
        buttonsPane.add(bt2, 1, 2);
        buttonsPane.add(bt3, 2, 2);
        buttonsPane.add(bt_minus, 3, 2);

        buttonsPane.add(bt0, 0, 3);
        buttonsPane.add(bt_equal, 2, 3);
        buttonsPane.add(bt_plus, 3, 3);

        // 숫자 버튼 이벤트
        bt0.setOnAction(e -> handleNumber("0", result));
        bt1.setOnAction(e -> handleNumber("1", result));
        bt2.setOnAction(e -> handleNumber("2", result));
        bt3.setOnAction(e -> handleNumber("3", result));
        bt4.setOnAction(e -> handleNumber("4", result));
        bt5.setOnAction(e -> handleNumber("5", result));
        bt6.setOnAction(e -> handleNumber("6", result));
        bt7.setOnAction(e -> handleNumber("7", result));
        bt8.setOnAction(e -> handleNumber("8", result));
        bt9.setOnAction(e -> handleNumber("9", result));

        // 연산자 버튼 이벤트
        bt_plus.setOnAction(e -> handleOperator("+", result));
        bt_minus.setOnAction(e -> handleOperator("-", result));
        bt_mul.setOnAction(e -> handleOperator("x", result));
        bt_div.setOnAction(e -> handleOperator("/", result));

        // = 버튼 이벤트
        bt_equal.setOnAction(e -> handleEqual(result));

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("계산기");
        primaryStage.show();
    }

    // 숫자 버튼 눌렀을 때
    private void handleNumber(String num, TextField result) {
        if (operator == null) {
            // 연산자가 아직 안 들어왔으면 firstNumber에 추가
            if (firstNumber == null) {
                firstNumber = num;
            } else {
                firstNumber += num;
            }
            result.setText(firstNumber);
        } else {
            // 연산자가 들어왔으면 secondNumber에 추가
            if (secondNumber == null) {
                secondNumber = num;
            } else {
                secondNumber += num;
            }
            result.setText(secondNumber);
        }
    }

    // 연산자 버튼 눌렀을 때
    private void handleOperator(String op, TextField result) {
        if (firstNumber != null) {
            operator = op;
        }
    }

    // = 버튼 눌렀을 때
    private void handleEqual(TextField result) {
        // 세 개 다 들어왔는지 확인
        if (firstNumber == null || operator == null || secondNumber == null) {
            return;
        }

        // 계산 (정수로!)
        int num1 = Integer.parseInt(firstNumber);
        int num2 = Integer.parseInt(secondNumber);
        int answer = 0;

        switch (operator) {
            case "+":
                answer = num1 + num2;
                break;
            case "-":
                answer = num1 - num2;
                break;
            case "x":
                answer = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    result.setText("오류");
                    // 초기화
                    firstNumber = null;
                    operator = null;
                    secondNumber = null;
                    return;
                }
                answer = num1 / num2;  // 정수 나눗셈 (몫만)
                break;
        }

        // 결과 표시
        result.setText(String.valueOf(answer));

        // 초기화 (다음 계산 준비)
        firstNumber = null;
        operator = null;
        secondNumber = null;
    }
}