import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def errorPageTitle = 'Error: What type of planning application is your appeal about? - Before you start - Appeal a planning decision - GOV.UK'
def errorPageText = 'Select which type of planning application your appeal is about, or if you have not made a planning application'
def errorPageText_VisuallyHidden = 'Error:\nSelect which type of planning application your appeal is about, or if you have not made a planning application'

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.typeOfPlanningApplicationPageUrl)

WebUI.click(findTestObject('Appeals Service/Type_Of_Planning_Application/button_Continue'))

def typleOfPlanningAppErrorPageURL = WebUI.getUrl()
def typleOfPlanningAppErrorPageTITLE = WebUI.getWindowTitle()

def errorTextAnchor = WebUI.getText(findTestObject('Object Repository/Appeals Service/Type_Of_Planning_Application/a_Select which type of planning application_4005ed'))
def errorTextSpan = WebUI.getText(findTestObject('Object Repository/Appeals Service/Type_Of_Planning_Application/span_Error Select which type of planning ap_dea18b'))

WebUI.verifyEqual(typleOfPlanningAppErrorPageURL, GlobalVariable.typeOfPlanningApplicationPageUrl) // Stays the same

WebUI.verifyEqual(typleOfPlanningAppErrorPageTITLE, errorPageTitle)

WebUI.verifyEqual(errorTextAnchor, errorPageText)

WebUI.verifyEqual(errorTextSpan, errorPageText_VisuallyHidden)

WebUI.closeBrowser()

