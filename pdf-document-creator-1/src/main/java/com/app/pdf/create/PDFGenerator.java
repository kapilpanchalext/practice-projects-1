package com.app.pdf.create;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.app.pdf.util.Constants;
import com.itextpdf.awt.geom.Line2D;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPage;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.Line;

@Component
public class PDFGenerator {

	public void generatePdf(String string) throws FileNotFoundException, DocumentException {
		
		Constants constants = new Constants();
		
		Document document = new Document(constants.PAGE_SIZE_A4, 
				constants.MARGINS_50, 
				constants.MARGINS_50, 
				constants.MARGINS_50, 
				constants.MARGINS_50);
		
		PdfWriter writer = new PdfWriter();
		
		PdfDocument pdf = new PdfDocument();
		
		PdfWriter.getInstance(document, new FileOutputStream("helloWorld.pdf"));
		
		PdfPage page = pdf.add
		PdfCanvas pdfCanvas = new PdfCanvas(page);
		
		Line line = new Line(0,0,500,0);
		
		
		document.open();
		
		Paragraph para = new Paragraph(string);
		document.add(line);
		document.add(para);
		
		document.close();
	}
}
