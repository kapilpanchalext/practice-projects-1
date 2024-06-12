package com.app.pdfbox.pdf;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.springframework.stereotype.Component;

@Component
public class PDFGenerator {
//	public void generate(String string) {
//		
//		String text1 = "This is an example of adding text to a page in the pdf document. We can add as many lines";
//	    String text2 = "as we want like this using the ShowText()  method of the ContentStream class";
//		
//		try {
//			PDDocument document = new PDDocument();
//			PDPage page1 = new PDPage();
//			
//			document.addPage(page1);
//			
////			PDDocumentInformation pdd = new PDDocumentInformation();
////			
////			pdd.setAuthor("Author 1");
////			pdd.setTitle("Title1");
////			pdd.setCreator("Creator1");
////			pdd.setSubject("Subject1");
////			 // Setting the created date of the document 
////            Calendar date = new GregorianCalendar();
////            date.set(2015, Calendar.DECEMBER, 5);
////            pdd.setCreationDate(date);
////
////            // Setting the modified date of the document 
////            date.set(2016, Calendar.JUNE, 5);
////            pdd.setModificationDate(date);
////			pdd.setKeywords("keywords");
//			
////			PDPageContentStream contentStream = new PDPageContentStream(document, page);
////			contentStream.beginText();
////			
////			PDFont font = new PDType1Font(FontName.TIMES_ROMAN);
////			
////			contentStream.setFont(font , 12);
////			contentStream.newLineAtOffset(25, 725);
////			
////			//Setting the font to the Content stream
////	        contentStream.setFont(font, 16);
////	       
////	        //Setting the leading
////	        contentStream.setLeading(14.5f);
////
////	        //Setting the position for the line
////	        contentStream.newLineAtOffset(25, 725);
////			
////			contentStream.showText(string);
////			contentStream.newLine();
////				
////		    //Adding text in the form of string
////		    contentStream.showText(text1);
////		    contentStream.newLine();
////		    
////		    contentStream.showText(text2);
////			contentStream.endText();
////			
////			contentStream.close();
//			
//			//Retrieving a page of the PDF Document
//		      PDPage page = document.getPage(0);
//
//		      //Instantiating the PDPageContentStream class
//		      PDPageContentStream contentStream = new PDPageContentStream(document, page);
//		       
//		      //Setting the non stroking color
////		      contentStream.setNonStrokingColor(Color.DARK_GRAY);
//
//		      //Drawing a rectangle 
//		      contentStream.addRect(200, 650, 100, 100);
//
//		      //Drawing a rectangle
//		      contentStream.fill();
//
//		      System.out.println("rectangle added");
//
//		      //Closing the ContentStream object
//		      contentStream.close();
//
//			document.save("C:\\Users\\kapil.panchal.ext\\Desktop\\hello.pdf");
//			document.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	public void generate(String string) {
//		
//		try {
//			PDDocument document = new PDDocument();
//			PDPage page = new PDPage(PDRectangle.A4);
//			
//			document.addPage(page);
//			
//			 // Margins (in points, 1 point = 1/72 inch)
//            float marginLeft = 50;
//            float marginRight = 50;
//            float marginTop = 50;
//            float marginBottom = 50;
//
//            // Creating a content stream to write content to the page
//            PDPageContentStream contentStream = new PDPageContentStream(document, page);
//
//            // Drawing a rectangle to visualize margins (optional)
//            contentStream.setStrokingColor(0.0f, 0.0f, 0.0f); // Red color for margin visualization
//            contentStream.addRect(marginLeft, marginBottom,
//                    PDRectangle.A4.getWidth() - marginLeft - marginRight,
//                    PDRectangle.A4.getHeight() - marginTop - marginBottom);
//            contentStream.stroke();
//
//            // Adding text within the margins
//            contentStream.beginText();
//            PDFont font = new PDType1Font(FontName.HELVETICA);
//            contentStream.setFont(font, 12);
//            contentStream.newLineAtOffset(marginLeft, PDRectangle.A4.getHeight() - marginTop - 12);
//            contentStream.showText("Hello, this is a sample text within the margins.");
//            contentStream.endText();
//
//            // Closing the content stream
//            contentStream.close();
//
//			document.save("C:\\Users\\kapil.panchal.ext\\Desktop\\hello.pdf");
//			document.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public void generate(String string) {
		
