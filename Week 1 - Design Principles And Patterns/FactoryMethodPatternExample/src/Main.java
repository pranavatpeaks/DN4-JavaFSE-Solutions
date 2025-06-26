import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select document type to open (word/pdf/excel): ");
        String choice = scanner.nextLine().toLowerCase();

        DocumentFactory factory;
        switch (choice) {
            case "word":
                factory = new WordDocumentFactory();
                break;
            case "pdf":
                factory = new PdfDocumentFactory();
                break;
            case "excel":
                factory = new ExcelDocumentFactory();
                break;
            default:
                System.out.println("Invalid document type selected.");
                scanner.close();
                return;
        }

        Document doc = factory.createDocument();
        doc.open();
        scanner.close();
    }
}
