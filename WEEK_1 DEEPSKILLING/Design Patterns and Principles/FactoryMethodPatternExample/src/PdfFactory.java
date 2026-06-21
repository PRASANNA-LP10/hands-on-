public class PdfFactory implements DocumentFactory{
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}
