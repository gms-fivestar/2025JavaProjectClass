module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    exports _11_04.numberQuiz;
    opens _11_04.numberQuiz to javafx.fxml;
}