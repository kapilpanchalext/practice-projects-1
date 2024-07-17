package com.app.pdfbox.pdf;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.springframework.stereotype.Component;

import com.app.pdfbox.DocumentBean;

@Component
public class PDFFrontPage {
	public void createFrontPage(DocumentBean documentBean) {
        // Margins (in points, 1 point = 1/72 inch)
        final float MARGIN_LEFT = 50;
        final float MARGIN_RIGHT = 50;
        final float MARGIN_TOP = 50;
        final float MARGIN_BOTTOM = 50;
        String versionString =  "v" + documentBean.getVersion();
        
        int offsetFromCenterVertical = 200;
		
		try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            
            // Creating a content stream to write content to the page
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            
            // Calculate the width of the text
            setSdd(contentStream, offsetFromCenterVertical);
            drawLineBelowSdd(contentStream, MARGIN_LEFT, MARGIN_RIGHT, offsetFromCenterVertical);
            setDocumentVersion(contentStream, versionString, offsetFromCenterVertical);
            setDate(contentStream, offsetFromCenterVertical);
            setTitle(contentStream, documentBean.getTitle(), offsetFromCenterVertical);
            setReferenceId(contentStream, MARGIN_LEFT, documentBean.getReferenceId(), offsetFromCenterVertical);
            
            // Closing the content stream
            contentStream.close();
            
            // Save the document
            document.save("C:\\Users\\kapil.panchal.ext\\Desktop\\1.pdf");
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	private void setReferenceId(PDPageContentStream contentStream, float MARGIN_LEFT, String referenceId, int offsetFromCenterVertical) throws IOException {
		final float refFontSize = 28;
        final FontTypesEnum fontEnum2 = FontTypesEnum.HELVETICA;
        final PDFont refFontType = fontEnum2.getFont();
        
        float xPositionRef = MARGIN_LEFT;
        
        contentStream.beginText();
        contentStream.setFont(refFontType, refFontSize);
        contentStream.newLineAtOffset(xPositionRef, offsetFromCenterVertical + 250);
        contentStream.showText(referenceId);
        contentStream.endText();
	}
	
	private void setDate(PDPageContentStream contentStream, int offsetFromCenterVertical) throws IOException {
		LocalDate date = LocalDate.now();
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM, yyyy", Locale.ENGLISH);
		final FontTypesEnum fontEnumVersion = FontTypesEnum.HELVETICA;
		final PDFont sddFontType = fontEnumVersion.getFont();
		float sddFontSize = 36;
		float dateFontSize = 20;
		String dateString = formatWithOrdinal(date, formatter).toString();
		
		contentStream.setFont(sddFontType, dateFontSize);
		float textWidth = sddFontType.getStringWidth(dateString) / 1000 * dateFontSize;

		// Calculate the x position to center the text
		float pageWidth = PDRectangle.A4.getWidth();
		float xPosition =  pageWidth - textWidth - 50;

		// Calculate the y position to center the text vertically
		float pageHeight = PDRectangle.A4.getHeight();
		float yPosition = (pageHeight - sddFontSize) / 2;
		
		contentStream.beginText();
		contentStream.newLineAtOffset(xPosition, yPosition + offsetFromCenterVertical - 80);
		contentStream.showText(dateString);
		contentStream.endText();
	}
	
	private void setDocumentVersion(PDPageContentStream contentStream, String versionString, int offsetFromCenterVertical) throws IOException {
		String versionText = "Version " + versionString;
		final FontTypesEnum fontEnumVersion = FontTypesEnum.HELVETICA;
		final PDFont sddFontType = fontEnumVersion.getFont();
		float sddFontSize = 36;
		float versionFontSize = 20;
		contentStream.setFont(sddFontType, versionFontSize);
		float textWidth = sddFontType.getStringWidth(versionText) / 1000 * versionFontSize;

		// Calculate the x position to center the text
		float pageWidth = PDRectangle.A4.getWidth();
		float xPosition =  pageWidth - textWidth - 50;

		// Calculate the y position to center the text vertically
		float pageHeight = PDRectangle.A4.getHeight();
		float yPosition = (pageHeight - sddFontSize) / 2;
		
		contentStream.beginText();
		contentStream.newLineAtOffset(xPosition, yPosition + offsetFromCenterVertical - 50);
		contentStream.showText(versionText);
		contentStream.endText();
	}
	
	private void setTitle(PDPageContentStream contentStream, String titleText, int offsetFromCenterVertical) throws IOException {
		final float titleFontSize = 38;
		final FontTypesEnum fontEnum2 = FontTypesEnum.HELVETICA;
        final PDFont titleFontType = fontEnum2.getFont();

	    float pageWidthTitle = PDRectangle.A4.getWidth();
	    float marginLeft = 50;
	    float marginRight = 50;
	    float usablePageWidth = pageWidthTitle - marginLeft - marginRight;

	    contentStream.setFont(titleFontType, titleFontSize);

	    // Split the text into lines that fit within the usable page width
	    String[] lines = splitTextIntoLines(titleText, titleFontType, titleFontSize, usablePageWidth);

	    // Calculate the height of the text
	    float titleTextHeight = titleFontType.getFontDescriptor().getCapHeight() / 1000 * titleFontSize;

	    // Calculate the y position to center the text block vertically
	    float pageHeightTitle = PDRectangle.A4.getHeight();
	    float totalTextHeight = lines.length * titleTextHeight;
	    float yPositionTitle = (pageHeightTitle + totalTextHeight - offsetFromCenterVertical) / 2;

		contentStream.beginText();
		contentStream.setLeading(titleTextHeight * 1.2f);
		contentStream.newLineAtOffset(marginLeft, yPositionTitle);

        for (String line : lines) {
            float lineWidth = titleFontType.getStringWidth(line) / 1000 * titleFontSize;
            float xPositionLine = (usablePageWidth - lineWidth) / 2;
            contentStream.newLineAtOffset(xPositionLine, 0);
            contentStream.showText(line);
            contentStream.newLineAtOffset(-xPositionLine, -titleTextHeight * 2.0f);
        }

        contentStream.endText();
	}
	
	private String[] splitTextIntoLines(String titleText, PDFont titleFontType, float titleFontSize,
		float usablePageWidth) throws IOException {
		String[] words = titleText.split(" ");
	    StringBuilder line = new StringBuilder();
	    List<String> lines = new ArrayList<>();

        for (String word : words) {
            String testLine = line + (line.length() > 0 ? " " : "") + word;
            float width = titleFontType.getStringWidth(testLine) / 1000 * titleFontSize;
            if (width > usablePageWidth) {
                lines.add(line.toString());
                line = new StringBuilder(word);
            } else {
                line.append((line.length() > 0 ? " " : "")).append(word);
            }
        }
        if (line.length() > 0) {
            lines.add(line.toString());
        }
        return lines.toArray(new String[0]);
	}
	
	private void drawLineBelowSdd(PDPageContentStream contentStream, float marginLeft, float marginRight, int offsetFromCenterVertical) throws IOException {
		float pageWidth = PDRectangle.A4.getWidth();
		float pageHeight = PDRectangle.A4.getHeight();
		float sddFontSize = 36;
		float yPosition = (pageHeight - sddFontSize) / 2;
        float lineYPosition = yPosition + offsetFromCenterVertical - 20;
        contentStream.moveTo(marginLeft, lineYPosition);
        contentStream.lineTo(pageWidth - marginRight, lineYPosition);
        contentStream.stroke();		
	}
	
	private void setSdd(PDPageContentStream contentStream, int offsetFromCenterVertical) throws IOException {
		final String sddText = "Software Design Document";
		final FontTypesEnum fontEnum1 = FontTypesEnum.HELVETICA_BOLD;
		final PDFont sddFontType = fontEnum1.getFont();
		
		float sddFontSize = 36;
		contentStream.setFont(sddFontType, sddFontSize);
		float textWidth = sddFontType.getStringWidth(sddText) / 1000 * sddFontSize;

		// Calculate the x position to center the text
		float pageWidth = PDRectangle.A4.getWidth();
		float xPosition = (pageWidth - textWidth) / 2;

		// Calculate the y position to center the text vertically
		float pageHeight = PDRectangle.A4.getHeight();
		float yPosition = (pageHeight - sddFontSize) / 2;
		
		contentStream.beginText();
		contentStream.newLineAtOffset(xPosition, yPosition + offsetFromCenterVertical);
		contentStream.showText(sddText);
		contentStream.endText();
	}
	
	public static String formatWithOrdinal(LocalDate date, DateTimeFormatter formatter) {
        String day = String.valueOf(date.getDayOfMonth());
        String suffix = getDayOfMonthSuffix(date.getDayOfMonth());
        String formattedDate = date.format(formatter);
        // Replace the day of month without suffix with the one with suffix
        return formattedDate.replaceFirst(day, day + suffix);
    }

    private static String getDayOfMonthSuffix(int day) {
        if (day >= 11 && day <= 13) {
            return "th";
        }
        switch (day % 10) {
            case 1:  return "st";
            case 2:  return "nd";
            case 3:  return "rd";
            default: return "th";
        }
    }
}
