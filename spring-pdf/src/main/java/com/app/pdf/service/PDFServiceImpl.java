package com.app.pdf.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.stream.Stream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


@Service
public class PDFServiceImpl implements PDFService {
	
	String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
    		+ "Euismod elementum nisi quis eleifend quam adipiscing vitae proin sagittis. "
    		+ "Massa eget egestas purus viverra accumsan in. "
    		+ "Habitant morbi tristique senectus et netus. "
    		+ "Elit duis tristique sollicitudin nibh sit amet commodo nulla. "
    		+ "Ullamcorper malesuada proin libero nunc consequat interdum varius sit. "
    		+ "Nec ullamcorper sit amet risus nullam. "
    		+ "Massa id neque aliquam vestibulum morbi blandit cursus. "
    		+ "Eget dolor morbi non arcu risus quis varius quam. "
    		+ "Odio facilisis mauris sit amet massa vitae tortor. "
    		+ "Pretium vulputate sapien nec sagittis aliquam malesuada bibendum arcu vitae. "
    		+ "Eget felis eget nunc lobortis. "
    		+ "Potenti nullam ac tortor vitae purus faucibus ornare suspendisse sed. "
    		+ "Lobortis scelerisque fermentum dui faucibus in ornare quam viverra orci. "
    		+ "Elit eget gravida cum sociis natoque penatibus. "
    		+ "At consectetur lorem donec massa sapien faucibus et. "
    		+ "Urna id volutpat lacus laoreet non curabitur gravida arcu ac.";

	@Override
	public String writePdf() {

		Document document = new Document();
		
		try {
			
			PdfWriter.getInstance(document, new FileOutputStream("iTextHelloWorld.pdf"));
			document.open();
			Font fontDate = FontFactory.getFont(FontFactory.COURIER, 10, BaseColor.BLACK);
			Font fontTitle = FontFactory.getFont(FontFactory.COURIER, 24, BaseColor.BLACK);

			Chunk chunkDate = new Chunk(new Date().toString(), fontDate);
			Chunk chunkTitle = new Chunk("Lorem ipsum", fontTitle);

			Paragraph para = new Paragraph();
			para.add(text);
			para.add("\n");
			para.add("\n");
			para.add(text);
			para.add("\n");
			para.add("\n");
			para.add(text);
			para.add("\n");
			para.add("\n");
			para.add(text);
			para.add("\n");
			para.add("\n");
			para.add(text);
			para.add("\n");
			para.add("\n");
			
			document.add(chunkDate);
			document.add(chunkTitle);
			document.add(para);
			
			document.close();

			Path path = Paths.get("C:\\Users\\kapil.panchal.ext\\Downloads\\dinosaur.png");

			document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream("iTextImageExample.pdf"));
			document.open();

			Image img = Image.getInstance(path.toAbsolutePath().toString());
			document.add(img);
			document.close();

			document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream("iTextTable.pdf"));

			document.open();

			PdfPTable table = new PdfPTable(3);
			addTableHeader(table);
			addRows(table);
			addCustomRows(table);

			document.add(table);
			document.close();

			/*PDF Box Document*/
			PDDocument document1 = new PDDocument();
			PDPage page = new PDPage();
			document1.addPage(page);

			PDPageContentStream contentStream = new PDPageContentStream(document1, page);

			contentStream.setFont(PDType1Font.COURIER, 12);
			contentStream.beginText();
			contentStream.showText("Hello World");
			contentStream.endText();
			contentStream.close();

			document1.save("pdfBoxHelloWorld.pdf");
			document1.close();

			/*PDF Box Pictures*/
			PDDocument document2 = new PDDocument();
			PDPage page2 = new PDPage();
			document2.addPage(page2);

			Path path2 = Paths.get("C:\\Users\\kapil.panchal.ext\\Downloads\\dinosaur.png");
			PDPageContentStream contentStream2 = new PDPageContentStream(document2, page2);
			PDImageXObject image = PDImageXObject.createFromFile(path2.toAbsolutePath().toString(), document2);
			contentStream2.drawImage(image, 0, 0);
			contentStream2.close();

