package Structural.Flyweight;

import java.util.HashMap;
import java.util.Map;

// Flyweight interface
interface TextCharacter {
    void display();
}

// Concrete Flyweight (Shared)
class CharacterStyle implements TextCharacter {
    private char character;
    private String style;

    CharacterStyle(char character, String style) {
        this.character = character;
        this.style = style;
    }

    public void display() {
        System.out.println("Character: " + character + ", Style: " + style);
    }
}

// Flyweight Factory
class CharacterStyleFactory {
    private Map<Character, CharacterStyle> characterStyleMap = new HashMap<>();

    CharacterStyle getCharacterStyle(char character, String style) {
        characterStyleMap.putIfAbsent(character, new CharacterStyle(character, style));
        return characterStyleMap.get(character);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        CharacterStyleFactory factory = new CharacterStyleFactory();

        String text = "Hello, Flyweight Pattern!";
        for (char c : text.toCharArray()) {
            TextCharacter character = factory.getCharacterStyle(c, "Times New Roman 12pt");
            character.display();
        }
    }
}
