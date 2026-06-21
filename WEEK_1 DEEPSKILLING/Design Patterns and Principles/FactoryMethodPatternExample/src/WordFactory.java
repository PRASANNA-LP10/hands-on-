public class WordFactory implements DocumentFactory{
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}
