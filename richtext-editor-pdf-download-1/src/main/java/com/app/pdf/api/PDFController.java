package com.app.pdf.api;

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
        
        int offsetFromCenterVertical = 200;
		
		System.err.println("HTML DATA: " + htmlData);
		
		Document document = Jsoup.parse(htmlData);
        Elements allElements = document.getAllElements();
        
        try {
            PDDocument pdfDocument = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            pdfDocument.addPage(page);
            
            // Creating a content stream to write content to the page
            PDPageContentStream contentStream = new PDPageContentStream(pdfDocument, page);
            //Begin the Content stream 
           
            //Setting the font to the Content stream  
            PDFont font = new PDType1Font(FontName.TIMES_ROMAN);
            contentStream.setFont(font , 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(25, 725);
            
            for (Element element : allElements) {
                System.out.println(element.nodeName() + " " + element.ownText());
                 
                contentStream.showText(element.ownText());      

                //Ending the content stream
                
            }
            contentStream.endText();
            // Closing the content stream
            contentStream.close();
            
            // Save the document
            pdfDocument.save("C:\\Users\\kapil.panchal.ext\\Desktop\\RichText_1.pdf");
            pdfDocument.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return ResponseEntity.status(HttpStatus.OK).body("Hello World");
	}
}
