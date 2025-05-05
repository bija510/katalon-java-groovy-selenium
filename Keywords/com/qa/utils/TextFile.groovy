package com.qa.utils
import java.nio.file.Files
import java.nio.file.Paths
import com.kms.katalon.core.annotation.Keyword


/**
 * Utility class for reading, writing, and appending data in a text file.
 * Commonly used for key-value pair management in test automation scenarios.
 */
class TextFile {

	private String txtFile

	/**
	 * Constructor to initialize the file path.
	 * @param txtFile Absolute or relative path of the text file.
	 */
	public TextFile(String txtFile) {
		this.txtFile = txtFile
	}

	/**
	 * Reads the value for a given key from the text file.
	 * Ignores commented lines (starting with #).
	 *
	 * @param key The key to search for.
	 * @return The value associated with the key, or null if not found.
	 * @throws Exception if file read fails.
	 */
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




	/**
	 * Updates the value for a given key in the text file.
	 * If the key is found, its value is replaced and the file is rewritten.
	 *
	 * @param key The key whose value should be updated.
	 * @param val The new value to assign to the key.
	 * @throws Exception if file write fails.
	 */
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

	/**
	 * Appends a new line to the end of the text file.
	 *
	 * @param msg The message or content to append.
	 * @throws Exception if file append fails.
	 */
	@Keyword
	def append(String msg) throws Exception{
		FileWriter fw = new FileWriter(txtFile, true);
		fw.write(msg + "\n");
		fw.close()
	}
}








































