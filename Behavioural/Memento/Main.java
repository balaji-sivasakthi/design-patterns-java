package Behavioural.Memento;

import java.util.ArrayList;
import java.util.List;

// Originator
class TextEditor {
    private String content;

    String getContent() {
        return content;
    }

    void setContent(String content) {
        this.content = content;
    }

    Memento save() {
        return new Memento(content);
    }

    void restore(Memento memento) {
        content = memento.getState();
    }
}

// Memento
class Memento {
    private String state;

    Memento(String state) {
        this.state = state;
    }

    String getState() {
        return state;
    }
}

// Caretaker
class History {
    private List<Memento> mementos = new ArrayList<>();

    void save(Memento memento) {
        mementos.add(memento);
    }

    Memento get(int index) {
        return mementos.get(index);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        History history = new History();

        textEditor.setContent("First text");
        history.save(textEditor.save());

        textEditor.setContent("Modified text");
        history.save(textEditor.save());

        textEditor.setContent("Latest text");
        history.save(textEditor.save());

        System.out.println("Current content: " + textEditor.getContent());

        textEditor.restore(history.get(1)); // Revert to the second state

        System.out.println("Content after restoring: " + textEditor.getContent());
    }
}