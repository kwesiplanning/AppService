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

def errorPageTitle = 'Error: Which local planning department dealt with your planning application? - Before you start - Appeal a planning decision - GOV.UK'
def errorPageText = 'Enter the name of the local planning department'
def errorPageText_VisuallyHidden = 'Error:\nEnter the name of the local planning department'

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.lpaPageUrl)

WebUI.click(findTestObject('Object Repository/Appeals Service/LPA/button_Continue'))

def lpaErrorPageURL = WebUI.getUrl()
def planningApplicationPageErrorTitle = WebUI.getWindowTitle()

def errorTextAnchor = WebUI.getText(findTestObject('Appeals Service/LPA/a_Enter the name of the local planning department'), FailureHandling.STOP_ON_FAILURE)
def errorTextSpan = WebUI.getText(findTestObject('Appeals Service/LPA/span_Error Enter the name of the local plan_2a74a3'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyEqual(lpaErrorPageURL, GlobalVariable.lpaPageUrl) // Stays the same

WebUI.verifyEqual(planningApplicationPageErrorTitle, errorPageTitle)

WebUI.verifyEqual(errorTextAnchor, errorPageText)

WebUI.verifyEqual(errorTextSpan, errorPageText_VisuallyHidden)

WebUI.closeBrowser()

