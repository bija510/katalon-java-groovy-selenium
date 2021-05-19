package utilites
import java.nio.file.Files
import java.nio.file.Paths
import com.kms.katalon.core.annotation.Keyword


class TextFile {
	private String txtFile
	public TextFile(String txtFile) {
		this.txtFile = txtFile
	}
	@Keyword
	public String readFromTextFile(String key)throws Exception {
		List<List<String>> outerList = new ArrayList<List<String>>()
		List<String> innerList = new ArrayList<String>()

		String[] arrLines = null

		try{
			List<String> allLines = Files.readAllLines(Paths.get(txtFile))
			int index = -1

			for(int i =0; i<allLines.size(); i++){
				if(!(allLines.get(i).toString().contains("#"))){

					if(allLines.get(i).toString().contains(key)){
						arrLines = allLines.get(i).toString().split("=")
						return arrLines[1]
					}
				}
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally{
		}
	}

	@Keyword
	public writeToTextFile(String key, String val) throws Exception{
		String[] arrLines =null

		try{

			List<String> allLines = Files.readAllLines(Paths.get(txtFile));
			int index = -1

			for(int i =0; i<allLines.size(); i++){
				if(!(allLines.get(i).toString().contains("#"))){

					if(allLines.get(i).toString().contains(key)){
						arrLines = allLines.get(i).toString().split("=")
						arrLines[1] =val
						allLines.set(i, arrLines[0].trim() +'='+arrLines[1].trim())
						break
					}
				}
			}
			Files.write(Paths.get(txtFile), allLines);
		}catch (IOException e){
			e.printStackTrace();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally{
		}
	}

	@Keyword
	def append(String msg) throws Exception{
		FileWriter fw = new FileWriter(txtFile, true);
		fw.write(msg + "\n");
		fw.close()
	}
}








