			document2.save("pdfBoxImage.pdf");
			document2.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "Write Successful!";
	}

	private void addCustomRows(PdfPTable table) {
		Stream.of("column header 1", "column header 2", "column header 3")
	      .forEach(columnTitle -> {
	        PdfPCell header = new PdfPCell();
	        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        header.setBorderWidth(2);
	        header.setPhrase(new Phrase(columnTitle));
	        table.addCell(header);
	    });
	}

	private void addRows(PdfPTable table) {
		table.addCell("row 1, col 1");
	    table.addCell("row 1, col 2");
	    table.addCell("row 1, col 3");
	}

	private void addTableHeader(PdfPTable table) {		
		try {
			Path path = Paths.get("C:\\Users\\kapil.panchal.ext\\Downloads\\dinosaur.png");
			Image img = Image.getInstance(path.toAbsolutePath().toString());
			img.scalePercent(10);

		    PdfPCell imageCell = new PdfPCell(img);
		    table.addCell(imageCell);

		    PdfPCell horizontalAlignCell = new PdfPCell(new Phrase("row 2, col 2"));
		    horizontalAlignCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		    table.addCell(horizontalAlignCell);

		    PdfPCell verticalAlignCell = new PdfPCell(new Phrase("row 2, col 3"));
		    verticalAlignCell.setVerticalAlignment(Element.ALIGN_BOTTOM);
		    table.addCell(verticalAlignCell);
		} catch (BadElementException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public String writeNewPdf() {
		
		try {
				
			PDDocument document = new PDDocument();
	        PDPage page = new PDPage();
	        document.addPage(page);
	
	        PDPageContentStream contentStream = new PDPageContentStream(document, page);
	
	        contentStream.setFont(PDType1Font.COURIER, 12);
	        
	        // Draw border lines
	        contentStream.setLineWidth(1f);
	        contentStream.addRect(50, 50, page.getMediaBox().getWidth() - 100, page.getMediaBox().getHeight() - 100);
	        contentStream.stroke();
	        
	        // Add "HELLO WORLD TOPIC" header
	        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
	        contentStream.beginText();
	        contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 3, page.getMediaBox().getHeight() - 80);
	        contentStream.showText("HELLO WORLD TOPIC");
	        
	        // Add date
//	        contentStream.setFont(PDType1Font.HELVETICA, 12);	        
//	        contentStream.newLineAtOffset(50, page.getMediaBox().getHeight() - 120);
//	        contentStream.showText("Date: " + new Date().toString());

	        // Add subsequent text
	        contentStream.setFont(PDType1Font.HELVETICA, 12);
//	        contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 5, page.getMediaBox().getHeight() - 140);

	        for (int i = 0; i < 10; i++) {
	            contentStream.showText(text);
	            contentStream.newLine();
	        }

	        contentStream.endText();
	        contentStream.close();

	        document.save("pdfBoxHelloWorld.pdf");
	        document.close();

	        return "PDF created successfully.";
	    } catch (IOException e) {
	        e.printStackTrace();
	        return e.getMessage();
    	}
	}

	
	@Override
	public String writePdfBox() {
		try {
			PDDocument document = new PDDocument();
	        PDPage page = new PDPage();
        
	        document.addPage(page);

	        PDPageContentStream contentStream = new PDPageContentStream(document, page);

	        contentStream.setFont(PDType1Font.COURIER, 12);
	        
	        // Draw border lines
	        contentStream.setLineWidth(0.1f);
	        contentStream.addRect(25, 25, page.getMediaBox().getWidth() - 50, page.getMediaBox().getHeight() - 50);
	        contentStream.addRect(30, 30, page.getMediaBox().getWidth() - 60, page.getMediaBox().getHeight() - 60);
	        contentStream.addRect(30, 700, page.getMediaBox().getWidth() - 60, 5);
	        contentStream.stroke();
	        
	        // Add "HELLO WORLD TOPIC" header
	        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
	        contentStream.beginText();
	        contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 3, page.getMediaBox().getHeight() - 80);
	        contentStream.showText("HELLO WORLD TOPIC");
	        contentStream.newLine();
	        
	        contentStream.setFont(PDType1Font.HELVETICA, 12);
//	        contentStream.newLineAtOffset(100, page.getMediaBox().getHeight() - 110);
	        contentStream.newLineAtOffset(50, page.getMediaBox().getHeight() - 110);
	        String[] lines = text.split("\n");
            
	        for (String line : lines) {
                contentStream.showText(line);
                contentStream.newLineAtOffset(0, -12); // Adjust line spacing as needed
            }
       	        
	        contentStream.endText();
	        contentStream.close();

	        document.save("pdfBoxHelloWorld.pdf");
	        document.close();
	        
	        return "PDF created successfully.";
		} catch(Exception e) {
			e.printStackTrace();
	        return e.getMessage();
		}
	}
}