package week3;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class _02_ListView_part3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ListView<Person> lv = new ListView<>();
        ObservableList<Person> ov = FXCollections.observableArrayList();
        lv.setItems(ov);

        Button addButton = new Button("추가하기");
        Button removeButton = new Button("제거하기");
        Button updateButton = new Button("변경하기");
        Button infoButton = new Button("정보 출력");

        TextField nameField = new TextField();
        TextField cityField = new TextField();

        nameField.setPromptText("이름을 입력하세요..");
        cityField.setPromptText("발령지를 입력하세요..");

        HBox buttons = new HBox(addButton, removeButton, updateButton, infoButton);
        HBox fields = new HBox(20, nameField, cityField);
        VBox root = new VBox(10, lv, fields, buttons);

        addButton.setOnAction(e->{
            Person newPerson = new Person(nameField.getText(), cityField.getText());

            ov.add(newPerson);
        });

        removeButton.setOnAction(e->{
            Person selected = lv.getSelectionModel().getSelectedItem();

            System.out.println(selected.getName() + "의 정보를 삭제합니다.");

            ov.remove(selected);
        });

        infoButton.setOnAction(e->{
            Person selected = lv.getSelectionModel().getSelectedItem();

            System.out.println("이름 : " + selected.getName() + "  발령지 : " + selected.getCity());
        });

        updateButton.setOnAction(e->{
            Person selected = lv.getSelectionModel().getSelectedItem();
            int index = lv.getSelectionModel().getSelectedIndex();

            Person newPerson = new Person(nameField.getText(), cityField.getText());

            ov.set(index, newPerson);
        });


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("학생관리시스템");
        primaryStage.show();
    }
}
