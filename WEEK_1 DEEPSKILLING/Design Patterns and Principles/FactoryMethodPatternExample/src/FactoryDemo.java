import java.util.Locale;

public class FactoryDemo {

public static Document getDocument(String type){
    if (type.equalsIgnoreCase("word")){
        DocumentFactory wordFactory = new WordFactory();
        return  wordFactory.createDocument();
    } else if (type.equalsIgnoreCase("pdf")) {
        DocumentFactory pdfFactory = new PdfFactory();
       return  pdfFactory.createDocument();

    }
    else if (type.equalsIgnoreCase("excel")) {
        DocumentFactory excelFactory = new ExcelFactory();
        return excelFactory.createDocument();

    }
    return null;
}
}
