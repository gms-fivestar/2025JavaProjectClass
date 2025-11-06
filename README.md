### 🏷️ Label (라벨)

단순 텍스트를 화면에 보여줄 때 사용합니다.

* **생성:** `Label myLabel = new Label("초기 텍스트");`
* **핵심 메서드:**
    * `myLabel.setText("바꿀 텍스트");`
        * 라벨의 텍스트를 변경합니다.
        * (예: 카운터 숫자 변경, 계산기 결과 표시, 숫자 퀴즈 Up/Down)
    * `String text = myLabel.getText();`
        * 라벨의 현재 텍스트를 가져옵니다.
        * (예: 카운터의 현재 숫자를 가져와서 1 더하기)

### 🔳 Button (버튼)

사용자가 클릭해서 특정 동작(이벤트)을 실행시킬 때 사용합니다.

* **생성:** `Button myButton = new Button("버튼 텍스트");`
* **핵심 메서드:**
    * `myButton.setOnAction(e -> { ... });`
        * **가장 중요!** 버튼이 클릭되었을 때 `{ ... }` 안의 코드를 실행합니다.
    * `myButton.fire();`
        * 코드로 버튼을 강제로 클릭합니다.
    * `myButton.setDisable(true);`
        * 버튼을 비활성화시킵니다. (true = 비활성화, false = 활성화)

### ⌨️ TextField (텍스트필드)

사용자에게 한 줄의 텍스트를 입력받을 때 사용합니다.

* **생성:** `TextField myField = new TextField();`
* **핵심 메서드:**
    * `String text = myField.getText();`
        * 사용자가 입력한 텍스트를 가져옵니다.
    * `myField.setText("새로운 텍스트");`
        * 텍스트필드의 내용을 코드로 변경합니다.
    * `myField.setPromptText("안내 문구");`
        * 사용자가 입력하기 전에 보여주는 회색 안내 문구(placeholder)를 설정합니다.
    * `myField.setOnAction(e -> { ... });`
        * 텍스트필드에 포커스된 상태에서 **'Enter' 키**를 눌렀을 때 `{ ... }` 안의 코드를 실행합니다.

### 📝 TextArea (텍스트영역)

여러 줄의 텍스트를 입력받거나 보여줄 때 사용합니다. (TextField와 사용법이 거의 동일)

* **생성:** `TextArea myArea = new TextArea();`
* **핵심 메서드:**
    * `String text = myArea.getText();`
    * `myArea.setText("새로운 텍스트");`

### 🗂️ ListView (리스트뷰)

여러 개의 항목(데이터)을 목록 형태로 보여주고 선택할 때 사용합니다.

* **생성 및 설정:**
    * `ListView<String> lv = new ListView<>();`
        * `<String>`: 이 리스트는 문자열(String)만 담겠다는 의미.
        * (예: `Person` 객체 담기 `ListView<Person> lv = new ListView<>();`)
    * `ObservableList<String> ov = FXCollections.observableArrayList();`
        * ListView에 연결할 실제 '데이터 보관함(List)'을 만듭니다.
    * `lv.setItems(ov);`
        * ListView(보여지는 UI)와 ObservableList(데이터)를 연결합니다.

* **데이터 조작 (ObservableList 메서드):**
    * `ov.add("추가할 데이터");`
    * `ov.addAll("데이터1", "데이터2", ...);`
    * `ov.remove("삭제할 데이터");`
    * `ov.set(바꿀인덱스, "새 데이터");`

* **선택 및 이벤트 (ListView 메서드):**
    * `String selected = lv.getSelectionModel().getSelectedItem();`
        * 현재 선택된 항목(데이터)을 가져옵니다.
    * `int index = lv.getSelectionModel().getSelectedIndex();`
        * 현재 선택된 항목의 인덱스(순번)를 가져옵니다.
    * `lv.setOnMouseClicked(e -> { ... });`
        * 리스트의 항목을 클릭했을 때 `{ ... }` 안의 코드를 실행합니다.
    * `lv.getSelectionModel().selectedItemProperty().addListener(...);`
        * (고급) 선택된 항목이 '변경'될 때마다 코드를 실행합니다.

### 📦 Layout (레이아웃)

UI 요소들을 담는 '틀' 또는 '컨테이너'입니다.

* `VBox`
    * UI 요소들을 **세로(Vertical)**로 차곡차곡 쌓습니다.
    * `VBox vb = new VBox(item1, item2, ...);`
* `HBox`
    * UI 요소들을 **가로(Horizontal)**로 나란히 쌓습니다.
    * `HBox hb = new HBox(item1, item2, ...);`
