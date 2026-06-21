public class ExcelFactory implements DocumentFactory{
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}
