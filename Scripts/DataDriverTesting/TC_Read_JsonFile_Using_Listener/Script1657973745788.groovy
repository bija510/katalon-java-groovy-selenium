import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable as GlobalVariable


Map data = GlobalVariable.jsonData

KeywordUtil.logInfo("===>"+data.welcomeMsg)