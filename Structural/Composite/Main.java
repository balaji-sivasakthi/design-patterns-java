package Structural.Composite;

import java.util.ArrayList;
import java.util.List;

// Component (common interface)
interface FileSystemComponent {
    void display();
}

// Leaf (File)
class File implements FileSystemComponent {
    private final String name;

    File(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("File: " + name);
    }
}

// Composite (Folder)
class Folder implements FileSystemComponent {
    private final String name;
    private final List<FileSystemComponent> components = new ArrayList<>();

    Folder(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void display() {
        System.out.println("Folder: " + name);
        for (FileSystemComponent component : components) {
            component.display();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Folder root = new Folder("Root");
        Folder folder1 = new Folder("Folder 1");
        Folder folder2 = new Folder("Folder 2");
        FileSystemComponent file1 = new File("File 1");
        FileSystemComponent file2 = new File("File 2");

        folder1.addComponent(file1);
        folder2.addComponent(file2);
        root.addComponent(folder1);
        root.addComponent(folder2);

        root.display();
    }
}