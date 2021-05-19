package utilites
import com.kms.katalon.core.annotation.Keyword


class CMD {
	/******************************
	 * Execute Command line command
	 * ref:- https://stackoverflow.com/questions/15464111/run-cmd-commands-through-java
	 ******************************/
	@Keyword
	def executeCmdCommand(String cmd) throws IOException, Exception{
		try{
			Process process = Runtime.getRuntime().exec("cmd /c " + cmd)
		}catch(IOException ioe){
			ioe.printStackTrace()
		}
	}
}