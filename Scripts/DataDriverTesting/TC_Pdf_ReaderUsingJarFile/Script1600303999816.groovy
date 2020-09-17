import org.apache.pdfbox.cos.COSDocument
import org.apache.pdfbox.pdfparser.PDFParser
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.util.PDFTextStripper
import org.testng.Assert
import com.kms.katalon.core.configuration.RunConfiguration
/**************************************************************************************
	1. We need two jar file// First put in build.gradle without opening katalon studio
	2. Then CMD in the Location and Run:- gradle katalonCopyDependencies
	3. Apache FontBox » 1.8.1 https://mvnrepository.com/artifact/org.apache.pdfbox/fontbox
	4. Apache PDFBox  » 1.8.1 https://mvnrepository.com/artifact/org.apache.pdfbox/pdfbox
**************************************************************************************/

String filePath = RunConfiguration.getProjectDir() + "/Data Files All/PdfReader/test_text2.pdf"

File file = new File(filePath)
FileInputStream fis = new FileInputStream(file)

PDFParser parser = new PDFParser(fis)
parser.parse()

COSDocument cosDoc = parser.getDocument()
PDDocument pdDoc = new PDDocument(cosDoc)

PDFTextStripper strip = new PDFTextStripper()
String data = strip.getText(pdDoc)

println data.trim() // this will remove the white space
Assert.assertTrue(data.contains("Like other schools around the nation"))



