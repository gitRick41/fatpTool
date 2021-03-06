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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.siteURL)

WebUI.waitForPageLoad(5)

WebUI.click(findTestObject('sublocadePatientOR/Page_Home/HP_FatpSearch/TopSection/btn_findProvider'))

WebUI.waitForElementVisible(findTestObject('sublocadePatientOR/Page_Home/HP_FatpSearch/TopSection/input_ZipCode'), 5)

WebUI.setText(findTestObject('sublocadePatientOR/Page_Home/HP_FatpSearch/TopSection/input_ZipCode'), '38569')

WebUI.sendKeys(findTestObject('sublocadePatientOR/Page_Home/HP_FatpSearch/TopSection/input_ZipCode'), Keys.chord(Keys.ENTER))

WebUI.executeJavaScript('document.querySelector(".modal.modal-disclaimer .modal-body").scrollBy(0, 700)', null)

//scroll within a div element(disclaimer)
/*  ((DriverFactory.getWebDriver()) as JavascriptExecutor).executeScript('document.querySelector(\'.modal.modal-disclaimer .modal-body\').scrollBy(0, 500)')
driver = DriverFactory.getWebDriver()
JavascriptExecutor js = ((driver) as JavascriptExecutor)
js.executeScript('document.querySelector(".modal.modal-disclaimer .modal-body").scrollBy(0, 500)')
*/
WebUI.sendKeys(findTestObject('sublocadePatientOR/Page_ModalDisclaimer/a_btnAcceptDisclaimer'), Keys.chord(Keys.ENTER))

WebUI.waitForPageLoad(5)

WebUI.verifyElementText(findTestObject('sublocadePatientOR/Page_FATP_SearchResults/a_filter_item_active_distance'), 'Distance')