		StringBuilder longText = new StringBuilder();
		longText.append("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Porta non pulvinar neque laoreet. Pulvinar elementum integer enim neque. Bibendum at varius vel pharetra vel turpis. Vel eros donec ac odio tempor. Malesuada nunc vel risus commodo viverra maecenas. Sed viverra ipsum nunc aliquet bibendum enim facilisis gravida. Vulputate eu scelerisque felis imperdiet proin fermentum leo vel orci. Massa tincidunt dui ut ornare lectus sit amet est. Sit amet risus nullam eget felis eget nunc lobortis mattis. Morbi non arcu risus quis varius quam quisque. Ut faucibus pulvinar elementum integer enim neque volutpat. Ut aliquam purus sit amet luctus venenatis lectus magna fringilla. Posuere lorem ipsum dolor sit amet consectetur. Sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus. Sagittis nisl rhoncus mattis rhoncus urna neque viverra.");
		longText.append("Platea dictumst vestibulum rhoncus est pellentesque elit ullamcorper dignissim. Elit sed vulputate mi sit amet. Pulvinar sapien et ligula ullamcorper malesuada proin libero. Proin nibh nisl condimentum id venenatis a condimentum vitae sapien. Venenatis cras sed felis eget velit. In nisl nisi scelerisque eu ultrices vitae auctor. Ac feugiat sed lectus vestibulum. Justo nec ultrices dui sapien eget mi proin sed libero. Vitae congue eu consequat ac felis donec et odio. Vitae purus faucibus ornare suspendisse sed nisi lacus sed viverra. In fermentum posuere urna nec tincidunt praesent semper feugiat nibh. Eros in cursus turpis massa tincidunt dui. Ut aliquam purus sit amet luctus venenatis lectus magna fringilla. Posuere morbi leo urna molestie at elementum eu facilisis sed. Quis risus sed vulputate odio ut enim blandit volutpat. Tellus rutrum tellus pellentesque eu tincidunt tortor. Nibh sit amet commodo nulla facilisi. Mauris ultrices eros in cursus turpis. Porta nibh venenatis cras sed felis.");
		longText.append("Morbi leo urna molestie at elementum eu. Quam pellentesque nec nam aliquam sem et tortor consequat. Est ante in nibh mauris cursus mattis. Tempus iaculis urna id volutpat. Tortor at risus viverra adipiscing. Eros donec ac odio tempor orci dapibus. Sollicitudin tempor id eu nisl nunc. Euismod quis viverra nibh cras pulvinar mattis. Et egestas quis ipsum suspendisse ultrices gravida dictum fusce ut. Cursus eget nunc scelerisque viverra mauris in aliquam sem fringilla.");
		longText.append("Feugiat pretium nibh ipsum consequat nisl vel pretium lectus quam. Cras adipiscing enim eu turpis egestas pretium aenean. Cursus in hac habitasse platea dictumst quisque sagittis purus sit. Nibh cras pulvinar mattis nunc sed blandit libero volutpat. Sociis natoque penatibus et magnis dis parturient montes. In ornare quam viverra orci sagittis eu volutpat. Non quam lacus suspendisse faucibus interdum. Penatibus et magnis dis parturient montes. Vestibulum sed arcu non odio. Rutrum tellus pellentesque eu tincidunt tortor aliquam nulla facilisi. Aliquet lectus proin nibh nisl condimentum. Pulvinar neque laoreet suspendisse interdum consectetur libero. Aliquam vestibulum morbi blandit cursus risus at ultrices. Etiam erat velit scelerisque in dictum non consectetur a erat. Vitae auctor eu augue ut. Laoreet id donec ultrices tincidunt arcu non sodales neque sodales. Ante metus dictum at tempor commodo. Fringilla urna porttitor rhoncus dolor purus. Tristique magna sit amet purus gravida quis blandit turpis.");
		longText.append("Aliquam ut porttitor leo a diam sollicitudin tempor id. Dictum varius duis at consectetur lorem. In nibh mauris cursus mattis molestie a iaculis. Sed egestas egestas fringilla phasellus faucibus scelerisque. Dictum varius duis at consectetur. Sagittis eu volutpat odio facilisis mauris sit. Quam id leo in vitae turpis massa sed elementum. Gravida in fermentum et sollicitudin ac orci phasellus egestas tellus. Lectus vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt ornare. Lectus vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt. Fringilla urna porttitor rhoncus dolor purus non.");
		longText.append("\n");
		longText.append("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Porta non pulvinar neque laoreet. Pulvinar elementum integer enim neque. Bibendum at varius vel pharetra vel turpis. Vel eros donec ac odio tempor. Malesuada nunc vel risus commodo viverra maecenas. Sed viverra ipsum nunc aliquet bibendum enim facilisis gravida. Vulputate eu scelerisque felis imperdiet proin fermentum leo vel orci. Massa tincidunt dui ut ornare lectus sit amet est. Sit amet risus nullam eget felis eget nunc lobortis mattis. Morbi non arcu risus quis varius quam quisque. Ut faucibus pulvinar elementum integer enim neque volutpat. Ut aliquam purus sit amet luctus venenatis lectus magna fringilla. Posuere lorem ipsum dolor sit amet consectetur. Sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus. Sagittis nisl rhoncus mattis rhoncus urna neque viverra.");
		longText.append("Platea dictumst vestibulum rhoncus est pellentesque elit ullamcorper dignissim. Elit sed vulputate mi sit amet. Pulvinar sapien et ligula ullamcorper malesuada proin libero. Proin nibh nisl condimentum id venenatis a condimentum vitae sapien. Venenatis cras sed felis eget velit. In nisl nisi scelerisque eu ultrices vitae auctor. Ac feugiat sed lectus vestibulum. Justo nec ultrices dui sapien eget mi proin sed libero. Vitae congue eu consequat ac felis donec et odio. Vitae purus faucibus ornare suspendisse sed nisi lacus sed viverra. In fermentum posuere urna nec tincidunt praesent semper feugiat nibh. Eros in cursus turpis massa tincidunt dui. Ut aliquam purus sit amet luctus venenatis lectus magna fringilla. Posuere morbi leo urna molestie at elementum eu facilisis sed. Quis risus sed vulputate odio ut enim blandit volutpat. Tellus rutrum tellus pellentesque eu tincidunt tortor. Nibh sit amet commodo nulla facilisi. Mauris ultrices eros in cursus turpis. Porta nibh venenatis cras sed felis.");
		longText.append("Morbi leo urna molestie at elementum eu. Quam pellentesque nec nam aliquam sem et tortor consequat. Est ante in nibh mauris cursus mattis. Tempus iaculis urna id volutpat. Tortor at risus viverra adipiscing. Eros donec ac odio tempor orci dapibus. Sollicitudin tempor id eu nisl nunc. Euismod quis viverra nibh cras pulvinar mattis. Et egestas quis ipsum suspendisse ultrices gravida dictum fusce ut. Cursus eget nunc scelerisque viverra mauris in aliquam sem fringilla.");
		longText.append("Feugiat pretium nibh ipsum consequat nisl vel pretium lectus quam. Cras adipiscing enim eu turpis egestas pretium aenean. Cursus in hac habitasse platea dictumst quisque sagittis purus sit. Nibh cras pulvinar mattis nunc sed blandit libero volutpat. Sociis natoque penatibus et magnis dis parturient montes. In ornare quam viverra orci sagittis eu volutpat. Non quam lacus suspendisse faucibus interdum. Penatibus et magnis dis parturient montes. Vestibulum sed arcu non odio. Rutrum tellus pellentesque eu tincidunt tortor aliquam nulla facilisi. Aliquet lectus proin nibh nisl condimentum. Pulvinar neque laoreet suspendisse interdum consectetur libero. Aliquam vestibulum morbi blandit cursus risus at ultrices. Etiam erat velit scelerisque in dictum non consectetur a erat. Vitae auctor eu augue ut. Laoreet id donec ultrices tincidunt arcu non sodales neque sodales. Ante metus dictum at tempor commodo. Fringilla urna porttitor rhoncus dolor purus. Tristique magna sit amet purus gravida quis blandit turpis.");
		longText.append("Aliquam ut porttitor leo a diam sollicitudin tempor id. Dictum varius duis at consectetur lorem. In nibh mauris cursus mattis molestie a iaculis. Sed egestas egestas fringilla phasellus faucibus scelerisque. Dictum varius duis at consectetur. Sagittis eu volutpat odio facilisis mauris sit. Quam id leo in vitae turpis massa sed elementum. Gravida in fermentum et sollicitudin ac orci phasellus egestas tellus. Lectus vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt ornare. Lectus vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt. Fringilla urna porttitor rhoncus dolor purus non.");
		
