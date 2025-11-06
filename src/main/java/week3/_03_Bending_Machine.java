package week3;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class _03_Bending_Machine extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ListView<Soda> lv = new ListView<>();
        ObservableList<Soda> ov = FXCollections.observableArrayList();
        lv.setItems(ov);

        Button purchaseButton = new Button("구매하기");
        Label countLabel = new Label("팔린 음료 수 : " + Soda.count);
        Label totalPriceLabel = new Label("판매한 금액 : " + Soda.totalPrice);

        ov.addAll(new Soda("코카콜라", 1300), new Soda("사이다", 1700), new Soda("펩시", 1300));


        purchaseButton.setOnAction(e->{
            Soda selected = lv.getSelectionModel().getSelectedItem();

            System.out.println(selected.name + "을 구매해주셔서 감사합니다~! 가격은 " + selected.price + "원 이에요");
            Soda.count++;
            Soda.totalPrice += selected.price;

            countLabel.setText("팔린 음료 수 : " + Soda.count);
            totalPriceLabel.setText("판매한 금액 : " + Soda.totalPrice);
        });


        HBox bar = new HBox(30, purchaseButton, countLabel, totalPriceLabel);

        VBox root = new VBox(lv, bar);
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("자판기");
        primaryStage.show();
    }
}