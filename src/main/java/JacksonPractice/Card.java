package JacksonPractice;

public class Card {
    private String question;
    private String answer;
    private int correctCount;
    private int wrongCount;

    // 1. 기본 생성자 (Jackson 필수!)
    public Card() {
    }

    // 2. 모든 필드를 받는 생성자
    public Card(String question, String answer, int correctCount, int wrongCount) {
        this.question = question;
        this.answer = answer;
        this.correctCount = correctCount;
        this.wrongCount = wrongCount;
    }

    // 3. Getter 메서드들 (Jackson이 JSON 변환할 때 사용!)
    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getWrongCount() {
        return wrongCount;
    }

    // 4. Setter 메서드들 (Jackson이 JSON에서 객체 만들 때 사용!)
    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setCorrectCount(int correctCount) {
        this.correctCount = correctCount;
    }

    public void setWrongCount(int wrongCount) {
        this.wrongCount = wrongCount;
    }
}
