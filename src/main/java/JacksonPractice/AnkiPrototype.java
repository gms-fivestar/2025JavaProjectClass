package JacksonPractice;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class AnkiPrototype extends Application {

    // 상수
    private static final String DECK_FILE = "deck.json";
    private static final String INITIAL_MESSAGE = "문제가 여기에 표시됩니다!";
    private static final String BTN_START = "시작하기";
    private static final String BTN_END = "끝내기";
    private static final String BTN_SHOW_ANSWER = "정답 보기";

    // 앱 상태
    private enum State { READY, PLAYING, FINISHED }
    private State currentState = State.READY;

    // 데이터
    private Deck deck;
    private int currentIndex;
    private int correctCount;

    // UI 컴포넌트
    private Label questionLabel;
    private TextField answerField;
    private Button checkButton;
    private Button startEndButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        loadDeck();
        initUI();
        setupEventHandlers();
        setupLayout(primaryStage);
    }

    private void loadDeck() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            deck = mapper.readValue(new File(DECK_FILE), Deck.class);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void initUI() {
        questionLabel = new Label(INITIAL_MESSAGE);
        answerField = new TextField();
        checkButton = new Button(BTN_SHOW_ANSWER);
        startEndButton = new Button(BTN_START);

        updateUIState(State.READY);
    }

    private void setupEventHandlers() {
        startEndButton.setOnAction(e -> handleStartEndButton());
        checkButton.setOnAction(e -> showAnswer());
        answerField.setOnAction(e -> handleAnswerSubmit());
    }

    private void setupLayout(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(questionLabel, answerField, checkButton, startEndButton);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Anki 퀴즈");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleStartEndButton() {
        if (currentState == State.READY) {
            startQuiz();
        } else {
            endQuiz();
        }
    }

    private void startQuiz() {
        currentIndex = 0;
        correctCount = 0;
        updateUIState(State.PLAYING);
        showCurrentQuestion();
    }

    private void endQuiz() {
        updateUIState(State.FINISHED);
        questionLabel.setText("맞춘 개수 : " + correctCount);
    }

    private void handleAnswerSubmit() {
        if (currentState != State.PLAYING || currentIndex >= deck.getCardCount()) {
            return;
        }

        checkAnswer();
        moveToNextQuestion();
    }

    private void checkAnswer() {
        String userAnswer = answerField.getText().trim();
        String correctAnswer = deck.getCard(currentIndex).getAnswer();

        if (userAnswer.equals(correctAnswer)) {
            correctCount++;
        }
    }

    private void moveToNextQuestion() {
        currentIndex++;

        if (currentIndex >= deck.getCardCount()) {
            finishQuiz();
        } else {
            showCurrentQuestion();
        }
    }

    private void finishQuiz() {
        updateUIState(State.FINISHED);
        questionLabel.setText("완료! 맞춘 개수 : " + correctCount);
    }

    private void showCurrentQuestion() {
        questionLabel.setText(deck.getCard(currentIndex).getQuestion());
        answerField.clear();
    }

    private void showAnswer() {
        if (currentState == State.PLAYING && currentIndex < deck.getCardCount()) {
            questionLabel.setText("정답: " + deck.getCard(currentIndex).getAnswer());
        }
    }

    private void updateUIState(State newState) {
        currentState = newState;

        switch (newState) {
            case READY:
                answerField.setDisable(true);
                answerField.clear();
                checkButton.setDisable(true);
                startEndButton.setText(BTN_START);
                break;

            case PLAYING:
                answerField.setDisable(false);
                checkButton.setDisable(false);
                startEndButton.setText(BTN_END);
                break;

            case FINISHED:
                answerField.setDisable(true);
                checkButton.setDisable(true);
                startEndButton.setText(BTN_START);
                break;
        }
    }
}
