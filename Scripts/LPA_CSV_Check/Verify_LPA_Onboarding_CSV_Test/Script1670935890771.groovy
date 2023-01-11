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

def excelData = findTestData('LPA_Test_Data')

def LPAPageUrl = GlobalVariable.LPA_OnBoard_lpa_page_Url

def useTheExistingService = GlobalVariable.LPA_OnBoard_Use_Existing_Service

def lpaErrorPageTitle = 'Error: Which local planning department dealt with your planning application? - Before you start - Appeal a planning decision - GOV.UK'

def excelCell = ''

def verifyWhatTypeOfApUrl = ''

def errorTitle = ''

def arrayCount = 300

String[] FalseOnBoardedLPAs = new String[arrayCount]
String[] ProblemOnBoardedLPAs = new String[arrayCount]
String[] IncorrectNameLPAs = new String[arrayCount]
String[] BlankNameLPAs = new String[arrayCount]
String[] NoEmailLPAs = new String[arrayCount]

CustomKeywords.'customPackage.CaseData.CreateReportTemplate'(FalseOnBoardedLPAs, 'The following LPA\'s are marked as FALSE on the CSV :')
CustomKeywords.'customPackage.CaseData.CreateReportTemplate'(ProblemOnBoardedLPAs, 'The following LPA\'s are marked as true on the CSV but not are not allowing access to the Beta service :')
CustomKeywords.'customPackage.CaseData.CreateReportTemplate'(IncorrectNameLPAs, 'The following LPA\'s are marked as true on the CSV but are not listed in the Beta service drop down :')
CustomKeywords.'customPackage.CaseData.CreateReportTemplate'(BlankNameLPAs, 'The following LPA\'s are marked as true on the CSV but are their LPA names are empty or blank :')
CustomKeywords.'customPackage.CaseData.CreateReportTemplate'(NoEmailLPAs, 'The following LPA\'s have NO emails registered on the CSV :')

def LPAIndexes = 4

def FalseOnBoardedLPAsCount = LPAIndexes

def ProblemLPAsCount = LPAIndexes

def IncorrectNameLPAsCount = LPAIndexes

def BlankNameLPAsCount = LPAIndexes

def NoEmaiLPAsCount = LPAIndexes

def ReportDirectory = 'C:\\Katalon\\Appeals_Service_Test_Automation\\LPA_OnBoarding_Master\\LPAResults'

WebUI.openBrowser(LPAPageUrl)

for (int excelCount = 1; excelCount <= excelData.getRowNumbers(); excelCount++) {
    WebUI.deleteAllCookies()

    if (excelData.getValue('LPA ONBOARDED', excelCount).toString() == 'false') {
        excelCell = excelData.getValue('LPA19NM', excelCount)

        (FalseOnBoardedLPAs[FalseOnBoardedLPAsCount]) = excelCell

        FalseOnBoardedLPAsCount++
    }
    
    if (excelData.getValue('LPA ONBOARDED', excelCount).toString() == 'true') {
        excelCell = excelData.getValue('LPA19NM', excelCount)

        WebUI.navigateToUrl(LPAPageUrl)

        WebUI.sendKeys(findTestObject('LPA_Onboarding_Master/Which_LPA/input_Which local planning department dealt_8f78ac'), 
            excelCell)

        WebUI.click(findTestObject('LPA_Onboarding_Master/Which_LPA/button_Continue'))

        verifyPageUrl = WebUI.getUrl()

        WebUI.delay(1)

        errorTitle = WebUI.getWindowTitle()

        if ((verifyPageUrl == LPAPageUrl) && (errorTitle == lpaErrorPageTitle)) {
            (IncorrectNameLPAs[IncorrectNameLPAsCount]) = excelCell

            IncorrectNameLPAsCount++
        }
        
        if ((excelData.getValue('EMAIL', excelCount).toString() == '')||(excelData.getValue('EMAIL', excelCount).toString() == null)) {
            (NoEmailLPAs[NoEmaiLPAsCount]) = excelCell

            NoEmaiLPAsCount++
        }
        
        if (verifyPageUrl == useTheExistingService) {
            (ProblemOnBoardedLPAs[ProblemLPAsCount]) = excelCell

            ProblemLPAsCount++
        }
        
        if (((verifyPageUrl == LPAPageUrl) && (errorTitle == lpaErrorPageTitle)) && (excelCell == '')) {
            def blankData = (((((((((((('OBJECTID: ' + excelData.getValue('OBJECTID', excelCount)) + ' ') + 'LPA19CD: ') + 
            excelData.getValue('LPA19CD', excelCount)) + ' ') + 'LPA CODE: ') + excelData.getValue('LPA CODE', excelCount)) + 
            ' ') + 'Email: ') + excelData.getValue('EMAIL', excelCount)) + ' ') + 'DOMAIN: ') + excelData.getValue('DOMAIN', 
                excelCount)

            (BlankNameLPAs[BlankNameLPAsCount]) = blankData

            BlankNameLPAsCount++
        }
    }
}

WebUI.closeBrowser()

CustomKeywords.'customPackage.CaseData.WriteToFile'(IncorrectNameLPAs, ReportDirectory, 'IncorrectNameLPAs.txt')
CustomKeywords.'customPackage.CaseData.WriteToFile'(NoEmailLPAs, ReportDirectory, 'NoEmailLPAs.txt')
CustomKeywords.'customPackage.CaseData.WriteToFile'(ProblemOnBoardedLPAs, ReportDirectory, 'ProblemOnBoardedLPAs.txt')
CustomKeywords.'customPackage.CaseData.WriteToFile'(BlankNameLPAs, ReportDirectory, 'BlankNameDataLPAs.txt')
CustomKeywords.'customPackage.CaseData.WriteToFile'(FalseOnBoardedLPAs, ReportDirectory, 'FalseLPAs.txt')

