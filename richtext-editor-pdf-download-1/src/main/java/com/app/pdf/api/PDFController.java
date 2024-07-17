package com.app.pdf.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PDFController {
	
	@GetMapping(path = "/hello")
	public ResponseEntity<String> getHelloWorld(){
		return ResponseEntity.status(HttpStatus.OK).body("Hello World");
	}
	
	@PostMapping(path = "/get-html")
	public ResponseEntity<String> getHtml(@RequestBody String htmlData){
		
		// Margins (in points, 1 point = 1/72 inch)
	    final float MARGIN_LEFT = 50;
	    final float MARGIN_RIGHT = 50;
	    final float MARGIN_TOP = 50;
	    final float MARGIN_BOTTOM = 50;
	    
	    System.err.println("HTML DATA: " + htmlData);
	    
	    Document document = Jsoup.parse(htmlData);
	    Elements allElements = document.getAllElements();
	    
	    try {
	        PDDocument pdfDocument = new PDDocument();
	        PDPage page = new PDPage(PDRectangle.A4);
	        pdfDocument.addPage(page);
	        
	        // Creating a content stream to write content to the page
	        PDPageContentStream contentStream = new PDPageContentStream(pdfDocument, page);
	        contentStream.setLeading(14.5f);
	        contentStream.beginText();
	        
	        // Setting the initial position
	        contentStream.newLineAtOffset(MARGIN_LEFT, page.getMediaBox().getHeight() - MARGIN_TOP);

	        PDFont currentFont = new PDType1Font(FontName.TIMES_BOLD);
	        float currentFontSize = 12;

	        for (Element element : allElements) {
	            String tagName = element.nodeName();
	            String text = element.ownText();
	            
	            if (text.isEmpty() || text.equalsIgnoreCase("{\"data\":\"\"}")) {
	            	continue;
	            }
	            
	            switch (tagName) {
	                case "h1":
	                    currentFont = new PDType1Font(FontName.TIMES_BOLD);
	                    currentFontSize = 20;
	                    break;
	                case "h2":
	                    currentFont = new PDType1Font(FontName.TIMES_BOLD);
	                    currentFontSize = 18;
	                    break;
	                case "h3":
	                    currentFont = new PDType1Font(FontName.TIMES_BOLD);
	                    currentFontSize = 16;
	                    break;
	                case "p":
	                    currentFont = new PDType1Font(FontName.TIMES_ROMAN);
	                    currentFontSize = 12;
	                    break;
	                default:
	                    currentFont = new PDType1Font(FontName.TIMES_BOLD);
	                    currentFontSize = 12;
	                    break;
	            }

	            contentStream.setFont(currentFont, currentFontSize);
	            
	            // Calculate the width of the text
	            float textWidth = currentFont.getStringWidth(text) / 1000 * currentFontSize;
	            float availableWidth = page.getMediaBox().getWidth() - MARGIN_LEFT - MARGIN_RIGHT;
	            
	            if (textWidth > availableWidth) {
	                // If the text exceeds the available width, split the text into multiple lines
	                List<String> lines = wrapText(text, currentFont, currentFontSize, availableWidth);
	                for (String line : lines) {
	                    contentStream.showText(line);
	                    contentStream.newLine();
	                }
	            } else {
	            	contentStream.newLine();
	                contentStream.showText(text);
	                contentStream.newLine();
	            }
	        }
	        
	        contentStream.endText();
	        contentStream.close();
	        
	        // Save the document
	        pdfDocument.save("C:\\Users\\kapil.panchal.ext\\Desktop\\RichText_1.pdf");
	        pdfDocument.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return ResponseEntity.status(HttpStatus.OK).body("Successful!");
	}
	
	private List<String> wrapText(String text, PDFont font, float fontSize, float maxWidth) throws IOException {
	    List<String> lines = new ArrayList<>();
	    String[] words = text.split(" ");
	    StringBuilder line = new StringBuilder();
	    
	    for (String word : words) {
	        String tempLine = line.length() == 0 ? word : line + " " + word;
	        float width = font.getStringWidth(tempLine) / 1000 * fontSize;
	        if (width > maxWidth) {
	            lines.add(line.toString());
	            line = new StringBuilder(word);
	        } else {
	            line.append(line.length() == 0 ? word : " " + word);
	        }
	    }
	    
	    if (line.length() > 0) {
	        lines.add(line.toString());
	    }
	    
	    return lines;
	}
}
