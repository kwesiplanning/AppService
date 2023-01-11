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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://appeals-service-test.planninginspectorate.gov.uk/before-you-start/local-planning-department')

WebUI.setText(findTestObject('Page_Which local planning department dealt _b978d1/input_Which local planning department dealt_8f78ac'), 
    'sys')

WebUI.click(findTestObject('Page_Which local planning department dealt _b978d1/li_System Test Borough Council'))

WebUI.setText(findTestObject('Page_Which local planning department dealt _b978d1/input_Which local planning department dealt_8f78ac'), 
    'System Test Borough Council')

WebUI.click(findTestObject('Page_Which local planning department dealt _b978d1/button_Continue'))

WebUI.click(findTestObject('Page_What type of planning application is y_20a620/input_You can check this on your planning a_8c61ca'))

WebUI.click(findTestObject('Page_What type of planning application is y_20a620/button_Continue'))

WebUI.click(findTestObject('Page_Was your planning application about an_a45c37/input_or_any-of-following'))

WebUI.click(findTestObject('Page_Was your planning application about an_a45c37/button_Continue'))

WebUI.click(findTestObject('Page_Was your planning application granted _09088d/input_Was your planning application granted_97f41f'))

WebUI.click(findTestObject('Page_Was your planning application granted _09088d/button_Continue'))

WebUI.setText(findTestObject('Page_Whats the decision date on the letter _9e56bc/input_Day_decision-date-day'), '20')

WebUI.setText(findTestObject('Page_Whats the decision date on the letter _9e56bc/input_Month_decision-date-month'), '11')

WebUI.setText(findTestObject('Page_Whats the decision date on the letter _9e56bc/input_Year_decision-date-year'), '2022')

WebUI.click(findTestObject('Page_Whats the decision date on the letter _9e56bc/button_Continue'))

WebUI.click(findTestObject('Page_Have you received an enforcement notic_99bb3d/input_Yes_enforcement-notice'))

WebUI.click(findTestObject('Page_Have you received an enforcement notic_99bb3d/button_Continue'))

WebUI.click(findTestObject('Page_You can appeal using this service - Be_40513e/a_Continue to my appeal'))

WebUI.setText(findTestObject('Page_Whats your planning application number_352706/input_You can find this on communications f_f90ec0'), 
    '12345679')

WebUI.click(findTestObject('Page_Whats your planning application number_352706/button_Continue'))

WebUI.setText(findTestObject('Page_Whats your email address - Appeal a pl_ba486c/input_Whats your email address_email-address'), 
    'kwesi.gepi-attee@planninginspectorate.gov.uk')

WebUI.click(findTestObject('Page_Whats your email address - Appeal a pl_ba486c/button_Continue'))

WebUI.click(findTestObject('Object Repository/Appeals Service/Email_Address_Confirmed_FP/h1_Your email address is confirmed'))

WebUI.rightClick(findTestObject('Object Repository/Appeals Service/Email_Address_Confirmed_FP/a_Continue'))

