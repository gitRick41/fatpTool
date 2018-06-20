import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
//import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
//import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
//import static org.junit.Assert.*

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.siteURL)
	
WebUI.waitForPageLoad(5)

WebUI.click(findTestObject('sublocadePatientOR/Page_Home/HP_FatpSearch/TopSection/btn_findProvider'))

WebUI.waitForElementVisible(findTestObject('sublocadePatientOR/Page_Home/HP_FatpSearch/TopSection/input_ZipCode'), 5)
 
WebUI.setText(findTestObject('sublocadePatientOR/Page_Home/HP_FatpSearch/TopSection/input_ZipCode'), ' ')

WebUI.click(findTestObject('sublocadePatientOR/Page_Home/HP_FatpSearch/TopSection/a_searchProvider'))

WebUI.waitForElementVisible(findTestObject('sublocadePatientOR/Page_Home/HP_FatpSearch/TopSection/txt_InvalidCodeMsg'), 5)

WebUI.delay(2)

WebUI.verifyElementText(findTestObject('sublocadePatientOR/Page_Home/HP_FatpSearch/TopSection/txt_InvalidCodeMsg'), 'Invalid code.')

WebUI.closeBrowser()

