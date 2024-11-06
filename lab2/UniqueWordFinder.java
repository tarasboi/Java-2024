import java.util.HashSet;
import java.util.Set;

public class UniqueWordFinder {

    public static void main(String[] args) {
        String text = "це перше речення. А це друге. Третє речення не має спільних слів з першим.";

        String[] sentences = text.split("\\."); // Розділяємо текст на речення за крапкою

        Set<String> firstSentenceWords = new HashSet<>(Set.of(sentences[0].split("\\s+"))); // Створюємо множину слів першого речення

        for (int i = 1; i < sentences.length; i++) {
            String[] words = sentences[i].split("\\s+");
            firstSentenceWords.removeAll(Set.of(words)); // Видаляємо слова, що зустрічаються в наступних реченнях
        }

        if (!firstSentenceWords.isEmpty()) {
            System.out.println("Унікальне слово в першому реченні: " + firstSentenceWords.iterator().next());
        } else {
            System.out.println("Унікальних слів у першому реченні не знайдено.");
        }
    }
}