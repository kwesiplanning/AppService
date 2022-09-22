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

def selectedLPA = 'System Test Borough Council'

def grantedOrRefusedPageTitle = 'Was your planning application granted or refused? - Before you start - Appeal a planning decision - GOV.UK'

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.lpaPageUrl)

WebUI.setText(findTestObject('Object Repository/Appeals Service/LPA/input_Which local planning department dealt_8f78ac'), 
    selectedLPA)

WebUI.click(findTestObject('Object Repository/Appeals Service/LPA/button_Continue'))

WebUI.click(findTestObject('Object Repository/Appeals Service/Type_Of_Planning_Application/label_Full planning'))

WebUI.click(findTestObject('Object Repository/Appeals Service/Type_Of_Planning_Application/button_Continue'))

WebUI.click(findTestObject('Object Repository/Appeals Service/Any_Of_The_Following/input_or_any-of-following_none_of_these'))

WebUI.click(findTestObject('Appeals Service/Any_Of_The_Following/button_Continue'))

WebUI.getText(findTestObject('Object Repository/Appeals Service/Granted_or_Refused/h1_Was your planning application granted or_23d283'))

def grantedOrRefusedPageURL = WebUI.getUrl()

def grantedOrRefusedPageTITLE = WebUI.getWindowTitle()

WebUI.verifyEqual(grantedOrRefusedPageURL, GlobalVariable.grantedOrRefusedPageUrl)

WebUI.verifyEqual(grantedOrRefusedPageTITLE, grantedOrRefusedPageTitle)

WebUI.closeBrowser()

