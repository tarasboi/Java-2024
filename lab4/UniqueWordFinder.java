import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Клас для представлення літери
class Letter {
    private final char character;

    public Letter(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}

// Клас для представлення слова, яке складається з масиву літер
class Word {
    private final List<Letter> letters = new ArrayList<>();

    public Word(String word) {
        for (char character : word.toCharArray()) {
            letters.add(new Letter(character));
        }
    }

    public String getWord() {
        StringBuilder word = new StringBuilder();
        for (Letter letter : letters) {
            word.append(letter.getCharacter());
        }
        return word.toString();
    }
}

// Клас для представлення розділового знака
class Punctuation {
    private final char symbol;

    public Punctuation(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}

// Клас для представлення речення, яке складається з масиву слів та розділових знаків
class Sentence {
    private final List<Word> words = new ArrayList<>();
    private final List<Punctuation> punctuations = new ArrayList<>();

    public Sentence(String sentence) {
        String[] wordArray = sentence.trim().split("\\s+");
        for (String word : wordArray) {
            if (!word.isEmpty()) {
                words.add(new Word(word));
            }
        }
        if (sentence.endsWith(".")) {
            punctuations.add(new Punctuation('.'));
        }
    }

    public List<Word> getWords() {
        return words;
    }

    public List<Punctuation> getPunctuations() {
        return punctuations;
    }
}

// Клас для представлення тексту, який складається з масиву речень
class Text {
    private final List<Sentence> sentences = new ArrayList<>();

    public Text(String text) {
        String[] sentenceArray = text.split("\\.");
        for (String sentence : sentenceArray) {
            if (!sentence.trim().isEmpty()) {
                sentences.add(new Sentence(sentence.trim()));
            }
        }
    }

    public List<Sentence> getSentences() {
        return sentences;
    }
}

// Головний клас, що виконує операції пошуку унікальних слів
public class UniqueWordFinder {
    
    // Метод пошуку унікальних слів у першому реченні
    public void findUniqueWord(Text text) {
        List<Sentence> sentences = text.getSentences();
        
        if (sentences.isEmpty()) {
            System.out.println("Текст не містить речень.");
            return;
        }

        // Отримання слів першого речення
        Set<String> firstSentenceWords = new HashSet<>();
        for (Word word : sentences.get(0).getWords()) {
            firstSentenceWords.add(word.getWord());
        }

        // Пошук спільних слів з іншими реченнями
        for (int i = 1; i < sentences.size(); i++) {
            Set<String> otherSentenceWords = new HashSet<>();
            for (Word word : sentences.get(i).getWords()) {
                otherSentenceWords.add(word.getWord());
            }
            firstSentenceWords.removeAll(otherSentenceWords); // Видаляємо спільні слова
        }

        // Виведення результату
        if (!firstSentenceWords.isEmpty()) {
            System.out.println("Унікальне слово в першому реченні: " + firstSentenceWords.iterator().next());
        } else {
            System.out.println("Унікальних слів у першому реченні не знайдено.");
        }
    }

    public static void main(String[] args) {
        String inputText = "це перше речення. А це друге. Третє речення не має спільних слів з першим.";
        
        // Видаляємо зайві пробіли і табуляції, замінюючи їх на один пробіл
        inputText = inputText.replaceAll("\\s+", " ");

        // Створюємо об'єкт Text для обробки вхідного тексту
        Text text = new Text(inputText);

        // Створюємо об'єкт UniqueWordFinder і виконуємо пошук унікальних слів
        UniqueWordFinder finder = new UniqueWordFinder();
        finder.findUniqueWord(text);
    }
}
