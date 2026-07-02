public abstract class DocumentFactory {
    // The Factory Method
    public abstract Document createDocument();
    
    // Optional: A template method that uses the factory method
    public void manageDocument() {
        Document doc = createDocument();
        doc.open();
        doc.save();
        doc.close();
    }
}