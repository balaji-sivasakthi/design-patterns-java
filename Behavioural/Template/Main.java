package Behavioural.Template;

// Abstract class with template method
abstract class DocumentGenerator {
    // Template method that defines the common algorithm structure
    public void generateDocument() {
        createHeader();
        createContent();
        createFooter();
    }

    // Abstract methods to be implemented by subclasses
    protected abstract void createHeader();
    protected abstract void createContent();
    protected abstract void createFooter();
}

// Concrete subclasses with specific implementations
class PdfDocumentGenerator extends DocumentGenerator {
    protected void createHeader() {
        System.out.println("PDF Header");
    }

    protected void createContent() {
        System.out.println("PDF Content");
    }

    protected void createFooter() {
        System.out.println("PDF Footer");
    }
}

class HtmlDocumentGenerator extends DocumentGenerator {
    protected void createHeader() {
        System.out.println("HTML Header");
    }

    protected void createContent() {
        System.out.println("HTML Content");
    }

    protected void createFooter() {
        System.out.println("HTML Footer");
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        DocumentGenerator pdfGenerator = new PdfDocumentGenerator();
        DocumentGenerator htmlGenerator = new HtmlDocumentGenerator();

        System.out.println("Generating PDF document:");
        pdfGenerator.generateDocument();

        System.out.println("\nGenerating HTML document:");
        htmlGenerator.generateDocument();
    }
}
