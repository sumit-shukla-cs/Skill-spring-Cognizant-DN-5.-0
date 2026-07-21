public class Exercise02_FactoryMethodDocumentDemo {
    public static void main(String[] args) {
        DocumentFactory[] factories = {
                new WordDocumentFactory(),
                new PdfDocumentFactory(),
                new ExcelDocumentFactory()
        };

        for (DocumentFactory factory : factories) {
            factory.openDocument();
        }
    }
}

interface DocumentProduct {
    void open();
}

final class WordDocumentProduct implements DocumentProduct {
    @Override
    public void open() {
        System.out.println("Opening a Word document");
    }
}

final class PdfDocumentProduct implements DocumentProduct {
    @Override
    public void open() {
        System.out.println("Opening a PDF document");
    }
}

final class ExcelDocumentProduct implements DocumentProduct {
    @Override
    public void open() {
        System.out.println("Opening an Excel document");
    }
}

abstract class DocumentFactory {
    public abstract DocumentProduct createDocument();

    public void openDocument() {
        DocumentProduct document = createDocument();
        System.out.println("Factory created: " + document.getClass().getSimpleName());
        document.open();
    }
}

final class WordDocumentFactory extends DocumentFactory {
    @Override
    public DocumentProduct createDocument() {
        return new WordDocumentProduct();
    }
}

final class PdfDocumentFactory extends DocumentFactory {
    @Override
    public DocumentProduct createDocument() {
        return new PdfDocumentProduct();
    }
}

final class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public DocumentProduct createDocument() {
        return new ExcelDocumentProduct();
    }
}