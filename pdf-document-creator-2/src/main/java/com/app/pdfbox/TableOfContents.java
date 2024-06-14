package com.app.pdfbox;

import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionGoTo;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageXYZDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.springframework.stereotype.Component;

import com.app.pdfbox.pdf.FontTypesEnum;

import lombok.NonNull;

@Component
public class TableOfContents {
	public void createTableOfContents() {
		 try (PDDocument document = new PDDocument()) {

	            // Add some dummy pages for sections
	            for (int i = 0; i < 4; i++) {
	                document.addPage(new PDPage(PDRectangle.A4));
	            }

	            // Create the TOC
	            addTableOfContents(document, List.of("Section 1", "Section 2", "Section 3"));

	            // Add the outline
	            addOutline(document);

	            // Save the document
	            document.save("C:\\Users\\kapil.panchal.ext\\Desktop\\2.pdf");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
    public void addOutline(@NonNull PDDocument document) {
    	PDDocumentOutline outline = new PDDocumentOutline();
        outline.addLast(buildPDOutlineItem(document, "Table of Contents", 0));

        // Add TOC entries
        outline.addLast(buildPDOutlineItem(document, "Section 1", 1));
        outline.addLast(buildPDOutlineItem(document, "Section 2", 2));
        outline.addLast(buildPDOutlineItem(document, "Section 3", 3));
        document.getDocumentCatalog().setDocumentOutline(outline);
    }

    private PDOutlineItem buildPDOutlineItem(
            @NonNull PDDocument document, String title, Integer pageNum) {
    	PDOutlineItem item = new PDOutlineItem();
        item.setTitle(title);

        PDPageXYZDestination dest = new PDPageXYZDestination();
        dest.setPage(document.getPage(pageNum));
        dest.setTop((int) document.getPage(pageNum).getMediaBox().getHeight());
        item.setDestination(dest);

        PDActionGoTo action = new PDActionGoTo();
        action.setDestination(dest);
        item.setAction(action);

        return item;
    }

    public void addTableOfContents(PDDocument document, List<String> sections) throws IOException {
    	 PDPage tocPage = new PDPage(PDRectangle.A4);
         document.addPage(tocPage);

         try (PDPageContentStream contentStream = new PDPageContentStream(document, tocPage)) {
             final FontTypesEnum fontEnum1 = FontTypesEnum.HELVETICA_BOLD;
             final PDFont sddFontType = fontEnum1.getFont();
             contentStream.setFont(sddFontType, 20);
             contentStream.beginText();
             contentStream.newLineAtOffset(50, PDRectangle.A4.getHeight() - 50);
             contentStream.showText("Table of Contents");
             contentStream.endText();

             final FontTypesEnum fontEnum2 = FontTypesEnum.HELVETICA;
             final PDFont contentFontType = fontEnum2.getFont();

             contentStream.setFont(contentFontType, 14);
             float yPosition = PDRectangle.A4.getHeight() - 100;

             for (int i = 0; i < sections.size(); i++) {
                 String section = sections.get(i);
                 addTOCEntry(contentStream, section, i + 1, 50, yPosition, document, tocPage);
                 yPosition -= 20;
             }
        }
    }
    
    private void addTOCEntry(PDPageContentStream contentStream, String section, int pageNum, float x, float y, PDDocument document, PDPage tocPage) throws IOException {
    	 // Set text color to blue
        contentStream.setNonStrokingColor(0.0f, 0.0f, 255/255.0f);

        contentStream.beginText();
        contentStream.newLineAtOffset(x, y);
        contentStream.showText(section + " ................................ " + pageNum);
        contentStream.endText();

        // Validate pageNum
        if (pageNum < 0 || pageNum >= document.getNumberOfPages()) {
            throw new IllegalArgumentException("Invalid page number: " + pageNum);
        }

        // Create a link annotation for the text
        PDAnnotationLink link = new PDAnnotationLink();
        PDRectangle position = new PDRectangle();
        position.setLowerLeftX(x);
        position.setLowerLeftY(y - 5); // Adjust y position to match text height
        position.setUpperRightX(x + 200); // Set width of the link area
        position.setUpperRightY(y + 10); // Adjust y position to match text height
        link.setRectangle(position);

        PDPageXYZDestination dest = new PDPageXYZDestination();
        dest.setPage(document.getPage(pageNum));
        dest.setTop((int) document.getPage(pageNum).getMediaBox().getHeight());

        PDActionGoTo action = new PDActionGoTo();
        action.setDestination(dest);
        link.setAction(action);

        // Set border style to no border
        PDBorderStyleDictionary borderStyle = new PDBorderStyleDictionary();
        borderStyle.setWidth(0);
        link.setBorderStyle(borderStyle);

        // Set the link border color to blue
        link.setColor(new PDColor(new float[]{0, 0, 1}, PDDeviceRGB.INSTANCE));

        tocPage.getAnnotations().add(link);
    }

//    private void addTOCEntry(PDPageContentStream contentStream, String section, int pageNum, float x, float y) throws IOException {
//        contentStream.beginText();
//        contentStream.newLineAtOffset(x, y);
//        contentStream.showText(section + " ................................ " + pageNum);
//        contentStream.endText();
//    }
}
