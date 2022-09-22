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

def anyOfTheFollowingH1 = 'Was your planning application about any of the following?'
def lPAToSelect = 'system test borough council'

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.lpaPageUrl)

WebUI.setText(findTestObject('Appeals Service/LPA/input_Which local planning department dealt_8f78ac'), lPAToSelect)

WebUI.click(findTestObject('Appeals Service/LPA/button_Continue'))

WebUI.click(findTestObject('Appeals Service/Type_Of_Planning_Application/input_You can check this on your planning a_8c61ca'))

WebUI.click(findTestObject('Appeals Service/Type_Of_Planning_Application/button_Continue'))

WebUI.verifyElementText(findTestObject('Appeals Service/Any_Of_The_Following/h1_Was your planning application about any _298ba9'), 
    anyOfTheFollowingH1)

WebUI.closeBrowser()

