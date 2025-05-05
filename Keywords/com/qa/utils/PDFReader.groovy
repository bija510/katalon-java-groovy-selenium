package com.qa.utils

import java.awt.geom.Rectangle2D;

import org.apache.pdfbox.cos.COSDocument
import org.apache.pdfbox.pdfparser.PDFParser
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.action.PDAction;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionURI;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.text.PDFTextStripper
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.pdfbox.pdmodel.PDDocumentInformation

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.apache.pdfbox.Loader
import java.io.File
import java.io.FileInputStream
import java.io.IOException

public class PDFReader {

	/**
	 * This method will return "All Text" from a PDF file using just path
	 * This class uses Apache PDFBox (3.x) to load the PDF and extract its text content.
	 * Usage:
	 * <pre>
	 *     String pdfText = new com.qa.utils.PDFReader().getPdfFileTextUsingPath("path/to/your/pdf/file.pdf");
	 *     System.out.println(pdfText);
	 * </pre>
	 *
	 * @param pdfFilePath The absolute or relative file path of the PDF file to read.
	 * @return A String containing the extracted text from the PDF file.
	 * @throws IOException If there is an issue reading the PDF file or opening the file stream.
	 */
	@Keyword
	def static String getPdfFileTextUsingPath(String pdfFilePath) throws IOException {
		File file = new File(pdfFilePath)
		FileInputStream inputStream = new FileInputStream(file)

		// Read file into byte array
		byte[] fileBytes = new byte[(int) file.length()]
		inputStream.read(fileBytes)
		inputStream.close()

		PDDocument document = null
		try {
			// Use PDFBox 3.x to load the PDF from byte array
			document = Loader.loadPDF(fileBytes)

			PDFTextStripper stripper = new PDFTextStripper()
			return stripper.getText(document)
		} finally {
			if (document != null) {
				document.close()
			}
		}
	}

	/**
	 * This method will return "All Text" from a PDF file using URL path
	 * Tested & Work 5/04/2025
	 * <pre>
	 * 		println new com.qa.utils.PDFReader().getPdfFileTextUsingURL(urlPath)
	 * </pre>
	 * @param pdfFilePath = open the pdf file in chrome and copy the url (test for link.pdf)
	 * @return String
	 * @throw IOException
	 */

	@Keyword
	static def getPdfFileTextUsingURL(String pdfFilePath) {
		URL url = new URL(pdfFilePath)
		InputStream is = url.openStream()
		BufferedInputStream filePase = new BufferedInputStream(is)

		byte[] byteArray = new byte[1024]
		ByteArrayOutputStream baos = new ByteArrayOutputStream()

		int bytesRead
		while ((bytesRead = filePase.read(byteArray)) != -1) {
			baos.write(byteArray, 0, bytesRead)
		}

		byte[] pdfBytes = baos.toByteArray()

		PDDocument document = null
		try {
			// Load PDF from byte array using PDFBox 3.x
			document = Loader.loadPDF(pdfBytes)

			// Extract text from the PDF document
			PDFTextStripper stripper = new PDFTextStripper()
			return stripper.getText(document)
		} finally {
			if (document != null) {
				document.close()
			}
			filePase.close()
			is.close()
		}
	}

	@Keyword
	def getUrlFromPDF(String path) {
		WebUI.delay(3)
		String allText = getPdfFileTextUsingPath(path)
		String textWithoutBlankLine = allText.replaceAll('[\\\r\\\n]+', '')
		String[] arrText = textWithoutBlankLine.split(':')
		String tempLink = 'https:' + (arrText[6])
		if (tempLink.contains('A')) {
			tempLink = tempLink.substring(0, tempLink.indexOf('A'))
		}
		return tempLink
	}

