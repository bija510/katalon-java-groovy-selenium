package utilites

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

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class PDFReader {

	@Keyword
	def getPdfFileText(String pdfFilePath){

		String path = pdfFilePath
		File file  = new File(path)

		FileInputStream fis = new FileInputStream(file)

		PDFParser parser = new PDFParser(fis)

		parser.parse()
		COSDocument cosDoc = parser.getDocument()
		PDDocument pdDoc = new PDDocument(cosDoc)

		PDFTextStripper strip = new PDFTextStripper()
		String data = strip.getText(pdDoc)
		//println(data)
		return data
	}

	@Keyword
	def getPdfFileText2(String pdfFilePath){
		URL url =new URL(pdfFilePath)
		InputStream is = url.openStream()
		BufferedInputStream filePase = new BufferedInputStream(is)
		PDDocument document =null

		document = PDDocument.load(filePase)
		String pdfContent = new PDFTextStripper().getText(document)
		//println pdfContent

		return pdfContent
	}

	@Keyword
	def getUrlFromPDF(String path) {
		WebUI.delay(3)
		String allText = new common.Util.PDFReader().getPdfFileText2(path)
		String textWithoutBlankLine = allText.replaceAll('[\\\r\\\n]+', '')
		String[] arrText = textWithoutBlankLine.split(':')
		String tempLink = 'https:' + (arrText[6])
		if (tempLink.contains('A')) {
			tempLink = tempLink.substring(0, tempLink.indexOf('A'))
		}
		return tempLink
	}

	@Keyword
	def getHyperlinkUrlFromPDF(String pdfFilePath , String contain_word_onLink) {
		WebUI.delay(3)

		URL url =new URL(pdfFilePath)
		InputStream is = url.openStream()
		BufferedInputStream filePase = new BufferedInputStream(is)
		PDDocument document =null

		document = PDDocument.load(filePase)
		String uri = null

		for( PDPage page : document.getPages() ) {
			int pageNum = 0;
			pageNum++;
			PDFTextStripperByArea stripper = new PDFTextStripperByArea();
			List<PDAnnotation> annotations = page.getAnnotations();
			//first setup text extraction regions
			for( int j=0; j<annotations.size(); j++ )
			{
				PDAnnotation annot = annotations.get(j);
				if( annot instanceof PDAnnotationLink )
				{
					PDAnnotationLink link = (PDAnnotationLink)annot;
					PDRectangle rect = link.getRectangle();
					//need to reposition link rectangle to match text space
					float x = rect.getLowerLeftX();
					float y = rect.getUpperRightY();
					float width = rect.getWidth();
					float height = rect.getHeight();
					int rotation = page.getRotation();
					if( rotation == 0 )
					{
						PDRectangle pageSize = page.getMediaBox();
						y = pageSize.getHeight() - y;
					}
					else if( rotation == 90 )
					{
						//do nothing
					}

					Rectangle2D.Float awtRect = new Rectangle2D.Float( x,y,width,height );
					stripper.addRegion( "" + j, awtRect );
				}
			}

			stripper.extractRegions( page );

			for( int j=0; j<annotations.size(); j++ )
			{
				PDAnnotation annot = annotations.get(j);
				if( annot instanceof PDAnnotationLink )
				{
					PDAnnotationLink link = (PDAnnotationLink)annot;
					PDAction action = link.getAction();
					String urlText = stripper.getTextForRegion( "" + j );
					if( action instanceof PDActionURI )
					{
						PDActionURI uris = (PDActionURI)action;
						//System.out.println( "Page " + pageNum +":'" + urlText.trim() + "'=" + uri.getURI() );
						uri = uris.getURI();
						if(uri.contains(contain_word_onLink)) {
							System.out.println("==>" + uri);
							break
						}
					}
				}
			}
		}
		return uri
	}



}
