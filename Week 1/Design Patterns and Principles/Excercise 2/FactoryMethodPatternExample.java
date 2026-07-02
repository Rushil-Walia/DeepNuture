public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        
        System.out.println("--- Testing Word Document ---");
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.save();

        System.out.println("\n--- Testing PDF Document ---");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        // You can also use the template method if you added it
        pdfFactory.manageDocument(); 

        System.out.println("\n--- Testing Excel Document ---");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}