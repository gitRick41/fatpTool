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

//import org.junit.matchers.JUnitMatchers
//import org.hamcrest.CoreMatchers
WebUI.openBrowser('')

WebUI.maximizeWindow()

//WebUI.authenticate('http://indivior-sublocade-consumer-stage.klickcloud.net/', 'client', '4HnoNSYj', 12)
WebUI.navigateToUrl(GlobalVariable.siteURL)

WebUI.waitForPageLoad(5)

WebUI.click(findTestObject('sublocadePatientOR/Page_Home/HP_FatpSearch/TopSection/btn_findProvider'))

WebUI.waitForElementVisible(findTestObject('sublocadePatientOR/Page_Home/HP_FatpSearch/TopSection/input_ZipCode'), 5)

//zipcode 10250, 
WebUI.setText(findTestObject('sublocadePatientOR/Page_Home/HP_FatpSearch/TopSection/input_ZipCode'), '90002')

WebUI.click(findTestObject('sublocadePatientOR/Page_Home/HP_FatpSearch/TopSection/a_searchProvider'))

WebUI.executeJavaScript('document.querySelector(".modal.modal-disclaimer .modal-body").scrollBy(0, 700)', null)

//scroll within a div element(disclaimer)
/*  ((DriverFactory.getWebDriver()) as JavascriptExecutor).executeScript('document.querySelector(\'.modal.modal-disclaimer .modal-body\').scrollBy(0, 500)')

JavascriptExecutor js = ((driver) as JavascriptExecutor)
js.executeScript('document.querySelector(".modal.modal-disclaimer .modal-body").scrollBy(0, 500)')
*/
WebUI.click(findTestObject('sublocadePatientOR/Page_ModalDisclaimer/a_btnAcceptDisclaimer'))


WebUI.waitForElementPresent(findTestObject('Object Repository/sublocadePatientOR/Page_FATP_SearchResults/txt_providerName'), 5)

//WebUI.waitForElementVisible(findTestObject('Object Repository/sublocadePatientOR/Page_FATP_SearchResults/txt_providerName'), 5)

//String name = WebUI.executeJavaScript('document.querySelectorAll(".module-FATP_ResultsList .result-item")[1].querySelector(".result-item__title strong").textContent', null)


driver = DriverFactory.getWebDriver()

//List<WebElement> myElements = driver.findElements(By.cssSelector('.result-item__title'))

//List<WebElement> myElements = driver.findElements(By.cssSelector('.module-FATP_ResultsList .result-item'))



//WebUI.executeJavaScript('return fatpResults.FormattedResult[0].FirstName + " " + fatpResults.FormattedResult[0].LastName', null)


//List<WebElement> myElements = driver.findElements(By.cssSelector('.module-FATP_ResultsList .result-item .result-item__title'))

//System.out.println(myElements2.size())

//LisfindTestObject('Object Repository/sublocadePatientOR/Page_FATP_SearchResults/txt_providerName')t<String> actual = new ArrayList<String>()
List<String> actual =  new ArrayList<String>(10)

      int count = 0
	  String provider		
      while (count < 10) {
		 provider = WebUI.executeJavaScript('return fatpResults.FormattedResult['+count+'].FirstName + " " + fatpResults.FormattedResult['+count+'].LastName', null)
		 actual.add((provider))
		 
		// System.out.println(WebUI.executeJavaScript('return fatpResults.FormattedResult[0].FirstName + " " + fatpResults.FormattedResult[0].LastName', null))
		 
	   count++
      }
System.out.println(actual.size())

List<String> expected = Arrays.asList("MarZVkh SavaHLa", "RVmi Lakha", "WenEis SanchKz", "Wavid KDrDZMeY", "KanXilal PateH", "RDDeAt YhTEg", "YATEfoAW ScoXX", "DaMFan OFraEL", "SXTEisHTu KinDXT", "DaMFan Dandari")


for (int i = 0; i < actual.size(); i++) {
	System.out.println(actual.get(i));
	System.out.print(" ")
	System.out.println(expected.get(i));
	
}
/*
for (WebElement e : myElements) {
    //actual.add(e.getText())
    System.out.println(e.getText())

    //System.out.println(myElements.size())
}


System.out.println(myElements.size())

*/


//WebUI.executeJavaScript('return fatpResults.FormattedResult[0].FirstName + " " + fatpResults.FormattedResult[0].LastName', null)


//System.out.println(WebUI.executeJavaScript('return fatpResults.FormattedResult[0].FirstName', null))

System.out.println(WebUI.executeJavaScript('return fatpResults.FormattedResult[0].FirstName + " " + fatpResults.FormattedResult[0].LastName', null))


//String fName = WebUI.executeJavaScript('return fatpResults.FormattedResult[0].FirstName', null)

//String lname = WebUI.executeJavaScript('return fatpResults.FormattedResult[0].LastName', null)

//String fname = WebUI.executeJavaScript('document.querySelectorAll(".module-FATP_ResultsList .result-item")[6].querySelector(".result-item__title strong").textContent', null)



//System.out.println(fname)


//System.out.println(lname)

Assert.assertEquals(actual, expected)
WebUI.verifyEqual(actual, expected)
WebUI.delay(2)

//All passed / true
//1. Test equal.
//Booolean test= assertThat(actual, is(expected))
//assertThat(actual, is(expected))
//assert WebUI.getWindowTitle() == 'FPO - treatment-journey'
//WebUI.verifyElementText(findTestObject('test_03/Page_FATP_SearchResults/txt_resultProvidersCounter'), '56')
//WebUI.closeBrowser()

