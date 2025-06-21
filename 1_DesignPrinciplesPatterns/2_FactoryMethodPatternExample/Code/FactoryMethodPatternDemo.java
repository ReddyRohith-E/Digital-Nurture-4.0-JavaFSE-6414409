package Week1.FactoryMethodPatternExample;

import Week1.FactoryMethodPatternExample.documents.*;

public class FactoryMethodPatternDemo {
    public static void main(String[] args) {
        DocumentFactory word = new WordDocumentFactory();
        Document wd = word.createDocument();
        wd.open();

        DocumentFactory pdf = new PdfDocumentFactory();
        Document pdfDoc = pdf.createDocument();
        pdfDoc.open();

        DocumentFactory excel = new ExcelDocumentFactory();
        Document excelDoc = excel.createDocument();
        excelDoc.open();
    }
}
