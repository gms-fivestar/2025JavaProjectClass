package JacksonPractice;

// JavaFX 애플리케이션이 아니라, Java 클래스 파일로 만들기

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;

public class DeckJsonTest {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT); // 예쁘게!

        try {
            // 1. Deck 만들기
            Deck deck = new Deck("영어 단어");
            deck.addCard(new Card("apple", "사과", 5, 1));
            deck.addCard(new Card("banana", "바나나", 5, 1));
            deck.addCard(new Card("cherry", "체리", 5, 1));

            // 2. 저장
            mapper.writeValue(new File("deck.json"), deck);
            System.out.println("✅ 덱 저장 완료!");

            // 3. 불러오기
            Deck loadedDeck = mapper.readValue(new File("deck.json"), Deck.class);
            System.out.println("✅ 덱 불러오기 완료!");
            System.out.println("덱 이름: " + loadedDeck.getName());
            System.out.println("카드 개수: " + loadedDeck.getCards().size());

            for (Card card : loadedDeck.getCards()) {
                System.out.println("- " + card.getQuestion() + " = " + card.getAnswer());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