	    try {
	        PDDocument document = new PDDocument();
	        PDPage page = new PDPage(PDRectangle.A4);

	        document.addPage(page);

	        // Margins (in points, 1 point = 1/72 inch)
	        float marginLeft = 50;
	        float marginRight = 50;
	        float marginTop = 50;
	        float marginBottom = 50;
	        float paddingBottom = 50;
	        float fontSize = 12;
	        float leading = 14.5f;

	        // Creating a content stream to write content to the page
	        PDPageContentStream contentStream = new PDPageContentStream(document, page);

//	        // Drawing top margin line
//	        contentStream.setStrokingColor(128/255.0f, 128/255.0f, 128/255.0f);
//	        contentStream.moveTo(marginLeft, PDRectangle.A4.getHeight() - marginTop);
//	        contentStream.lineTo(PDRectangle.A4.getWidth() - marginRight, PDRectangle.A4.getHeight() - marginTop);
//	        contentStream.stroke();
//
//	        // Drawing bottom margin line
//	        contentStream.moveTo(marginLeft, marginBottom+paddingBottom);
//	        contentStream.lineTo((PDRectangle.A4.getWidth() - marginRight), marginBottom+paddingBottom);
//	        contentStream.stroke();
//
//	        // Adding text within the margins
//	        contentStream.beginText();
	        PDFont font = new PDType1Font(FontName.HELVETICA);
//	        contentStream.setFont(font, 12);
//	        contentStream.newLineAtOffset(marginLeft, PDRectangle.A4.getHeight() - marginTop - 12);
////	        contentStream.showText(longText.toString());
////	        contentStream.endText();
////
////	        // Closing the content stream
////	        contentStream.close();
//	        
//	        float width = PDRectangle.A4.getWidth() - marginLeft - marginRight;
//
//	        String[] words = longText.toString().split("\\s+");
//	        StringBuilder line = new StringBuilder();
//	        
//	        for (String word : words) {
//	            String tempLine = line + " " + word;
//	            float size = font.getStringWidth(tempLine) / 1000 * 12;
//	            if (size > width) {
//	                contentStream.showText(line.toString());
//	                contentStream.newLineAtOffset(0, -leading);
//	                line = new StringBuilder(word);
//	            } else {
//	                line.append(" ").append(word);
//	            }
//	        }
//
//	        // Show the remaining text
//	        if (line.length() > 0) {
//	            contentStream.showText(line.toString());
//	        }
//
//	        contentStream.endText();
//
//	        // Closing the content stream
//	        contentStream.close();
//
//	        document.save("C:\\Users\\kapil.panchal.ext\\Desktop\\hello.pdf");
//	        document.close();
	        
	        // Drawing top margin line
	        contentStream.setStrokingColor(128 / 255.0f, 128 / 255.0f, 128 / 255.0f);
	        contentStream.moveTo(marginLeft, PDRectangle.A4.getHeight() - marginTop);
	        contentStream.lineTo(PDRectangle.A4.getWidth() - marginRight, PDRectangle.A4.getHeight() - marginTop);
	        contentStream.stroke();

	        // Drawing bottom margin line
	        contentStream.moveTo(marginLeft, marginBottom + paddingBottom);
	        contentStream.lineTo(PDRectangle.A4.getWidth() - marginRight, marginBottom + paddingBottom);
	        contentStream.stroke();

	        // Start text
	        contentStream.beginText();
	        contentStream.setFont(font, fontSize);
	        contentStream.newLineAtOffset(marginLeft, PDRectangle.A4.getHeight() - marginTop - fontSize);

	        float width = PDRectangle.A4.getWidth() - marginLeft - marginRight;
	        float startY = PDRectangle.A4.getHeight() - marginTop - fontSize;
	        float endY = marginBottom + paddingBottom;

	        // Convert longText to a String and split it into words
	        String[] words = longText.toString().split("\\s+");
	        StringBuilder line = new StringBuilder();
	        
	        for (String word : words) {
	            String tempLine = line + " " + word;
	            float size = font.getStringWidth(tempLine) / 1000 * fontSize;
	            if (size > width) {
	                if (startY <= endY) {
	                    contentStream.endText();
	                    contentStream.close();
	                    
	                    // Add new page and start a new content stream
	                    page = new PDPage(PDRectangle.A4);
	                    document.addPage(page);
	                    contentStream = new PDPageContentStream(document, page);
	                    
	                    drawTopMargin(contentStream, marginLeft, marginTop, marginRight, marginBottom);                 
	                    drawBottomMargin(contentStream, marginLeft, marginTop, marginRight, marginBottom, paddingBottom);
	                    
	                    contentStream.beginText();
	                    contentStream.setFont(font, fontSize);
	                    contentStream.newLineAtOffset(marginLeft, PDRectangle.A4.getHeight() - marginTop - fontSize);
	                    startY = PDRectangle.A4.getHeight() - marginTop - fontSize;
	                }

	                contentStream.showText(line.toString());
	                contentStream.newLineAtOffset(0, -leading);
	                line = new StringBuilder(word);
	                startY -= leading;
	            } else {
	                line.append(" ").append(word);
	            }
	        }

	        // Show the remaining text
	        if (line.length() > 0) {
	            contentStream.showText(line.toString());
	        }

	        contentStream.endText();
	        contentStream.close();

	        document.save("C:\\Users\\kapil.panchal.ext\\Desktop\\hello.pdf");
	        document.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	private void drawBottomMargin(PDPageContentStream contentStream, float marginLeft, float marginTop,
			float marginRight, float marginBottom, float paddingBottom) throws IOException {
        // Drawing bottom margin line
        contentStream.moveTo(marginLeft, marginBottom + paddingBottom);
        contentStream.lineTo(PDRectangle.A4.getWidth() - marginRight, marginBottom + paddingBottom);
        contentStream.stroke();
	}

	private void drawTopMargin(PDPageContentStream contentStream, float marginLeft, float marginTop, float marginRight, float marginBottom) throws IOException {
		// Drawing top margin line
        contentStream.setStrokingColor(128 / 255.0f, 128 / 255.0f, 128 / 255.0f);
        contentStream.moveTo(marginLeft, PDRectangle.A4.getHeight() - marginTop);
        contentStream.lineTo(PDRectangle.A4.getWidth() - marginRight, PDRectangle.A4.getHeight() - marginTop);
        contentStream.stroke();
	}
}
