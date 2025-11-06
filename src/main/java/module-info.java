module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens week1 to javafx.fxml;
    exports week1;
    exports week2;
    exports week3;
    exports _10_28;
    exports _11_04;
    opens week2 to javafx.fxml;
    opens week3 to javafx.fxml;
    opens _10_28 to javafx.fxml;
    opens _11_04 to javafx.fxml;
}