	/**
	 * This Method will return the pdf file "Title" in the form of string.
	 * Tested & Work 5/04/2025
	 * <pre>
	 * 		String filePath = RunConfiguration.getProjectDir() + "/Data Files All/PdfReader/test for link.pdf"
	 * 		println new com.qa.utils.PDFReader().getPdfTitle(filePath)
	 * </pre>
	 * @param pdfFilePath 
	 * @return String title
	 * @throw FileNotFoundException
	 */
	@Keyword
	static String getPdfTitle(String pdfFilePath) {
		File file = new File(pdfFilePath)
		if (!file.exists()) {
			throw new FileNotFoundException("PDF not found at path: $pdfFilePath")
		}

		FileInputStream inputStream = new FileInputStream(file)
		byte[] fileBytes = new byte[(int) file.length()]
		inputStream.read(fileBytes)
		inputStream.close()

		PDDocument document = null
		try {
			document = Loader.loadPDF(fileBytes)

			PDDocumentInformation info = document.getDocumentInformation()
			return info.getTitle() ?: "No title found in PDF metadata"
		} finally {
			if (document != null) {
				document.close()
			}
		}
	}

	/**
	 * This method will return the "Link" that match with @param contain_word_onLink
	 * Tested & Work 5/04/2025
	 * <pre>
	 * 		String filePath = RunConfiguration.getProjectDir() + "/Data Files All/PdfReader/test for link.pdf"
	 * 		new com.qa.utils.PDFReader().getHyperlinkUrlFromPDF(filePath, "http")
	 * </pre>
	 */
	@Keyword
	static String getHyperlinkUrlFromPDF(String pdfFilePath, String contain_word_onLink) {
		WebUI.delay(2)

		File file = new File(pdfFilePath)
		if (!file.exists()) {
			KeywordUtil.markFailed("PDF file not found at path: $pdfFilePath")
			return null
		}

		// Load file into byte array
		FileInputStream inputStream = new FileInputStream(file)
		byte[] fileBytes = new byte[(int) file.length()]
		inputStream.read(fileBytes)
		inputStream.close()

		PDDocument document = null
		try {
			document = Loader.loadPDF(fileBytes)
			String matchedUri = null

			for (PDPage page : document.getPages()) {
				List<PDAnnotation> annotations = page.getAnnotations()
				for (PDAnnotation annotation : annotations) {
					if (annotation instanceof PDAnnotationLink) {
						PDAnnotationLink link = (PDAnnotationLink) annotation
						PDAction action = link.getAction()
						if (action instanceof PDActionURI) {
							String uri = ((PDActionURI) action).getURI()
							if (uri != null && uri.contains(contain_word_onLink)) {
								println("Found link: $uri")
								matchedUri = uri
								break
							}
						}
					}
				}
				if (matchedUri != null) break
			}

			if (matchedUri == null) {
				KeywordUtil.markWarning("No hyperlink containing '$contain_word_onLink' found in PDF.")
			}

			return matchedUri
		} catch (Exception e) {
			KeywordUtil.markFailed("Error reading PDF: ${e.message}")
			return null
		} finally {
			if (document != null) {
				document.close()
			}
		}
	}

	/**
	 * THis method will return the "Header" of the pdf file of the first page
	 * <pre>
	 * 		new com.qa.utils.PDFReader().getFirstPageHeader(filePath1).replaceAll('[\\r\\n]+', '')
	 * </pre>
	 * @param pdfFilePath 
	 * @return String Header
	 */
	@Keyword
	static String getFirstPageHeader(String pdfFilePath) {
		File file = new File(pdfFilePath)
		if (!file.exists()) {
			throw new FileNotFoundException("PDF not found: $pdfFilePath")
		}

		FileInputStream inputStream = new FileInputStream(file)
		byte[] fileBytes = new byte[(int) file.length()]
		inputStream.read(fileBytes)
		inputStream.close()

		PDDocument document = null
		try {
			document = Loader.loadPDF(fileBytes)

			PDFTextStripper stripper = new PDFTextStripper()
			stripper.setStartPage(1)
			stripper.setEndPage(1)

			// Get all text from first page
			String firstPageText = stripper.getText(document)

			// Assuming header is first 1-3 lines
			String[] lines = firstPageText.trim().split("\\r?\\n")
			def headerLines = lines.take(3).join('\n')

			println "PDF Header:\n$headerLines"
			return headerLines
		} finally {
			if (document != null) {
				document.close()
			}
		}
	}
}
