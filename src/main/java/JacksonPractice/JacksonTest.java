package JacksonPractice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;

public class JacksonTest {
    public static void main(String[] args) {
        try {
            // ObjectMapper 생성
            ObjectMapper mapper = new ObjectMapper(); // ObjectMapper 인스턴스 생성
            mapper.enable(SerializationFeature.INDENT_OUTPUT); // 예쁘게 출력되게 설정 변경

            // 1. Card 생성
            Card card = new Card("질문", "답", 5, 2);
            System.out.println("📝 Card 객체 생성 완료");

            // 2. JSON 파일로 저장
            mapper.writeValue(new File("card.json"), card); // card.json이란 파일로 card 인스턴스 저장
            System.out.println("✅ card.json 저장 완료!");

            // 3. 콘솔에 JSON 출력
            String json = mapper.writeValueAsString(card); // card 인스턴스를 정리된 문자열로 바꿔줌
            System.out.println("\n📄 JSON 내용:");
            System.out.println(json); // 그걸 출력해서 보여줌

            // 4. JSON 파일에서 불러오기
            Card loadedCard = mapper.readValue(new File("card.json"), Card.class); // 저장된 card.json을 가져옴 그래서 Card란 클래스 형식에 맞게 그걸 다시 인스턴스화 시켜줌
            System.out.println("\n✅ card.json 불러오기 완료!");
            System.out.println("질문: " + loadedCard.getQuestion()); // 인스턴스의 getter메서드로 질문 출력
            System.out.println("답: " + loadedCard.getAnswer()); // 위와 전부 마찬가지
            System.out.println("맞은 횟수: " + loadedCard.getCorrectCount());
            System.out.println("틀린 횟수: " + loadedCard.getWrongCount());

            System.out.println("\n🎉 모든 테스트 성공!");

        } catch (Exception e) {
            System.err.println("❌ 에러 발생!");
        }
    }
}