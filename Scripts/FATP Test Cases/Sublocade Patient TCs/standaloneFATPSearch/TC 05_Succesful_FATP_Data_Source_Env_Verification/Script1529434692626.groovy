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
import org.openqa.selenium.By.ByCssSelector as ByCssSelector
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.junit.Assert as Assert

WebUI.openBrowser('')

WebUI.maximizeWindow()

//WebUI.authenticate('http://indivior-sublocade-consumer-stage.klickcloud.net/', 'client', '4HnoNSYj', 12)

WebUI.navigateToUrl(GlobalVariable.siteURL)

WebUI.waitForPageLoad(5)

WebUI.click(findTestObject('sublocadePatientOR/Page_Home/HP_FatpSearch/TopSection/btn_findProvider'))

WebUI.waitForElementVisible(findTestObject('sublocadePatientOR/Page_Home/HP_FatpSearch/TopSection/input_ZipCode'), 5)

WebUI.setText(findTestObject('sublocadePatientOR/Page_Home/HP_FatpSearch/TopSection/input_ZipCode'), '90002')

WebUI.click(findTestObject('sublocadePatientOR/Page_Home/HP_FatpSearch/TopSection/a_searchProvider'))

WebUI.executeJavaScript('document.querySelector(".modal.modal-disclaimer .modal-body").scrollBy(0, 700)', null)

WebUI.click(findTestObject('sublocadePatientOR/Page_ModalDisclaimer/a_btnAcceptDisclaimer'))

WebUI.waitForElementPresent(findTestObject('Object Repository/sublocadePatientOR/Page_FATP_SearchResults/txt_providerName'), 5)


List<String> actual =  new ArrayList<String>(10)
List<String> expected = Arrays.asList("MarZVkh SavaHLa", "RVmi Lakha", "WenEis SanchKz", "Wavid KDrDZMeY", "KanXilal PateH", "RDDeAt YhTEg", "YATEfoAW ScoXX", "DaMFan OFraEL", "SXTEisHTu KinDXT", "DaMFan Dandari")

int count = 0
String provider		

while (count < 10) {
   provider = WebUI.executeJavaScript('return fatpResults.FormattedResult['+count+'].FirstName + " " + fatpResults.FormattedResult['+count+'].LastName', null)
   actual.add((provider))
   count++
}

WebUI.verifyEqual(actual, expected)
WebUI.closeBrowser()

